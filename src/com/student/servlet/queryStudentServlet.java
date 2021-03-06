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
 * Servlet implementation class queryStudentServlet
 */
@WebServlet("/queryStudentServlet")
public class queryStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int uno = Integer.parseInt(request.getParameter("uno"));

		IStudentService stuService = new StudentServiceImpl();
		Student student = stuService.queryStudent(uno);
		request.setAttribute("student", student);
		request.getRequestDispatcher("student.jsp").forward(request, response);
//		response.sendRedirect("student.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
