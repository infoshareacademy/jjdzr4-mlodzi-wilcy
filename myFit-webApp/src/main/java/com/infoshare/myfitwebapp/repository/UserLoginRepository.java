package com.infoshare.myfitwebapp.repository;

import com.infoshare.myfitwebapp.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
    UserLogin findByUsername(String username);
}
