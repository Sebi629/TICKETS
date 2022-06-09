<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Search:</h2>

<form:form method="post" action="/search" modelAttribute="filtr">
<%--<form:form method="post" action="/ticketByDepartment" modelAttribute="filtr">--%>
    <label>Department</label>
    <form:select path="department">
<%--        <form:option value="-" label="--Please Select--"/>--%>
        <form:options itemLabel="departmentName" items="${department}"/>
    </form:select>
<%--    <label>Priority</label>--%>
<%--    <form:select path="priority">--%>
<%--        <form:option value="-" label="--Please Select--"/>--%>
<%--        <form:options item="${priority}"/>--%>
<%--    </form:select>--%>
    <label>Status</label>
<form:select path="status">
<%--    <form:option value="-" label="--Please Select--"/>--%>
    <form:options items="${status}" itemValue="name"/>
</form:select>
    <input type="submit" value="search">
</form:form>

<h2>Tickets:</h2>

<table class="table">

    <tr>

        <th>Id</th>

        <th>User</th>

        <th>Description</th>

        <th>Department</th>

        <th>Date</th>

        <th>Created</th>

        <th>Edited</th>

        <th>Accepted</th>

        <th>Priority</th>

        <th>Status</th>

        <th>Akcja</th>

    </tr>



    <c:forEach items="${tickets}" var="ticket">

        <tr>

            <td>${ticket.id}</td>

            <td>${ticket.user}</td>

            <td>${ticket.description}</td>

            <td>${ticket.department}</td>

            <td>${ticket.date}</td>

            <td>${ticket.created}</td>

            <td>${ticket.edited}</td>

            <td>${ticket.accepted}</td>

            <td>${ticket.priority}</td>

            <td>${ticket.status}</td>

            <td>

                <a href="<c:url value="/pytanieticket/${ticket.id}"/>">Delete</a>

                 <a href="<c:url value="/editticket/${ticket.id}"/>">Edit</a>

            </td>

        </tr>

    </c:forEach>

</table>

<form:form method="get" action="/addticket" modelAttribute="ticket">
    <input type="submit" value="Add new ticket">
</form:form>


</body>
</html>
