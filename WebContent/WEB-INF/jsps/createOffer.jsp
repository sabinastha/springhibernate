<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
   <%--  <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create offer page</title>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main.css"> 


</head>
<body>


 <div class="container">
 <center>
<form action="${pageContext.request.contextPath}/offerCreated" method="post" >


<table class="formtable">
<tr><td >FullName: </td><td><input  path="fullname" name="fullname" type="text" /><br/></td></tr>
<tr><td >UserName: </td><td><input   path="username" name="username" type="text" /><br/></tr>
<tr><td >Password: </td><td><input   path="password" name="password" type="text"><br/></td></tr>
<tr><td> </td><td><input  value="Create Offer" type="submit" /></td></tr>
</table>
</form>
</center>
</div>

</body>
</html>