<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<sql:query var="rs" dataSource="jdbc/TestDB">
select * from user where id="${id}"

</sql:query>
</head>
<body>
offer selected

<c:forEach var="row" items="${rs.row}">
 <p>   Id ${row.id}<br />
    FullName ${row.fullname}<br />
    FullName ${row.username}<br />
    Password ${row.password}<br /> </p>
	</c:forEach>
</body>
</html>