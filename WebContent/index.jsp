<%@page import="com.student.entity.Pages"%>
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
			Pages p = (Pages)request.getAttribute("pages");
			for(Student student : p.getPageStudents()){
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
	<a href="add.jsp">新增</a>显示数据量
	<form action="getStudentsByPageServlet" method="post">
		<select name="pSize">
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="5">5</option>
		</select>
		<input type="submit" value="确定"/>
	</form>
	<%=p.getCurrentPage()+1 %>/<%=p.getTotalPage() %>
	<%
		if(p.getCurrentPage()==0){
	%>
	<a>首页</a>
	<a>上一页</a>
	<a href="getStudentsByPageServlet?currentPage=<%=p.getCurrentPage()+1%>">下一页</a>
	<a href="getStudentsByPageServlet?currentPage=<%=p.getTotalPage()-1%>">尾页</a>
	<%
		}else if(p.getCurrentPage()==p.getTotalPage()-1){
	%>
	<a href="getStudentsByPageServlet?currentPage=0">首页</a>
	<a href="getStudentsByPageServlet?currentPage=<%=p.getCurrentPage()-1%>">上一页</a>
	<a>下一页</a>
	<a>尾页</a>
	<%
		}else{
	%>
	<a href="getStudentsByPageServlet?currentPage=0">首页</a>
	<a href="getStudentsByPageServlet?currentPage=<%=p.getCurrentPage()-1%>">上一页</a>
	<a href="getStudentsByPageServlet?currentPage=<%=p.getCurrentPage()+1%>">下一页</a>
	<a href="getStudentsByPageServlet?currentPage=<%=p.getTotalPage()-1%>">尾页</a>
	<%} %>
</body>
</html>