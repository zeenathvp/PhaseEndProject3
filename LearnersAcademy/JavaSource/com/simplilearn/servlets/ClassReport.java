package com.simplilearn.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.ClassroomDao;
import com.simplilearn.entity.Classroom;
import com.simplilearn.entity.Student;


public class ClassReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassroomDao classroomDao= new ClassroomDao();   
    
    public ClassReport() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int classId = Integer.parseInt(request.getParameter("classroom"));  
		Classroom classroom = classroomDao.getClassById(classId);
		List<Student> studentList = classroom.getStudents();
		
		request.setAttribute("StudentList", studentList);		
		RequestDispatcher rd = request.getRequestDispatcher("pages/ClassReport.jsp");		
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
