package com.company.service.iservice;

import java.util.List;

import com.company.dao.pojo.Order;
import com.company.dao.pojo.UserOrder;

public interface UserOrderService extends BaseService<UserOrder, Integer>{
	List<Order> findUidByOrderDate(int uid,String orderDate);
	List<UserOrder> findAllById(Integer k);
}
