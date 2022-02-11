package com.simplilearn.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.TeacherDao;
import com.simplilearn.entity.Teacher;


public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDao teacherDao= new TeacherDao();   

    public TeacherServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("add")) {
			createTeacher(request,response);
		}else if(action.equals("list")) {
			getTeachers(request,response);
		}
	}

	private void createTeacher(HttpServletRequest request, HttpServletResponse response) {
		try {
			String teacherName = request.getParameter("teacherName");
			if(teacherName.isEmpty()) {
				request.getSession(false).setAttribute("message","One of the input parameter is missing");
				response.sendRedirect("pages/Welcome.jsp");
			}else {
				Teacher teacher = new Teacher(teacherName);		
				teacherDao.createSubject(teacher);		
				getTeachers(request,response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	private void getTeachers(HttpServletRequest request, HttpServletResponse response)  {
		try {
			List<Teacher> TeacherList = teacherDao.getTeachers();
			request.getSession(false).setAttribute("TeacherList", TeacherList);
			RequestDispatcher rd = request.getRequestDispatcher("pages/viewTeachers.jsp");		
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
