package com.temmytechie.coursems.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.temmytechie.coursems.security.model.User;
import com.temmytechie.coursems.security.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	
	User save(UserRegistrationDto userRegistrationDto);

}
