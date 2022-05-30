
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form  method="post" modelAttribute="ticket">

    <label>User:</label>


    <form:select itemValue="id" itemLabel="email" path="user"
                 items="${users}" />



    <label>Description:</label>
<form:input type="text"  path="description"/>

    <label>Priority:</label>
    <form:select path="priority">
        <form:option value="-" label="--Please Select--"/>
        <form:options item="${priority}"/>
    </form:select>

<%--    <label>Department:</label>--%>
<%--    <form:select path="department">--%>
<%--        <form:option value="-" label="--Please Select--"/>--%>
<%--        <form:options item="${department}"/>--%>
<%--    </form:select>--%>

    <form:select itemValue="id" itemLabel="email" path="department"
                 items="${department}" />

    <input type="submit" value="save">
</form:form>



</body>
</html>
