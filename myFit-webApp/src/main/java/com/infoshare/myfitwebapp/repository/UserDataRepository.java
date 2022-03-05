package com.infoshare.myfitwebapp.repository;

import com.infoshare.myfitwebapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDataRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
}
