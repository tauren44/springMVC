package com.mateacademy.springmvcexample.repository;

import com.mateacademy.springmvcexample.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
