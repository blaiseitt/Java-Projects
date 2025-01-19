<%--
  Created by IntelliJ IDEA.
  User: Buarzej
  Date: 2020-05-20
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:insertAttribute name="title" ignore="true"/></title> <!-- tytuł - taka sama nazwa jak w tiles.xml-->
</head>
<body>
<table border="1" cellpadding="2" cellspacing="2" align="center">
    <tr>
        <td height="80" colspan="2"><tiles:insertAttribute name="header"/> <!-- jedna kolumna w wierszu 1-->
        </td>
    </tr>
    <tr>
        <td height="900"><tiles:insertAttribute name="menu"/></td>
        <td width="1500"><tiles:insertAttribute name="body"/></td>
    </tr>
    <tr>
        <td height="30" colspan="2"><tiles:insertAttribute name="footer"/></td>
    </tr>
</table>
</body>
</html>
