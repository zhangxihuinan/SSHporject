package com.company.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.idao.UserOrderDao;
import com.company.dao.pojo.Order;
import com.company.dao.pojo.UserOrder;
import com.company.service.iservice.UserOrderService;
@Service("userorderService")
public class UserOrderServiceImpl implements UserOrderService {
	@Autowired
	private UserOrderDao userorderDao;
	@Transactional
	@Override
	public String save(UserOrder t) {
		String msg = "error";
		try {
			userorderDao.save(t);
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	@Transactional
	@Override
	public String update(UserOrder t) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public String delete(UserOrder t) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public List<UserOrder> findAll() {
		List<UserOrder> userOrder = new ArrayList<UserOrder>();
		try {
			userOrder = userorderDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userOrder;
	}
	@Transactional
	@Override
	public UserOrder findById(Integer k) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public List<Order> findUidByOrderDate(int uid,String orderDate) {
		List<Order> Order = new ArrayList<Order>();
		try {
				Order = userorderDao.findUidByOrderDate(uid,orderDate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Order;
	}
	@Transactional
	@Override
	public List<UserOrder> findAllById(Integer k) {
		List<UserOrder> userOrder = new ArrayList<UserOrder>();
		try {
			userOrder = userorderDao.findAllById(k);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userOrder;
	}

}
