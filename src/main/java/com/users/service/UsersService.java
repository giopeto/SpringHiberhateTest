package com.users.service;

import com.users.domain.User;

import java.util.List;

public interface UsersService {
	
	public User save(User u);

	public List<User> get();
	
}
