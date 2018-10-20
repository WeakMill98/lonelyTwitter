package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import junit.framework.Assert;

import java.util.ArrayList;

public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Tweet");
        tweets.addTweet(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testDeleteTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Tweet");

        tweets.addTweet(tweet);
        assertTrue(tweets.hasTweet(tweet));

        tweets.deleteTweet(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }

    public void testHasTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("Hello");

        assertFalse(tweetList.hasTweet(tweet));
        tweetList.addTweet(tweet);
        assertTrue(tweetList.hasTweet(tweet));
    }

    public void testHasDuplicateTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("Hello");
        try {
            assertFalse(tweetList.hasTweet(tweet));
            tweetList.addTweet(tweet);
            assertTrue(tweetList.hasTweet(tweet));
            tweetList.addTweet(tweet);
        }
        catch (IllegalArgumentException e) {
        }
    }

    public void testGetChronologicalOrder(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("Yeah Okay");
        tweetList.addTweet(tweet);
        ArrayList<Tweet> tweets2 = new ArrayList<Tweet>();
        tweets2.add(tweet);

        assertEquals(tweetList.getSortedTweets(), tweets2);
    }

    public void testGetTweetCount(){
        TweetList tweets = new TweetList();
        Tweet tweet1 = new NormalTweet("Hello");
        Tweet tweet2 = new NormalTweet("Hello Again");

        tweets.addTweet(tweet1);
        assertEquals(tweets.getTweetCount(), 1);

        tweets.addTweet(tweet2);
        assertEquals(tweets.getTweetCount(), 2);
    }

    public void testGetTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Tweet");
        tweets.addTweet(tweet);
        Tweet returnedTweet = tweets.getTweet(0);

        assertTrue(returnedTweet.equals(tweet));
        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
    }
}
