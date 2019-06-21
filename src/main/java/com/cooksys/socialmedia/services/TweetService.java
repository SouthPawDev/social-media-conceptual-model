package com.cooksys.socialmedia.services;

import java.util.List;

import com.cooksys.socialmedia.dto.TweetRequestDto;
import com.cooksys.socialmedia.dto.TweetResponseDto;
import com.cooksys.socialmedia.entity.Credentials;

public interface TweetService {

	TweetResponseDto createTweet(TweetRequestDto tweetDto);

	List<TweetResponseDto> getTweets();

	TweetResponseDto getTweetById(int id);

	TweetResponseDto deleteTweet(Credentials credentials, int id);

}
