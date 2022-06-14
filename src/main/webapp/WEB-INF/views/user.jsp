<%--
  Created by IntelliJ IDEA.
  User: Sebi629
  Date: 01.06.2022
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Users:</h2><br>


<table class="table">

    <tr>

        <th>Id</th>

        <th>First Name</th>

        <th>Last Name</th>

        <th>Email</th>

        <th>Role</th>

        <th>Position</th>

        <th>Department</th>

        <th>Akcja</th>

    </tr>



    <c:forEach items="${users}" var="user">

        <tr>

            <td>${user.id}</td>

            <td>${user.firstName}</td>

            <td>${user.lastName}</td>

            <td>${user.email}</td>

            <td>${user.role}</td>

            <td>${user.position}</td>

            <td>${user.department}</td>

            <td>



                        <a href="<c:url value="/edituser/${user.id}"/>">Edit</a>

                        <a href="<c:url value="/pytanieuser/${user.id}"/>">Delete</a>



            </td>

        </tr>

    </c:forEach>

</table>
<form:form method="get" action="/adduser" modelAttribute="user">
    <input type="submit" value="Add new user">
</form:form>
<form:form method="get" action="/ticket" modelAttribute="ticket">
    <input type="submit" value="TICKETS">
</form:form>

</body>
</html>
