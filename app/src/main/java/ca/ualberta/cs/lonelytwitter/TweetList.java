package ca.ualberta.cs.lonelytwitter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TweetList {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet) {
        tweets.add(tweet);
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int index) {
        return tweets.get(index);
    }

    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }

    public int getCount() {
        return tweets.size();
    }

    public void addTweet(Tweet tweet) {
        boolean acopy = hasTweet(tweet);
        if (acopy == false){
            add(tweet);
        }else{
            throw new IllegalArgumentException("Duplicate Tweet");
        }
    }

    public ArrayList<Tweet> getTweets(){
        Collections.sort(tweets, new Comparator<Tweet>() {
            public int compare(Tweet o1, Tweet o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
        return tweets;
    }
}
