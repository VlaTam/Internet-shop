package ru.tampashev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.tampashev.shop.dto.User;
import ru.tampashev.shop.services.UserService;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final String adminEmail = "admin@admin";
    private final String adminPassword = "sector578";

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if (email == null)
            throw new UsernameNotFoundException("Email is null");

        if (email.trim().equals(adminEmail))
            return getAdmin();

        User user = userService.findByEmail(email.trim());
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(user.getRole().getName()));

        return new  org.springframework.security.core.userdetails
                    .User(user.getMailAddress(), user.getPassword(), roles);
    }

    private UserDetails getAdmin(){
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        String encodedPassword = new BCryptPasswordEncoder().encode(adminPassword);

        return new  org.springframework.security.core.userdetails.User(adminEmail, encodedPassword, roles);
    }
}
