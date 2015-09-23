<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ page session="false" %>
<html>
	<head>
		<title>${message}</title>
	</head>
	<body>
	    <h1>${message}</h1>
		<f:form method="POST" action="addPerson">
		<table>
			<tbody>
				<tr>
				  <td>Ticker:</td>
				  <td><f:input path="firstName" size="10" maxlength="10"></f:input></td>
				</tr>
				<tr>
				  <td>Issuer Name:</td>
				  <td><f:input path="lastName" size="30"></f:input></td>
				</tr>
				<tr>
				  <td>Issuer Type:</td>
				  <td><f:input path="branch" size="6"></f:input></td>
				</tr>
				<tr>
				  <td>Country:</td>
				  <td><f:input path="country" size="20"></f:input></td>
				</tr>
				<tr>
        			<td colspan="2"><input type="submit" value="Add Person"></td>
    			</tr>
			</tbody>
		</table>
		</f:form>	
	</body>
</html>