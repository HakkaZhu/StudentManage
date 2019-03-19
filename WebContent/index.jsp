<%@page import="com.student.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=request.getAttribute("result") %>
	
	<table border="1">
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>地址</th>
			<th>操作</th>
		</tr>
		<%
			request.setCharacterEncoding("utf-8");
			List<Student> students = (List<Student>)request.getAttribute("students");
			for(Student student : students){
		%>
		
				<tr>
					<td><a href="queryStudentServlet?uno=<%=student.getId() %>"><%=student.getId() %></a></td>
					<td><%=student.getName() %></td>
					<td><%=student.getAge() %></td>
					<td><%=student.getAddress() %></td>
					<td><a href="deleteStudentServlet?uno=<%=student.getId()%>">删除</a></td>
				</tr>
		<%		
			}
		%>
	
	</table>
	<a href="add.jsp">新增</a>
</body>
</html>