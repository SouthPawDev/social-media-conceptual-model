package com.cooksys.socialmedia.services;

import com.cooksys.socialmedia.dto.UsersRequestDto;
import com.cooksys.socialmedia.dto.UsersResponseDto;

public interface UsersService {

	UsersResponseDto createUser(UsersRequestDto userDto);

}
