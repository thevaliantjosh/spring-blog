package com.codeup.springblog.models;

import java.util.Random;

public class Dice {

    //Instance Variables
    private String number;

    //Getters and Setters

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    //Constructors

    public Dice(){

    }

    public Dice(String number){
        this.number = number;
    }


    //Methods

    public String rollDice(){
        Random generator = new Random();
        int diceRoll = generator.nextInt(6);
        return Integer.toString(diceRoll);
    }
}
