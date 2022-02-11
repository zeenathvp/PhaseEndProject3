<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page import="com.simplilearn.entity.Student"%>
<%@ page import="java.util.List"%>  

 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Classes</title>
</head>
<% 
	List<Student> studentList = (List<Student>) request.getSession().getAttribute("StudentList"); 
%>
<h2><a href="pages/Welcome.jsp">Home</a></h2>
<h2><a href="/LearnersAcademy/logoutServlet">Logout</a></h2>		
<body>
		<table>
			<tr>
				<th>Student Name</th>
				<th>Email</th>
				<th>Class</th>
			</tr>	
			<%
				for(Student student : studentList){
			%>
				<tr>
					<td><%= student.getStdName() %></td>
					<td><%= student.getStdEmail() %></td>
					<td><%= student.getClassroom().getClassName() %></td>
				</tr>
			<%
				}
			%>
		</table>
</body>
</html>