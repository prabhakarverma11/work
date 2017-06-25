package org.ht.tweet.controller;

import org.ht.tweet.model.User;
import org.ht.tweet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by cgfu on 9/29/16.
 */
@Controller
public class SignupController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/signup")
    public ModelAndView signupPage(){
        ModelAndView mav = new ModelAndView("signup");
//        mav.addObject("user", new User());
        return mav;
    }

    @RequestMapping(value="/signup", method= RequestMethod.POST)
    public String signupSubmit( @ModelAttribute User user, Model model){
        User newUser = userService.findUserByUsername(user.getUsername());
//        ModelAndView mav = new ModelAndView();

        if(newUser != null){
//            mav.setViewName("redirect:/signup");
            model.addAttribute("sameUsermsg" , "this user is already present , enter new user");
            return "signup";
        }
        else {
            userService.saveUser(user);
//            mav.setViewName("login");
            model.addAttribute("message", "YOu have signed up, now login");
            return "login";
        }
    }
}
