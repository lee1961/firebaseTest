package com.example.firebasetutorial;

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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ValueEventListener;
//import com.google.

import org.w3c.dom.Text;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    //private FirebaseAuth mAuth;
    private Button mFirebaseBtn;
    private EditText editText;
    private DatabaseReference mDatabase;
    private TextView textView;
    private EditText e;
    private Button switchBtn;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private TextView mNameView;

    private  EditText mNameField;
    private EditText mEmailField;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        mDatabase = FirebaseDatabase.getInstance().getReference().child("Name");
//        mNameView = (TextView) findViewById(R.id.name_view);
//
//        switchBtn = (Button) findViewById(R.id.switch_button);
//
//        mDatabase.addValueEventListener(new ValueEventListener() {
//
//            @Override // this will be retrieving the value
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String name = dataSnapshot.getValue().toString();
//                mNameView.setText("Name: " + name);
//            }
//
//            @Override // this will be getting error
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//
//        switchBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //startActivity();
//                switch_activity();
//                //System.out.println("asd");
//            }
//        });
//
//
//    }
    public void switch_activity() {
        Intent intent = new Intent(this,RetrieveActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser() == null) {
                    Intent loginIntent = new Intent(MainActivity.this,RetrieveActivity.class);
                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // prevents the user from going back to the page
                    startActivity(loginIntent);

                }
            }
        };




        switchBtn = (Button) findViewById(R.id.switch_button);
        mFirebaseBtn = (Button) findViewById(R.id.firebase_btn);
        mDatabase = FirebaseDatabase.getInstance().getReference(); // this points to the root of the database
       // editText = (EditText) findViewById(R.id.editText);
        //\\//textView = (TextView) findViewById(R.id.textView);

        mNameField = (EditText) findViewById(R.id.name_field);
        mEmailField = (EditText) findViewById(R.id.email_field);


//        editText_2 = (EditText) findViewById(R.id.editText2);

//        mFirebaseBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // 1 - Create child in root object
//                // 2 - Assign some value to the child object
//                String name = mNameField.getText().toString().trim();
//                String email = mEmailField.getText().toString().trim();
//
//                HashMap<String,String> dataMap = new HashMap<String, String>();
//                dataMap.put("Name",name);
//                dataMap.put("Email",email);
//                // the add on complete listener is for giving error if the setValue is not complete
//
//                mDatabase.push().setValue(dataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if(task.isSuccessful()) {
//                            Toast.makeText(MainActivity.this,"Stored...", Toast.LENGTH_LONG).show();
//                        } else {
//                            Toast.makeText(MainActivity.this,"Error...", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//
//               // mDatabase.child("Name").setValue("Victor Lee");
//            }
//        });
        switchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity();
                switch_activity();
                //System.out.println("asd");
            }
        });

    }


    public void onSubmit(View view) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        System.out.println(mDatabase.toString());
        String text1 = mNameField.getText().toString();
        String text2 = mEmailField.getText().toString();
        if(text1 != null && text2 != null) {
           // mDatabase.child("Name").setValue(g);
            //mDatabase.child("name").setValue(g);
            Person person = new Person();
            person.setName(text1);
            person.setAddress(text2);
            User_Pass u = new User_Pass(text1,text2);
            mDatabase.setValue(u);
            //displayValue(g);

        }



    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }



//    public void displayValue(String string) {
//        mDatabase.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
//               // Log.d(TAG, "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//               // Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });
//    }





}
