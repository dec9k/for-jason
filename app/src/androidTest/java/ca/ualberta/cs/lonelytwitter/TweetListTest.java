package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;

public class TweetListTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity>{

    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    // JUnit test method for adding tweet into TweetList
    public void testAddTweet() {
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("added tweet");
        tweetList.add(tweet);

        assertTrue(tweetList.hasTweet(tweet));
    }

    // JUnit test method for checking whether a tweet is in the TweetList
    public void testHasTweet() {
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("Hello");

        // tweet not in the tweet list, test should return false
        assertFalse(tweetList.hasTweet(tweet));

        tweetList.add(tweet);

        // tweet in the tweet list, test should return true
        assertTrue(tweetList.hasTweet(tweet));
    }

    public void testGetTweet() {
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("get tweet check");

        tweetList.add(tweet);
        Tweet retrievedTweet = tweetList.getTweet(0);

        assertEquals(retrievedTweet.getMessage(), tweet.getMessage());
        assertEquals(retrievedTweet.getDate(), tweet.getDate());
    }

    public void testDeleteTweet() {
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("one for delete");

        tweetList.add(tweet);
        tweetList.delete(tweet);

        assertFalse(tweetList.hasTweet(tweet));
    }

    public void testGetTweets() {
        TweetList tweetList = new TweetList();
        Tweet tweet1 = new NormalTweet("first tweet");
        tweetList.add(tweet1);
        Tweet tweet2 = new NormalTweet("second tweet");
        tweetList.add(tweet2);
        ArrayList<Tweet> retrievedTweet = tweetList.getTweets();
        Tweet firstTweet = retrievedTweet.get(0);
        Tweet secondTweet = retrievedTweet.get(1);

        assertEquals(firstTweet.getMessage(), tweet1.getMessage());
        assertEquals(firstTweet.getDate(), tweet1.getDate());

        assertEquals(secondTweet.getMessage(), tweet2.getMessage());
        assertEquals(secondTweet.getDate(), tweet2.getDate());
    }

    public void testGetCount(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("Tweet");
        tweetList.add(tweet);

        assertEquals(tweetList.getCount(), 1);
    }

}
