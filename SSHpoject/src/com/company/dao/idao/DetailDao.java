package com.company.dao.idao;

import com.company.dao.pojo.Detail;

public interface DetailDao extends BaseDao<Detail, Integer>{
	void upload(int uid,String filePath)throws Exception;
}
