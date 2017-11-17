package com.company.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.company.dao.idao.DetailDao;
import com.company.dao.pojo.Detail;

@Repository("detailDao")
public class DetailDaoImpl implements DetailDao {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void save(Detail t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Detail t) throws Exception {
		sessionFactory.getCurrentSession().update(t);
	}

	@Override
	public void delete(Detail t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Detail> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Detail findById(Integer k) throws Exception {
		Detail detail = (Detail) sessionFactory.getCurrentSession().get(Detail.class, k);
		return detail;
	}
	//修改用户头像
	@Override
	public void upload(int uid,String filePath) throws Exception {
		String sql = "UPDATE t_detail SET filePath=? WHERE uid=?";
		sessionFactory.getCurrentSession().createSQLQuery(sql)
						.setParameter(0, filePath)
						.setParameter(1, uid).executeUpdate();
		
	}
	
	

}
