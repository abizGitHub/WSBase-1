<%@ page import="oracle.jdbc.driver.Const" %>
<%@ page import="util.Consts" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope}</title>
    <script rel="script" src="js/jquery-3.3.1.js"></script>
</head>
<body>
<center>
    <h1>Group</h1>
</center>
<br/>
<jsp:include page="header.jsp"/>
<br/>
<c:set var="ua" value="${requestScope.list}"/>
<br/>
<table border="true" style="text-align: center">
    <tr>
        <td></td>
        <td>tableId</td>
        <td>name</td>
        <td>id</td>
    </tr>
    <c:forEach var="item" items="${ua}" varStatus="x">
        <tr>
            <td>${x.count}</td>
            <td>${item.tableId}</td>
            <td>${item.name}</td>
            <td>${item.id}</td>
        </tr>
    </c:forEach>
</table>

<br/>
</body>
</html>

