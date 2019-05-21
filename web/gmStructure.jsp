<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope}</title>
</head>
<body>
<center>
    <h1>GM Structure</h1>
</center>
<br/>
<jsp:include page="header.jsp"/>
<br/>
<br/>
<table border="1" style="text-align: center;height: 10%">
    <tr>
        <td> tableIx</td>
        <td> tableName</td>
        <td> title</td>
        <td> headerL</td>
        <td> headerR</td>
        <td> body</td>
        <td> footerL</td>
        <td> footerR</td>
    </tr>
    <c:set var="ua" value="${requestScope.list}"/>
    <c:forEach var="item" items="${ua}" varStatus="x">
        <form action="gmStructure.do">
            <input type="hidden" name="id" value="${item.id}"/>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr>
                <td>${item.tableIx}</td>
                <td><input name="tableName" value="${item.tableName}"/></td>
                <td><input name="title" value="${item.title}"/></td>
                <td><input name="headerL" value="${item.headerL}"/></td>
                <td><input name="headerR" value="${item.headerR}"/></td>
                <td><input name="body" value="${item.body}"/></td>
                <td><input name="footerL" value="${item.footerL}"/></td>
                <td><input name="footerR" value="${item.footerR}"/></td>
                <td><input type="submit" value="save"/></td>
            </tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
        </form>
    </c:forEach>
</table>
<br/>
</body>
</html>

