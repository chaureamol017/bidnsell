package com.myproject.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.spring.dao.UserDao;
import com.myproject.spring.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDaoObj;

	@Override
	@Transactional
	public User get(String id) {
		User user = userDaoObj.get(id);
		return user;
	}

	@Override
	@Transactional
	public List<User> getAll() {
		List<User> user = userDaoObj.getAll();
		return user;
	}

	@Override
	@Transactional
	public String save(User user) {
		return userDaoObj.save(user);
	}

	@Override
	@Transactional
	public void update(User user, String id) {
		userDaoObj.update(user, id);
	}

	@Override
	@Transactional
	public void delete(String id) {
		userDaoObj.delete(id);

	}

}
