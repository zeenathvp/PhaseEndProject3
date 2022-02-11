<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.simplilearn.entity.Classroom"%>
<%@ page import="java.util.List"%> 
<%@ page import="com.simplilearn.dao.ClassroomDao"%>
<%@ page import="com.simplilearn.dao.SubjectDao"%>
<%@ page import="com.simplilearn.entity.Subject"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Subject To Classes</title>
</head>
<h2><a href="Welcome.jsp">Home</a></h2>
<h2><a href="/LearnersAcademy/logoutServlet">Logout</a></h2>
<% 
	List<Classroom> classRoomList = new ClassroomDao().getClassrooms();
	List<Subject> SubjectList = new SubjectDao().getSubjects();
%>
<body>
	<center>
		<h2>
			<form method="post" action="/LearnersAcademy/assignment">
				<table border="1" cellpadding="10">
					<tr>
						<th>Class</th>
						<td>
							<select name="classroom">
								<option value="select one">Select One</option>
								<%
									for(Classroom classroom : classRoomList){
								%>
									<option value=<%=classroom.getClassId() %>><%= classroom.getClassName() %></option>	
								<%
									}
								%>
							</select>
						</td>					
					</tr>
					<tr>
						<th>Subject</th>
						<td>
							<select name="subject">
								<option value="select one">Select One</option>
								<%
									for(Subject subject : SubjectList){
								%>
									<option value=<%=subject.getSubjectId() %>><%= subject.getSubjectName() %></option>	
								<%
									}
								%>
							</select>
						</td>					
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="hidden" name="action" value="assignClassSubject">
							<input type="submit" value="Save" />
						</td>
					</tr>
				</table>
			</form>
		</h2>
	</center>>
	</form>
</body>
</html>