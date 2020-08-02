package com.fpt.namhnp_assignment1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpt.namhnp_assignment1.CustomMessageError;
import com.fpt.namhnp_assignment1.dto.UserRequestDTO;
import com.fpt.namhnp_assignment1.dto.UserLoginResponseDTO;
import com.fpt.namhnp_assignment1.dto.UserRegisterResponseDTO;
import com.fpt.namhnp_assignment1.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping(value = "/register")
	public ResponseEntity<UserRegisterResponseDTO> regiter(@Valid @RequestBody UserRequestDTO userRequestDTO) throws CustomMessageError {
		UserRegisterResponseDTO response = userService.save(userRequestDTO);;
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<UserLoginResponseDTO> login(@Valid @RequestBody UserRequestDTO userRequestDTO) throws CustomMessageError {
		UserLoginResponseDTO response = userService.login(userRequestDTO);
		return ResponseEntity.ok().body(response);
	}

}
