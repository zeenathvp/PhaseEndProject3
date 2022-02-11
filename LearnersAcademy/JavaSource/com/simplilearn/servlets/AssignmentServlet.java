package com.simplilearn.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.entity.Class_Subject_Teacher;
import com.simplilearn.entity.Classroom;
import com.simplilearn.entity.Subject;
import com.simplilearn.entity.Teacher;
import com.simplilearn.dao.AssignmentDao;
import com.simplilearn.dao.ClassroomDao;
import com.simplilearn.dao.SubjectDao;
import com.simplilearn.dao.TeacherDao;


public class AssignmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SubjectDao subjectDao= new SubjectDao();
	private ClassroomDao classRoomDao= new ClassroomDao();  
	private TeacherDao teacherDao= new TeacherDao();  
	private AssignmentDao assignmentDao= new AssignmentDao();  

    public AssignmentServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("assignClassSubject")) {
			assignClassSubject(request,response);
		}else if(action.equals("assignClassSubjectTeacher")) {
			assignClassSubjectTeacher(request,response);
		}
	}

	private void assignClassSubject(HttpServletRequest request, HttpServletResponse response)  {
		try {
			int subjectId = Integer.parseInt(request.getParameter("subject"));  
			int classId = Integer.parseInt(request.getParameter("classroom"));  
			
			String subjectName = subjectDao.getSubjectById(subjectId).getSubjectName();
			String className = classRoomDao.getClassById(classId).getClassName();
			
			Classroom classroom = new Classroom(classId,className);			
			Subject subject = new Subject(subjectId,subjectName);
			
			Class_Subject_Teacher classSubject = new Class_Subject_Teacher(subject,classroom);
			assignmentDao.assignclassSubjectTeacher(classSubject);
			
			request.getSession(false).setAttribute("message","Subject Assigned to Class");
			response.sendRedirect("pages/Welcome.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void assignClassSubjectTeacher(HttpServletRequest request, HttpServletResponse response)  {
		try {
						
			int subjectId = Integer.parseInt(request.getParameter("subjectId"));  
			int classId = Integer.parseInt(request.getParameter("classId"));  
			int teacherId = Integer.parseInt(request.getParameter("teacher")); 
			int classsubjectteacherid = Integer.parseInt(request.getParameter("classsubjectteacherid")); 
			
			String subjectName = subjectDao.getSubjectById(subjectId).getSubjectName();
			String className = classRoomDao.getClassById(classId).getClassName();
			String teacherName = teacherDao.getTeacherById(teacherId).getTeacherName();
			
			Classroom classroom = new Classroom(classId,className);			
			Subject subject = new Subject(subjectId,subjectName);
			Teacher teacher = new Teacher(teacherId,teacherName);
			
			Class_Subject_Teacher classSubjectTeacher = new Class_Subject_Teacher(classsubjectteacherid,subject,classroom,teacher);
			assignmentDao.updateclassSubjectTeacher(classSubjectTeacher);
			
			response.sendRedirect("pages/AssignTeacher.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
