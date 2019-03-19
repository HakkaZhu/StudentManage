package com.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.entity.Student;
import com.student.service.IStudentService;
import com.student.service.Impl.StudentServiceImpl;

/**
 * Servlet implementation class addStudentServlet
 */
@WebServlet("/addStudentServlet")
public class addStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int uno = Integer.parseInt(request.getParameter("uno"));
		String uname = request.getParameter("uname");
		int uage = Integer.parseInt(request.getParameter("uage"));
		String uaddress = request.getParameter("uaddress");
		
		Student student = new Student(uno,uname,uage,uaddress);
		IStudentService stuService = new StudentServiceImpl();
		if(stuService.addStudentService(student)) {
			request.setAttribute("result", "新增成功");
			request.getRequestDispatcher("queryAllStudentServlet").forward(request, response);
		}else {
			request.getRequestDispatcher("add.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
