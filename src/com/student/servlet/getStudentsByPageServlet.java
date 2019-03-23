package com.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.entity.Pages;
import com.student.entity.Student;
import com.student.service.IStudentService;
import com.student.service.Impl.StudentServiceImpl;

@WebServlet("/getStudentsByPageServlet")
public class getStudentsByPageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Pages p = new Pages();
		IStudentService stuService = new StudentServiceImpl();
		int totalStudent = stuService.getTotalStudents();
		//数据总量
		p.setTotalStudent(totalStudent);
		String cPage = request.getParameter("currentPage");
		if(cPage == null) {
			cPage = "0";
		}
		int currentPage = Integer.parseInt(cPage);	
		//当前页
		p.setCurrentPage(currentPage);
		//页面大小
		String reqSize = request.getParameter("pSize");
		int pageSize = 3;
		if(reqSize != null) 
			pageSize = Integer.parseInt(request.getParameter("pSize"));
		p.setPageSize(pageSize);
		//当前页面集合
		List<Student> students = stuService.getStudentsByPage(currentPage, pageSize);
		p.setPageStudents(students);
		request.setAttribute("pages", p);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
