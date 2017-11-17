package com.company.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.company.dao.idao.ShoppingCartDao;
import com.company.dao.pojo.ShoppingCart;
@Repository("shoppingCartDao")
public class ShoppingCartDaoImpl implements ShoppingCartDao {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void save(ShoppingCart t) throws Exception {
		sessionFactory.getCurrentSession().save(t);
	}

	@Override
	public void update(ShoppingCart t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ShoppingCart t) throws Exception {
		sessionFactory.getCurrentSession().delete(t);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShoppingCart> findAll() throws Exception {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from ShoppingCart");
		return query.list();
	}

	@Override
	public ShoppingCart findById(Integer k) throws Exception {
		ShoppingCart shoppingCart = (ShoppingCart) sessionFactory.getCurrentSession().get(ShoppingCart.class, k);
		return shoppingCart;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShoppingCart> findShoppingCartAllByUser(int uid) throws Exception{
		List<ShoppingCart> shoppingCartList = sessionFactory.getCurrentSession()
							.createQuery("from ShoppingCart s where s.uid=?")
							.setParameter(0, uid).list();
		return shoppingCartList;
	}
	//单独修改checkbox属性
	@Override
	public void updateCheckBox(int sid, int check) throws Exception {
		String sql = "UPDATE t_shoppingcart SET checkbox=? WHERE sid=?";
		sessionFactory.getCurrentSession().createSQLQuery(sql)
						.setParameter(0, check)
						.setParameter(1, sid).executeUpdate();
		
	}
	
	
}
