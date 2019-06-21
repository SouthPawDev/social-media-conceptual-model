package com.cooksys.socialmedia.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Tweet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private boolean active = true;

	@ManyToOne
	private SmUser author;

	private Timestamp posted = new Timestamp(System.currentTimeMillis());

	private String content;

	@ManyToOne
	private Tweet inReplyTo;

	@ManyToOne
	private Tweet repostOf;

	@ManyToMany
	private List<Hashtag> hashtag;

	@ManyToMany
	private List<SmUser> liked;

	public Tweet() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SmUser getAuthor() {
		return author;
	}

	public void setAuthor(SmUser author) {
		this.author = author;
	}

	public Timestamp getPosted() {
		return posted;
	}

	public void setPosted(Timestamp posted) {
		this.posted = posted;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public List<Hashtag> getHashtag() {
		return hashtag;
	}

	public void setHashtag(List<Hashtag> hashtag) {
		this.hashtag = hashtag;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<SmUser> getLiked() {
		return liked;
	}

	public void setLiked(List<SmUser> liked) {
		this.liked = liked;
	}

}
