package com.simplilearn.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.StudentDao;
import com.simplilearn.entity.Classroom;
import com.simplilearn.entity.Student;

public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao= new StudentDao();
	
    public StudentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("add")) {
			createStudent(request,response);
		}else if(action.equals("list")) {
			getStudents(request,response);
		}
	}

	private void createStudent(HttpServletRequest request, HttpServletResponse response) {
		try {
			String stdName = request.getParameter("stdName");
			String stdEmail = request.getParameter("stdEmail");
			int classId = Integer.parseInt(request.getParameter("className"));  
			
			Classroom classroom =  new Classroom(classId);
			Student student = new Student(stdName,stdEmail,classroom);	
			studentDao.saveStudent(student);		
			getStudents(request,response);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	private void getStudents(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Student> StudentsList = studentDao.getStudents();
			request.getSession(false).setAttribute("StudentList", StudentsList);
			RequestDispatcher rd = request.getRequestDispatcher("pages/viewStudents.jsp");		
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
