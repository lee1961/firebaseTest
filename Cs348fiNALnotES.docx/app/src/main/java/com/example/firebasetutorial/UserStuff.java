package com.example.firebasetutorial;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by victorlee95 on 1/31/2017.
 */

public class UserStuff extends User{
    public String name;
    public ArrayList<String> taken_quizID;
    public ArrayList<String> created_quizID;

    public UserStuff() {

    }
    public UserStuff(String name) {
        this.name = name;

    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<String> getTaken_quizID() {
        return this.getTaken_quizID();
    }
    public void setTaken_quizID(ArrayList<String> list_taken_quizID) {
        this.taken_quizID = list_taken_quizID;
    }



}
