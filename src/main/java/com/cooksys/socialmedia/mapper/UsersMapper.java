package com.cooksys.socialmedia.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cooksys.socialmedia.dto.UsersRequestDto;
import com.cooksys.socialmedia.dto.UsersResponseDto;
import com.cooksys.socialmedia.entity.SmUser;

@Mapper(componentModel = "spring")
public interface UsersMapper {

	SmUser dtoToEntity(UsersRequestDto request);

	UsersResponseDto entityToDto(SmUser smUser);
	
	List<UsersResponseDto> entityToDtos(List<SmUser> users);
}
