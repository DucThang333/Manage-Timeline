<%-- 
    Document   : login
    Created on : Apr 15, 2022, 2:52:57 PM
    Author     : Thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
        <link rel="stylesheet" href="CSS/styleBase.css">
        <link rel="stylesheet" href="CSS/styleLogin.css">
    </head>
    <body>
        <div class="login">
            <div class="login__container">
                <form action="login" class="login__form--login">
                    <p class="text text--login">Username</p>
                    <input type="text" class="input login__form--input" name="username">
                    <p class="text text--login">Password</p>
                    <input type="password" class="input login__form--input" name="password">
                    <div class="login__form--forget">
                        <a href="" class="login__form--link">Forgot password</a>
                    </div>
                    <div class="login__form--change">
                        <a href="" class="login__form--link">Change Password</a>
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
