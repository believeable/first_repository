<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'update.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="updatePerson.action">
  姓名:<input type="text" name="name" value="${person.name }"><br>
  年龄<input type="text" name="age" value="${person.age }"><br>
  性别<input type="radio" name="gender" value="1">男
  <input type="radio" name="gender" value="0">女<br>
  邮箱:<input type="text" name="email" value="${person.email }"><br>
  <input type="submit">
  <input type="reset">
  </form>
  </body>
</html>
