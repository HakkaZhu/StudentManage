package com.student.dao;

import java.util.List;

import com.student.entity.Student;

public interface IStudentDao {
	
	
	//新增学生功能
	public boolean addStudent(Student student);
		
	//删除学生
	public boolean deleteStudent(int uno);
	
	//修改学生信息
	public boolean updateStudent(Student student);
	
	//查询学生是否存在
	public boolean isExist(int sno); 
	
	//查询单个学生
	public Student queryStudent(int uno); 
		
	//查询所有学生
	public List<Student> queryAllStudent(); 
}
