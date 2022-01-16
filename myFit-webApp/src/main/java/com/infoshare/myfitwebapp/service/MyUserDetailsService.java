package com.infoshare.myfitwebapp.service;

import com.infoshare.myfitwebapp.model.UserLogin;
import com.infoshare.myfitwebapp.model.UserPrincipal;
import com.infoshare.myfitwebapp.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService  implements UserDetailsService{

    @Autowired
    private UserLoginRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username){
        UserLogin userLogin = userRepository.findByUsername(username);
        if(userLogin == null){
            throw new UsernameNotFoundException(username);
        }
        return new UserPrincipal(userLogin);
    }
}
