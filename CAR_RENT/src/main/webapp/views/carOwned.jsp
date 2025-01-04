<%--
  Created by IntelliJ IDEA.
  User: Buarzej
  Date: 2020-05-27
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cars manager</title>
</head>
<body>
<h1><spring:message code="label.car"/></h1>

<form:form method="post" action="addCarOwned.html" modelAttribute="carOwned">
    <table>
        <tr>
            <td>
                    <form:hidden path="id"/>
        </tr>
        <tr>
            <td><form:label path="carBrand"><spring:message code="label.carBrand"/></form:label></td>
            <td><form:input path="carBrand"/></td>
            <td><form:errors path="carBrand"/></td>
        </tr>
        <tr>
            <td><form:label path="carModel"><spring:message code="label.carModel"/></form:label></td>
            <td><form:input path="carModel"/></td>
            <td><form:errors path="carModel"/></td>
        </tr>
        <tr>
            <td><form:label path="avaliable"><spring:message code="label.avaliability"/></form:label></td>
            <td><form:checkbox path="avaliable"/></td>
            <td><form:errors path="avaliable"/></td>
        </tr>
        <tr>
            <td><form:label path="carCostPerDay"><spring:message code="label.carCost"/></form:label></td>
            <td><form:input path="carCostPerDay"/></td>
            <td><form:errors path="carCostPerDay"/></td>
        </tr>

        <tr>
            <td colspan="2">
                <c:if test="${carOwned.id==0}">
                    <input type="submit" value="<spring:message code="label.addCar"/>"/>
                </c:if>
                <c:if test="${carOwned.id!=0}">
                    <input type="submit" value="<spring:message code="label.editCar"/>"/>
                </c:if>
            </td>
        </tr>
    </table>

    <h3><spring:message code="label.carList"/></h3>
    <c:if test="${!empty carOwnedList}">
        <table class="data">
            <!-- jeżeli tabela nie jest pusta to wyświetlić dodatkową tabele nt. użytkownika, jeżeli jest pusta to nic nie wyświetlać-->
            <tr>
                <th><spring:message code="label.carBrand"/></th>
                <th><spring:message code="label.carModel"/></th>
                <th><spring:message code="label.carCost"/></th>
                <th>&nbsp;</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach items="${carOwnedList}" var="carOwned">
                <tr>
                    <td>${carOwned.carBrand} </td>
                    <td>${carOwned.carModel} </td>
                    <td>${carOwned.carCostPerDay}</td>
                    <td><a href="/deleteCarOwned/${carOwned.id}.html">delete</a></td>
                    <td><a href="/carsOwned.html?carOwnedId=${carOwned.id}">edit</a></td>
                    <td><a href="/ordersOfCar/${carOwned.id}.html">Show related orders</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</form:form>

</body>
</html>
