<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope}</title>
    <script rel="script" src="js/jquery-3.3.1.js"></script>
</head>
<body>
<center>
    <h1> General Model View ${requestScope.tableIx}</h1>
</center>
<br/>
<jsp:include page="header.jsp"/>
<br/>
<br/>
<table border="true" style="text-align: center; width : 100%">
    <tr>
        <td></td>
        <td>id</td>
        <td>title</td>
        <td>headerL</td>
        <td>headerR</td>
        <td>body</td>
        <td>footerL</td>
        <td>footerR</td>
    </tr>
    <c:forEach var="item" items="${requestScope.list}" varStatus="x">
        <tr>
            <td>${x.count}</td>
            <td>${item.id}</td>
            <td>${item.title}</td>
            <td>${item.headerL}</td>
            <td>${item.headerR}</td>
            <td>${item.body}</td>
            <td>${item.footerL}</td>
            <td>${item.footerR}</td>
        </tr>
    </c:forEach>
</table>

<br/>
</body>
</html>