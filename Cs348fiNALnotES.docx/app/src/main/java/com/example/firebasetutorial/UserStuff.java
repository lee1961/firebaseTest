package com.example.firebasetutorial;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by victorlee95 on 1/31/2017.
 */

public class UserStuff {
    public String name;
    public ArrayList<String> taken_quizID;
    public ArrayList<String> created_quizID;

    public UserStuff() {

    }
    public UserStuff(String name) {
        this.name = name;
        taken_quizID = new ArrayList<>();
        created_quizID = new ArrayList<>();
//        this.taken_quizID = null;
//        this.created_quizID = null;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }



}
