package org.ht.tweet.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.ht.tweet.model.Account;
import org.ht.tweet.model.User;
import org.ht.tweet.security.CustomUserDetails;
import org.ht.tweet.service.AccountService;
import org.ht.tweet.service.TwitterService;
import org.ht.tweet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cgfu on 9/21/16
 */
@Controller
public class MainController {

    @Autowired
    TwitterService twitterService;

    @Autowired
    AccountService accountService;

    @Autowired
    UserService userService;


    @RequestMapping(value="/" , method=RequestMethod.GET)
    public String mainPage() {
        //get user from session and set account
        User user = twitterService.getCurrentUser();
//        Account account = accountService.findAccountById(user.getId());
//        user.setAccount(account);

        //check for accesstoken
        if(user.getAccount() != null) {
//            if (user.getAccount().getAccessToken() != null)
                return ("user_home_page");
//            else
//                return ("redirect:connect");
        }
        return ("redirect:connect");
    }


    @RequestMapping(value="/login")
    public ModelAndView loginPage(){
        return new ModelAndView("login");}


//    @RequestMapping(value="/login", method = RequestMethod.POST)
//    public ModelAndView loginPostPage(@ModelAttribute ("username") String username, @ModelAttribute ("password") String password){
//
//        User user = userService.findUserByUsername(username);
//        ModelAndView mav = new ModelAndView("");
//        if(user == null) {
////            ModelAndView mav = new ModelAndView("/login");
//            mav.setViewName("/login");
//            mav.addObject("userMessage", "User not created, please signup first");
//        }
//        else if(user.getPassword() != password) {
////            ModelAndView mav = new ModelAndView("/login");
//            mav.setViewName("/login");
//            mav.addObject("userMessage", "User and password do not matech");
//        }
//        else {
////            ModelAndView mav = new ModelAndView("/");
//            mav.setViewName("/");
//        }
//        return mav;
//    }


    @RequestMapping(value="/Access_Denied")
    public ModelAndView accessDeniedPage(){return new ModelAndView("Access_Denied");}



    @RequestMapping(value="/homePage")
    public ModelAndView homePage(){
        return new ModelAndView("user_home_page");

    }


    @RequestMapping(value = "/favicon.ico")
    public String image(){
        return "redirect: /resources/images/twitterlogo.png";
    }

}
