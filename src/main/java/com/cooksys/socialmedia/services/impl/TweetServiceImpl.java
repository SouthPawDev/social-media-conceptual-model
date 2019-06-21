package com.cooksys.socialmedia.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.socialmedia.dto.TweetRequestDto;
import com.cooksys.socialmedia.dto.TweetResponseDto;
import com.cooksys.socialmedia.entity.Credentials;
import com.cooksys.socialmedia.entity.Tweet;
import com.cooksys.socialmedia.mapper.TweetMapper;
import com.cooksys.socialmedia.repository.TweetRepository;
import com.cooksys.socialmedia.services.TweetService;

@Service
public class TweetServiceImpl implements TweetService {

	private TweetRepository tweetRepository;
	private TweetMapper tweetMapper;
	

	public TweetServiceImpl(TweetRepository tweetRepository, TweetMapper tweetMapper) {
		super();
		this.tweetRepository = tweetRepository;
		this.tweetMapper = tweetMapper;
	}

	@Override
	public TweetResponseDto createTweet(TweetRequestDto tweetDto) {
		return tweetMapper.entityToDto(tweetRepository.saveAndFlush(tweetMapper.dtoToEntity(tweetDto)));
	}

	@Override
	public List<TweetResponseDto> getTweets() {
		return tweetMapper.entityToDtos(tweetRepository.findActiveTweets());
	}

	@Override
	public TweetResponseDto getTweetById(int id) {
		return tweetMapper.entityToDto(tweetRepository.findTweet(id));
	}

	@Override
	public TweetResponseDto deleteTweet(Credentials credentials, int id) {
		Tweet tweet = tweetRepository.findTweet(id);
		if (tweet.getAuthor().getCredentials().getPassword().equals(credentials.getPassword())) {
			tweet.setActive(false);
			tweetRepository.saveAndFlush(tweet);
		}
		return tweetMapper.entityToDto(tweet);
	}

}
