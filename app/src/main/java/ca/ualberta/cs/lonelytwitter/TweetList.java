package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public class TweetList {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void addTweet(Tweet tweet) throws IllegalArgumentException{
        if (this.hasTweet(tweet)){
            throw new IllegalArgumentException();
        }
        tweets.add(tweet);
    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public void deleteTweet(Tweet tweet){
        tweets.remove(tweet);
    }

    public Tweet getTweet(int tweetIndex){
        return tweets.get(tweetIndex);
    }

    public int getTweetCount(){
        return tweets.size();
    }

    public ArrayList<Tweet> getSortedTweets(){
        return tweets;
    }
}
