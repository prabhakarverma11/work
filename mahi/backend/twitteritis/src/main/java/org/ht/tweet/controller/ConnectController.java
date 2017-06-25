package org.ht.tweet.controller;

import org.ht.tweet.model.Account;
import org.ht.tweet.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cgfu on 9/22/16.
 */
@Controller
@RequestMapping("/connect")
public class ConnectController {

    @Autowired
    TwitterService twitterService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printWelcome(HttpServletResponse response, HttpServletRequest request) {

        Twitter twitter = twitterService.getTwitter();
        RequestToken requestToken;
        try {

            String callbackURL = "http://127.0.0.1:8080/callback";
            requestToken = twitter.getOAuthRequestToken(callbackURL);
            request.getSession().setAttribute("requestToken", requestToken);
            String authUrl = requestToken.getAuthorizationURL();
            return new ModelAndView("redirect:" + authUrl+"&force_login=true");

        } catch (TwitterException e) {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("failedToAccessTwitter", e.getMessage());
            e.printStackTrace();
            return modelAndView;
        }
//        return null;
    }
}
