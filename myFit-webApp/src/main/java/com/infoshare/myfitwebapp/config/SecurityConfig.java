package com.infoshare.myfitwebapp.config;

import com.infoshare.myfitwebapp.security.oauth2.CustomerOAuth2UserService;
import com.infoshare.myfitwebapp.security.oauth2.OAuth2LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomerOAuth2UserService oAuth2UseService;

    @Autowired
    private OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/oauth2/**").permitAll()
                .antMatchers("/", "/register", "/webjars/**", "/css/**", "/js/**", "/images/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .oauth2Login()
                .loginPage("/login")
                .userInfoEndpoint().userService(oAuth2UseService)
                .and()
                .successHandler(oAuth2LoginSuccessHandler)
                .and()
                .logout().logoutSuccessUrl("/?logout")
                .permitAll();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


}