package org.ht.tweet.controller;

import org.ht.tweet.model.Search;
import org.ht.tweet.service.SearchService;
import org.ht.tweet.service.TweetService;
import org.ht.tweet.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import twitter4j.*;

import java.util.List;

/**
 * Created by cgfu on 10/2/16.
 */
@Controller
public class SearchController {

    @Autowired
    TwitterService twitterService;

    @Autowired
    SearchService searchService;

    @RequestMapping(value = "/search")
    public ModelAndView searchPage() {
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("string", new String());
        return mav;
    }


    @RequestMapping(value = "/search" , method = RequestMethod.POST)
    public ModelAndView searchResultPage(@ModelAttribute String string) throws TwitterException {
        ModelAndView mav = new ModelAndView("searchResult");
        Twitter twitter = twitterService.getTwitterFormed();

        try {
            Query query = new Query(string);
            QueryResult queryResult = twitter.search(query);
            List<Status> statuses = queryResult.getTweets();
            Search search = new Search(twitterService.getCurrentUser().getAccount(), string);
            searchService.saveSearch(search);
            mav.addObject("statuses", statuses);
        } catch (TwitterException e) {
            mav.addObject("failedSearch", e.getMessage());
            mav.setViewName("search");
            e.printStackTrace();
        }
        return mav;
    }
}
