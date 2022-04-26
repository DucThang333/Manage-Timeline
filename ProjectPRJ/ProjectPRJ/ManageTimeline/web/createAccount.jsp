<%-- 
    Document   : createAccount
    Created on : Apr 26, 2022, 3:26:05 PM
    Author     : Thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="CSS/styleLogin1.css"/>
        <link rel="stylesheet" href="CSS/styleBase3.css">
        <link rel="stylesheet" href="CSS/styleCreateAccount.css"/>
    </head>
    <body>
        <div class="login">
            <div class="login__container">
                <form action="createAccount" class="login__form--login" method="post">
                    <p class="text text--login">Your name</p>
                    <input type="text" class="input login__form--input" name="name">  
                    <p class="text text--login">Username</p>
                    <input type="text" class="input login__form--input" name="username">
                    <p class="text text--login">Password</p>
                    <input type="password" class="input login__form--input" name="password">
                    <p class="text text--login">phoneNumber</p>
                    <input type="text" class="input login__form--input" name="phoneNumber">
                    <p class="text text--login">your avatar</p>
                    <input type="file" class="input login__form--input" name="avatar"> <br> 
                    <p class="login__error">${messSignUp}</p>
                    <button class="btn login__form--btn">Sign</button>
                    <div class="login__create">
                        <a href="login" class="login__create--link">Cancel</a>
                    </div> 
                </form>
            </div>
        </div> 
    </body>
</html>
