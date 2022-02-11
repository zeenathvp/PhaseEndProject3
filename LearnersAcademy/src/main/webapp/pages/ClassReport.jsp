<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.simplilearn.entity.Classroom"%>
<%@ page import="java.util.List"%> 
<%@ page import="com.simplilearn.dao.ClassroomDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Class Report</title>
</head>
<% 
	List<Classroom> classRoomList = new ClassroomDao().getClassrooms();
%>
<body>
	<center>
		<form action="/LearnersAcademy/classReport" method="post">
			<table>
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
					<td colspan="2" align="center">
						<input type="submit" value="View Report" />
					</td>
				</tr>
			</table>
		</form>	
		<%
			if(request.getParameter("StudentList") != null){
		%>	
			<h2>Student List</h2>
			<table>
				
			</table>
		<%
			}
		%>
	</center>
</body>
</html>