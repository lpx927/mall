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
	static String url = null; // 数据库的地址
	static String name = null; // 用户名
	static String password = null; // 用户密码
	
	// 创建一个静态的代码块，一旦加载JDBCUtil类，就会去读取properties
	static{
		try {
			//1. 创建一个属性配置对象
			Properties properties = new Properties();
			
			// 导入输入流
//			InputStream in0 = new FileInputStream("jdbc.properties"); // 对应文件位于工程根目录
			InputStream in0 = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"); //对应文件位于src目录底下 
			properties.load(in0);
			
			// 读取属性
			driverClass = properties.getProperty("driverClass");
			url = properties.getProperty("url");
			name = properties.getProperty("name");
			password = properties.getProperty("password");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 获取连接对象
	 * return Connection conn
	 */
	public static Connection getConn() {
		Connection conn = null; // 这句话可以不用写,JDBC4.0以后在使用jar包时候自带了
		try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url,name,password);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return conn;
	}
	
	
	/**
	 * 释放资源
	 * @param conn
	 * @param st
	 * @param rs
	 */
	// 暴露的方法
	public static void release(Connection conn, Statement st, ResultSet rs) {
		closeRs(rs);
		closeSt(st);
		closeConn(conn);
	}
	
	public static void release(Connection conn, Statement st) {
		closeSt(st);
		closeConn(conn);
	}
	
	
	
	// 释放资源
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
	
	// 释放资源
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
	
	// 释放资源
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
