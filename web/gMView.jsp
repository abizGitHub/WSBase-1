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
<c:set var="tag" value="${requestScope.tag}"/>
<table border="true" style="text-align: center; width : 100%">
    <tr>
        <td></td>
        <td>id (star)</td>
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
            <td ${tag.starVisible ? 'style="background-color: yellow"': ''} >${item.id}</td>
            <td ${tag.titleVisible ? 'style="background-color: yellow"': ''}>${item.title}</td>
            <td ${tag.headerLVisible ? 'style="background-color: yellow"': ''}>${item.headerL}</td>
            <td ${tag.headerRVisible ? 'style="background-color: yellow"': ''}>${item.headerR}</td>
            <td ${tag.bodyVisible ? 'style="background-color: yellow"': ''}>${item.body}</td>
            <td ${tag.footerLVisible ? 'style="background-color: yellow"': ''}>${item.footerL}</td>
            <td ${tag.footerRVisible ? 'style="background-color: yellow"': ''}>${item.footerR}</td>
        </tr>
    </c:forEach>
</table>

<br/>
</body>
</html>