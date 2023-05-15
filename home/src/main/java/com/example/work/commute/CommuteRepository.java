package com.example.work.commute;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommuteRepository extends JpaRepository<Commute ,Long> {
    @Override
    Optional<Commute> findById(Long aLong);
}
