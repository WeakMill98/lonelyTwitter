package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Anger extends CurrentMood{
    protected Date date;

    // Default constructor
    Anger() {}

    // Constructor with optional date parameter
    Anger (Date date){
        this.date = date;
    }

    void printMood() {
        System.out.print("I AM ANGRY");
    }

    // Smash something, for the anger class only
    void SmashSomething(){
        System.out.print("Just smashed something rn");
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
