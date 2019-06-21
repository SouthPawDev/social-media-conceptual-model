package com.cooksys.socialmedia.services;

import java.util.List;

import com.cooksys.socialmedia.dto.UsersRequestDto;
import com.cooksys.socialmedia.dto.UsersResponseDto;
import com.cooksys.socialmedia.entity.Credentials;
import com.cooksys.socialmedia.entity.SmUser;

public interface UsersService {

	UsersResponseDto createUser(UsersRequestDto userDto);

	List<UsersResponseDto> getUsers();

	UsersResponseDto getByUsername(String username);

	UsersResponseDto updateUser(UsersRequestDto usersDto);

	UsersResponseDto deleteUser(Credentials credentials);

	void followUser(Credentials credentials, String username);

	void unfollowUser(Credentials credentials, String username);

	List<UsersResponseDto> getFollowers(String username);

	List<UsersResponseDto> getFollowing(String username);

}
