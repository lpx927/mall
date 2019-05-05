package com.qutao.service;

import com.qutao.dao.impl.RegisterDaoImpl;

public class RegisterService {
	public boolean register(String username,String password,String invitecode)
	{
		RegisterDaoImpl registerDaoImpl = new RegisterDaoImpl();
//		检测邀请码是否有效，如果有效继续注册，否则直接返回false;
		if(registerDaoImpl.checkInvitecode(invitecode))
		{
			boolean registerFalg = registerDaoImpl.register(username, password);
			if(registerFalg)
			{
//				如果注册成功删除注册码,并返回true
				registerDaoImpl.deleteInvitecode(invitecode);
				return true;
			}
			return false;
		}
		return false;
	}
}
