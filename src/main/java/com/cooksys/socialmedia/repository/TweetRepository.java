package com.cooksys.socialmedia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cooksys.socialmedia.entity.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Integer>{
	
	@Query("select s from Tweet s where s.active = true")
	List<Tweet> findActiveTweets();
	
	@Query("select s from Tweet s where s.id = ?1 and s.active = true")
	Tweet findTweet(int id);

}
