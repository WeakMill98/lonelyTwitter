package ca.ualberta.cs.lonelytwitter;

/*
* class TooLongTweetException
*
* Inherits Exception
*
* When instantiated, throws an exception
* */

public class TooLongTweetException extends Exception {

    TooLongTweetException() {
        super("The message is too long! Please keep your tweets within 140 characters.");
    }
}