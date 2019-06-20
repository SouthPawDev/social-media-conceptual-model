package com.cooksys.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.socialmedia.entity.SmUser;

@Repository
public interface UsersRepository extends JpaRepository<SmUser, Integer>{

}
