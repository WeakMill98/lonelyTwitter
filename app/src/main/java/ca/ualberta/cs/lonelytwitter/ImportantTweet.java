package ca.ualberta.cs.lonelytwitter;
/*
* Class ImportantTweet
* Inherits the Tweet class
*
* Implements the isImportant Interface of the abstract tweet class
* Adds a Boolean isImportant to True
* */

public class ImportantTweet extends Tweet {

    //Empty argument constructor with default values
    ImportantTweet() {
        //Call the parent constructor to: avoid duplication!
        super();
    }

    ImportantTweet(String message) {
        super(message);
    }

    @Override
    public Boolean isImportant() {
        return true;
    }
}