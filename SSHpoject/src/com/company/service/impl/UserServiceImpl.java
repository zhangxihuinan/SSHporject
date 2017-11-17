package com.company.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.idao.UserDao;
import com.company.dao.pojo.Detail;
import com.company.dao.pojo.User;
import com.company.service.iservice.UserService;


@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Transactional
	@Override
	public String save(User t) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public String update(User t) {
		String msg = "error";
		try {
			userDao.update(t);
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	@Transactional
	@Override
	public String delete(User t) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public List<User> findAll() {
		List<User> userList =new ArrayList<User>();
		try {
			userList = userDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	@Transactional
	@Override
	public User findById(Integer k) {
		User user = new User();
		try {
			user = userDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	@Transactional
	@Override
	public String login(User user) {
		String msg = "error";
		try {
			msg = userDao.login(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	@Transactional
	@Override
	public String registry(User user, Detail detail) {
		String msg = "error";
		try {
			userDao.registry(user,detail);
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	@Transactional
	@Override
	public int findUidByUsername(String username) {
		int uid = 0;
		try {
			uid = userDao.findUidByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uid;
	}

}
