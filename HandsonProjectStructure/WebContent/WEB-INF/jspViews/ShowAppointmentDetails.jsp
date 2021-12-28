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
		<h2>Show Appointment Details</h2>
		
		
		<c:if test="${not empty appointmentReportList}">
				<table border="2">
					<tr>
						<th>Appointment Id</th>
						<th>Patient Name</th>
						<th>Visit Date</th>
						<th>Doctor Id</th>
					</tr>
					<c:forEach items="${appointmentReportList}" var="list">
						<tr>
							<td>${list.appointmentId}</td>
							<td>${list.patientName}</td>
							<td>${list.visitDate}</td>
							<td>${list.doctorId}</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			 <br> <a href="index.jsp">Home</a>
	</center>
</body>
</html>