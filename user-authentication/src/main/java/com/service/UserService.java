package com.service;

import org.springframework.http.ResponseEntity;

import com.dto.ForgotPasswordDTO;
import com.dto.LoginDTO;
import com.dto.SignupDTO;
import com.dto.UserResponseDTO;

public interface UserService {
	public ResponseEntity<UserResponseDTO>addUser(SignupDTO signupDto);

    public ResponseEntity<UserResponseDTO> login(LoginDTO loginDto);

	public ResponseEntity<?> forgotPassword(ForgotPasswordDTO forgotPasswordDTO);
}
