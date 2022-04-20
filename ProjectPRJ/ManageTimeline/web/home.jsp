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
                    <div class="header__notifi">
                        <i class="fa-regular fa-bell" style="color: white;font-size: 1.6rem;"></i>
                    </div>
                    <div class="header__account">
                        <img class="header__account--img"  id="account-img" src="IMG/Logo.png" alt="">
                        <ul class="header__account--setting " id="account-setting">
                            <li class="header__setting--header line">
                                <img class="header__setting--img" src="IMG/Logo.png" alt="">
                                <div class="header__setting--info">
                                    <h4>Luu Duc Thang</h4>
                                    <h5>Thoi gian hoat dong : 90 ngay</h5>
                                </div>
                            </li>
                            <li class="header__account--propoties ">Sign out <i class="fal fa-bell-exclamation"></i></li>
                            <li class="header__account--propoties line">Switch account</li>
                            <li class="header__account--propoties ">Language</li>
                            <li class="header__account--propoties ">Appearance</li>
                            <li class="header__account--propoties ">Setting</li>
                            <li class="header__account--propoties line">Reset Data</li>
                            <li class="header__account--propoties ">Contact</li>
                            <li class="header__account--propoties ">Help</li>
                            <li class="header__account--propoties ">Send feedback</li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="container__content">
                <div class="container__timeline">
                    <div class="container__timeline--line timeline--begin">
                        <p class="container__timeline--time">12/2021</p>
                    </div>
                    <div class="container__timeline--line">
                        <p class="container__timeline--time">1/2022</p>
                    </div>
                    <div class="container__timeline--line">
                        <p class="container__timeline--time">2/2022</p>
                    </div>
                    <div class="container__timeline--line">
                        <p class="container__timeline--time">3/2022</p>
                    </div>
                    <div class="container__timeline--line">
                        <p class="container__timeline--time">4/2022</p>
                    </div>
                    <div class="container__timeline--line">
                        <p class="container__timeline--time">5/2022</p>
                    </div>
                    <div class="container__timeline--line">
                        <p class="container__timeline--time">6/2022</p>
                    </div>
                    <div class="container__timeline--line">
                        <p class="container__timeline--time">7/2022</p>
                    </div>
                    <div class="container__timeline--line">
                        <p class="container__timeline--time">8/2022</p>
                    </div>
                    <div class="container__timeline--line">
                        <p class="container__timeline--time">9/2022</p>
                    </div>
                    <div class="container__timeline--line">
                        <p class="container__timeline--time">10/2022</p>
                    </div>
                    <div class="container__timeline--line">
                        <p class="container__timeline--time">11/2022</p>
                    </div>
                    <div class="container__timeline--line">
                        <p class="container__timeline--time">12/2022</p>
                    </div>
                    <div class="container__timeline--line timeline--big">
                        <p class="container__timeline--time">1/2023</p>
                    </div>
                </div>
                <%for(int i = 0 ; i  <5 ; i++){%>
                    <div class="container__content--box"
                         style="">
                    </div>
                <%}%>
                
            </div>
            <div class="container__feature">
                <div class="container__feature--create">Create New</div>
                <div class="container__feature--create">Create New</div>
                <div class="container__feature--create">Create New</div>
                <div class="container__feature--create">Create New</div>
                <div class="container__feature--create">Create New</div>
                <div class="container__feature--create">Create New</div>
                <div class="container__feature--create">Create New</div>
            </div>
        </div>
        <script src="https://kit.fontawesome.com/98a6f068d5.js" crossorigin="anonymous"></script>
<!--        <script src="toolBase.js"></script>-->
<script src="JS/scriptHome.js"></script>
    </body>
</html>
