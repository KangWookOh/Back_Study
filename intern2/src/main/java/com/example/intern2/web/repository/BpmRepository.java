package com.example.intern2.web.repository;

import com.example.intern2.web.entity.Bpm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BpmRepository extends JpaRepository<Bpm,Long> {

    @Query("select b from Bpm b  where b.user.id=:userId")
    Bpm findByUserId(@Param("userId")Long userId);

    @Query("select b from Bpm b join fetch b.user u where u.id =:user")
    List<Bpm> findUserByBpm(@Param("user")Long id);

    @Query("select b from Bpm b join fetch b.user u where u.userId=:userId")
    List<Bpm> findUserByBpm(@Param("userId") String userId);



}
