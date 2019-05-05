package com.qutao.test;

import org.junit.Test;

import com.qutao.dao.impl.RegisterDaoImpl;

public class TestRegister {

	@Test
	public void testInvitecode()
	{
		RegisterDaoImpl rd = new RegisterDaoImpl();
		String invitecode = "12345126";
		boolean flag = rd.checkInvitecode(invitecode);
		System.out.println(flag);
	}
	
	@Test
	public void testRegister()
	{
		RegisterDaoImpl rd = new RegisterDaoImpl();
		String username = "lspal";
		String password = "sdasda";
		boolean flag = rd.register(username, password);
		System.out.println(flag);
	}
	
	@Test
	public void testDelete()
	{
		RegisterDaoImpl rd = new RegisterDaoImpl();
		String invitecode = "234567";
		boolean flag = rd.deleteInvitecode(invitecode);
		System.out.println(flag);
	}
}
