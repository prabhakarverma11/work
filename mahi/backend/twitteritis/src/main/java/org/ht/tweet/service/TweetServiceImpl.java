package org.ht.tweet.service;

import org.ht.tweet.dao.TweetDao;
import org.ht.tweet.dao.TweetDaoImpl;
import org.ht.tweet.model.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cgfu on 9/29/16.
 */
@Service
@Transactional
public class TweetServiceImpl implements TweetService {

    @Autowired
    TweetDao tweetDao;

    public void updateTweet(Tweet tweet) {

        tweetDao.updateTweet(tweet);

    }

    public void deleteTweet(Tweet tweet) {

        tweetDao.deleteTweet(tweet);
    }

    public void saveTweet(Tweet tweet) {

        tweetDao.saveTweet(tweet);
    }

    public Tweet findTweetByTweet(String string) {

        return tweetDao.findTweetByTweet(string);
    }
}
