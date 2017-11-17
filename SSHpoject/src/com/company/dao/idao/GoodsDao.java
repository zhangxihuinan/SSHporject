package com.company.dao.idao;

import java.util.List;

import com.company.dao.pojo.Goods;

public interface GoodsDao extends BaseDao<Goods, Integer>{
	List<Goods> findAllPage(int pageBegin,int pageSize) throws Exception;
	List<Goods> findByName(String gname) throws Exception;
	List<Goods> findByNamePage(int pageBegin,int pageSize,String gname) throws Exception;
	List<Goods> findByGtype(String gtype) throws Exception;
	List<Goods> findByGtypePage(int pageBegin,int pageSize,String gtype) throws Exception;

}
