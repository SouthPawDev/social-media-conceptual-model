package com.cooksys.socialmedia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cooksys.socialmedia.entity.SmUser;

@Repository
public interface UsersRepository extends JpaRepository<SmUser, Integer>{

	@Query("select s from SmUser s where s.active = true")
	List<SmUser> findActiveUsers();
	
	@Query("select s from SmUser s where s.credentials.username = ?1 and s.active = true")
	SmUser findUser(String username);
	


}
