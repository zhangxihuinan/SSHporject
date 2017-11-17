package com.company.service.iservice;

import java.util.List;

import com.company.dao.pojo.ShoppingCart;

public interface ShoppingCartService extends BaseService<ShoppingCart, Integer>{
	List<ShoppingCart> findShoppingCartAllByUser(int uid);
	String updateCheckBox(int sid,int check);
}
