package org.ht.tweet.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.ht.tweet.model.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by cgfu on 9/29/16.
 */
@Repository
public class TweetDaoImpl implements TweetDao {

    @Autowired
    SessionFactory sessionFactory;

    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }


    public void updateTweet(Tweet tweet) {
        getCurrentSession().update(tweet);
    }

    public void deleteTweet(Tweet tweet) {

        getCurrentSession().delete(tweet);
    }

    public void saveTweet(Tweet tweet) {

        getCurrentSession().save(tweet);
    }

    public Tweet findTweetByTweet(String string) {

        Tweet tweet = (Tweet) getCurrentSession().createCriteria(Tweet.class).add(Restrictions.eq("tweet",string)).uniqueResult();
        return tweet;

    }
}
