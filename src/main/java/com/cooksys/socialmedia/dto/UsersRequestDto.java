package com.cooksys.socialmedia.dto;

import com.cooksys.socialmedia.entity.Credentials;
import com.cooksys.socialmedia.entity.Profile;

public class UsersRequestDto {
	
	private Credentials credentials;
	private Profile profile;
	
	public UsersRequestDto() {
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	
	
	
}
