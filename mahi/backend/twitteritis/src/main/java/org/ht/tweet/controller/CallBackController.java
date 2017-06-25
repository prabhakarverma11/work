package org.ht.tweet.controller;

import org.ht.tweet.model.Account;
import org.ht.tweet.model.UserProfile;
import org.ht.tweet.security.CustomUserDetails;
import org.ht.tweet.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cgfu on 9/22/16.
 */
@Controller
@RequestMapping("/callback")
public class CallBackController {


    @Autowired
    TwitterService twitterService;

//    @Autowired
//    DBFillingService dbFillingService;

    @Autowired
    AccountService accountService;

    @Autowired
    UserProfileService userProfileService;

    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {


        try {
            Twitter twitter = twitterService.getTwitter();
            //getting access token
            String verifier = request.getParameter("oauth_verifier");

            RequestToken requestToken = (RequestToken) request.getSession().getAttribute("requestToken");

            AccessToken accessToken = twitter.getOAuthAccessToken(requestToken,verifier);
            twitter.setOAuthAccessToken(accessToken);
            User user = twitter.verifyCredentials();


            //Saving access token to db
            org.ht.tweet.model.User user1 = twitterService.getCurrentUser();
            Account account =  new Account(user1, accessToken);
            accountService.saveAccount(account);
            user1.setAccount(account);


            //now filling UserProfile db for analytics
            UserProfile userProfile = new UserProfile(user, account);
            userProfileService.saveUserProfile(userProfile);
            account.setUserProfile(userProfile);


            System.out.println(user.getName());
            ModelAndView model = new ModelAndView("user_home_page");
            model.addObject("message1", "YOur access Token have been storred" +user.getName());
            return model;
        } catch (TwitterException e) {
            e.printStackTrace();
            ModelAndView mav = new ModelAndView("login");
            mav.addObject("twitterAccessTokenFail", e.getMessage());
            return mav;
        }
    }

    @RequestMapping(method = RequestMethod.GET,params = "denied")
    public String deniedPage(Model model){
        model.addAttribute("deniedAuthourization","YOu denied Authorization, now burn in hell");
        return "redirect: /login";


    }
}
