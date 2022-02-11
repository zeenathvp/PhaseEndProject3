package com.simplilearn.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.dao.SubjectDao;
import com.simplilearn.entity.Subject;

public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SubjectDao subjectDao= new SubjectDao();
	
    public SubjectServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("add")) {
			createSubject(request,response);
		}else if(action.equals("list")) {
			getSubjects(request,response);
		}
	}

	private void createSubject(HttpServletRequest request, HttpServletResponse response) {
		try {
			String subjectName = request.getParameter("subjectName");
			Subject subject = new Subject(subjectName);		
			subjectDao.createSubject(subject);		
			getSubjects(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	private void getSubjects(HttpServletRequest request, HttpServletResponse response)  {
		try {
			List<Subject> SubjectList = subjectDao.getSubjects();
			request.getSession(false).setAttribute("SubjectList", SubjectList);
			RequestDispatcher rd = request.getRequestDispatcher("pages/viewSubjects.jsp");		
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
