package com.cooksys.socialmedia.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SmUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Embedded
	private Profile profile;

	private Timestamp joined = new Timestamp(System.currentTimeMillis());

	@Column(nullable = false)
	@Embedded
	private Credentials credentials;

	private boolean active = true;

	@OneToMany
	private List<Tweet> tweets;

	@OneToMany
	private List<SmUser> following;

	@OneToMany
	private List<SmUser> followers;

	// constructor
	public SmUser() {

	}

	// getters and setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Timestamp getJoined() {
		return joined;
	}

	public void setJoined(Timestamp joined) {
		this.joined = joined;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
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

	public List<SmUser> getFollowing() {
		return following;
	}

	public void setFollowing(List<SmUser> following) {
		this.following = following;
	}

	public List<SmUser> getFollowers() {
		return followers;
	}

	public void setFollowers(List<SmUser> followers) {
		this.followers = followers;
	}

}
