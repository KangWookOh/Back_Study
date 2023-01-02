package com.example.intern.web.repository;

import com.example.intern.web.entity.Fastener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FastenerRepository extends JpaRepository<Fastener, Long> {

    @Query(" select f " +
            " from Fastener f" +
            " join fetch f.businessMember bm" +
            " where bm.key_id =:key_id")
    List<Fastener> findMemberByFastener(@Param("key_id") Long key_id);

    @Query(" select f " +
            " from Fastener f" +
            " join fetch f.businessMember bm" +
            " where bm.license =:license")
    List<Fastener> findMemberByFastener(@Param("license") String license);
}
