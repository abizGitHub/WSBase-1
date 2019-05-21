<%@ page import="util.Consts" %>
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
    <h1>UserAccount</h1>
</center>
<br/>
<jsp:include page="header.jsp"/>
<br/>
<br/>
<table border="1" style="text-align: center;width : 100%">
    <tr>
        <td></td>
        <td> userName</td>
        <td> password</td>
        <td> email</td>
        <td> phone</td>
        <td> id </td>
        <td> group </td>
        <td> log </td>
    </tr>
    <c:set var="ua" value="${requestScope.list}"/>
    <c:forEach var="item" items="${ua}" varStatus="x">
        <tr>
            <td>${x.count}</td>
            <td>${item.userName}</td>
            <td>${item.password}</td>
            <td>${item.email}</td>
            <td>${item.phone}</td>
            <td>${item.id}</td>
            <td><a href="userToGroup.do?${Consts.USERACCOUNTID}=${item.id}">requested Groups</a></td>
            <td><a href="userAccountLog.do?${Consts.USERACCOUNTID}=${item.id}">user log</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
</body>
</html>

