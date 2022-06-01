<%--
  Created by IntelliJ IDEA.
  User: Sebi629
  Date: 01.06.2022
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

Tickets:<br>
<%--<c:forEach items="${users}" var="user">--%>
<%--    ${user.id}--%>
<%--    ${user.firstName}--%>
<%--    ${user.lastName}--%>
<%--    ${user.email}--%>
<%--    ${user.password}--%>
<%--    ${user.role}--%>
<%--    ${user.position}--%>
<%--    ${user.department}--%>
<%--    <br>--%>
<%--</c:forEach>--%>

<table class="table">

    <tr>

        <th>Id</th>

        <th>First Name</th>

        <th>Last Name</th>

        <th>Email</th>

        <th>Password</th>

        <th>Role</th>

        <th>Position</th>

        <th>Department</th>

        <%--        <th>Akcja</th>--%>

    </tr>

    <%--<c:forEach items="${users}" var="user">--%>

    <%--    <tr>--%>
    <%--        <td>${eser.email}</td>--%>
    <%--    </tr>--%>

    <%--</c:forEach>--%>

    <c:forEach items="${users}" var="user">

        <tr>

            <td>${user.id}</td>

            <td>${user.firstName}</td>

            <td>${user.lastName}</td>

            <td>${user.email}</td>

            <td>${user.password}</td>

            <td>${user.role}</td>

            <td>${user.position}</td>

            <td>${user.department}</td>

            <td>

                    <%--                <a href='<c:url value="/userdelete?id=${user.id}"/>'>Usuń</a>--%>

                    <%--                <a href='<c:url value="/useredit?id=${user.id}"/>'>Edit</a>--%>

                    <%--                <a href='<c:url value="/usershow?id=${user.id}"/>'>Pokaż</a>--%>

            </td>

        </tr>

    </c:forEach>

</table>

</body>
</html>
