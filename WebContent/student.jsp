<%@page import="com.student.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		Student student = (Student)request.getAttribute("student");
	%>
	<form action="updateStudentServlet">
	学号<input type="text" name="uno" value="<%=student.getId()%>" readonly="readonly"/><br/>
	姓名<input type="text" name="uname" value="<%=student.getName()%>"/><br/>
	年龄<input type="text" name="uage" value="<%=student.getAge()%>"/><br/>
	地址<input type="text" name="uaddress" value="<%=student.getAddress()%>"/><br/>
	<input type="submit" value="更新"/>
	</form>
	<a href="getStudentsByPageServlet">返回</a>
</body>
</html>