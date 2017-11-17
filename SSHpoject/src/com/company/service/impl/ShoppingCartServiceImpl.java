package com.company.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.idao.ShoppingCartDao;
import com.company.dao.pojo.ShoppingCart;
import com.company.service.iservice.ShoppingCartService;

@Service("shoppingCartService")
public class ShoppingCartServiceImpl implements ShoppingCartService {
	@Autowired
	private ShoppingCartDao shoppingCartDao;
	@Transactional
	@Override
	public String save(ShoppingCart t) {
		String msg = "error";
		try {
			shoppingCartDao.save(t);
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	@Transactional
	@Override
	public String update(ShoppingCart t) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public String delete(ShoppingCart t) {
		String msg = "error";
		try {
			shoppingCartDao.delete(t);
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	@Transactional
	@Override
	public List<ShoppingCart> findAll() {
		List<ShoppingCart> shoppingCart = new ArrayList<ShoppingCart>();
		try {
			shoppingCart = shoppingCartDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shoppingCart;
	}
	@Transactional
	@Override
	public ShoppingCart findById(Integer k) {
		ShoppingCart shoppingCart = new ShoppingCart();
		try {
			shoppingCart = shoppingCartDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shoppingCart;
	}
	@Transactional
	@Override
	public List<ShoppingCart> findShoppingCartAllByUser(int uid) {
		List<ShoppingCart> shoppingCart = new ArrayList<ShoppingCart>();
		try {
			shoppingCart = shoppingCartDao.findShoppingCartAllByUser(uid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shoppingCart;
	}
	@Transactional
	@Override
	public String updateCheckBox(int sid, int check){
		String msg = "error";
		try {
			shoppingCartDao.updateCheckBox(sid, check);
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

}
