package com.company.service.iservice;

import com.company.dao.pojo.Detail;
import com.company.dao.pojo.User;

public interface UserService extends BaseService<User, Integer>{
	String login(User user);
	String registry(User user,Detail detail);
	int findUidByUsername(String username);

}
