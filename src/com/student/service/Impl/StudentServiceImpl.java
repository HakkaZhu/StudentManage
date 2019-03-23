package com.student.service.Impl;

import java.util.List;

import com.student.dao.IStudentDao;
import com.student.dao.Impl.StudentDaoImpl;
import com.student.entity.Pages;
import com.student.entity.Student;
import com.student.service.IStudentService;
import com.student.utils.DBUtil;


public class StudentServiceImpl implements IStudentService {
	IStudentDao stu = new StudentDaoImpl();
	//新增学生信息
	public  boolean addStudentService(Student student) {
		if(!(stu.isExist(student.getId()))) {
			return stu.addStudent(student);
		}else
			return false;
	}
	//查询所有学生
	public List<Student> queryAllStudent(){
		return stu.queryAllStudent();
	}
	//删除学生
	public boolean deleteStudentService(int uno) {
		if(stu.isExist(uno)) {
			return stu.deleteStudent(uno);
		}else
			return false;
	}
	//根据学号查询学生
	public Student queryStudent(int uno) {
		return stu.queryStudent(uno);
	}
	//修改学生信息
	public boolean updateStudent(Student student) {
		if(stu.updateStudent(student))
			return true;
		else
			return false;
	}
	@Override
	public int getTotalStudents() {
		return stu.getTotalStudents();
	}
	@Override
	public List<Student> getStudentsByPage(int currentPage,int pageSize) {
		return stu.getStudentsByPage(currentPage, pageSize);
	}
	
}
