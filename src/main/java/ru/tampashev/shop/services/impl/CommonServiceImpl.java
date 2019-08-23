package ru.tampashev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.tampashev.shop.dto.User;
import ru.tampashev.shop.services.CommonService;
import ru.tampashev.shop.services.UserService;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private UserService userService;

    @Override
    public User getAuthorisedUser() {
        User user = new User();

        if (!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
            UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            user = userService.findByEmail(principal.getUsername());
        }

        return user;
    }
}
