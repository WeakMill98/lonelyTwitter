package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Tweet{
    private String message;
    private Date date;

    public Tweet () {
    }

    public Tweet (String message) {
        this.message = message;
    }

    // Mention that the exception might be thrown in the function
    public String getMessage(){
        return this.message;
    }

    public void setMessage(String message)throws TooLongTweetException{
        if (message.length() > 140){
            throw new TooLongTweetException();
        }
        this.message = message;
    }

    public Date getDate(){
        return this.date;
    }

    public void setDate(Date date){
        this.date = date;
    }

}
