package com.qutao.dao;

public interface RegisterDao {
//	���ע�����Ƿ���Ч
	public boolean checkInvitecode(String invitecode);
//	�����ݿ������������Ϣ
	public boolean register(String username,String password);
//	ע��ɹ��Ժ�ɾ��������
	public boolean deleteInvitecode(String invitecode);
}
