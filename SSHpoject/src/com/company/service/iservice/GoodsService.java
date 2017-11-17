package com.company.service.iservice;

import java.util.List;

import com.company.dao.pojo.Goods;

public interface GoodsService extends BaseService<Goods, Integer>{
	List<Goods> findByName(String gname);
	List<Goods> findAllPage(int pageBegin,int pageSize);
	List<Goods> findByNamePage(int pageBegin,int pageSize,String gname);
	List<Goods> findByGtype(String gtype);
	List<Goods> findByGtypePage(int pageBegin,int pageSize,String gtype);

}
