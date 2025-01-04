<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form class="form-signin" name='loginForm' action="login" method='POST'>
                <input type="text" name='login' id="inputLogin" class="form-control" placeholder="Login" required
                       autofocus/>
                <input type="password" name='password' id="inputPassword" class="form-control" placeholder="Password"
                       required/>
                <div id="remember" class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign in</button>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
