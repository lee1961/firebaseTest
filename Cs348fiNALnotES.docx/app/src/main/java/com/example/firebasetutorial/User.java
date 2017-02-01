package com.example.firebasetutorial;

import java.util.ArrayList;

/**
 * Created by victorlee95 on 1/31/2017.
 */

public class User {
    public String userID;
    public String name;
    public ArrayList<String> taken_quizID;
    public ArrayList<String> created_quizID;

    public User() {

    }
    public User(String userID,String name) {
        this.userID = userID;
        this.name = name;
    }


    public void set_profile(String userID,String name) {
        this.userID = userID;
        this.name = name;
    }






}
