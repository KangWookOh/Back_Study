package com.example.intern.web.repository;

import com.example.intern.web.entity.BusinessMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface BusinessMemberRepository extends JpaRepository<BusinessMember, Long> {

    @Query("select m from BusinessMember m where m.b_number =:b_number")
    BusinessMember findByB_number(@Param("b_number") Integer b_number);

    BusinessMember findByLicense(String license);

    @Query("select m from BusinessMember m where m.b_number =:b_number")
    Optional<BusinessMember> findByB_number1(Integer b_number);

    @Query("select m from BusinessMember m where m.license =:license")
    Optional<BusinessMember> findByLicense1(String license);
}
