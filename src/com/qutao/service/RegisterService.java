package com.qutao.service;

import com.qutao.dao.impl.RegisterDaoImpl;

public class RegisterService {
	public boolean register(String username,String password,String invitecode)
	{
		RegisterDaoImpl registerDaoImpl = new RegisterDaoImpl();
//		����������Ƿ���Ч�������Ч����ע�ᣬ����ֱ�ӷ���false;
		if(registerDaoImpl.checkInvitecode(invitecode))
		{
			boolean registerFalg = registerDaoImpl.register(username, password);
			if(registerFalg)
			{
//				���ע��ɹ�ɾ��ע����,������true
				registerDaoImpl.deleteInvitecode(invitecode);
				return true;
			}
			return false;
		}
		return false;
	}
}
