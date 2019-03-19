package com.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.entity.Student;
import com.student.service.IStudentService;
import com.student.service.Impl.StudentServiceImpl;

@WebServlet("/queryAllStudentServlet")
public class queryAllStudentServlet extends HttpServlet {
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		IStudentService stuService = new StudentServiceImpl();
		List<Student> students = stuService.queryAllStudent();
		request.setAttribute("students", students);
		request.getRequestDispatcher("index.jsp").forward(request, response);
			
		
	}
	
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
