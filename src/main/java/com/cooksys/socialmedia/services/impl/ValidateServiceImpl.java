package com.cooksys.socialmedia.services.impl;

import org.springframework.stereotype.Service;

import com.cooksys.socialmedia.entity.SmUser;
import com.cooksys.socialmedia.repository.HashtagRepository;
import com.cooksys.socialmedia.repository.UsersRepository;
import com.cooksys.socialmedia.services.ValidateService;

@Service
public class ValidateServiceImpl implements ValidateService {

	private HashtagRepository hashtagRepository;
	private UsersRepository usersRepository;

	public ValidateServiceImpl(HashtagRepository validateRepository) {
		super();
		this.hashtagRepository = validateRepository;
	}

	@Override
	public boolean validateTag(String label) {
		return hashtagRepository.findByLabel(label);

	}

	@Override
	public boolean usernameAvailable(String username) {
		SmUser user = usersRepository.findUser(username);
		if (user.getCredentials().getUsername().equals("")) {
			return true;
		} else {
			return false;
		}
	}

}
