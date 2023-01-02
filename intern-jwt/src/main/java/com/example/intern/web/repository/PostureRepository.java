package com.example.intern.web.repository;

import com.example.intern.web.dto.posture.CreatePostureDto;
import com.example.intern.web.entity.Posture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostureRepository extends JpaRepository<Posture, Long> {

    // " on p.businessMember.key_id = bm.key_id " +
    @Query(" select p " +
            " from Posture p" +
            " join fetch p.businessMember bm" +
            " where bm.key_id =:key_id")
    List<Posture> findMemberByPosture(@Param("key_id") Long key_id);

    @Query(" select p " +
            " from Posture p" +
            " join fetch p.businessMember bm" +
            " where bm.license =:license")
    List<Posture> findMemberByPosture(@Param("license") String license);

    //    @Query(" select p " +
//            " from Posture p" +
//            " join fetch p.businessMember bm" +
//            " where bm.key_id =:key_id")
//    List<Posture> findMemberByPosture(@Param("key_id") Long id);
}