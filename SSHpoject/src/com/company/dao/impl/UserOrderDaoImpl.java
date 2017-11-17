package com.company.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.company.dao.idao.UserOrderDao;
import com.company.dao.pojo.Order;
import com.company.dao.pojo.UserOrder;
@Repository("userorderDao")
public class UserOrderDaoImpl implements UserOrderDao {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	@Override
	public void save(UserOrder t) throws Exception {
		sessionFactory.getCurrentSession().save(t);
	}

	@Override
	public void update(UserOrder t) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(UserOrder t) throws Exception {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserOrder> findAll() throws Exception {
		List<UserOrder> userOrderList = sessionFactory.getCurrentSession().createQuery("from UserOrder").list();
		return userOrderList;
	}

	@Override
	public UserOrder findById(Integer k) throws Exception {
		sessionFactory.getCurrentSession().get(UserOrder.class, k);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findUidByOrderDate(int uid,String orderDate) throws Exception {
		List<Order> OrderList = sessionFactory.getCurrentSession()
				.createQuery("from Order o where o.orderdate=? and o.uid=?")
				.setParameter(0, orderDate)
				.setParameter(1, uid).list();
		return OrderList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserOrder> findAllById(Integer k) {
		List<UserOrder> userOrderList = sessionFactory.getCurrentSession()
				.createQuery("from UserOrder u where u.uid=?")
				.setParameter(0, k)
				.list();
		return userOrderList;
	}

}
