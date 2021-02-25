<%--
  Created by IntelliJ IDEA.
  User: Buarzej
  Date: 2020-05-20
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html lang="en">
<head>
    <title>App user page</title>
    <!-- Captcha Google -->
    <script src="https://www.google.com/recaptcha/api.js"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link href="<c:url value="/resources/css/tableStyle.css" />" rel="stylesheet">
</head>
<body>
<h1><spring:message code="label.appUser"/></h1>

<form:form method="post" action="addAppUser.html" modelAttribute="appUser">
    <div class="container">
        <table class="table table-striped">
            <tr>
                <td>
                        <form:hidden path="id"/> <!--ukryte pole z id użytkownika-->
            </tr>
            <tr>
                <td><form:label path="login"><spring:message code="label.login"/></form:label></td>
                <td><form:input path="login"/></td>
                <td><form:errors path="login"/></td>
            </tr>
            <tr>
                <td><form:label path="password"><spring:message code="label.password"/></form:label></td>
                <td><form:input type="password" path="password"/></td>
                <!--dobrze żeby nie było to zwykle pole tekstowe-->
                <td><form:errors path="password"/></td>
            </tr>
            <sec:authorize
                    access="hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')">
                <tr>
                    <td><form:label path="enabled"><spring:message code="label.enabled"/></form:label></td>
                    <td><form:checkbox path="enabled"/></td>
                    <td><form:errors path="enabled"/></td>
                </tr>
            </sec:authorize>
            <tr>
                <td><form:label path="firstName"><spring:message code="label.firstName"/></form:label></td>
                <td><form:input path="firstName"/></td>
                <td><form:errors path="firstName"/></td>
            </tr>
            <tr>
                <td><form:label path="lastName"><spring:message code="label.lastName"/></form:label></td>
                <td><form:input path="lastName"/></td>
                <td><form:errors path="lastName"/></td>
            </tr>
            <tr>
                <td><form:label path="birthday"><spring:message code="label.birthday"/></form:label></td>
                <td><form:input path="birthday"/></td>
                <td><form:errors path="birthday"/></td>
            </tr>
            <tr>
                <td><form:label path="email"><spring:message code="label.email"/></form:label></td>
                <td><form:input path="email"/></td>
                <td><form:errors path="email"/></td>
            </tr>
            <tr>
                <td><form:label path="telephone"><spring:message code="label.telephone"/></form:label></td>
                <td><form:input path="telephone"/></td>
                <td><form:errors path="telephone"/></td>
            </tr>
            <tr>
                <td><form:label path="appUserDocuments.PESEL"><spring:message code="label.pesel"/></form:label></td>
                <td><form:input path="appUserDocuments.PESEL"/></td>
                <td><form:errors path="appUserDocuments"/></td>
            </tr>
            <tr>
                <td><form:label path="appUserDocuments.drivingLicenceNumber"><spring:message
                        code="label.licenceNumber"/></form:label></td>
                <td><form:input path="appUserDocuments.drivingLicenceNumber"/></td>
                <td><form:errors path="appUserDocuments"/></td>
            </tr>
            <sec:authorize
                    access="hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')">
                <tr>
                    <td><form:label path="appUserRole"><spring:message code="label.role"/></form:label></td>
                    <td><form:select path="appUserRole" multiple="true">
                        <form:options items="${appUserRoleList}" itemValue="id" itemLabel="role"/>
                    </form:select></td>
                    <td><form:errors path="appUserRole"/></td>
                </tr>
            </sec:authorize>

            <tr>
                <td colspan="3">
                    <div class="g-recaptcha" data-sitekey="6LcnBPAUAAAAADDi737xsUL7gSDYp6furFtbBE3y"></div>
                </td>
            </tr>
            <tr>    <!-- edytuj użytkownika jak są dane/dodaj jak nie ma danych-->
                <td colspan="2">
                    <c:if test="${appUser.id==0}">
                        <input type="submit" value="<spring:message code="label.addAppUser"/>"/>
                    </c:if>
                    <c:if test="${appUser.id!=0}">
                        <input type="submit" value="<spring:message code="label.editAppUser"/>"/>
                    </c:if>
                </td>
            </tr>
        </table>
    </div>

    <sec:authorize
            access="hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')">
        <h3><spring:message code="label.userList"/></h3>
        <c:if test="${!empty appUserList}">
            <div class="container">
                <table class="table table-striped">
                    <!-- jeżeli tabela nie jest pusta to wyświetlić dodatkową tabele nt. użytkownika, jeżeli jest pusta to nic nie wyświetlać-->
                    <tr>
                        <th><spring:message code="label.firstName"/></th>
                        <th><spring:message code="label.lastName"/></th>
                        <th><spring:message code="label.email"/></th>
                        <th><spring:message code="label.telephone"/></th>
                        <th>&nbsp;</th>
                        <th>&nbsp;</th>
                    </tr>
                    <c:forEach items="${appUserList}" var="appUser">
                        <tr>
                            <td>${appUser.firstName} </td>
                            <td>${appUser.lastName} </td>
                            <td>${appUser.email}</td>
                            <td>${appUser.telephone}</td>
                            <td><a href="delete/${appUser.id}.html">delete</a></td>
                            <td><a href="appUsers.html?appUserId=${appUser.id}">edit</a></td>
                            <td><a href="ordersOfUser/${appUser.id}.html">Show user orders</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </c:if>
    </sec:authorize>
</form:form>
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
