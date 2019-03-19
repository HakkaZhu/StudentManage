package com.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.service.IStudentService;
import com.student.service.Impl.StudentServiceImpl;


@WebServlet("/deleteStudentServlet")
public class deleteStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uno = Integer.parseInt(request.getParameter("uno"));
		IStudentService stuService = new StudentServiceImpl();
		if(stuService.deleteStudentService(uno)) {
			request.setAttribute("result", "删除成功");
		}else {
			request.setAttribute("result", "删除失败");
		}
		request.getRequestDispatcher("queryAllStudentServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
