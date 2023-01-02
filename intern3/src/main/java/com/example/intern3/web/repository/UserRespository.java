package com.example.intern3.web.repository;

import com.example.intern3.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public interface UserRespository extends JpaRepository<User,Long> {


    Optional<User> findByuserId(String userId);
    User findUserByUserId(String userId);

//    @Query("select u from User u where u.userId=:userId")
//    User findByUserId(@Param("userId") String userId);
//
//    @Query("select u from User u where u.userPw=:userPw")
//    User findByUserPw(String userPw);

}
