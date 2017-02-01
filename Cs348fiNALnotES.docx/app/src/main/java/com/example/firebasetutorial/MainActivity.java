package com.example.firebasetutorial;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
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
    private EditText mPasswordField;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private ProgressDialog mProgress;

    private TextView mNameView;

    private EditText mNameField;
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


    //
//
//    }
    public void switch_activity() {
        Intent intent = new Intent(this, RetrieveActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        mProgress = new ProgressDialog(this);


        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    Intent loginIntent = new Intent(MainActivity.this, RetrieveActivity.class);
                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // prevents the user from going back to the page
                    startActivity(loginIntent);

                }
            }
        };


        switchBtn = (Button) findViewById(R.id.switch_button);
        mFirebaseBtn = (Button) findViewById(R.id.firebase_btn);
        //  mDatabase = FirebaseDatabase.getInstance().getReference(); // this points to the root of the database
        // editText = (EditText) findViewById(R.id.editText);
        //\\//textView = (TextView) findViewById(R.id.textView);

        mNameField = (EditText) findViewById(R.id.name_field);
        mEmailField = (EditText) findViewById(R.id.email_field);
        mPasswordField = (EditText) findViewById(R.id.password_field);


        mAuth = FirebaseAuth.getInstance();

//        editText_2 = (EditText) findViewById(R.id.editText2);

//        mFirebaseBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//               // mDatabase.child("Name").setValue("Victor Lee");
//            }
//        });
        switchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity();
                //switch_activity();
                //System.out.println("asd");
                String name = mNameField.getText().toString();
                String email = mEmailField.getText().toString();
                mDatabase = FirebaseDatabase.getInstance().getReference();
                mDatabase.child("User").setValue(name);
                System.out.println("asdas");

            }
        });

    }

    public void onSubmit(View view) {
        startRegister();
    }

    public void startRegister() {
       // final String name = mNameField.getText().toString().trim();
//        String email = mEmailField.getText().toString().trim();
//        String password = mPasswordField.getText().toString().trim();
        final String name = "Victor";
        String email = "victorlee_1995@hotmail.com";
        String password = "abcdefg";

        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            mDatabase = FirebaseDatabase.getInstance().getReference(); // to point at users
            mProgress.setMessage("Signing up...");
            mProgress.show();
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        // once successfully signed up
                        // it is in sign in mode so retrieve id

                        //String user_id = mAuth.getCurrentUser().getUid(); // to get the uniqueid
                        //DatabaseReference current_user_db = mDatabase.child(user_id);
                        //current_user_db.child("name").setValue(name);
                        //current_user_db.child("image").setValue("default");
                        // System.out.println("the user id is " + user_id);

                        String user_id = mAuth.getCurrentUser().getUid();
                        User user1 = new User(user_id,name);
                        //user1.set_profile(user_id,name);
                        mDatabase.setValue(user1);
                        mProgress.dismiss();
                        Intent mainIntent = new Intent(MainActivity.this, RetrieveActivity.class);
                        mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(mainIntent);
                    } else {
                        mProgress.dismiss();
                        Toast.makeText(MainActivity.this, "ALready registed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


    //    public void onSubmit(View view) {
//        mDatabase = FirebaseDatabase.getInstance().getReference();
//        System.out.println(mDatabase.toString());
//        String text1 = mNameField.getText().toString();
//        String text2 = mEmailField.getText().toString();
//        if(text1 != null && text2 != null) {
//           // mDatabase.child("Name").setValue(g);
//            //mDatabase.child("name").setValue(g);
//            Person person = new Person();
//            person.setName(text1);
//            person.setAddress(text2);
//            User_Pass u = new User_Pass(text1,text2);
//            mDatabase.setValue(u);
//            //displayValue(g);
//
//        }
//
//
//
//    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
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
