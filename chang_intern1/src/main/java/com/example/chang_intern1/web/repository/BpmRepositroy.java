package com.example.chang_intern1.web.repository;


import com.example.chang_intern1.web.entity.Bpm;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BpmRepositroy extends JpaRepository<Bpm,Long> {

    @Query("select b "+ "from  Bpm b "+" join fetch b.user u"+" where u.userName=:user")
    List<Bpm> findUserByBpInfo(@Param("user") String user);


}
