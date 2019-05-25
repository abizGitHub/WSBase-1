<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope}</title>
</head>
<body>
<center>
    <h2>portal</h2>
</center>
<br/>
<jsp:include page="header.jsp"/>
<c:set var="pc" value="${requestScope.portalConfiq}"/>
<br/>
<br/>
<form action="portal.do">
    <input type="hidden" name="update" value="${pc.id}"/>
    <table border="1" style="text-align: center;height: 10%;width: 100%">
        <tr>
            <td>updateGroup</td>
            <td>haveNewChange</td>
            <td>sendDetail</td>
            <td>clearDB</td>
            <td>connectPeriod</td>
            <td>wait4Server</td>
            <td>lastModelMapId</td>
        </tr>
        <tr></tr>
        <tr>
            <td ${pc.updateGroup ? 'style="background-color: yellow"': ''}>
                <select value='${pc.updateGroup}' name="updateGroup">
                    <option value="true">true</option>
                    <option value="false">false</option>
                </select>
            </td>
            <td ${pc.haveNewChange ? 'style="background-color: yellow"': ''}>
                <select value='${pc.haveNewChange}' name="haveNewChange">
                    <option value="true">true</option>
                    <option value="false">false</option>
                </select>
            </td>
            <td ${pc.sendDetail ? 'style="background-color: yellow"': ''}>
                <select value='${pc.sendDetail}' name="sendDetail">
                    <option value="true">true</option>
                    <option value="false">false</option>
                </select>
            </td>
            <td ${pc.clearDB ? 'style="background-color: yellow"': ''}>
                <select value='${pc.clearDB}' name="clearDB">
                    <option value="true">true</option>
                    <option value="false">false</option>
                </select>
            </td>
            <td>
                <select value='${pc.connectPeriod}' name="connectPeriod">
                    <option value="1000">1 sec</option>
                    <option value="5000">5 sec</option>
                    <option value="10000">10 sec</option>
                    <option value="20000">20 sec</option>
                    <option value="30000">30 sec</option>
                    <option value="60000">60 sec</option>
                    <option value="600000">10 min</option>
                    <option value="1800000">30 min</option>
                </select>
            </td>
            <td>
                <select value='${pc.wait4Server}' name="wait4Server">
                    <option value="1000">1 sec</option>
                    <option value="5000">5 sec</option>
                    <option value="10000">10 sec</option>
                    <option value="20000">20 sec</option>
                    <option value="30000">30 sec</option>
                </select>
            </td>
            <td>${pc.lastModelMapId}</td>
        </tr>
    </table>
    <br/>
    <br/>
    <table border="1" style="text-align: center;height: 10%;width: 100%">
        <tr>
            <td>lastGMId1</td>
            <td>lastGMId2</td>
            <td>lastGMId3</td>
            <td>lastGMId4</td>
            <td>lastGMId5</td>
            <td>lastGMId6</td>
        </tr>
        <tr></tr>
        <tr>
            <td>${pc.lastGMId1}</td>
            <td>${pc.lastGMId2}</td>
            <td>${pc.lastGMId3}</td>
            <td>${pc.lastGMId4}</td>
            <td>${pc.lastGMId5}</td>
            <td>${pc.lastGMId6}</td>
        </tr>
    </table>
    <br/>
    <br/>
    <table border="1" style="text-align: center;height: 10%;width: 100%">
        <tr>
            <td>lastGroupId1</td>
            <td>lastGroupId2</td>
            <td>lastGroupId3</td>
            <td>lastGroupId4</td>
            <td>lastGroupId5</td>
            <td>lastGroupId6</td>
        </tr>
        <tr></tr>
        <tr>
            <td>${pc.lastGroupId1}</td>
            <td>${pc.lastGroupId2}</td>
            <td>${pc.lastGroupId3}</td>
            <td>${pc.lastGroupId4}</td>
            <td>${pc.lastGroupId5}</td>
            <td>${pc.lastGroupId6}</td>
        </tr>
    </table>
    <br/>
    <br/>
    <table border="1" style="text-align: center;height: 10%;width: 100%">
        <tr>
            <td> tableName1</td>
            <td> tableName2</td>
            <td> tableName3</td>
            <td> tableName4</td>
            <td> tableName5</td>
            <td> tableName6</td>
        </tr>
        <tr></tr>
        <tr>
            <td><input name="tableName1" value="${pc.tableName1}"/></td>
            <td><input name="tableName2" value="${pc.tableName2}"/></td>
            <td><input name="tableName3" value="${pc.tableName3}"/></td>
            <td><input name="tableName4" value="${pc.tableName4}"/></td>
            <td><input name="tableName5" value="${pc.tableName5}"/></td>
            <td><input name="tableName6" value="${pc.tableName6}"/></td>
        </tr>
    </table>
    <br/>
    <br/>
    <input type="submit" value="update"/>
</form>
<br/>
<jsp:include page="footer.jsp"/>
</body>
</html>

