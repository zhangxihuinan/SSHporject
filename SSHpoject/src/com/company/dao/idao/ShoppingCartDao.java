package com.company.dao.idao;

import java.util.List;

import com.company.dao.pojo.ShoppingCart;

public interface ShoppingCartDao extends BaseDao<ShoppingCart, Integer>{
	//查看用户的购物车
	List<ShoppingCart> findShoppingCartAllByUser(int uid)throws Exception;
	//单独修改checkbox的数值
	void updateCheckBox(int sid,int check)throws Exception;
}
