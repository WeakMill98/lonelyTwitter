package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

public abstract class Tweet implements Tweetable {

    private Date date;
    private String message;
    private static final Integer MAX_CHARS = 140;
    private ArrayList<CurrentMood> moodArrayList = new ArrayList<CurrentMood>();

    //Empty argument constructor with default values
    Tweet() {
        //Must use the 'this' keyword in order to specify the current object message = message does nothing!
        this.date = new Date();
        this.message = "I am default message schwa!";
    }

    //Overloading: so that we can specify the tweet content
    Tweet(String message) {
        this.date = new Date();
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) throws TooLongTweetException {
        if (message.length() <= this.MAX_CHARS ) {
            this.message = message;
        } else {
            throw new TooLongTweetException();
        }
    }

    public void AddMood(CurrentMood Mood) {
        this.moodArrayList.add(Mood);
    }

    public Date getDate() { return this.date; }

    //No method body implemented! We leave that up to the subclasses (they MUST implement it)
    public abstract Boolean isImportant();

    public String toString(){
     return this.date.toString() + " | " + this.message;
    }
}