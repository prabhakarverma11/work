package org.ht.tweet.service;

import org.ht.tweet.model.User;
import org.ht.tweet.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by cgfu on 9/28/16.
 */
@Service
//@Transactional
public class   TwitterServiceImpl implements TwitterService {


    @Value("${twitter4j.oauth.consumerKey}")
    String consumerKey;

    @Value("${twitter4j.oauth.consumerSecret}")
    String consumerSecret;


    public Twitter getTwitter(){

//        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
//        configurationBuilder.setHttpProxyHost("10.24.2.30");
//        configurationBuilder.setHttpProxyPort(8080);
//        configurationBuilder.setHttpProxyUser("htmedia/M82508");
//        configurationBuilder.setHttpProxyPassword("password123");
//
//        Twitter twitter= new TwitterFactory(configurationBuilder.build()).getInstance();
        Twitter twitter = new TwitterFactory().getInstance();


        twitter.setOAuthConsumer(consumerKey, consumerSecret);

        return twitter;
    }



    public User getCurrentUser(){
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDetails.getUser();

        return user;
    }



    public void setAccessToken(Twitter twitter){
        User user = getCurrentUser();
        AccessToken accessToken = new AccessToken(user.getAccount().getAccessToken(), user.getAccount().getAccessTokenSecret());
        twitter.setOAuthAccessToken(accessToken);
    }


    //returns twitter with accesstoken set
    public Twitter getTwitterFormed(){
        Twitter twitter = getTwitter();
        setAccessToken(twitter);
        return  twitter;
    }

//    public twitter4j.User getUser(RequestToken requestToken, String verifier) throws TwitterException {
//        Twitter twitter = getTwitter();
//        AccessToken accessToken = twitter.getOAuthAccessToken(requestToken,verifier);
//        twitter.setOAuthAccessToken(accessToken);
//        return twitter.verifyCredentials();
//    }
//
//    public AccessToken getOAuthAccessToken(RequestToken requestToken, String verifier) throws TwitterException {
//        Twitter twitter=getTwitter();
//        return twitter.getOAuthAccessToken(requestToken,verifier);
//    }
//
//    public RequestToken getOAuthRequestToken(String callbackURL) throws TwitterException {
//        return getTwitter().getOAuthRequestToken(callbackURL);
//    }
//

}
