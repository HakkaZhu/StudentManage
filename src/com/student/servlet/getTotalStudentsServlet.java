package com.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.entity.Pages;
import com.student.service.IStudentService;
import com.student.service.Impl.StudentServiceImpl;



@WebServlet("/getTotalStudentsServlet")
public class getTotalStudentsServlet extends HttpServlet {       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
//		Pages p = new Pages();
		IStudentService stuService = new StudentServiceImpl();
		int totalStudents = stuService.getTotalStudents();
		System.out.println(totalStudents);
//		p.setTotalStudent(totalStudents);
//		Pages p = new Pages(totalStudents);
		request.setAttribute("totalStudents", totalStudents);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
