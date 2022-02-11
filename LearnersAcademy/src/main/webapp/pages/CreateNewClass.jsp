<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Class</title>
</head>
<h2><a href="Welcome.jsp">Home</a></h2>
<h2><a href="/LearnersAcademy/logoutServlet">Logout</a></h2>	
<body>
	<center>
		<h2>
			<form method="post" action="/LearnersAcademy/classroom">
				<table border="1" cellpadding="10">
					<tr>
						<th>Class Name</th>
						<td><input type="text" name="className"></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="hidden" name="action" value="add">
							<input type="submit" value="Save" />
						</td>
					</tr>
				</table>
			</form>
		</h2>
	</center>
</body>
</html>