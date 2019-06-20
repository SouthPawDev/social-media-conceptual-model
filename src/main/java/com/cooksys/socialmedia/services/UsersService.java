package com.cooksys.socialmedia.services;

import java.util.List;

import com.cooksys.socialmedia.dto.UsersRequestDto;
import com.cooksys.socialmedia.dto.UsersResponseDto;

public interface UsersService {

	UsersResponseDto createUser(UsersRequestDto userDto);

	List<UsersResponseDto> getUsers();

	UsersResponseDto getByUsername(String username);

}
