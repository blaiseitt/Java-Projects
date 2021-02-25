<%--
  Created by IntelliJ IDEA.
  User: Buarzej
  Date: 2020-05-25
  Time: 00:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <title><spring:message code="label.rent"/></title>
    <link href="<c:url value="/resources/css/tableStyle.css" />" rel="stylesheet">
</head>
<body>

<h3>Choosen car:</h3>
<div class="tableStyle">
    <table>
        <tr>
            <th><spring:message code="label.carBrand"/></th>
            <th><spring:message code="label.carModel"/></th>
            <th><spring:message code="label.carCost"/></th>
        </tr>
        <tr>
            <td>${carOwned.carBrand}</td>
            <td>${carOwned.carModel}</td>
            <td>${carOwned.carCostPerDay}</td>
        </tr>
    </table>
</div>
<form:form method="post" action="addOrder.html" modelAttribute="order">
    <table>
        <tr>
            <td>
                <form:hidden path="id"/>
            </td>
        </tr>
        <tr>
            <spring:message code="label.days"/>
        </tr>
        <tr>
            <td><form:input type="number" path="days"/></td>
            <form:errors path="days"/>
        </tr>
        <form:hidden readonly="true" path="appUser.id" value="${loggedUser.id}"/>
        <form:errors path="appUser.id"/>
        <form:hidden readonly="true" path="carOwned.id" value="${carOwned.id}"/>
        <form:errors path="carOwned.id"/>
        <tr>
            <td>
                <input type="submit" value="<spring:message code="label.rent"/>"/>
            </td>
        </tr>

    </table>
</form:form>
</body>
</html>
