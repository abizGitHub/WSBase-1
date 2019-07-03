<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Message" %>
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
    <h2>message for (from) [${requestScope.get('userAccountId')} - ${requestScope.get('USERNAME')}] </h2>
</center>
<c:set var="ualog" value="${requestScope.list}"/>
<br/>
<jsp:include page="header.jsp"/>
<br/>
<c:if test="${requestScope.get('userAccountId') != null}">
    <form action="message.do" style="padding: 1%;margin: 1%;" method="post">
        <input type="hidden" value="${requestScope.get('userAccountId')}" name="${'userAccountId'}"/>
        <input type="hidden" value="${requestScope.get('USERNAME')}" name="${'USERNAME'}"/>
        <input type="hidden" value="${Message.SENT}" name="${Consts.METHOD}"/>
        <table>
            <tr>
                <td>message :</td>
                <td><textarea id="f_body" name="body" cols="100" rows="8"></textarea>
                </td>
            </tr>
        </table>
        <center><input type="submit" value="Send"></center>
    </form>
</c:if>
<table border="1" style="text-align: center;width : 100%">
    <tr>
        <td> x</td>
        <td> userAccountId</td>
        <td> id</td>
        <td> msgId</td>
        <td> body</td>
        <td> delivered</td>
        <td> type</td>
        <td> date</td>
    </tr>
    <c:forEach var="item" items="${ualog}" varStatus="x">
        <tr>
            <td>${x.count}</td>
            <td>${item.userAccountId}</td>
            <td>${item.id}</td>
            <td>${item.msgId}</td>
            <td>${item.body}</td>
            <td>${item.delivered}</td>
            <c:if test="${item.type == Message.RECEIPT}">
                <td style="background-color: yellow">
                    RECEIPT
                </td>
            </c:if>
            <c:if test="${item.type == Message.SENT}">
                <td style="background-color: cornflowerblue">
                    SENT
                </td>
            </c:if>
            <td>${item.registerDate}</td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="footer.jsp"/>
</body>
</html>

