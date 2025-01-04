<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<form:form method="post" action="registerUser"  modelAttribute="user">
    <div class="container">
        <table class="table table-striped">
            <tr>
                <td>
                        <form:hidden path="id"/>
            </tr>
            <tr>
                <td><form:label path="login">login</form:label></td>
                <td><form:input path="login"/></td>
                <td><form:errors path="login"/></td>
            </tr>
            <tr>
                <td><form:label path="password">password</form:label></td>
                <td><form:input type="password" path="password"/></td>
                <td><form:errors path="password"/></td>
            </tr>
            <tr>
                <td><form:label path="email">email</form:label></td>
                <td><form:input path="email"/></td>
                <td><form:errors path="email"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="submit"/></td>
            </tr>
        </table>
    </div>
</form:form>