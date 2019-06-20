package com.cooksys.socialmedia.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		super();
		this.usersService = usersService;
	}

	@PostMapping
	public UsersResponseDto createUser(@RequestBody UsersRequestDto userDto) {
		return usersService.createUser(userDto);
	}

	@GetMapping
	public List<UsersResponseDto> getUsers(){
		return usersService.getUsers();
	}
	
	@GetMapping("/{username}")
	public UsersResponseDto getByUsername(@PathVariable String username) {
		return usersService.getByUsername(username);
	}
}
