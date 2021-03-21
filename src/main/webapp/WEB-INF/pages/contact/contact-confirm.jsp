<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>This is page for Contact CONFIRM...</p>
	
	<c:if test="${not empty information}">
		<div>${information}</div>
	</c:if>
	<c:if test="${not empty exception}">
		<div>${exception}</div>
	</c:if>
	
	
	<form:form action="${pageContext.request.contextPath}/contact/saveOrUpdate" 
				modelAttribute="contactPersonDto" method="post">
		<div>First Name:</div>
		<div><form:input type="text" path="firstname" size="60"/></div>
		<div><form:errors path="firstname" /></div>
		
		<div>Last Name:</div>
		<div><form:input type="text" path="lastname"/></div>
		<div><form:errors path="lastname" /></div>
		
		<div>Manufacurer Name:</div>
		<div>
			<div><form:input type="text" path="manufacturerDto.name"/></div>
		</div>
		<div><form:errors path="manufacturerDto" /></div>
		
		<div>Manufacurer Id :</div>
		<div>
			<div><form:input type="text" path="manufacturerDto.id"/></div>
		</div>
		<div><form:errors path="manufacturerDto" /></div>
		
		<button id=save>Save</button>
	</form:form>
</body>
</html>