package com.cooksys.socialmedia.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.socialmedia.dto.TweetRequestDto;
import com.cooksys.socialmedia.dto.TweetResponseDto;
import com.cooksys.socialmedia.entity.Credentials;
import com.cooksys.socialmedia.entity.SmUser;
import com.cooksys.socialmedia.services.TweetService;

@RestController
@RequestMapping(path = "/tweets")
public class TweetController {

	private TweetService tweetService;

	public TweetController(TweetService tweetService) {
		super();
		this.tweetService = tweetService;
	}

	@PostMapping
	public TweetResponseDto createTweet(@RequestBody TweetRequestDto tweet) {
		return tweetService.createTweet(tweet);
	}

	@GetMapping
	public List<TweetResponseDto> getTweets() {
		return tweetService.getTweets();
	}

	@GetMapping("/{id}")
	public TweetResponseDto getTweetById(@PathVariable Integer id) {
		return tweetService.getTweetById(id);
	}

	@DeleteMapping("/{id}")
	public TweetResponseDto deleteTweet(@RequestBody Credentials credentials, @PathVariable Integer id) {
		return tweetService.deleteTweet(credentials, id);
	}
	
	@PostMapping("/{id}/like")
	public void likeTweet(@RequestBody Credentials credentials, @PathVariable Integer id) {
		tweetService.likeTweet(credentials, id);
	}
	
	@GetMapping("/{id}/likes")
	public List<SmUser> getTweetLikes(@PathVariable Integer id){
		return tweetService.getTweetLikes(id);
	}

}
