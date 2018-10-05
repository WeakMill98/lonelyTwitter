package ca.ualberta.cs.lonelytwitter;

/*
* Abstract Super class
* Meant for different emotions to inherit this class
*
* requires a printMood Method to be implemented by the children class
*
* */

import java.util.Date;

public abstract class CurrentMood    {
    // Datetime does not need to be changed for the sub class
    protected Date date;

    // Abstract method
    // printMood depends on what the mood actually is
    abstract void printMood();

    // Setter for date time
    public void setDateTime(Date date){
        this.date = date;
    }

    // Getter for date time
    public Date getDateTime(){
        return date;
    }
}



