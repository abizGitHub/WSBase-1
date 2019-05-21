<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--
  Created by IntelliJ IDEA.
  User: abiz
  Date: 5/18/2019
  Time: 12:49 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope}</title>
</head>
<body>
<center>
    <h1>UserAccountLog</h1>
</center>
<c:set var="ualog" value="${requestScope.list}"/>
<br/>
<jsp:include page="header.jsp"/>
<br/>
<table border="1" style="text-align: center;width : 100%">
    <tr>
        <td> x </td>
        <td> userAccountId </td>
        <td> userName </td>
        <td> hasPermission </td>
        <td> lastConnectDate </td>
        <td> lastConnectTime </td>
        <td> logType </td>
    </tr>
    <c:forEach var="item" items="${ualog}" varStatus="x">
        <tr>
            <td>${x.count}</td>
            <td>${item.userAccountId}</td>
            <td>${item.userName}</td>
            <td>${item.hasPermission}</td>
            <td>${item.lastConnectDate}</td>
            <td>${item.lastConnectTime}</td>
            <td>${item.logType}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

