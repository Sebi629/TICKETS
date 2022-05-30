<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
Tickets:<br>
<c:forEach items="${tickets}" var="ticket">
    ${ticket.id}
    ${ticket.description}
    ${ticket.department}
    ${ticket.date}
    ${ticket.created}
    ${ticket.edited}
    ${ticket.accepted}
    ${ticket.priority}
    ${ticket.done}
    <br>
</c:forEach>

<%--${tickets}--%>
</body>
</html>
