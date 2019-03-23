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

@WebServlet("/updateStudentServlet")
public class updateStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int sno = Integer.parseInt(request.getParameter("uno"));
		String sname = request.getParameter("uname");
		int sage = Integer.parseInt(request.getParameter("uage"));
		String saddress = request.getParameter("uaddress");
		Student student = new Student(sno,sname,sage,saddress);
		IStudentService stuService = new StudentServiceImpl();
		boolean result = stuService.updateStudent(student);
		if(result) {
			request.setAttribute("result", "修改成功");
			request.getRequestDispatcher("getStudentsByPageServlet").forward(request, response);
		}else {
			request.getRequestDispatcher("getStudentsByPageServlet").forward(request, response);
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
