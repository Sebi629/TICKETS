<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%--Tickets:<br>--%>
<%--<c:forEach items="${tickets}" var="ticket">--%>
<%--    ${ticket.id}--%>
<%--    ${ticket.description}--%>
<%--    ${ticket.department}--%>
<%--    ${ticket.date}--%>
<%--    ${ticket.created}--%>
<%--    ${ticket.edited}--%>
<%--    ${ticket.accepted}--%>
<%--    ${ticket.priority}--%>
<%--    ${ticket.done}--%>
<%--    <br>--%>
<%--</c:forEach>--%>

<table class="table">

    <tr>

        <th>Id</th>

        <th>Description</th>

        <th>Department</th>

        <th>Date</th>

        <th>Created</th>

        <th>Edited</th>

        <th>Accepted</th>

        <th>Priority</th>

        <th>Done</th>

        <th>Akcja</th>

    </tr>



    <c:forEach items="${tickets}" var="ticket">

        <tr>

            <td>${ticket.id}</td>

            <td>${ticket.description}</td>

            <td>${ticket.department}</td>

            <td>${ticket.date}</td>

            <td>${ticket.created}</td>

            <td>${ticket.edited}</td>

            <td>${ticket.accepted}</td>

            <td>${ticket.priority}</td>

            <td>${ticket.done}</td>

            <td>

<%--                <a href='<c:url value="/userdelete?id=${user.id}"/>'>Usuń</a>--%>
    <a href="<c:url value="/delete/${ticket.id}"/>">Delete</a>
<%--                <a href='<c:url value="editticket?id=${ticked.id}"/>'>Edit</a>--%>
    <a href="<c:url value="/editticket/${ticket.id}"/>">Edit</a>

<%--                <a href='<c:url value="/usershow?id=${user.id}"/>'>Pokaż</a>--%>

            </td>

        </tr>

    </c:forEach>

</table>


</body>
</html>
