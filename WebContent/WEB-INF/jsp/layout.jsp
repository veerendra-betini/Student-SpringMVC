<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>

<title><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute>
</title>
</head>
<body>
	<table width="700" border="1" bordercolor="#505050">
		<tr bgcolor=#C8C8C8>
			<td colspan="2" align="center"><tiles:insertAttribute
					name="header"></tiles:insertAttribute></td>
		</tr>
		<tr>
			<td style="background-color: #C8C8C8; width: 70px;"><tiles:insertAttribute
					name="leftmenu"></tiles:insertAttribute></td>
			<td><tiles:insertAttribute name="body"></tiles:insertAttribute>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><tiles:insertAttribute
					name="footer"></tiles:insertAttribute></td>
		</tr>
	</table>
</body>

</html>