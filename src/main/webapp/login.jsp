<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>
<head>
	<title>Insert title here</title>
</head>
<body>
	<h4>登录页面..注意。。。。。。。暂时没做出来全面的，所以这里必须选中复选框！！！</h4>
	<form action="shiro/login" method="POST" id="form1">
		用户名: <input type="text" name="username" /> <br>
		<br> 密码: <input type="password" name="password" /> <br>
		<br> 记住我：<input type="checkbox" name="rememberme" id="rememberme"> <br>
		<br> 
				<input type="submit" value="提交2"/>
	</form>

</body>
</html>