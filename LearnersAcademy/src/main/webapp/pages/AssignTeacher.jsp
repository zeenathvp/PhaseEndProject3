<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%> 
<%@ page import="com.simplilearn.dao.ClassroomDao"%>
<%@ page import="com.simplilearn.dao.SubjectDao"%>
<%@ page import="com.simplilearn.dao.TeacherDao"%>
<%@ page import="com.simplilearn.dao.AssignmentDao"%>
<%@ page import="com.simplilearn.entity.Classroom"%>
<%@ page import="com.simplilearn.entity.Subject"%>
<%@ page import="com.simplilearn.entity.Teacher"%>
<%@ page import="com.simplilearn.entity.Class_Subject_Teacher"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Teachers</title>
</head>
<h2><a href="Welcome.jsp">Home</a></h2>
<h2><a href="/LearnersAcademy/logoutServlet">Logout</a></h2>
<% 
	List<Class_Subject_Teacher> assignmentList = new AssignmentDao().getAssignmentList();
	List<Teacher> TeacherList = new TeacherDao().getTeachers();
%>
<body>
	<center>
	
		<table>
			<tr>
				<th>Class</th>	
				<th>Subject</th>	
				<th>Teacher</th>	
			</tr>
			<%
				for(Class_Subject_Teacher assignment : assignmentList){
					int classID=assignment.getClassroom().getClassId();
					int subjectId=assignment.getSubject().getSubjectId();
					int class_subject_teacher_id = assignment.getClass_subject_teacher_id();
					int teacherId=0;
					if(assignment.getTeacher() != null){
						teacherId= assignment.getTeacher().getTeacherId();
					}
			%>
				<form action="/LearnersAcademy/assignment" method="post">
				<tr>
					<td><%= assignment.getClassroom().getClassName() %></td>
					<td><%= assignment.getSubject().getSubjectName() %></td>
					<td>
						<select name="teacher">
								<option value="select one">Select One</option>
								<%
									for(Teacher teacher : TeacherList){
								%>
									<option <% if(teacher.getTeacherId()==teacherId){ %>selected<%} %> value=<%=teacher.getTeacherId()%>><%= teacher.getTeacherName() %></option>	
								<%
									}
								%>
							</select>
					</td>
					<td></td>
					<td colspan="2" align="center">
						<input type="hidden" name="action" value="assignClassSubjectTeacher">
						<input type="hidden" name="classId" value=<%= classID %>>
						<input type="hidden" name="subjectId" value=<%=subjectId %>>
						<input type="hidden" name="classsubjectteacherid" value=<%=class_subject_teacher_id %>>
						<input type="submit" value="Assign" />
					</td>
				</tr>
				</form>
			<%
				}
			%>
		</table>
	</center>
</body>
</html>