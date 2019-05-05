package com.qutao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qutao.service.LoginService;

/**
 * �������ڴ����¼��Servlet
 */
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // ����request���ı������� 
		response.setContentType("text/html;charset=UTF-8"); // ����response���ı������� 
		// 1 ��ȡ�ͻ����ύ������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username:" + username + " password:"+password);
		
		// 2 ȥ�������ݿ⣬��û�������������servlet��Ӧ��ֱ�ӷ���Dao�����Ӧ��ͨ��service��ȥ����Dao��
		LoginService ls = new LoginService();
		boolean isSuccess = ls.login(username,password);
		
		// 3 ����Dao�ķ��ʽ����������Ӧ
		if(isSuccess) {
			response.getWriter().write(username + ",���ã���¼�ɹ���");
			
		} else {
			response.getWriter().write("�û������������");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
