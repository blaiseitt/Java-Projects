<%--
  Created by IntelliJ IDEA.
  User: Buarzej
  Date: 2020-05-20
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value="/resources/css/header.css" />" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
</script>


<div class="header">
    <h3><spring:message code="label.titleRent"/></h3>
    <span style="float: right">
    	<a style="background-color: white" href="?lang=pl">pl</a> | <a style="background-color: white" href="?lang=en">en</a> | <a
            style="background-color: white" href="?lang=es">es</a>
	</span>
    <br>

    <form id="langForm" action="" method="get">
	<span style="float: right">
		<select size="1" name="lang" onchange="form.submit()">
	        <option value="pl">PL</option>
	        <option value="en">EN</option>
	        <option value="es">ES</option>
        </select>
	</span>
    </form>
</div>
