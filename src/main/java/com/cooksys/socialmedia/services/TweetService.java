package com.cooksys.socialmedia.services;

import java.util.List;

import com.cooksys.socialmedia.dto.TweetRequestDto;
import com.cooksys.socialmedia.dto.TweetResponseDto;
import com.cooksys.socialmedia.entity.Credentials;
import com.cooksys.socialmedia.entity.SmUser;

public interface TweetService {

	TweetResponseDto createTweet(TweetRequestDto tweetDto);

	List<TweetResponseDto> getTweets();

	TweetResponseDto getTweetById(Integer id);

	TweetResponseDto deleteTweet(Credentials credentials, Integer id);

	void likeTweet(Credentials credentials, Integer id);

	List<SmUser> getTweetLikes(Integer id);

}
