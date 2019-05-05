package com.qutao.service;

import com.qutao.dao.impl.UserDaoImpl;

public class LoginService {
	public boolean login(String username,String password)
	{
		UserDaoImpl udi = new UserDaoImpl();
		return udi.login(username, password);
	}
}
