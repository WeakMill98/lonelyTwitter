package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Sadness extends CurrentMood{
    protected Date date;

    Sadness(){}

    // Constructor with optional date parameter
    Sadness (Date date){
        this.date = date;
    }

    void printMood() {
        System.out.print("i am sad, rip x.");
    }

    // Cry, for the sadness class only
    void Cry(){
        System.out.print("Powerful message, crying rn");
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
