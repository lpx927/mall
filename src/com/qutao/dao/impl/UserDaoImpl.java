package com.qutao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qutao.dao.UserDao;
import com.qutao.util.JDBCUtil;

public class UserDaoImpl implements UserDao {
	
	public boolean login(String username, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn(); // 1 获得连接对象
			System.out.println("数据库状态: " + conn.isClosed()); // 判断数据库是否连接，通过输出conn的状态
			String sql = "SELECT * FROM c_user WHERE username=? AND password=?"; 
			
			ps = conn.prepareStatement(sql); // 2 创建ps对象
			ps.setString(1, username);
			ps.setString(2, password);
			
			rs = ps.executeQuery(); // 3 开始查询，得到结果集
			return rs.next(); // 如果可以成功移动到下一行，那么有这个用户。 也可以用if-else判断
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, ps, rs);
		}
		return false;
	}

}
