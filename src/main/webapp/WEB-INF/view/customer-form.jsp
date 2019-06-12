<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CustomerForm</title>
</head>
<body>

	<!--<h3>Save Customer</h3>-->

	<form:form action="save" modelAttribute="customer" method="post">

		<!-- need to associate this data with customer id -->
		<form:hidden path="id" />

		<table>
			<tbody>
				<tr>
					<td><label>First name:</label></td>
					<td><form:input path="firstName" /></td>
				</tr>

				<tr>
					<td><label>Last name:</label></td>
					<td><form:input path="lastName" /></td>
				</tr>

				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</tbody>
		</table>
	</form:form>
</body>
</html>