package com.company.service.iservice;

import com.company.dao.pojo.Detail;

public interface DetailService extends BaseService<Detail, Integer>{
	String upload(int uid,String filePath);
}
