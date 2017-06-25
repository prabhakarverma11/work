package org.ht.tweet.controller;

//import org.hibernate.mapping.List;
import org.ht.tweet.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.List;

/**
 * Created by cgfu on 9/28/16.
 */
@Controller
public class LatestTweets{

//    Twitter twitter = getTwitter();
//    List<Status> statuses = twitter.getHomeTimeline();
//
//    public LatestTweets() throws TwitterException {
//    }

    @Autowired
    TwitterService twitterService;


    @RequestMapping(value = "/latest_tweets")
    public ModelAndView latestTweetsPage() throws TwitterException {
        try {
            ModelAndView mav = new ModelAndView("latest_tweets");
            Twitter twitter = twitterService.getTwitterFormed();
            List<Status> statuses = twitter.getHomeTimeline();

            mav.addObject("statuses", statuses);
            return mav;
        } catch (TwitterException e) {
            e.printStackTrace();
            ModelAndView mav = new ModelAndView("user_home_page");
            mav.addObject("failLatestTweet", e.getMessage());
            return mav;
        }
    }

}
