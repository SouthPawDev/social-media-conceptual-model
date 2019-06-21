package com.cooksys.socialmedia.dto;

import java.util.List;

import com.cooksys.socialmedia.entity.Profile;
import com.cooksys.socialmedia.entity.Tweet;

public class UsersResponseDto {

	private Profile profile;

	private boolean active = true;

	private List<Tweet> tweets;

	public UsersResponseDto() {
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}

}
