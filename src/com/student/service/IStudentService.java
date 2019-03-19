package com.student.service;

import java.util.List;

import com.student.dao.IStudentDao;
import com.student.entity.Student;

public interface IStudentService {
	//新增学生信息
	public  boolean addStudentService(Student student); 
	
	//查询所有学生
	public List<Student> queryAllStudent();
	
	//删除学生
	public boolean deleteStudentService(int uno); 
	
	//根据学号查询学生
	public Student queryStudent(int uno); 
	
	//修改学生信息
	public boolean updateStudent(Student student); 
	
}
