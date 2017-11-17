package com.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.idao.MoneyDao;
import com.company.dao.pojo.Money;
import com.company.service.iservice.MoneyService;
@Service("moneyService")
public class MoneyServiceImpl implements MoneyService {
	@Autowired
	private MoneyDao moneyDao;
	@Transactional
	@Override
	public String save(Money t) {
		String msg = "error";
		try {
			moneyDao.save(t);
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	@Transactional
	@Override
	public String update(Money t) {
		String msg = "error";
		try {
			moneyDao.update(t);
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	@Transactional
	@Override
	public String delete(Money t) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public List<Money> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public Money findById(Integer k) {
		Money money = new Money();
		try {
			money = moneyDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return money;
	}

}
