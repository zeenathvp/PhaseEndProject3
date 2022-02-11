<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.simplilearn.entity.Subject"%>
<%@ page import="java.util.List"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Subjects</title>
</head>
<% 
	List<Subject> subjectList = (List<Subject>) request.getSession().getAttribute("SubjectList"); 
%>
<h2><a href="pages/Welcome.jsp">Home</a></h2>
<h2><a href="/LearnersAcademy/logoutServlet">Logout</a></h2>		
<body>
		<table>
			<tr>
				<th>Subject Name</th>
			</tr>	
			<%
				for(Subject subject : subjectList){
			%>
				<tr>
					<td><%= subject.getSubjectName() %></td>
				</tr>
			<%
				}
			%>
		</table>
</body>
</html>