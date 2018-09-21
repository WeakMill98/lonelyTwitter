package ca.ualberta.cs.lonelytwitter;

public class TooLongTweetException extends Exception {

    TooLongTweetException() {
        super("The message is too long! Please keep your tweets within 140 characters.");
    }
}