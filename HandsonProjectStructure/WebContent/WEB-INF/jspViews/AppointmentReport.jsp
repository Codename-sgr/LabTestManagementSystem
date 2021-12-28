<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dummy Page</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
	<center>
		<h2>Appointment Report Details</h2>
		<form:form method="POST" modelAttribute="dateRangeObj"
			action="showAppointmentReport.html">
			<table border="2">
				<tr>
					<td>From Date [dd - MMM - yyyy]</td>
					<td><form:input path="fromDate" /></td>
					<br>
					<td>To Date[dd - MMM - yyyy]</td>
					<td><form:input path="toDate" /></td>
				</tr>
			</table>
					<br>
					<td><input type="submit" value="Fetch" /></td>
			
			
		</form:form>
		<br> <br> <a href="index.jsp">Home</a>


	</center>
</body>
</html>