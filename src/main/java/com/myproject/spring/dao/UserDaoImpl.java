package com.myproject.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.spring.model.User;;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User get(String id) {
		User user = (User) getCurrentSession().get(User.class, id);
		return user;
	}

	@Override
	public List<User> getAll() {
		List<User> list = getCurrentSession().createQuery("FROM User ").list();
		return list;
	}

	@Override
	public String save(User user) {
		getCurrentSession().save(user);
		return user.getId();
	}

	@Override
	public void update(User user, String id) {
		Session sessionObj = getCurrentSession();
		User oldUser = sessionObj.byId(User.class).load(id);
		
		oldUser.setId(user.getId());
		oldUser.setUserName(user.getUserName());
		oldUser.setFullName(user.getFullName());
		oldUser.setEmail(user.getEmail());
		oldUser.setMobile(user.getMobile());
		
		sessionObj.flush();
	}

	@Override
	public void delete(String id) {
		Session sessionObj = getCurrentSession();
		User oldUser = sessionObj.byId(User.class).load(id);
		
		sessionObj.delete(oldUser);

	}

	private Session getCurrentSession() {
		Session sessionObj = sessionFactory.getCurrentSession();
		
		return sessionObj;
	}
}
