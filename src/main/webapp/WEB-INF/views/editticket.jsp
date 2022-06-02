<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="ticket">

    <label>User:</label>
    <form:select itemValue="id" itemLabel="email" path="user"
                 items="${users}" /><br>

    <label>Description:</label>
    <form:input type="text"  path="description"/><br>

    <label>Priority:</label>
    <form:select path="priority">
        <form:options item="${priority}"/>
    </form:select><br>

    <label>Department:</label>
    <form:select path="department"
                 items="${department}" /><br>

    <label>Date:</label>
    <form:input type="date" path="date"/><br>

    <input type="submit" value="save">



</form:form>
</body>
</html>
