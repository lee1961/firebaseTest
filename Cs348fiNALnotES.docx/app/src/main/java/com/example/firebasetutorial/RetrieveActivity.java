package com.example.firebasetutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.auth.FirebaseUser;

public class RetrieveActivity extends AppCompatActivity {

    private TextView first_textView;
    private TextView second_textView;
    private DatabaseReference mDatabase;

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);
        first_textView = (TextView) findViewById(R.id.textView);
        second_textView = (TextView) findViewById(R.id.textView2);
        button = (Button) findViewById(R.id.button2);



        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        //mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(user.getUid());
        if(user != null) {
            first_textView.setText("Hello " + user.getUid());
        }
//        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                UserStuff u = dataSnapshot.getValue(UserStuff.class);
//                second_textView.setText("now u will only retrieve the name " + u.getName());
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });


        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                
//                UserStuff u = dataSnapshot.getValue(UserStuff.class);
//                first_textView.setText("Hello " + u.name);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

//        mDatabase.addValueEventListener(new ValueEventListener() {
//
//            @Override // this will be retrieving the value
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                //String name = dataSnapshot.getValue().toString();
//               // first_textView.setText("Name: " + name);
//                UserStuff u = dataSnapshot.getValue(UserStuff.class);
//                first_textView.setText(u.name);
//
//            }
//
//            @Override // this will be getting error
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
            }
        });


    }
}
