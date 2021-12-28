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
	color: red;
	font-style: italic;
}
</style>
</head>
<body>
	<center>
		<h2>Book a Appointment</h2>
		<form:form modelAttribute="appointmentBean" method="POST"
			action="addAppointment.html">

			<br>
			<table border="2">
				<tr>
					<th>Patient Name</th>
					<td><form:input path="patientName" /></td>
					<td><form:errors path="patientName"/></td>
				</tr>
				<tr>
					<th>Visit Date[dd-MMM-yyyy]</th>
					<td><form:input path="visitDate" /></td>
					<td><form:errors path="visitDate"/></td>
				</tr>
				<tr>
					<th>Doctor Name</th>
					<td><form:select path="doctorId">
							<form:option label="--Select--" value="0" />
							<form:options items="${doctorList}" />
						</form:select>
					</td>
					<td><form:errors path="doctorId"/></td>
				</tr>
			</table>
			<br>
			<br>
			<input type="submit" value="Book Appointment" />
			
			<%-- <spring:hasErrors name="appointmentBean">
				<form:errors path="*" />
			</spring:hasErrors> --%>
		</form:form>
		<br> <br> <a href="index.jsp">Home</a>

	</center>
</body>
</html>