<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Person page</title>
 <style type="text/css">
 .tg{
 border-collapse:collapse;
 border-margin:0;
 border-color:black;
 }
 .tg td{
 font-family:arial, sans-serif;
 font-size:15px;
 padding:10px 5px;
 border-style:solid;
 border-width:1px;
 overflow:hidden;
 word-break:normal;
 border-color:black;
 color:#333;
 background-color:skyblue;
}
.tg th{
font-family:Arial, sans-serif;
font-size:14px;
font-weight:normal;
padding:10px 5px;
border-style:solid;
border-width:1px;
overflow:hidden;
word-break:normal;
border-color:#ccc;
color:#333;
background-color:pink;
}
.tg .tg-4eph{background-color:#f9f9f9}
 </style>
 </head>
 <body>
 <h1> ADD A PERSON</h1>
 <form method="post" action="/MVCSpring/addPerson.do">
Name : <input type="text" name="name" value="">
Country : <input type="text" name="country">
<input type="submit" value="Save">
</form>
  <br>
 <br>
 <h3>Persons List</h3>
<c:if test="${!empty personList}">
	<table class="tg">
	<tr>
		<th width="80">Person ID</th>
		<th width="120">Person Name</th>
		<th width="120">Person Country</th>
		
	</tr>
	<c:forEach items="${personList}" var="person">
		<tr>
			<td>${person.id}</td>
			<td>${person.name}</td>
			<td>${person.country}</td>
			</tr>
	</c:forEach>
	</table>
</c:if>
 
 </body>
 
</html>