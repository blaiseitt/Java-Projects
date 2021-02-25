<%--
  Created by IntelliJ IDEA.
  User: Buarzej
  Date: 2020-06-14
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html lang="en">
<link>
<title>Title</title>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link href="<c:url value="/resources/css/tableStyle.css" />" rel="stylesheet">
</head>
<body>

<h3 style="text-align:center"><spring:message code="label.carList"/></h3>
<div class="container">
    <table class="table table-striped">
        <!-- jeżeli tabela nie jest pusta to wyświetlić dodatkową tabele nt. użytkownika, jeżeli jest pusta to nic nie wyświetlać-->
        <tr>
            <th><spring:message code="label.carBrand"/></th>
            <th><spring:message code="label.carModel"/></th>
            <th><spring:message code="label.carCost"/></th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${carOwnedList}" var="carOwned">
            <tr>
                <td>${carOwned.carBrand} </td>
                <td>${carOwned.carModel} </td>
                <td>${carOwned.carCostPerDay}</td>
                <td>
                    <div><a class="btn btn-primary" href="order.html?carOwnedId=${carOwned.id}"><spring:message
                            code="label.order"/></a></div>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
</body>
</html>
