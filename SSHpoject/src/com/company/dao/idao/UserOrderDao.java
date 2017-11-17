package com.company.dao.idao;

import java.util.List;

import com.company.dao.pojo.Order;
import com.company.dao.pojo.UserOrder;

public interface UserOrderDao extends BaseDao<UserOrder, Integer>{
	List<Order> findUidByOrderDate(int uid,String orderDate) throws Exception;
	List<UserOrder> findAllById(Integer k);
}
