package com.qutao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qutao.dao.RegisterDao;
import com.qutao.util.JDBCUtil;

public class RegisterDaoImpl implements RegisterDao {

//	检测验证码是否存在
	public boolean checkInvitecode(String invitecode) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn(); 
			String sql = "SELECT * FROM c_userinvitecode WHERE invitecode=?"; 
			ps = conn.prepareStatement(sql); 
			ps.setString(1, invitecode);
			rs = ps.executeQuery(); 
			return rs.next(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, ps, rs);
		}
		return false;
	}

//	注册功能
	public boolean register(String username, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn(); 
			String sql = "INSERT INTO c_user (username,PASSWORD) VALUES(?,?)"; 
			ps = conn.prepareStatement(sql); 
			ps.setString(1, username);
			ps.setString(2, password);
			return ps.executeUpdate()==1; 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, ps, rs);
		}
		return false;
	}

//	删除验证码
	public boolean deleteInvitecode(String invitecode) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn(); 
			String sql = "DELETE FROM c_userinvitecode WHERE invitecode=?"; 
			ps = conn.prepareStatement(sql); 
			ps.setString(1, invitecode);
			return ps.executeUpdate()==1; 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, ps, rs);
		}
		return false;
		
	}

}
