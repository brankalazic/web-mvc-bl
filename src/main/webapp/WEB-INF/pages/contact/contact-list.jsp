<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contacts</title>
</head>
<body>
	This is page for CONTACT list.
	<div>
		<h1>All CONTACTS</h1>
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>First name</th>
					<th>Last name</th>
					<th>Manufacturer</th>
					<th>Details</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="c" items="${contacts}">
				<tr>
					<td>${c.id}</td>
					<td>${c.firstname}</td>
					<td>${c.lastname}</td>
					<td>${c.manufacturerDto.id}</td>
					<td><a href="${pageContext.request.contextPath}/contact/details/id/${c.id}"> details</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>