
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="user">
<h2>Czy chcesz usunąć pracownika o id: ${user.id}</h2>
<a href="<c:url value="/deleteuser/${user.id}"/>">TAK</a>
<a href="<c:url value="/user"/>">NIE</a>
</form:form>
</body>
</html>
