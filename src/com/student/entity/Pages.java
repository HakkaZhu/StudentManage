package com.student.entity;

import java.util.List;

public class Pages {
	//数据总量
	private int totalStudent;
	//页面大小
	private int pageSize;
	//页面总数
	private int totalPage;
	//当前页
	private int currentPage;
	//页面数据集合
	private List<Student> pageStudents;

	public Pages() {}
	
	public Pages(int totalStudent, int pageSize, int currentPage, List<Student> pageStudents) {
		this.totalStudent = totalStudent;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.pageStudents = pageStudents;
	}
	
	public Pages(int totalStudent, int pageSize, int totalPage, int currentPage, List<Student> pageStudents) {
		this.totalStudent = totalStudent;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.pageStudents = pageStudents;
	}
	
	public int getTotalStudent() {
		return totalStudent;
	}
	public void setTotalStudent(int totalStudent) {
		this.totalStudent = totalStudent;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		this.totalPage = (totalStudent%pageSize==0 ? totalStudent/pageSize:(totalStudent/pageSize+1));
	}
	
	public int getTotalPage() {
		return totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public List<Student> getPageStudents() {
		return pageStudents;
	}
	public void setPageStudents(List<Student> pageStudents) {
		this.pageStudents = pageStudents;
	}
	
	@Override
	public String toString() {
		return toString();
	}
}
