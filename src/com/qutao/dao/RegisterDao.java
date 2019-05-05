package com.qutao.dao;

public interface RegisterDao {
//	检测注册码是否有效
	public boolean checkInvitecode(String invitecode);
//	向数据库中添加数据信息
	public boolean register(String username,String password);
//	注册成功以后删除邀请码
	public boolean deleteInvitecode(String invitecode);
}
