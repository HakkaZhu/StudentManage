package com.student.dao.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.student.dao.IStudentDao;
import com.student.entity.Student;
import com.student.utils.DBUtil;

public class StudentDaoImpl implements IStudentDao {
	static Connection connection = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	// 新增学生功能
	public boolean addStudent(Student student) {
		String sql = "insert into users(id,name,age,address) values(?,?,?,?)";
		Object[] params = { student.getId(), student.getName(), student.getAge(), student.getAddress() };
		return DBUtil.executeUpdate(sql, params);
	}

	// 删除学生
	public boolean deleteStudent(int uno) {
		String sql = "delete from users where id = ?";
		Object[] params = { uno };
		return DBUtil.executeUpdate(sql, params);
	}

	// 修改学生信息
	public boolean updateStudent(Student student) {
		String sql = "update users set name = ?,age = ?,address =? where id = ?";
		Object[] params = { student.getName(), student.getAge(), student.getAddress(), student.getId() };
		return DBUtil.executeUpdate(sql, params);
	}

	// 查询学生是否存在
	public boolean isExist(int sno) {
		boolean flag = false;
		String sql = "select * from users where id = ?";
		Object[] params = { sno };
		try {
			rs = DBUtil.executeQuery(sql, params);
			if (rs.next())
				flag = true;
			else
				flag = false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.getAllClose(rs, pstmt, DBUtil.connection);
		}
		return flag;
	}

	// 查询单个学生
	public Student queryStudent(int uno) {
		Student student = null;
		String sql = "select * from users where id = ?";
		Object[] params = {uno};
		try {
			rs = DBUtil.executeQuery(sql, params);
				if(rs.next()) {
					int sno = rs.getInt("id");
					String sname = rs.getString("name");
					int sage = rs.getInt("age");
					String saddress = rs.getString("address");
					student = new Student(sno,sname,sage,saddress);
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.getAllClose(rs, pstmt, DBUtil.connection);
		}
		return student;
	}

	// 查询所有学生
	public List<Student> queryAllStudent() {
		List<Student> students = new ArrayList<>();
		Student student = null;
		String sql = "select * from users";
		Object[] params = {};
		try {
			rs = DBUtil.executeQuery(sql, params);
			while(rs.next()) {
				int sno = rs.getInt("id");
				String sname = rs.getString("name");
				int sage = rs.getInt("age");
				String saddress = rs.getString("address");
				student = new Student(sno,sname,sage,saddress);
				students.add(student);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.getAllClose(rs, pstmt, DBUtil.connection);
		}
		return students;
	}

}
