<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<table>
	<tr><td><a href="/login">login</a></td></tr>
	<tr><td><a href="/register">register</a></td></tr>
	<tr><td><a href="/userList">user list</a></td></tr>
	<tr><td>
	    <script>
            function formSubmit() {
                document.getElementById("logoutForm").submit();
            }
        </script>
	    <form action="/logout" method="post" id="logoutForm">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <a href="javascript:formSubmit()"> Logout</a>
    </td></tr>
</table>
<div>
	${username}
</div>