package org.ht.tweet.controller;

import org.ht.tweet.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.List;

/**
 * Created by cgfu on 10/3/16.
 */
@Controller
public class FriendTimelineController {
    @Autowired
    TwitterService twitterService;


    //// TODO: 10/7/16 Change to scheduler and database
    @RequestMapping(value = "/friend_timeline")
    public ModelAndView friendTimelinePage() throws TwitterException {
        ModelAndView mav = new ModelAndView("friendTimeline");
        Twitter twitter = twitterService.getTwitterFormed();
        Paging paging = new Paging(2, 10);
        List<Status> statuses = twitter.getHomeTimeline(paging);
        mav.addObject("statuses", statuses);
        return mav;
    }
}
