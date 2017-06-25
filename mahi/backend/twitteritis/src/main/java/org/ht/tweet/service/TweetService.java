package org.ht.tweet.service;

import org.ht.tweet.model.Tweet;

/**
 * Created by cgfu on 9/29/16.
 */
public interface TweetService {
    void updateTweet(Tweet tweet);
    void deleteTweet(Tweet tweet);
    void saveTweet(Tweet tweet);
    Tweet findTweetByTweet(String string);
}
