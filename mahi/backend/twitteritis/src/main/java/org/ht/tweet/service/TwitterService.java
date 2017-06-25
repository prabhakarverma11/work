package org.ht.tweet.service;

import org.ht.tweet.model.User;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

/**
 * Created by cgfu on 9/28/16.
 */
public interface TwitterService {

    Twitter getTwitter();
    User getCurrentUser();
    void setAccessToken(Twitter twitter);
    Twitter getTwitterFormed();

//
//    twitter4j.User getUser(RequestToken requestToken, String verifier) throws TwitterException;
//
//    AccessToken getOAuthAccessToken(RequestToken requestToken, String verifier) throws TwitterException;
//
//    RequestToken getOAuthRequestToken(String callbackURL) throws TwitterException;
}
