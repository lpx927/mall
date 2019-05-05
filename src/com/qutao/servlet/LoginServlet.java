package com.qutao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qutao.service.LoginService;

/**
 * 这是用于处理登录的Servlet
 */
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 处理request中文编码问题 
		response.setContentType("text/html;charset=UTF-8"); // 处理response中文编码问题 
		// 1 获取客户端提交的数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username:" + username + " password:"+password);
		
		// 2 去访问数据库，有没有这个对象。这里servlet不应该直接访问Dao层而是应该通过service层去访问Dao层
		LoginService ls = new LoginService();
		boolean isSuccess = ls.login(username,password);
		
		// 3 根据Dao的访问结果，做出响应
		if(isSuccess) {
			response.getWriter().write(username + ",您好！登录成功！");
			
		} else {
			response.getWriter().write("用户名或密码错误！");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
