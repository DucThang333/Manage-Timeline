<%-- 
    Document   : home
    Created on : Apr 15, 2022, 7:13:13 PM
    Author     : Thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="View.ModelView.ItemsLocate"%>
<%@page import="View.ModelView.Timeline"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Controller.homeServlet" %>
<!DOCTYPE html>
<html>
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="CSS/styleBase2.css">
        <link rel="stylesheet"  href="CSS/styleHome5.css">
        <link rel="stylesheet" href="CSS/styletoast.css"/>
        <link rel="stylesheet" href="CSS/styleSearch.css"/>
        <script src="JS/scriptToast.js"></script>
        <%
            // get list Items
            ArrayList<ItemsLocate> listItemsInfor = (ArrayList) session.getAttribute("listItemsLocate"); 
            // get timeline
            Timeline timeline = (Timeline) session.getAttribute("timeline");
            boolean create = (boolean) request.getAttribute("create");
        %> 
        <script>
            let suggestions = ${sessionScope.ItemsIdentity};
        </script>
    </head>
    <body>
        <div id="toast"></div>
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
                        <img class="header__account--img" onclick="getDisplay(this, 'account-setting')" src="IMG/Logo.png" alt="">
                        <ul class="header__account--setting" id="account-setting">
                            <li class="header__setting--header line">
                                <img onclick='event.stopPropagation();' class="header__setting--img" src="IMG/Logo.png" alt="">
                                <div onclick='event.stopPropagation();' class="header__setting--info">
                                    <h4>Luu Duc Thang</h4>
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
        <div class="container">
            <div class="container__content">
                <div class="container__timeline">
                    <%for(int i = 0;i < timeline.getSegmentNumber(); i++){%>

                    <%String date = (String)timeline.getNextDate(i);%>
                    <div class="container__timeline--distance">
                        <hr width="30%" <%if(i==0){%> style="height:0px"<%}%> 
                            class="<%=timeline.getLine()?"timeline--big":""%>">
                        <p class="container__timeline--time ">
                            <%=date%>
                        </p>
                    </div>
                    <%}%>
                </div>
                <div style="display: flex;width: fit-content">
                    <%for(ItemsLocate item : listItemsInfor){%>
                    <div class="container__content--box"
                         style="margin-top: <%=item.getDistance()%>px;height:
                         <%=item.getHeigth()%>px">
                    </div>
                    <%}%>
                </div> 
            </div>
            <ul class="container__feature">
                <li class="container__feature--item" onclick="getDisplay(this, 'form-create')">
                    Create New Item
                    <div class="container__feature--form" id="form-create">
                        <p onclick='event.stopPropagation();'>information</p>
                        <form onclick='event.stopPropagation();' action="createItemsInfor">
                            <table>
                                <tr>
                                    <td><label for="">title</title></label></td>
                                    <td><input name="createTitle"type="text"></td>
                                </tr>
                                <tr>
                                    <td><label for="">date start</label></td>
                                    <td><input name="createDateStart"type="date" value="2022-04-22" min="2022-04-22"><br></td>
                                </tr>
                                <tr>
                                    <td><label for="">date end</label></td>
                                    <td><input name="createDateEnd"type="date"  value="2022-04-22" min="2022-04-22"><br></td>
                                </tr>
                                <tr>
                                    <td><label for="">description</label></td>
                                    <td><textarea name="createDescription" ></textarea><br></td>
                                </tr>
                                <tr>
                                    <td>background</td>
                                    <td>
                                        <input name="bgColor" class="background--color" type="color"
                                               value="#d6ecd6"><br>
                                        <input name="bgfile"type="file" value="null"style="padding: 0px;">
                                    </td>
                                </tr>
                            </table>
                            <button class="btn">create</button>
                        </form>
                        <button class="btn">cancel</button>
                        <%if(create){%>
                        <script>
                            showSuccessToast();
                        </script>
                        <%}%>
                    </div>
                </li>
                <li class="container__feature--item">
                    Delete Item
                    <div  class="container__feature--form" id="form-delete" style="width: 400px; display: block;">
                        <p >search to delete</p>
                        <form class="feature-search" action="">
                            <input  type="text" placeholder="Type to search..">
                            <button class="btn">create</button>
                            <div class="autocom-box">
                                <!-- here list are inserted from javascript -->
                            </div>
                        </form>
                    </div>  
                </li>
                <li class="container__feature--item">Update</li>

            </ul>
        </div>
        <script src="https://kit.fontawesome.com/98a6f068d5.js" crossorigin="anonymous"></script>
        <!--        <script src="toolBase.js"></script>-->
        <script src="JS/scriptHome1.js"></script>
        <script src="JS/scriptSearch.js"></script>
    </body>
</html>
