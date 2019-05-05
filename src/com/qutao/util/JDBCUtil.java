package com.qutao.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	static String driverClass = null;
	static String url = null; // ���ݿ�ĵ�ַ
	static String name = null; // �û���
	static String password = null; // �û�����
	
	// ����һ����̬�Ĵ���飬һ������JDBCUtil�࣬�ͻ�ȥ��ȡproperties
	static{
		try {
			//1. ����һ���������ö���
			Properties properties = new Properties();
			
			// ����������
//			InputStream in0 = new FileInputStream("jdbc.properties"); // ��Ӧ�ļ�λ�ڹ��̸�Ŀ¼
			InputStream in0 = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"); //��Ӧ�ļ�λ��srcĿ¼���� 
			properties.load(in0);
			
			// ��ȡ����
			driverClass = properties.getProperty("driverClass");
			url = properties.getProperty("url");
			name = properties.getProperty("name");
			password = properties.getProperty("password");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * ��ȡ���Ӷ���
	 * return Connection conn
	 */
	public static Connection getConn() {
		Connection conn = null; // ��仰���Բ���д,JDBC4.0�Ժ���ʹ��jar��ʱ���Դ���
		try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url,name,password);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return conn;
	}
	
	
	/**
	 * �ͷ���Դ
	 * @param conn
	 * @param st
	 * @param rs
	 */
	// ��¶�ķ���
	public static void release(Connection conn, Statement st, ResultSet rs) {
		closeRs(rs);
		closeSt(st);
		closeConn(conn);
	}
	
	public static void release(Connection conn, Statement st) {
		closeSt(st);
		closeConn(conn);
	}
	
	
	
	// �ͷ���Դ
	private static void closeRs(ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			rs = null;
		}
	}
	
	// �ͷ���Դ
	private static void closeSt(Statement st) {
		try {
			if(st != null) {
				st.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			st = null;
		}
	}
	
	// �ͷ���Դ
	private static void closeConn(Connection conn) {
		try {
			if(conn != null) {
				conn.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			conn = null;
		}
	}
}
