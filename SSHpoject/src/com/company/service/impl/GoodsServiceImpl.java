package com.company.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.idao.GoodsDao;
import com.company.dao.pojo.Goods;
import com.company.service.iservice.GoodsService;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsDao goodsDao;
	@Transactional
	@Override
	public String save(Goods t) {
		String msg = "error";
		try {
			goodsDao.save(t);
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	@Transactional
	@Override
	public String update(Goods t) {
		String msg = "error";
		try {
			goodsDao.update(t);
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	@Transactional
	@Override
	public String delete(Goods t) {
		String msg = "error";
		try {
			goodsDao.delete(t);
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	@Transactional
	@Override
	public List<Goods> findAll() {
		List<Goods> goodsList = new ArrayList<Goods>();
		try {
			goodsList = goodsDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsList;
	}
	@Transactional
	@Override
	public Goods findById(Integer k) {
		Goods goods = new Goods();
		try {
			goods = goodsDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goods;
	}
	@Transactional
	@Override
	public List<Goods> findByName(String gname) {
		List<Goods> goodsList = new ArrayList<Goods>();
		try {
			goodsList = goodsDao.findByName(gname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsList;
	}
	@Transactional
	@Override
	public List<Goods> findAllPage(int pageBegin, int pageSize) {
		List<Goods> goodsList = new ArrayList<Goods>();
		try {
			goodsList = goodsDao.findAllPage(pageBegin, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsList;
	}
	@Transactional
	@Override
	public List<Goods> findByNamePage(int pageBegin, int pageSize, String gname) {
		List<Goods> goodsList = new ArrayList<Goods>();
		try {
			goodsList = goodsDao.findByNamePage(pageBegin, pageSize, gname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsList;
	}
	@Transactional
	@Override
	public List<Goods> findByGtype(String gtype) {
		List<Goods> goodsList = new ArrayList<Goods>();
		try {
			goodsList = goodsDao.findByGtype(gtype);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsList;
	}
	@Transactional
	@Override
	public List<Goods> findByGtypePage(int pageBegin, int pageSize, String gtype) {
		List<Goods> goodsList = new ArrayList<Goods>();
		try {
			goodsList = goodsDao.findByGtypePage(pageBegin, pageSize, gtype);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsList;
	}
	

}
