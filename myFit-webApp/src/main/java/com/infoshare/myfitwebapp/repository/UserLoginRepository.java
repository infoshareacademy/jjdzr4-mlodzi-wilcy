package com.infoshare.myfitwebapp.repository;

import com.infoshare.myfitwebapp.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
    UserLogin findByUsername(String username);
}
