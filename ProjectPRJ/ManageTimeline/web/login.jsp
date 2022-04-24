<%-- 
    Document   : login
    Created on : Apr 15, 2022, 2:52:57 PM
    Author     : Thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Controller.loginServlet" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
        <link rel="stylesheet" href="CSS/styleBase2.css">
        <link rel="stylesheet" href="CSS/styleLogin1.css">
        <%
            Cookie[] cookie = request.getCookies();
            if(loginServlet.getCookie(cookie,"username") != null){
                response.sendRedirect("home");
            }
        %>
    </head>   
    <body>
        <div class="login">
            <div class="login__container">
                <form action="login" class="login__form--login" method="post">
                    <p class="text text--login">Username</p>
                    <input type="text" class="input login__form--input" name="username" value=${name}>
                    <p class="text text--login">Password</p>
                    <input type="password" class="input login__form--input" name="password"><br>
                    <input type="checkbox" name="remember" value="remember"
                           style="margin-top: 5px;" checked="checked">Remember account
                    <div class="login__form--forget">
                        <a href="" class="login__form--link">Forgot password</a>
                    </div>
                    <p class="login__error">${errorLogin}</p>
                    <button class="btn login__form--btn">Login</button>
                </form>
                <div class="login__create">
                    <a href="" class="login__create--link">Create New Account</a>
                </div>
            </div>
        </div>
        <div class="contact"></div>
    </body>
</html>
