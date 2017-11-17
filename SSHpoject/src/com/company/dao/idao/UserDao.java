package com.company.dao.idao;

import com.company.dao.pojo.Detail;
import com.company.dao.pojo.User;

public interface UserDao extends BaseDao<User, Integer>{
	//登录
	String login(User user) throws Exception;
	//注册
	void registry(User user,Detail detail) throws Exception;
	//根据username获取主键uid
	int findUidByUsername(String username) throws Exception;
}
