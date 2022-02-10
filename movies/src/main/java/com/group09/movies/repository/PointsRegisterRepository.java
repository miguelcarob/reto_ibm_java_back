package com.group09.movies.repository;

import com.group09.movies.entity.PointsRegister;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointsRegisterRepository extends JpaRepository<PointsRegister, Integer> {
}