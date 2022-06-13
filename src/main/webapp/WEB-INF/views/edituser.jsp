<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Edytowanie usera</h2>

<form:form method="post" action="/edituser" modelAttribute="user">

    <form:hidden path="id"/>

    <label>First Name:</label>
    <form:input path="firstName" type="text"/><br>

    <label>Last Name:</label>
    <form:input path="lastName" type="text"/><br>

    <label>Email:</label>
    <form:input path="email" type="text"/><br>

    <label>Password:</label>
    <form:password  path="password"/><br>

    <label>Role:</label>
    <form:select path="role">
        <form:options items="${role}" /><br>
    </form:select><br>

    <label>Position:</label>
    <form:select path="position">
        <form:options items="${position}" />
    </form:select><br>

    <label>Department:</label>
    <form:select  path="department">
        <form:options itemLabel="departmentName" items="${department}"/> >
    </form:select><br>

    <input type="submit" value="save">

</form:form>

</body>
</html>
