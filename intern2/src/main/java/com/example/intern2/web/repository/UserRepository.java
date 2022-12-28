package com.example.intern2.web.repository;

import com.example.intern2.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    //User findByUserId(String userId);

    @Query("select u from User u where u.userId=:userId")
    User findByUserId(@Param("userId") String userId);

    @Query("select u from User u where u.userPw=:userPw")
    User findByUserPw(String userPw);




}
