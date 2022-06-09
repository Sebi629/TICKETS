
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>TESTOWY NAPIS</h1>

<%--<form:form method="post" action="/home" modelAttribute="actual">--%>

<%--<c:if test="${actual.id==9}">--%>
<%--  <h1>jestem adminem</h1>--%>
<%--    <form:input path="id"/>--%>
<%--</c:if>--%>
<%--<c:if test="${actual.id!=9}">--%>
<%--   <h1>nie jestem adminem</h1>--%>
<%--    <form:hidden path="id"/>--%>
<%--</c:if>--%>

<%--</form:form>--%>

<form:form method="post" action="/home" modelAttribute="actual">

    <c:if test="${actual.role==ADMIN}">
        <h1>jestem adminem</h1>
        <form:input path="id"/>
    </c:if>
    <c:if test="${actual.role==USER}">
        <h1>nie jestem adminem</h1>
        <form:hidden path="id"/>
    </c:if>

</form:form>
</body>
</html>
