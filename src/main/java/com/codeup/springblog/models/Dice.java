package com.codeup.springblog.models;

import java.util.Random;

public class Dice {

    //Instance Variables
    private int number;

    //Getters and Setters

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    //Constructors

    public Dice(){

    }

    public Dice(int number){
        this.number = number;
    }

    //Methods

    public int rollDice(){
        Random generator = new Random();
        int diceRoll = generator.nextInt(6);
        return diceRoll;
    }
}
