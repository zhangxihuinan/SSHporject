package com.company.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.company.dao.idao.MoneyDao;
import com.company.dao.pojo.Money;

@Repository("moneyDao")
public class MoneyDaoImpl implements MoneyDao {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	@Override
	public void save(Money t) throws Exception {
		sessionFactory.getCurrentSession().save(t);
	}

	@Override
	public void update(Money t) throws Exception {
		sessionFactory.getCurrentSession().update(t);

	}

	@Override
	public void delete(Money t) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Money> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Money findById(Integer k) throws Exception {
		Money money = (Money) sessionFactory.getCurrentSession().get(Money.class, k);
		return money;
	}

}
