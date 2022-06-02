
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Czy chcesz usunąć pracownika o id: ${ticket.id}</h2>
<form:form method="post" action="/deleteticket/${ticket.id}" modelAttribute="ticket">
    <input type="submit" value="TAK">
</form:form>
<form:form method="get" action="/ticket" modelAttribute="ticket">
    <input type="submit" value="NIE">
</form:form>

</body>
</html>
