package com.cooksys.socialmedia.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.socialmedia.dto.UsersRequestDto;
import com.cooksys.socialmedia.dto.UsersResponseDto;
import com.cooksys.socialmedia.entity.Credentials;
import com.cooksys.socialmedia.entity.SmUser;
import com.cooksys.socialmedia.mapper.UsersMapper;
import com.cooksys.socialmedia.repository.UsersRepository;
import com.cooksys.socialmedia.services.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	private UsersRepository usersRepository;
	private UsersMapper usersMapper;

	public UsersServiceImpl(UsersRepository usersRepository, UsersMapper usersMapper) {
		this.usersRepository = usersRepository;
		this.usersMapper = usersMapper;
	}

	@Override
	public UsersResponseDto createUser(UsersRequestDto usersDto) {
		return usersMapper.entityToDto(usersRepository.saveAndFlush(usersMapper.dtoToEntity(usersDto)));
	}

	@Override
	public List<UsersResponseDto> getUsers() {
		return usersMapper.entityToDtos(usersRepository.findActiveUsers());
	}

	@Override
	public UsersResponseDto getByUsername(String username) {
		return usersMapper.entityToDto(usersRepository.findUser(username));
	}

	@Override
	public UsersResponseDto updateUser(UsersRequestDto usersDto) {
		SmUser user = usersRepository.findUser(usersDto.getCredentials().getUsername());
		if (user.getCredentials().getPassword().equals(usersDto.getCredentials().getPassword())) {
			user.setProfile(usersDto.getProfile());
		}
		usersRepository.saveAndFlush(user);
		return usersMapper.entityToDto(user);
	}

	@Override
	public UsersResponseDto deleteUser(Credentials credentials) {
		SmUser user = usersRepository.findUser(credentials.getUsername());
		if (user.getCredentials().getPassword().equals(credentials.getPassword())) {
			user.setActive(false);
		}
		usersRepository.saveAndFlush(user);
		return usersMapper.entityToDto(user);
	}

	@Override
	public void followUser(Credentials credentials, String username) {
		SmUser user = usersRepository.findUser(credentials.getUsername());
		SmUser follow = usersRepository.findUser(username);
		if (user.getCredentials().getPassword().equals(credentials.getPassword())) {
			user.getFollowing().add(follow);
		}
		usersRepository.saveAndFlush(user);
	}

	@Override
	public void unfollowUser(Credentials credentials, String username) {
		SmUser user = usersRepository.findUser(credentials.getUsername());
		SmUser unfollow = usersRepository.findUser(username);
		if (user.getCredentials().getPassword().equals(credentials.getPassword())) {
			user.getFollowing().remove(unfollow);
		}
		usersRepository.saveAndFlush(user);

	}

}
