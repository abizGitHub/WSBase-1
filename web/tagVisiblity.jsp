<%@ page import="oracle.jdbc.driver.Const" %>
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
    <script rel="script" src="js/jquery-3.3.1.js"></script>
</head>
<body>
<center>
    <h1>TagVisiblity</h1>
</center>
<br/>
<jsp:include page="header.jsp"/>
<br/>
<c:set var="ua" value="${requestScope.list}"/>
<br/>
<c:forEach var="item" items="${ua}" varStatus="x">
    <form action="tagVisiblity.do?" id="form_${item.tableId}" method="get">
        <input name="actionMethod" type="hidden" value="update"/>
        <input name="tableId" type="hidden" value="${item.tableId}"/>
        <input name="id" type="hidden" value="${item.id}"/>

        <table border="true" style="text-align: center">
            <tr>
                <td>tableId : ${item.tableId}</td>
            </tr>
            <tr>
                <td ${item.titleVisible ? 'style="background-color: yellow"': ''}>
                    titleVisible
                    <select value='${item.titleVisible}' name="titleVisible">
                        <option value='true'>11111111</option>
                        <option value='false'>_________</option>
                    </select>
                </td>
                <td ${item.titleString ? 'style="background-color: yellow"': ''}>
                    titleString
                    <select value='${item.titleString}' name="titleString">
                        <option value="true">ABCDEF</option>
                        <option value="false">____________</option>
                    </select>
                </td>
                <td ${item.starVisible ? 'style="background-color: yellow"': ''}>
                    starVisible
                    <select value='${item.starVisible}' name="starVisible">
                        <option value="true">11111111111</option>
                        <option value="false">__________</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td ${item.headerRVisible ? 'style="background-color: yellow"': ''}>
                    headerRVisible
                    <select value='${item.headerRVisible}' name="headerRVisible">
                        <option value="true">11111111</option>
                        <option value="false">__________</option>
                    </select>
                </td>
                <td ${item.headerRString ? 'style="background-color: yellow"': ''}>
                    headerRString
                    <select value='${item.headerRString}' name="headerRString">
                        <option value="true">ABCDEF</option>
                        <option value="false">____________</option>
                    </select>
                </td>
                <td ${item.headerLVisible ? 'style="background-color: yellow"': ''}>
                    headerLVisible
                    <select value='${item.headerLVisible}' name="headerLVisible">
                        <option value="true">11111111</option>
                        <option value="false">__________</option>
                    </select>
                </td>
                <td ${item.headerLString ? 'style="background-color: yellow"': ''}>
                    headerLString
                    <select value='${item.headerLString}' name="headerLString">
                        <option value="true">ABCDEF</option>
                        <option value="false">____________</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td ${item.bodyVisible ? 'style="background-color: yellow"': ''}>
                    bodyVisible
                    <select value='${item.bodyVisible}' name="bodyVisible">
                        <option value="true">11111111</option>
                        <option value="false">__________</option>
                    </select>
                </td>
                <td ${item.bodyString ? 'style="background-color: yellow"': ''}>
                    bodyString
                    <select value='${item.bodyString}' name="bodyString">
                        <option value="true">ABCDEF</option>
                        <option value="false">____________</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td ${item.footerRVisible ? 'style="background-color: yellow"': ''}>
                    footerRVisible
                    <select value='${item.footerRVisible}' name="footerRVisible">
                        <option value="true">11111111</option>
                        <option value="false">__________</option>
                    </select>
                </td>
                <td ${item.footerRString ? 'style="background-color: yellow"': ''}>
                    footerRString
                    <select value='${item.footerRString}' name="footerRString">
                        <option value="true">ABCDEF</option>
                        <option value="false">____________</option>
                    </select>
                </td>
                <td ${item.footerLVisible ? 'style="background-color: yellow"': ''}>
                    footerLVisible
                    <select value='${item.footerLVisible}' name="footerLVisible">
                        <option value="true">11111111</option>
                        <option value="false">__________</option>
                    </select>
                </td>
                <td ${item.footerLString ? 'style="background-color: yellow"': ''}>
                    footerLString
                    <select value='${item.footerLString}' name="footerLString">
                        <option value="true">ABCDEF</option>
                        <option value="false">____________</option>
                    </select>
                </td>
            </tr>
        </table>
        <br/>
            <input type="submit"/>
    </form>
    <br/>
</c:forEach>
</body>
<script>
    $(document).ready(
        $("select").each(function () {
            var dd = $(this);
            $(this).find('option').each(function (i, opt) {
                //alert(i + '-' + opt.value +"-"+ dd.attr("value"));
                if(dd.attr("value") == opt.value){
                    $(opt).attr('selected','selected');
                }
            })
        })
    );
</script>
</html>

