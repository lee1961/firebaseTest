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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class RetrieveActivity extends AppCompatActivity {

    private TextView first_textView;
    private TextView second_textView;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);
        first_textView = (TextView) findViewById(R.id.textView);
        second_textView = (TextView) findViewById(R.id.textView2);


        mDatabase = FirebaseDatabase.getInstance().getReference().child("level1").child("level2").child("level3");


        mDatabase.addValueEventListener(new ValueEventListener() {

            @Override // this will be retrieving the value
            public void onDataChange(DataSnapshot dataSnapshot) {
                //String name = dataSnapshot.getValue().toString();
               // first_textView.setText("Name: " + name);
            }

            @Override // this will be getting error
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
