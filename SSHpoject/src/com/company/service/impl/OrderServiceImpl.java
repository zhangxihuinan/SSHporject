package com.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.idao.OrderDao;
import com.company.dao.pojo.Order;
import com.company.service.iservice.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	@Transactional
	@Override
	public String save(Order t) {
		String msg = "error";
		try {
			orderDao.save(t);
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	@Transactional
	@Override
	public String update(Order t) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public String delete(Order t) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public Order findById(Integer k) {
		// TODO Auto-generated method stub
		return null;
	}

}
