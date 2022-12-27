package com.example.chang_intern1.web.repository;

import com.example.chang_intern1.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositroy extends JpaRepository<User,Long> {

    Optional<User> findByUserId (String userId);
    Optional<User>  findByUserName (String userName);

}
