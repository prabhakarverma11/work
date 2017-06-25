package org.ht.tweet.security;

import lombok.Getter;
import lombok.Setter;
import org.ht.tweet.model.Account;
import org.ht.tweet.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.*;

/**
 * Created by cgfu on 9/23/16.
 */
@Getter
@Setter
public class CustomUserDetails implements UserDetails {

    public CustomUserDetails() {
        super();
    }

    public CustomUserDetails(User user) {

        this.user = user;
    }

    private User user;


    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        list.add(new SimpleGrantedAuthority("ROLE_USER"));
        return list;
    }

    public String getPassword() {
        return user.getPassword();
    }

    public String getUsername() {
        return user.getUsername();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }
}
