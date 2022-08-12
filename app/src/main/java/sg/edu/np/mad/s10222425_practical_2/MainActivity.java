package sg.edu.np.mad.s10222425_practical_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get the stored data
        Intent intent = getIntent();
        User student1 = (User) intent.getSerializableExtra("user");

        //Creating a new user object
//        User student1 = new User("Nicholas Lee" + "\n" + randInt,
//                "Second year IT student at Ngee Ann Polytechnic, loves to play chess and talk to plants during his free time.",
//                10222425,
//                false);

        //Retrieve name from user
        //Display name
        TextView nameTxt = findViewById(R.id.nameTxt);
        nameTxt.setText(student1.name);

        //Retrieve description from user
        //Display description
        TextView descTxt = findViewById(R.id.descTxt);
        descTxt.setText(student1.description);

        //Check if user is being followed
        //Display unfollow/follow
        Button followBtn = findViewById(R.id.followBtn);
        if (student1.followed){
            followBtn.setText(R.string.unfollow);
        } else {
            followBtn.setText(R.string.follow);
        }

        //Change the status of "followed" whenever the follow button is clicked
        followBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Check if user is being followed
                //Update the text displayed on the follow button
                Button followBtn = findViewById(R.id.followBtn);
                String displayTxt = student1.followed? "Unfollowed" : "Followed";

                //Update followed status accordingly
                student1.followed = !student1.followed;
                if (student1.followed){
                    followBtn.setText(R.string.unfollow);
                } else {
                    followBtn.setText(R.string.follow);
                }
                Toast.makeText(getApplicationContext(), displayTxt, Toast.LENGTH_SHORT).show();
            }
        });

        Button messageBtn = findViewById(R.id.msgBtn);
        messageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(intent);
            }
        });
    }

}