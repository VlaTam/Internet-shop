package ru.tampashev.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
            .disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/user/login").permitAll()
                .antMatchers("/user/registration").anonymous()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/catalog").permitAll()
                .antMatchers("/catalog/filtered").permitAll()
                .antMatchers("/category").hasAuthority("ROLE_ADMIN")
                .antMatchers("/product/add").hasAuthority("ROLE_ADMIN")
                .antMatchers("/order/show").hasAuthority("ROLE_ADMIN")
                .antMatchers("/order/add").hasAuthority("ROLE_CUSTOMER")
                .antMatchers("/product/**").permitAll()
                .antMatchers("/basket/**").hasAnyAuthority("ROLE_CUSTOMER", "ROLE_ANONYMOUS")
                .anyRequest().authenticated()
                .and()
                    .exceptionHandling().accessDeniedPage("/WEB-INF/pages/errors/access_denied.jsp")
                    .and()
                        .formLogin()
                        .usernameParameter("j_username")
                        .passwordParameter("j_password")
                        .loginPage("/user/login")
                        .loginProcessingUrl("/j_spring_security_check")
                        .defaultSuccessUrl("/")
                        .failureUrl("/user/login?error=login or password are not valid")
                        .and()
                            .logout()
                            .logoutUrl("/user/logout")
                            .deleteCookies("JSESSIONID")
                            .logoutSuccessUrl("/");
    }
}
