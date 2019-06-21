package com.cooksys.socialmedia.dto;

import com.cooksys.socialmedia.entity.Credentials;

public class TweetRequestDto {

	private String content;
	private Credentials credentials;

	public TweetRequestDto() {
		super();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

}
