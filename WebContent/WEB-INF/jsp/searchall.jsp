<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.data,.data td {
	border-collapse: collapse;
	border: 1px solid #aaa;
	margin: 2px;
	padding: 2px;
	background-color: #C8C8C8;
}

.data th {
	font-weight: bold;
	background-color: #505050;
	color: white;
}
</style>
</head>
<body>
	<h4>
		<a href="/Student-SpringMVC">Add More Students</a>
	</h4>
	<c:if test="${empty studentList}">
		<h4>No result found</h4>
	</c:if>
	<c:if test="${!empty studentList}">
		<h4>Students List:</h4>
		<table class="data">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>DOB</th>
				<th>Age</th>
				<th>Gender</th>
				<th>City</th>
				<th>Phone</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${studentList}" var="std">
				<!-- To change date format using JSTL -->
				<fmt:formatDate value="${std.birthDate}" var="formatedDate"
					pattern="dd/MM/yyyy" />
				<tr>
					<td>${std.id}</td>
					<td>${std.name}</td>
					<td>${formatedDate}</td>
					<td>${std.age}</td>
					<td>${std.gender}</td>
					<td>${std.city}</td>
					<td>${std.phone}</td>
					<td><a href="edit.html?id=${std.id}">edit</a> | <a
						href="delete/${std.id}">delete</a></td>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
