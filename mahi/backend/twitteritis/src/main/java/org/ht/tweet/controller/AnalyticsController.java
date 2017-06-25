package org.ht.tweet.controller;

import org.ht.tweet.model.Account;
import org.ht.tweet.model.Search;
import org.ht.tweet.model.Tweet;
import org.ht.tweet.model.message;
import org.ht.tweet.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

/**
 * Created by cgfu on 10/2/16.
 */
@Controller
public class AnalyticsController {

    @Autowired
    TwitterService twitterService;


    @RequestMapping(value = "/analytics")
    public ModelAndView analyticsPage(){
        ModelAndView mav = new ModelAndView("analytics");
        List<Tweet> tweets = twitterService.getCurrentUser().getAccount().getTweets();
        Set<Search> searches = twitterService.getCurrentUser().getAccount().getSearches();
        Set<message> messages = twitterService.getCurrentUser().getAccount().getMessages();
        mav.addObject("tweets", tweets.size());
        mav.addObject("searches", searches.size());
        mav.addObject("messages", messages.size());
        return mav;
    }

    @RequestMapping(value = "/appTweets")
    public ModelAndView appTweetsPage(){
        ModelAndView mav = new ModelAndView("appTweets");
        List<Tweet> tweets = twitterService.getCurrentUser().getAccount().getTweets();
        mav.addObject("tweets" , tweets);
        return mav;
    }


    @RequestMapping(value = "/appSearches")
    public ModelAndView appSearchesPage(){
        ModelAndView mav = new ModelAndView("appSearches");
        Set<Search> searches = twitterService.getCurrentUser().getAccount().getSearches();
        mav.addObject("searches",searches);
        return mav;
    }

    @RequestMapping(value = "/appMessages")
    public ModelAndView appMessagesPage() {
        ModelAndView mav = new ModelAndView("appMessages");
        Set<message> messages = twitterService.getCurrentUser().getAccount().getMessages();
        mav.addObject("messages", messages);
        return mav;
    }
}
