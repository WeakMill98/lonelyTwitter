package ca.ualberta.cs.lonelytwitter;

/*
* Interface Tweetable
*
* When implemented, getMessage and getDate must be supplied
* */

import java.util.Date;

public interface Tweetable {
    public String getMessage();
    public Date getDate();
}