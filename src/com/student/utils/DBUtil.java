package com.student.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.student.entity.Student;

public class DBUtil {
	private static final String url = "jdbc:mysql://localhost:3306/test";
	private static final String user = "root";
	private static final String password = "rootroot";

	public static Connection connection = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;
	
	//建立连接
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
			Class.forName("com.mysql.jdbc.Driver");
			return  DriverManager.getConnection(url, user, password);
	}
	
//	创建数据库语句
	public static PreparedStatement createPreparedStatement(String sql,Object[] params) {
		try {
			pstmt = getConnection().prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return pstmt;
	}
	
	//关闭数据库
	public static void getAllClose(ResultSet rs,Statement stmt,Connection connection) {
		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (connection != null) connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 增删改
	public static boolean executeUpdate(String sql, Object[] params) {
		boolean flag = false;
		try {
			pstmt = createPreparedStatement(sql, params);

			int count = pstmt.executeUpdate();
			if (count > 0)
				flag = true;
			else
				flag = false;

		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			getAllClose(null, pstmt, connection);
		}
		return flag;
	}

	// 查
	public static ResultSet executeQuery(String sql, Object[] params) {
		try {
			pstmt = createPreparedStatement(sql, params);
			rs = pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return rs;
	}
	
	//查询数据总量
	public static int getTotalDatas(String sql) {
		int count = -1;
		pstmt = createPreparedStatement(sql, null);
		try {
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			getAllClose(rs, pstmt, connection);
		}
		return count;
	}
	

}
