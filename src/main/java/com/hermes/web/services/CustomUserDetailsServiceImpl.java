package com.hermes.web.services;

import com.hermes.core.domain.users.AbstractUser;
import com.hermes.core.domain.users.Role;
import com.hermes.core.infrastructure.dataaccess.services.UserService;
import com.hermes.core.infrastructure.dataaccess.specifications.users.UserWhich;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan on 08.11.16.
 */
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService{

    @Autowired
    private UserService userService;
    @Autowired
    private UserWhich userWhich;

    static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        AbstractUser user = userService.getOne(userWhich.hasLogin(s));

        String username = user.getLogin();
        String password = user.getPassword();
        Role role = user.getRole();

        List<SimpleGrantedAuthority> authList = getAuthorities(role);

        //get the encoded password
        String encodedPassword = passwordEncoder.encode(password);

        User user = new User(username, encodedPassword, authList);

        return user;
    }

    private List<SimpleGrantedAuthority> getAuthorities(Role role) {
        List<SimpleGrantedAuthority> authList = new ArrayList<>();
        authList.add(new SimpleGrantedAuthority("ROLE_USER"));

        //you can also add different roles here
        //for example, the user is also an admin of the site, then you can add ROLE_ADMIN
        //so that he can view pages that are ROLE_ADMIN specific
        if (role != null && role.trim().length() > 0) {
            if (role.equals("admin")) {
                authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }
        }

        return authList;
    }
}
