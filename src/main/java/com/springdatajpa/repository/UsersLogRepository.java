package com.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdatajpa.model.UsersLog;

public interface UsersLogRepository extends JpaRepository<UsersLog, Long> {

}
