package org.ht.tweet.controller;

import org.ht.tweet.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by cgfu on 10/2/16.
 */
@Controller
public class ProfileController {

    @Autowired
    TwitterService twitterService;


    @RequestMapping(value = "/profile")
    public ModelAndView profilePage(){
        ModelAndView mav = new ModelAndView("profile");
        mav.addObject("user" ,twitterService.getCurrentUser().getAccount().getUserProfile());
        return mav;
    }

}
