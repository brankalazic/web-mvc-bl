<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contacts</title>
</head>
<body>
	<p>This is page for CONTACT DETAILS...</p>
	
	<c:if test="${not empty information}">
		<div>${information}</div>
	</c:if>
	<c:if test="${not empty exception}">
		<div>${exception}</div>
	</c:if>
	
	
	<form:form modelAttribute="contactDto">
		<div>Id:</div>
		<div><form:input type="text" path="id" readonly="true" size="60"/></div>
		<div><form:errors path="id" /></div>
	
		<div>First name:</div>
		<div><form:input type="text" path="firstname" readonly="true" size="60"/></div>
		<div><form:errors path="firstname" /></div>
		
		<div>Last name:</div>
		<div><form:input type="text" path="lastname" readonly="true" size="60"/></div>
		<div><form:errors path="lastname" /></div>
		
		<div>Manufacturer id:</div>
		<div>
			<div><form:input type="text" path="manufacturerDto.id" readonly="true" size="60"/></div>
		</div>
		
		<div>Manufacturer name:</div>
		<div>
			<div><form:input type="text" path="manufacturerDto.name" readonly="true" size="60"/></div>
		</div>
		<div><form:errors path="manufacturerDto" /></div>
		
		<div>
			<a href="${pageContext.request.contextPath}/contact/edit/id/${contactPersonDto.id}">Edit</a>		
		</div>
	</form:form>
</body>
</html>