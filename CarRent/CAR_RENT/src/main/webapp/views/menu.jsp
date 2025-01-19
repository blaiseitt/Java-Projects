<%--
  Created by IntelliJ IDEA.
  User: Buarzej
  Date: 2020-05-20
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<p><spring:message code="label.menu"/></p>

<sec:authorize access="isAnonymous()">  <%-- link logowania dostępny wtedy gdy nikt nie jest zalogowany--%>
    <a href="/login.html"><spring:message code="label.login"/></a>
    <br/>
    <a href="/appUsers.html"><spring:message code="label.register"/></a>
    <br/>
</sec:authorize>

<sec:authorize
        access="hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')">  <%-- wyświetlanie adminowi i menedżerowi linku do strony dodawania użytkownikow--%>
    <a href="/appUsers.html"><spring:message code="label.title"/></a>
    <br/>
    <a href="/carsOwned.html"><spring:message code="label.title2"/></a>
    <br/>
</sec:authorize>
<sec:authorize
        access="hasRole('ROLE_ADMIN')">  <%-- wyświetlanie adminowi linku do strony dodawania ról--%>
    <a href="/appUserRole.html"><spring:message code="label.role"/></a>
    <br/>
</sec:authorize>
<%-- nie jest to wystarczjące zabezpieczenie bo użytkownik wciąż może wpisać adres ręcznie >> filtry wciąż potrzebne--%>
<%-- ie trzeba przygotowywać wielu widoków, wystarczy jedynie zmienić to kto co widzi--%>

<a href="/products.html"><spring:message code="label.products"/></a>
<br/>
<sec:authorize
        access="hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER') or hasRole('ROLE_USER')">
    <a href="/orderViewer.html">Order list</a>
</sec:authorize>
<a href="/pagedUsers.html">Paged users</a>
<br/>
<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>

<!-- csrf for log out-->
<form action="/logout" method="post" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

<br/>
<div>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <p>
            <spring:message code="label.welcome"/> : ${pageContext.request.userPrincipal.name} |
            <a href="javascript:formSubmit()"> Logout</a>
        </p>
    </c:if>
</div>
