package com.cooksys.socialmedia.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Hashtag {

	@Column(nullable = false)
	private String label;

	private Timestamp fisrtUsed;

	private Timestamp lastUsed;

	@ManyToMany
	private List<Tweet> tweets;

	public Hashtag(String label, Timestamp fisrtUsed, Timestamp lastUsed) {
		super();
		this.label = label;
		this.fisrtUsed = new Timestamp(System.currentTimeMillis());
		this.lastUsed = lastUsed;
		this.tweets = new ArrayList<Tweet>();
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Timestamp getFisrtUsed() {
		return fisrtUsed;
	}

	public void setFisrtUsed(Timestamp fisrtUsed) {
		this.fisrtUsed = fisrtUsed;
	}

	public Timestamp getLastUsed() {
		return lastUsed;
	}

	public void setLastUsed(Timestamp lastUsed) {
		this.lastUsed = lastUsed;
	}

	public List<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}

}
