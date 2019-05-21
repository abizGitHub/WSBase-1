<%--
  Created by IntelliJ IDEA.
  User: abiz
  Date: 4/16/2019
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>base</title>
</head>
<body>
<p style="background-color: yellow">
    This is base
</p>
<br/>
<br/>
<br/>
<center>
    <h1>HOME
    </h1>
</center>
<br/>
<jsp:include page="header.jsp"/>
<br/>
<fieldset style="border-color: yellow">
    <table style="width: 90%">
        <tr>
            <td>table</td>
            <td>column-1</td>
            <td>column-2</td>
            <td>column-3</td>
            <td>column-4</td>
            <td>column-5</td>
            <td>column-6</td>
            <td>column-7</td>
            <td>column-8</td>
        </tr>
        <tr></tr>
        <tr></tr>
        <tr>
            <td><input type="text" value="auction"></td>
            <td><input type="text" value="buTitle"></td>
            <td><input type="text" value="eDate"></td>
            <td><input type="text" value="description"></td>
            <td><input type="text" value="client"></td>
        </tr>
        <tr></tr>
        <tr>
            <td><input type="text" value="auctionView"></td>
            <td><input type="text" value="buTitle"></td>
            <td><input type="text" value="eDate"></td>
            <td><input type="text" value="description"></td>
            <td><input type="text" value="client"></td>
            <td><input type="text" value="city"></td>
            <td><input type="text" value="province"></td>
            <td><input type="text" value="cityId"></td>
            <td><input type="text" value="provinceId"></td>
        </tr>
        <tr></tr>
        <tr>
            <td><input type="text" value="clientView"></td>
            <td><input type="text" value="name"></td>
            <td><input type="text" value="city"></td>
            <td><input type="text" value="province"></td>
        </tr>
        <tr></tr>
        <tr>
            <td><input type="text" value="client"></td>
            <td><input type="text" value="name"></td>
            <td><input type="text" value="city"></td>
        </tr>
        <tr></tr>
        <tr>
            <td><input type="text" value="businessT"></td>
            <td><input type="text" value="title"></td>
        </tr>
        <tr></tr>
        <tr>
            <td><input type="text" value="province"></td>
            <td><input type="text" value="code"></td>
            <td><input type="text" value="name"></td>
        </tr>
        <tr>
            <td><input type="text" value="city"></td>
            <td><input type="text" value="code"></td>
            <td><input type="text" value="name"></td>
        </tr>
    </table>
</fieldset>
</body>

</html>
