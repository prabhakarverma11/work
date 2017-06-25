package org.ht.tweet.controller;

import org.ht.tweet.service.MessageService;
import org.ht.tweet.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import twitter4j.DirectMessage;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 * Created by cgfu on 10/3/16.
 */
@Controller
public class MessageController {
    @Autowired
    TwitterService twitterService;

    @Autowired
    MessageService messageService;


    @RequestMapping(value = "/message")
    public ModelAndView messagePage(){
        ModelAndView mav = new ModelAndView("message");
        return mav;
    }


    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public ModelAndView messagePost(@ModelAttribute ("handle") String handle, @ModelAttribute("mesg") String mesg){
        ModelAndView mav = new ModelAndView("user_home_page");
        Twitter twitter = twitterService.getTwitterFormed();
        try {
            DirectMessage message = twitter.sendDirectMessage(handle, mesg);
            System.out.println("Direct message successfully sent to " + message.getRecipientScreenName());
            mav.addObject("messageSent","Message Has been Sent");
            org.ht.tweet.model.message message1 =  new org.ht.tweet.model.message(twitterService.getCurrentUser().getAccount(), handle, mesg);
            messageService.saveMessage(message1);

        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to send a direct message: " + te.getMessage());
            mav.addObject("failedMessage", te.getMessage());
            mav.setViewName("message");
        }
        return mav;

    }
}
