package com.springdatajpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springdatajpa.model.Users;

@Repository
public interface UserJpaRepository extends JpaRepository<Users, Long>{

	Optional<List<Users>> findByName(String name);

}
