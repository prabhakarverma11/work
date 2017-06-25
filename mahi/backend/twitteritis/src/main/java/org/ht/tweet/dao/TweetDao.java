package org.ht.tweet.dao;

import org.ht.tweet.model.Tweet;

/**
 * Created by cgfu on 9/29/16.
 */
public interface TweetDao {

    void updateTweet(Tweet tweet);
    void deleteTweet(Tweet tweet);
    void saveTweet(Tweet tweet);
    Tweet findTweetByTweet(String string);
}
