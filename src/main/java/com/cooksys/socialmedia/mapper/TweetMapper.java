package com.cooksys.socialmedia.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cooksys.socialmedia.dto.TweetRequestDto;
import com.cooksys.socialmedia.dto.TweetResponseDto;
import com.cooksys.socialmedia.entity.Tweet;

@Mapper(componentModel = "spring")
public interface TweetMapper {

	Tweet dtoToEntity(TweetRequestDto request);

	TweetResponseDto entityToDto(Tweet tweet);

	List<TweetResponseDto> entityToDtos(List<Tweet> tweets);
}
