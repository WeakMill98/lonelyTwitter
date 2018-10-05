package ca.ualberta.cs.lonelytwitter;

/*
* class NormalTweet
*
* inherits the tweet class
*
* Implements isImportant and returns False
* */

public class NormalTweet extends Tweet {
    NormalTweet() {
        super();
    }

    NormalTweet(String message) {
        super(message);
    }

    @Override
    public Boolean isImportant() {
        return false;
    }
}