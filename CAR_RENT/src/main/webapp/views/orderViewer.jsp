<%--
  Created by IntelliJ IDEA.
  User: Buarzej
  Date: 2020-06-15
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Order view</title>
    <link href="<c:url value="/resources/css/tableStyle.css" />" rel="stylesheet">
</head>
<body>
<h3>Order list:</h3>
<c:if test="${!empty orderList}">
    <div class="tableStyle">
        <table>
            <tr>
                <th>ID</th>
                <th><spring:message code="label.days"/></th>
                <th><spring:message code="label.carCost"/></th>
                <th>Total order cost</th>
                <th><spring:message code="label.firstName"/></th>
                <th><spring:message code="label.lastName"/></th>
                <th><spring:message code="label.carBrand"/></th>
                <th><spring:message code="label.carModel"/></th>
                <th>Generate PDF for order</th>
                <th>Delete order</th>
            </tr>
            <c:if test="${loggedUser.appUserRole==ROLE_ADMIN || loggedUser.appUserRole==ROLE_MANAGER}">
                <c:forEach items="${orderList}" var="singleOrder">
                    <tr>
                        <td>${singleOrder.id} </td>
                        <td>${singleOrder.days} </td>
                        <td>${singleOrder.carOwned.carCostPerDay} </td>
                        <td>${singleOrder.days * singleOrder.carOwned.carCostPerDay}</td>
                        <td>${singleOrder.appUser.firstName} </td>
                        <td>${singleOrder.appUser.lastName} </td>
                        <td>${singleOrder.carOwned.carBrand}</td>
                        <td>${singleOrder.carOwned.carModel}</td>
                        <td><a href="generatePdf-${singleOrder.id}">pdf</a></td>
                        <td><a href="deleteOrder/${singleOrder.id}.html">delete</a></td>
                    </tr>
                </c:forEach>
            </c:if>

            <c:if test="${loggedUser.appUserRole!=ROLE_ADMIN && loggedUser.appUserRole!=ROLE_MANAGER}">
                <c:forEach items="${orderList}" var="singleOrder">
                    <tr>
                        <c:if test="${loggedUser.login==singleOrder.appUser.login}">
                            <td>${singleOrder.id} </td>
                            <td>${singleOrder.days} </td>
                            <td>${singleOrder.carOwned.carCostPerDay} </td>
                            <td>${singleOrder.days * singleOrder.carOwned.carCostPerDay}</td>
                            <td>${singleOrder.appUser.firstName} </td>
                            <td>${singleOrder.appUser.lastName} </td>
                            <td>${singleOrder.carOwned.carBrand}</td>
                            <td>${singleOrder.carOwned.carModel}</td>
                            <td><a href="generatePdf-${singleOrder.id}">pdf</a></td>
                            <td><a href="deleteOrder/${singleOrder.id}.html">delete</a></td>
                        </c:if>
                    </tr>
                </c:forEach>
            </c:if>

        </table>
    </div>
</c:if>
</body>
</html>
<%--<c:if test="${loggedUser.login==singleOrder.appUser.login}">
</c:if>--%>
