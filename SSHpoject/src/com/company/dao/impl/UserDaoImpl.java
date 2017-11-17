package com.company.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.company.dao.idao.UserDao;
import com.company.dao.pojo.Detail;
import com.company.dao.pojo.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public void save(User t) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(User t) throws Exception {
		sessionFactory.getCurrentSession().update(t);
	}

	@Override
	public void delete(User t) throws Exception {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() throws Exception {
		List<User> userList = sessionFactory.getCurrentSession().createQuery("from User").list();
		return userList;
	}

	@Override
	public User findById(Integer k) throws Exception {
		User user = (User) sessionFactory.getCurrentSession().get(User.class, k);
		return user;
	}

	
	
	
	@Override
	public String login(User user) throws Exception {
		Object obj = sessionFactory.getCurrentSession()
				.createQuery("from User u where u.username=? and u.password=?")
				.setParameter(0, user.getUsername())
				.setParameter(1, user.getPassword())
				.uniqueResult();
		return obj == null ? "error" : "success";
	}

	@Override
	public void registry(User user, Detail detail) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		session.save(detail);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int findUidByUsername(String username) throws Exception {
		int uid = 0;
		List<User> userList = sessionFactory.getCurrentSession()
					.createQuery("from User u where u.username=?")
					.setParameter(0, username).list();
		for (User user : userList) {
			uid = user.getUid();
		}
		return uid;
	}

}
