package com.student.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			connection = DriverManager.getConnection(url, user, password);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch(SQLException e) {
//			e.printStackTrace();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		return connection;
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
			createPreparedStatement(sql, params);
			rs = pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
//			getAllClose(null, pstmt,connection );
//			try {
//				if (rs != null)
//					rs.close();
//				if (pstmt != null)
//					pstmt.close();
//				if (connection != null)
//					connection.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
		}
		return rs;
	}

}
