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


public class ClassRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassroomDao classroomdao= new ClassroomDao();
       

    public ClassRoomServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("add")) {
			createClassRoom(request,response);
		}else if(action.equals("list")) {
			getClassRoom(request,response);
		}
	}

	private void createClassRoom(HttpServletRequest request, HttpServletResponse response) {
		try {
			String className = request.getParameter("className");
			Classroom classroom = new Classroom(className);		
			classroomdao.createClassRoom(classroom);		
			getClassRoom(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	private void getClassRoom(HttpServletRequest request, HttpServletResponse response)  {
		try {
			List<Classroom> ClassRoomList = classroomdao.getClassrooms();
			request.getSession(false).setAttribute("ClassRoomList", ClassRoomList);
			RequestDispatcher rd = request.getRequestDispatcher("pages/viewClasses.jsp");		
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
