package com.company.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.company.dao.idao.GoodsDao;
import com.company.dao.pojo.Goods;
@Repository("goodsDao")
public class GoodsDaoImpl implements GoodsDao {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	@Override
	public void save(Goods t) throws Exception {
		sessionFactory.getCurrentSession().save(t);
	}

	@Override
	public void update(Goods t) throws Exception {
		sessionFactory.getCurrentSession().update(t);

	}

	@Override
	public void delete(Goods t) throws Exception {
		sessionFactory.getCurrentSession().delete(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Goods> findAll() throws Exception {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from Goods");
		//query.setFirstResult(pageBegin);  
		//query.setMaxResults(pageSize);  
		return query.list();
	}

	@Override
	public Goods findById(Integer k) throws Exception {
		Goods goods = (Goods) sessionFactory.getCurrentSession().get(Goods.class, k);
		return goods;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Goods> findByName(String gname) throws Exception{
		List<Goods> goodsList = sessionFactory.getCurrentSession().createQuery("from Goods where gname like :gname")
		.setParameter("gname", "%"+gname+"%").list();
		return goodsList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Goods> findAllPage(int pageBegin, int pageSize) throws Exception {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from Goods");
		pageBegin = (pageBegin - 1) * pageSize;
		query.setFirstResult(pageBegin);  
		query.setMaxResults(pageSize);  
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Goods> findByNamePage(int pageBegin, int pageSize,String gname) throws Exception {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from Goods where gname like :gname")
				.setParameter("gname", "%"+gname+"%");
		pageBegin = (pageBegin - 1) * pageSize;
		query.setFirstResult(pageBegin);  
		query.setMaxResults(pageSize);  
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Goods> findByGtype(String gtype) throws Exception {
		List<Goods> goodsList = sessionFactory.getCurrentSession().createQuery("from Goods g where g.gtype=:gtype")
				.setParameter("gtype", gtype).list();
				return goodsList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Goods> findByGtypePage(int pageBegin, int pageSize, String gtype) throws Exception {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from Goods g where g.gtype=:gtype")
				.setParameter("gtype", gtype);
		pageBegin = (pageBegin - 1) * pageSize;
		query.setFirstResult(pageBegin);  
		query.setMaxResults(pageSize);  
		return query.list();
	}

}
