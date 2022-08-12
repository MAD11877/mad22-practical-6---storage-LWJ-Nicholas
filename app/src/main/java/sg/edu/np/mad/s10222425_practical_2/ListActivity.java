package sg.edu.np.mad.s10222425_practical_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;



    int num = 20; //Variable to determine how many times name is generated
    List<User> userList = new ArrayList<User>(); //List to store randomly generated users

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.recyclerView);

        //function to autogenerate random numbers
        for(int i = 0; i < num; i++){
            String randInt = Integer.toString(new Random().nextInt(10000000) + 10000000);
            String randInt2 = Integer.toString(new Random().nextInt());
            Boolean randBool3 = new Random().nextBoolean();
            User u = new User("Name" + randInt, "Description "+ randInt2, Integer.parseInt(randInt), randBool3);
            userList.add(u);
        }

        ListAdapter listAdapter = new ListAdapter(this, userList);
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        //Code from Pratical 3
//        ImageView img = findViewById(R.id.imageView3);
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("This is an AlertDialog");
//        builder.setMessage("Please choose an option below");
//        builder.setCancelable( false );
//        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                String randInt = Integer.toString(new Random().nextInt(10000000) + 10000000);
//                Intent intent = new Intent(ListActivity.this, MainActivity.class);
//                intent.putExtra("randInt",randInt);
//                startActivity(intent);
//            }
//        }).setNegativeButton("Close", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//
//            }
//        });
//
//        img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                builder.show();
//
//            }
//        });
    }
}