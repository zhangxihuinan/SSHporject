package com.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.idao.DetailDao;
import com.company.dao.pojo.Detail;
import com.company.service.iservice.DetailService;
@Service("detailService")
public class DetailServiceImpl implements DetailService {
	@Autowired
	private DetailDao detailDao;
	@Transactional
	@Override
	public String save(Detail t) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public String update(Detail t) {
		String msg = "error";
		try {
			detailDao.update(t);
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	@Transactional
	@Override
	public String delete(Detail t) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public List<Detail> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public Detail findById(Integer k) {
		Detail detail = new Detail();
		try {
			detail = detailDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return detail;
	}
	@Transactional
	@Override
	public String upload(int uid, String filePath) {
		String msg = "error";
		try {
			detailDao.upload(uid, filePath);
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

}
