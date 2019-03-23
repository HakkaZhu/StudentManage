<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="addStudentServlet" method="post">
		学号<input type="text" name="uno"/><br/>
		姓名<input type="text" name="uname"/><br/>
		年龄<input type="text" name="uage"/><br/>
		地址<input type="text" name="uaddress"/><br/>
		<input type="submit" value="新增"/>
		<a href="getStudentsByPageServlet">返回</a>
	</form>
</body>
</html>