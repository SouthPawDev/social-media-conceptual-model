package com.cooksys.socialmedia.dto;

import java.sql.Timestamp;
import java.util.List;

import com.cooksys.socialmedia.entity.Hashtag;
import com.cooksys.socialmedia.entity.SmUser;
import com.cooksys.socialmedia.entity.Tweet;

public class TweetResponseDto {

	private String content;

	private UsersResponseDto author;

	private Timestamp posted;

	private List<Hashtag> hashtag;

	private Tweet inReplyTo;

	private Tweet repostOf;

	public TweetResponseDto() {
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public UsersResponseDto getAuthor() {
		return author;
	}

	public void setAuthor(UsersResponseDto author) {
		this.author = author;
	}

	public Timestamp getPosted() {
		return posted;
	}

	public void setPosted(Timestamp posted) {
		this.posted = posted;
	}

	public List<Hashtag> getHashtag() {
		return hashtag;
	}

	public void setHashtag(List<Hashtag> hashtag) {
		this.hashtag = hashtag;
	}

	public Tweet getInReplyTo() {
		return inReplyTo;
	}

	public void setInReplyTo(Tweet inReplyTo) {
		this.inReplyTo = inReplyTo;
	}

	public Tweet getRepostOf() {
		return repostOf;
	}

	public void setRepostOf(Tweet repostOf) {
		this.repostOf = repostOf;
	}

}
