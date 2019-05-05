<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
<style type="text/css"> 
.align-center{ 
margin:0 auto; width:500px;  text-align:center;
} 
</style> 
</head>
<body>
	<div class="align-center">
	<h1>欢迎注册！</h1> <br><br>
		<form action="RegisterServlet" method="post">
		姓 名：<input type="text" name="username" /><br>
		密 码：<input type="text" name="password"><br>
		邀请码：<input type="text" name="invitecode"><br><br>
		<input type="submit" value="注册">
		</form>
	</div>
</body>
</html>