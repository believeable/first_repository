<%@page import="test2.bean.PersonBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'persons.jsp' starting page</title>
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
  
  
  <center>
  <table border=1>
  <caption>大神</caption>
  <tr>
  <td>id</td>
  <td>姓名</td>
  <td>年龄</td>
  <td>性别</td>
  <td>邮箱</td>
  <td>修改</td>
  <td>删除</td>
  </tr>
  <c:forEach items="${persons }" var="person">
  <tr>
  <td>${person.id }</td>
  <td>${person.name }</td>
  <td>${person.age }</td>
  <td>
  <c:if test="${person.gender ==1}">男</c:if>
  <c:if test="${person.gender ==0}">女</c:if>
  </td>
  <td>${person.email }</td>
  <td>
  <c:url var="update" value="updatePrepared.action">
  <c:param name="id" value="${person.id }"></c:param>
  <c:param name="name" value="${person.name }"></c:param>
  <c:param name="age" value="${person.age }"></c:param>
  <c:param name="gender" value="${person.gender }"></c:param>
  <c:param name="email" value="${person.email }"></c:param>
  <%-- <%session.setAttribute("person",${person}) %> --%>
  </c:url>
  <a href="${update} ">修改</a>
  </td>
  <td>
  <c:url var="delete" value="/deletePersonById.action">
  <c:param name="id" value="${person.id }"></c:param>
  </c:url>
  <a href="${delete} ">删除</a>
  </td>
  </tr>
  </c:forEach>
  </table>
  <a href="/test2/addPerson.jsp">增加用户</a>
  
  </center>
  </body>
</html>
