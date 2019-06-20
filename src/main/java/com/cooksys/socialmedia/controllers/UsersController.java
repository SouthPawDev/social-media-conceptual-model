package com.cooksys.socialmedia.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.socialmedia.dto.UsersRequestDto;
import com.cooksys.socialmedia.dto.UsersResponseDto;
import com.cooksys.socialmedia.services.UsersService;


@RestController
@RequestMapping(path = "/users")
public class UsersController {
	
	private UsersService usersService;

	public UsersController(UsersService usersService) {
		this.usersService = usersService;
	}
	
	
	@PostMapping
	public UsersResponseDto createUser(@RequestBody UsersRequestDto userDto) {
		return usersService.createUser(userDto);
	}
	
}
