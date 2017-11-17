package com.company.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.company.dao.idao.ReportDao;
@Repository("reportDao")
public class ReportDaoImpl implements ReportDao {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	@Override
	public List<String> report() throws Exception {
		
		List<String> report = sessionFactory.getCurrentSession()
		.createSQLQuery("SELECT gname FROM t_goods g WHERE g.gid IN"
					+"(SELECT gid FROM t_order o WHERE o.uid IN"
					+"(SELECT uid FROM t_detail WHERE sex = '男') "
					+"AND orderdate LIKE '%201711%')"
					+"AND g.gtype = 'book' AND g.price>20").list();
		
		List<String> report1 = sessionFactory.getCurrentSession()
				.createSQLQuery("SELECT SUM(allcount) FROM t_order o WHERE o.uid IN"
						+"(SELECT uid FROM t_detail WHERE sex = '男')"
						+"AND orderdate LIKE '%201711%' AND o.gid IN"
						+"(SELECT gid FROM t_goods g WHERE g.gid IN"
						+"(SELECT gid FROM t_order o WHERE o.uid IN"
						+"(SELECT uid FROM t_detail WHERE sex = '男')"
						+"AND orderdate LIKE '%201711%')"
						+"AND g.gtype = 'book' AND g.price>20)").list();
		report.addAll(report1);
		return report;
	}

}
