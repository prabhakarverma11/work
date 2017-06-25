package org.ht.tweet.controller;

//import org.hibernate.engine.spi.Status;
import org.hibernate.annotations.SourceType;
import org.ht.tweet.model.Tweet;
import org.ht.tweet.service.TweetService;
import org.ht.tweet.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 * Created by cgfu on 9/28/16.
 */
@Controller
public class PostController {

    @Autowired
    TwitterService twitterService;

    @Autowired
    TweetService tweetService;

    @RequestMapping(value="/post")
    public ModelAndView onPostPage(){
        ModelAndView mav = new ModelAndView("post");
        mav.addObject("string", new String());
        return mav;
    }

    @RequestMapping(value="/post", method= RequestMethod.POST)
    public ModelAndView afterPostPage(@ModelAttribute String string) throws TwitterException {

        Twitter twitter = twitterService.getTwitterFormed();


        ModelAndView mav = new ModelAndView("user_home_page");
        try {
            Status status = twitter.updateStatus(string);
            System.out.println("Status Updated to " + status.getText());
            mav.addObject("posttweetmsg","STATUS update to" + status.getText());
            Tweet tweet = new Tweet(twitterService.getCurrentUser().getAccount(), status.getText());
            tweetService.saveTweet(tweet);

        } catch (TwitterException e) {
            mav.addObject("failtweetmsg", e.getMessage());
            mav.setViewName("post");
            e.printStackTrace();

        }



        return mav;
    }
}
