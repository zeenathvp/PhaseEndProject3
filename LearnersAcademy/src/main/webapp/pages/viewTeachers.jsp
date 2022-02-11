<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.simplilearn.entity.Teacher"%>
<%@ page import="java.util.List"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Teachers</title>
</head>
<% 
	List<Teacher> teacherList = (List<Teacher>) request.getSession().getAttribute("TeacherList"); 
%>
<h2><a href="pages/Welcome.jsp">Home</a></h2>
<h2><a href="/LearnersAcademy/logoutServlet">Logout</a></h2>		
<body>
		<table>
			<tr>
				<th>Subject Name</th>
			</tr>	
			<%
				for(Teacher teacher : teacherList){
			%>
				<tr>
					<td><%= teacher.getTeacherName() %></td>
				</tr>
			<%
				}
			%>
		</table>
</body>
</html>