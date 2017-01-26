package com.example.firebasetutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button mFirebaseBtn;
    private EditText editText;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseBtn = (Button) findViewById(R.id.firebase_btn);
        mDatabase = FirebaseDatabase.getInstance().getReference(); // this points to the root of the database
        editText = (EditText) findViewById(R.id.editText);

//        mFirebaseBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // 1 - Create child in root object
//                // 2 - Assign some value to the child object
//
//                mDatabase.child("Name").setValue("Victor Lee");
//            }
//        });
    }

    public void onSubmit(View view) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        String g = editText.getText().toString();
        if(g != null) {
           // mDatabase.child("Name").setValue(g);
            mDatabase.push().setValue(g);

        }

    }
}
