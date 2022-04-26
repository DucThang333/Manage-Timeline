<%-- 
    Document   : header
    Created on : Apr 26, 2022, 8:14:37 PM
    Author     : Thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                        <a href="home" class="header__feature--link">Home</a>
                    </div>
                    <div class="header__transfer--link">
                        <a href="diagram" class="header__feature--link">Diagram</a>
                    </div>
                </div>
                <form action="" class="header__search">
                    <input type="search" class="header__search--input" placeholder="Search">
                    <button class="header__search--btn btn" type="submit">Search</button>
                </form>
                <div class="header__log">
                    <div class="header__notifi">
                        <i class="fa-regular fa-bell" style="color: white;font-size: 1.6rem;"></i>
                    </div>
                    <div class="header__account">
                        <img class="header__account--img" onclick="getDisplay(this, 'account-setting')" src="IMG/Logo.png" alt="">
                        <ul class="header__account--setting" id="account-setting">
                            <li class="header__setting--header line">
                                <img onclick='event.stopPropagation();' class="header__setting--img" src="IMG/Logo.png" alt="">
                                <div onclick='event.stopPropagation();' class="header__setting--info">
                                    <h4>${accountInfor.getName()}</h4>
                                    <h5>Thoi gian hoat dong : 90 ngay</h5>
                                </div>
                            </li>
                            <li onclick='event.stopPropagation();' class="header__account--propoties ">
                                <a href="login">Sign out</a>
                            </li>
                            <li onclick='event.stopPropagation();' class="header__account--propoties line">Switch account</li>
                            <li onclick='event.stopPropagation();'  class="header__account--propoties ">Language</li>
                            <li onclick='event.stopPropagation();' class="header__account--propoties ">Appearance</li>
                            <li onclick='event.stopPropagation();' class="header__account--propoties ">Setting</li>
                            <li onclick='event.stopPropagation();' class="header__account--propoties line">Reset Data</li>
                            <li onclick='event.stopPropagation();' class="header__account--propoties ">Contact</li>
                            <li onclick='event.stopPropagation();' class="header__account--propoties ">Help</li>
                            <li onclick='event.stopPropagation();' class="header__account--propoties ">Send feedback</li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
    </body>
</html>
