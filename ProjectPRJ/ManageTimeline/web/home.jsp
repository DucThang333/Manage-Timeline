<%-- 
    Document   : home
    Created on : Apr 15, 2022, 7:13:13 PM
    Author     : Thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="CSS/styleBase.css">
        <link rel="stylesheet" href="CSS/styleHome.css">
    </head>
    <body>
        <nav class="header">
            <div class="header__brand">
                <img class="header__brand--img" src="IMG/Logo.png" alt="Logo">
                <H1 class="header__brand--text">TimeLine</H1>
            </div>
            <div class="header__feature">
                <div class="header__transfer">
                    <div class="header__transfer--link">
                        <a href="" class="header__feature--link">Home</a>
                    </div>
                    <div class="header__transfer--link">
                        <a href="" class="header__feature--link">Graph</a>
                    </div>
                </div>
                <form action="" class="header__search">
                    <input type="search" class="header__search--input" placeholder="Search">
                    <button class="header__search--btn btn" type="submit">Search</button>
                </form>
                <div class="header__log">
                    <div class="header__out">
                        <a href="" class="header__out--link header__feature--link">Log Out</a>
                    </div>
                    <div class="header__Account">
                        <img class="header__Account--img" src="IMG/Logo.png" alt="">
                    </div>
                </div>
            </div>
        </nav>
    </body>
</html>
