package com.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springdatajpa.model.UserContact;

@Repository
public interface UsersContactRepository extends JpaRepository<UserContact, Long> {

}
