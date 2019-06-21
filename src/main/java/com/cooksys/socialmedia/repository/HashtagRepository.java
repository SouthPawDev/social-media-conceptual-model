package com.cooksys.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cooksys.socialmedia.entity.Hashtag;

public interface HashtagRepository extends JpaRepository<Hashtag, Integer>{

	@Query("select s from Hashtag s where s.label = ?1")
	boolean findByLabel(String label);
}
