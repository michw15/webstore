<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <head>--%>
<%--        <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">--%>
<%--        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">--%>
<%--        <title>Produkty</title>--%>
<%--    </head>--%>
<%--<body>--%>
<%--<section>--%>
<%--    <div class="jumbotron">--%>
<%--        <div class="container">--%>
<%--            <h1>Produkty</h1>--%>
<%--            <p>Dodaj produkt</p>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>
<%--<div class="container">--%>
<%--    <div class="row">--%>
<%--        <div class="col-md-4 col-md-offset-4">--%>
<%--            <div class="panel panel-default">--%>
<%--                <div class="panel-heading">--%>
<%--                    <h3 class="panel-title">Zaloguj się</h3>--%>
<%--                </div>--%>
<%--                <div class="panel-body">--%>
<%--                    <c:if test="${not empty error}">--%>
<%--                        <div class="alert alert-danger">--%>
<%--                            <spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/><br />--%>
<%--                        </div>--%>
<%--                    </c:if>--%>
<%--                    <form action="<c:url value="/j_spring_securiy_check"></c:url>" method="post">--%>
<%--                        <fieldset>--%>
<%--                            <div class="form-group">--%>
<%--                                <input class="form-control" placeholder="Nazwa użytkownika" name='j_username' type="text">--%>
<%--                            </div>--%>
<%--                            <div class="form-group">--%>
<%--                                <input class="form-control" placeholder="Hasło" name='j_password' type="password" value="">--%>
<%--                            </div>--%>
<%--                            <input class="btn btn-lg btn-success btn-block" type="submit" value="Zaloguj się">--%>
<%--                        </fieldset>--%>
<%--                    </form>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>

<%--</div>--%>
<%--</body>--%>
<%--</html>--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body onload='document.loginForm.username.focus();'>
<h1>Spring Security 5 - Login Form</h1>

<c:if test="${not empty errorMessge}"><div style="color:red; font-weight: bold; margin: 30px 0px;">${errorMessge}</div></c:if>

<form name='login' action="/login" method='POST'>
    <table>
        <tr>
            <td>UserName:</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="submit" /></td>
        </tr>
    </table>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
</body>
</html>