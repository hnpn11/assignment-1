package com.fpt.namhnp_assignment1.service;


import com.fpt.namhnp_assignment1.CustomMessageError;
import com.fpt.namhnp_assignment1.dto.UserRequestDTO;
import com.fpt.namhnp_assignment1.dto.UserLoginResponseDTO;
import com.fpt.namhnp_assignment1.dto.UserRegisterResponseDTO;

public interface UserService {

	UserRegisterResponseDTO save(UserRequestDTO userRequestDTO) throws CustomMessageError;
	
	UserRegisterResponseDTO findByUsername(String username);
	
	UserLoginResponseDTO login(UserRequestDTO userRequestDTO) throws CustomMessageError;
}
