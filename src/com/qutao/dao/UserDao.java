package com.qutao.dao;
/**
 * 该dao定义了对用户表的访问限制
 * 
 *
 */
public interface UserDao {
	/**
	 * 简化： 返回Boolean类型，成功或者失败
	 * 实际开发：登录一旦成功，应该返回该用户的个人信息
	 * @param username 
	 * @param password
	 * @return true:登录成功  false:登录失败
	 */
	boolean login(String username, String password);
}
