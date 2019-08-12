package ru.tampashev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.tampashev.shop.dto.User;
import ru.tampashev.shop.services.UserService;

import javax.transaction.Transactional;
import java.util.Collections;

@Service
@Transactional
public class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = new User();
        user.setMailAddress(email);
        if (userService.find(user) < 0) {
            throw new UsernameNotFoundException(email);
        }
        return new org.springframework.security.core.userdetails.User(user.getMailAddress(), user.getPassword(),
                Collections.emptyList());
    }
}
