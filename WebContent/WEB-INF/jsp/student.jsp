<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Spring MVC Form Handling</title>
<style type="text/css">
.error {
	color: red;
	font-size: 0.9em;
	font-weight: bold;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}

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
<!-- DatePicker functionality -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
	$(function() {
		$("#dob")
				.datepicker(
						{
							onSelect : function(value, ui) {
								var today = new Date(), dob = new Date(value), age = new Date(
										today - dob).getFullYear() - 1970;
								$('#age').val(age);
								/* $('#age').attr('disabled', 'disabled');
								   $('#age').attr("readonly", true); */
							},
							maxDate : "+0D",
							yearRange : '1980:+0',
							changeMonth : true,
							changeYear : true,
						});
	});
</script>
</head>
<body>
	<form:form method="POST" action="/Student-SpringMVC/formpath"
		commandName="studentEntity">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<!-- commandName = name of a variable in the request scope or session scope that contaisn the information about this form, it should be a been.
         path = name of a bean property that should be accessed in order to pass the information to from and to the controller, 
from the controller when you want your inputs to have a "starting value" for example when you want to update a record,and to the controller when you submit your form. -->
		<!-- To change date format -->
		<fmt:formatDate value="${studentEntity.birthDate}" var="formatedDate"
			pattern="MM/dd/YYYY" />
		<table>
			<tr>
				<td><form:label path="id">
						<spring:message code="label.id" />
					</form:label></td>
				<td><form:input path="id" value="${studentEntity.id}" /></td>
				<td><form:errors path="id" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="name">
						<spring:message code="label.name" />
					</form:label></td>
				<td><form:input path="name" value="${studentEntity.name}" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="birthDate">
						<spring:message code="label.birthDate" />
					</form:label></td>
				<td><form:input path="birthDate" value="${formatedDate}"
						id="dob" /></td>
				<td><form:errors path="birthDate" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="age">
						<spring:message code="label.age" />
					</form:label></td>
				<td><form:input path="age" value="${studentEntity.age}"
						id="age" readonly='true' /></td>
				<td><form:errors path="age" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="phone">
						<spring:message code="label.phone" />
					</form:label></td>
				<td><form:input path="phone" value="${studentEntity.phone}" /></td>
				<td><form:errors path="phone" cssClass="error" /></td>
			</tr>
			<!-- Radio button  example-->
			<tr>
				<td>Gender:</td>
				<td><form:radiobutton path="gender" value="MALE" label="Male" />
					<form:radiobutton path="gender" value="FEMALE" label="Female" /></td>
				<td><form:errors path="gender" cssClass="error" /></td>
			</tr>
			<!-- Select box example-->
			<tr>
				<td>City:</td>
				<td><form:select path="city">
						<form:option value="NONE" label="--- Select ---" />
						<form:options items="${cityNames}" />
						<form:option value="Mumbai" label="Mumbai" />
					</form:select></td>
			</tr>
			<!--  Check box example -->
			<tr>
				<td>Hobbies:</td>
				<td><form:checkboxes path="hobbies" items="${hobbies}" /> <form:checkbox
						path="hobbies" value="Cricket" label="Cricket" /></td>
				<td><form:errors path="hobbies" cssClass="error" /></td>
			</tr>
			<tr>
				<td><c:if test="${!empty studentEntity.id}">
						<input type="submit" name="addStudent"
							value="<spring:message code="label.edit"/>" />
					</c:if> <c:if test="${empty studentEntity.id}">
						<input type="submit" name="addStudent"
							value="<spring:message code="label.add"/>" />
					</c:if></td>
				<%-- <td><input type="submit" name="addStudent"
				value="<spring:message code="label.add" />" /></td> --%>
				<td><input type="submit" name="search" value="search by id" />
					<input type="submit" name="searchall" value="searchall" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
