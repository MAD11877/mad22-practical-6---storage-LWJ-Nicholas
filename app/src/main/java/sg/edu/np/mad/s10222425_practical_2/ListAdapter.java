package sg.edu.np.mad.s10222425_practical_2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class ListAdapter extends RecyclerView.Adapter {

    List<User> userList;
    Context context;

    public ListAdapter(Context ct, List<User> users){
        context = ct;
        userList = users;
    };


    @Override
    public int getItemViewType(int position){
        String name = userList.get(position).name;
        char lastChar= name.charAt(name.length()-1);
        if ( lastChar == '7'){
            return 1;
        }
        return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        if (viewType == 1)
        {
            view = inflater.inflate(R.layout.viewholder_seven, parent, false);
            return new ListViewHolder7(view);
        }

        view = inflater.inflate(R.layout.viewholder_user, parent, false);
        return new ListViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        if (viewType == 1){
            ListViewHolder7 viewHolder7 = (ListViewHolder7) holder;
            viewHolder7.nameView.setText(userList.get(position).name);
            viewHolder7.descView.setText(userList.get(position).description);
            viewHolder7.imageView.setImageResource(R.drawable.ic_launcher_background);
            viewHolder7.imageView7.setImageResource(R.drawable.ic_launcher_background);
            viewHolder7.imageView7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("This is an AlertDialog");
                    builder.setMessage("Please choose an option below");
                    builder.setCancelable( false );
                    builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(context, MainActivity.class);
                            User user = userList.get(position);
                            intent.putExtra("user", user);
                            context.startActivity(intent);
                        }
                    }).setNegativeButton("Close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.show();
                }
            });
        }
        else {
            ListViewHolder viewHolder = (ListViewHolder) holder;
            viewHolder.nameView.setText(userList.get(position).name);
            viewHolder.descView.setText(userList.get(position).description);
            viewHolder.imageView.setImageResource(R.drawable.ic_launcher_background);
            viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Profile");
                    builder.setMessage(userList.get(position).name);
                    builder.setCancelable( false );
                    builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(context, MainActivity.class);
                            User user = userList.get(position);
                            intent.putExtra("user", user);
                            context.startActivity(intent);
                        }
                    }).setNegativeButton("Close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.show();
                }
            });



        }
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        TextView nameView, descView;
        ImageView imageView;

        public ListViewHolder(@NonNull View itemView){
            super(itemView);
            nameView = itemView.findViewById(R.id.nameView);
            descView = itemView.findViewById(R.id.descView);
            imageView = itemView.findViewById(R.id.imageView3);
        }

    }

    public class ListViewHolder7 extends RecyclerView.ViewHolder{
        TextView nameView, descView;
        ImageView imageView;
        ImageView imageView7;

        public ListViewHolder7(@NonNull View itemView){
            super(itemView);
            nameView = itemView.findViewById(R.id.nameView2);
            descView = itemView.findViewById(R.id.descView2);
            imageView7 = itemView.findViewById(R.id.imageView7);
            imageView = itemView.findViewById(R.id.imageView6);
        }
    }
}
