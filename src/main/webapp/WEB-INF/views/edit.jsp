<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:if test="${user!=null }">
	<form : form action ="edit" modelAttribute="u">
	
		<form:label path="id">ID</form:label>
		<form:input path="id" value="${user.gerId()}" readonly="true"/>
		<br>
		 <form:label path="name">Name</form:label>
		 <form:input path="name" value="${user.getName()}"/>
		 <br>
		 <form:label path="age">Age</form:label>
		  <form:input path="age" value="${user.getAge()}"/>
		  <br>
		   <form:label path="phone">Phone</form:label>
		  <form:input path="phone" value="${user.getPhone()}"/>
		  <br>
		   <form:label path="password">Phone</form:label>
		  <form:input path="password" value="${user.getPassword()}"/>
		  <br>
		  <form:button>Update</form:button>
	
	</form>
</c:if>

</body>
</html>