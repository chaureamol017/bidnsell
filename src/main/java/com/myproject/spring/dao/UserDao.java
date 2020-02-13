package com.myproject.spring.dao;

import java.util.List;

import com.myproject.spring.model.User;

public interface UserDao {

	User get(String id);

	List<User> getAll();

	String save(User user);

	void update(User user, String id);

	void delete(String id);
}
