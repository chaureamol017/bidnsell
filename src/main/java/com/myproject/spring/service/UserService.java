package com.myproject.spring.service;

import java.util.List;

import com.myproject.spring.model.User;

public interface UserService {
	User get(String id);

	List<User> getAll();

	String save(User crop);

	void update(User crop, String id);

	void delete(String id);
}
