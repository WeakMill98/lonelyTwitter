package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Happiness extends CurrentMood{
    protected Date date;

    Happiness(){}

    // Constructor with optional date parameter
    Happiness (Date date){
        this.date = date;
    }

    void printMood() {
        System.out.print("I am happy");
    }

    // BeHappy for the Happiness class only
    void BeHappy(){
        System.out.print("So happy rn");
    }

    @Override
    public void setDateTime(Date date){
        this.date = date;
    }

    @Override
    public Date getDateTime(){
        return this.date;
    }

}
