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
			conn = JDBCUtil.getConn(); // 1 ������Ӷ���
			System.out.println("���ݿ�״̬: " + conn.isClosed()); // �ж����ݿ��Ƿ����ӣ�ͨ�����conn��״̬
			String sql = "SELECT * FROM c_user WHERE username=? AND password=?"; 
			
			ps = conn.prepareStatement(sql); // 2 ����ps����
			ps.setString(1, username);
			ps.setString(2, password);
			
			rs = ps.executeQuery(); // 3 ��ʼ��ѯ���õ������
			return rs.next(); // ������Գɹ��ƶ�����һ�У���ô������û��� Ҳ������if-else�ж�
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.release(conn, ps, rs);
		}
		return false;
	}

}
