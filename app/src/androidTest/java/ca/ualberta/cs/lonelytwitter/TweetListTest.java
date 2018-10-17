package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

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

}
