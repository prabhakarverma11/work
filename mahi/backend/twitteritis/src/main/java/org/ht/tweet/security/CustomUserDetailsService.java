package org.ht.tweet.security;

import org.ht.tweet.model.Account;
import org.ht.tweet.model.User;
import org.ht.tweet.security.CustomUserDetails;
import org.ht.tweet.service.AccountService;
import org.ht.tweet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cgfu on 9/23/16.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String userName )
            throws UsernameNotFoundException {
        User user = userService.findUserByUsername(userName);
        System.out.println("User : "+user);
        if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new CustomUserDetails(user);

    }

}