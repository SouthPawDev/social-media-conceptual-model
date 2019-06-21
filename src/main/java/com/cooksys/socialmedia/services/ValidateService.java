package com.cooksys.socialmedia.services;

public interface ValidateService {

	boolean validateTag(String label);

	boolean usernameAvailable(String username);

}
