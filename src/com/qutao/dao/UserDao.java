package com.qutao.dao;
/**
 * ��dao�����˶��û���ķ�������
 * 
 *
 */
public interface UserDao {
	/**
	 * �򻯣� ����Boolean���ͣ��ɹ�����ʧ��
	 * ʵ�ʿ�������¼һ���ɹ���Ӧ�÷��ظ��û��ĸ�����Ϣ
	 * @param username 
	 * @param password
	 * @return true:��¼�ɹ�  false:��¼ʧ��
	 */
	boolean login(String username, String password);
}
