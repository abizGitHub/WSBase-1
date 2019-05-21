<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.GeneralModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope}</title>
    <script rel="script" src="js/jquery-3.3.1.js"></script>
</head>
<body>
<center>
    <h1>ModelMap</h1>
</center>
<br/>
<jsp:include page="header.jsp"/>
<br/>
<c:set var="ua" value="${requestScope.list}"/>
<br/>
<table border="true" style="text-align: center;width : 100%">
    <tr>
        <td></td>
        <td>tableId</td>
        <td>columnIx</td>
        <td>intValue</td>
        <td>stringValue</td>
        <td>idDelete</td>
    </tr>
    <c:forEach var="item" items="${ua}" varStatus="x">
        <tr>
            <td>${x.count}</td>
            <td>${item.tableId}</td>
            <td>${item.columnIx} - ${GeneralModel.columnMap.get(item.columnIx)}</td>
            <td>${item.intValue}</td>
            <td>${item.stringValue}</td>
            <td>${item.idDelete}</td>
        </tr>
    </c:forEach>
</table>

<br/>
</body>
</html>

