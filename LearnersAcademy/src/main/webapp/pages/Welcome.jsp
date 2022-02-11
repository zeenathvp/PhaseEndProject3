<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Learner's Academy</title>
</head>
<body>
	<h2><a href="/LearnersAcademy/logoutServlet">Logout</a></h2>
	<center>
		<% if(request.getSession(false).getAttribute("message") != null && ! request.getSession(false).getAttribute("message").toString().isEmpty()) {%>
			<h2><p style="color:red"><%= request.getSession(false).getAttribute("message") %></p></h2>
		<%
			request.getSession(false).removeAttribute("message");
			} 
		%>
		<table>
			<tr>
				<td>
					<h1>Student Management</h1>
					<h2><a href="CreateNewStudent.jsp">Add New Student</a></h2>
					<h2><a href="/LearnersAcademy/student?action=list">View Students</a></h2>
				</td>
				<td>
					<h1>Teacher Management</h1>
					<h2><a href="CreateNewTeacher.jsp">Add New Teacher</a></h2>
					<h2><a href="/LearnersAcademy/teacher?action=list">View Teachers</a></h2>
				</td>
			</tr>
			<tr>
				<td>
					<h1>Subject Management</h1>
					<h2><a href="CreateNewSubject.jsp">Add New Subject</a></h2>
					<h2><a href="/LearnersAcademy/subject?action=list">View Subjects</a></h2>
				</td>
				<td>
					<h1>Classroom Management</h1>
					<h2><a href="CreateNewClass.jsp">Add New Classroom</a></h2>
					<h2><a href="/LearnersAcademy/classroom?action=list">View Classrooms</a></h2>
				</td>
			</tr>
			<tr>
				<td>
					<h1>Admin Functions</h1>
					<h2><a href="AssignSubject.jsp">Assign Subjects to Classes</a></h2>
					<h2><a href="AssignTeacher.jsp">Assign Teachers to Classes</a></h2>
					<h2><a href="ClassReport.jsp">Class Report</a></h2>
				</td>
			</tr>
		</table>						
	</center>
</body>
</html>