package com.cooksys.socialmedia.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.socialmedia.dto.TweetRequestDto;
import com.cooksys.socialmedia.dto.TweetResponseDto;
import com.cooksys.socialmedia.entity.Credentials;
import com.cooksys.socialmedia.entity.SmUser;
import com.cooksys.socialmedia.entity.Tweet;
import com.cooksys.socialmedia.mapper.TweetMapper;
import com.cooksys.socialmedia.repository.TweetRepository;
import com.cooksys.socialmedia.repository.UsersRepository;
import com.cooksys.socialmedia.services.TweetService;

@Service
public class TweetServiceImpl implements TweetService {

	private TweetRepository tweetRepository;
	private TweetMapper tweetMapper;
	private UsersRepository usersRepository;


	public TweetServiceImpl(TweetRepository tweetRepository, TweetMapper tweetMapper, UsersRepository usersRepository) {
		super();
		this.tweetRepository = tweetRepository;
		this.tweetMapper = tweetMapper;
		this.usersRepository = usersRepository;
		
	}

	@Override
	public TweetResponseDto createTweet(TweetRequestDto tweetDto) {
		Tweet tweet = tweetMapper.dtoToEntity(tweetDto);
		SmUser author = usersRepository.findUser(tweetDto.getCredentials().getUsername());
		tweet.setAuthor(author);
		return tweetMapper.entityToDto(tweetRepository.saveAndFlush(tweet));
	}

	@Override
	public List<TweetResponseDto> getTweets() {
		return tweetMapper.entityToDtos(tweetRepository.findActiveTweets());
	}

	@Override
	public TweetResponseDto getTweetById(Integer id) {
		return tweetMapper.entityToDto(tweetRepository.findTweet(id));
	}

	@Override
	public TweetResponseDto deleteTweet(Credentials credentials, Integer id) {
		Tweet tweet = tweetRepository.findTweet(id);
		if (tweet.getAuthor().getCredentials().getPassword().equals(credentials.getPassword())) {
			tweet.setActive(false);
			tweetRepository.saveAndFlush(tweet);
		}
		return tweetMapper.entityToDto(tweet);
	}

	@Override
	public void likeTweet(Credentials credentials, Integer id) {
		Tweet tweet = tweetRepository.findTweet(id);
		SmUser user = usersRepository.findUser(credentials.getUsername());
		tweet.getLiked().add(user);
		tweetRepository.saveAndFlush(tweet);
		
	}

	@Override
	public List<SmUser> getTweetLikes(Integer id) {
		Tweet tweet = tweetRepository.findTweet(id);
		return tweet.getLiked();
	}

}
