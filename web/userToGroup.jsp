<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="util.Consts" %>

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
    <h1>UserToGroup</h1>
</center>
<c:set var="ualog" value="${requestScope.list}"/>
<br/>
<jsp:include page="header.jsp"/>
<br/>
<table border="1" style="text-align: center;width : 100%">
    <tr>
        <td> x</td>
        <td> userAccountId</td>
        <td> userName</td>
        <td> groupId</td>
        <td> groupName</td>
        <td> status</td>
        <td> register</td>
    </tr>
    <c:forEach var="item" items="${ualog}" varStatus="x">
        <tr>
            <td>${x.count}</td>
            <td>${item.userName}</td>
            <td>${item.userAccountId}</td>
            <td>${item.groupId}</td>
            <td>${item.groupName}</td>
            <td>${item.status}</td>
            <td><c:if test="${item.status == 1}">
                <a href="userToGroup.do?register=${item.id}&${Consts.USERACCOUNTID}=${item.userAccountId}">
                    register </a></c:if></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

