package com.qutao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qutao.service.RegisterService;

public class RegisterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html;charset=UTF-8"); 
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
//		��д��������
		String invitecode = request.getParameter("invitecode");
		
		RegisterService registerService = new RegisterService();
//		�ж��Ƿ�ע��ɹ������ע��ɹ������򵽵�½ҳ�棬������ע��ҳ������ע��
		boolean isRgisterSuccess = registerService.register(username, password, invitecode);
		if(isRgisterSuccess)
		{
			response.sendRedirect("login.jsp");
		}
		else
		{
			response.sendRedirect("register.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
