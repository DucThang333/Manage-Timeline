<%-- 
    Document   : home
    Created on : Apr 15, 2022, 7:13:13 PM
    Author     : Thang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="View.ModelView.ItemsLocate"%>
<%@page import="View.ModelView.Timeline"%>
<%@page import="Model.ItemsInfor" %>
<%@page import="java.util.ArrayList"%>
<%@page import="Controller.homeServlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="CSS/styleBase2.css">
        <link rel="stylesheet"  href="CSS/styleHome6.css">
        <link rel="stylesheet" href="CSS/styletoast.css"/>
        <link rel="stylesheet" href="CSS/styleSearch1.css"/>
        <script src="JS/scriptToast1.js"></script>
        <%
            // get list Items
            ArrayList<ItemsLocate> listItemsInfor = (ArrayList) session.getAttribute("listItemsLocate"); 
            ArrayList<ItemsInfor> itemsIdentity = (ArrayList) session.getAttribute("itemsIdentity"); 
            // get timeline
            Timeline timeline = (Timeline) session.getAttribute("timeline");
        %> 
        <script>
            let suggestions = ${sessionScope.itemsIdentity};
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
                                        <input name="bgfile"type="file" value=""style="padding: 0px;">
                                    </td>
                                </tr>
                            </table>
                            <button class="btn">create</button>
                        </form>
                        <button class="btn">cancel</button>
                    </div>
                    <c:if test="${doCreate}">
                        <c:if test="${checkCreate}">
                            <script>
                                showSuccessToastCreate();
                            </script>
                        </c:if>  
                        <c:if test="${!checkCreate}">
                            <script>
                                showErrorToastCreate();
                            </script>
                        </c:if>   
                    </c:if> 
                </li>
                <li class="container__feature--item" onclick="getDisplay(this, 'form-delete')" >
                    Delete Item
                    <div onclick='event.stopPropagation();'  class="container__feature--form" id="form-delete" style="width: 400px;">
                        <p>search</p>
                        <form class="feature-search" action="deleteItemInfor" method="post">
                            <input name="search-delete" type="text" placeholder="search : title + date start">
                            <button class="btn">search</button>
                            <div class="autocom-box">
                                <!-- here list are inserted from javascript -->
                            </div>
                        </form>
                    </div>
                    <c:if test="${checkFindDelete}">
                        <div class="container__feature--delete" id="display-delete"> 
                            <div class="form-delete">
                                <c:forEach items="${listItemsDelete}" var="item">
                                    <div class="form" id="${item.getID()}">
                                        <p>title : ${item.getTitle()}</p>
                                        <p>date start : ${item.getDateStart()} </p>
                                        <p>date end : ${item.getDateEnd()}</p>
                                        <p>description : ${item.getDetailBrief()}</p>
                                        <div class="btn" onclick="getHideDelete(this)">delete</div>
                                    </div> 
                                </c:forEach>
                                <a class="btn" id="submit-delete" >done</a>
                            </div>
                            <button class="btn" id="cancel-delete" onclick="cancelHideDelete()">cancel</button>
                        </div>
                    </c:if>   
                    <c:if test="${checkDelete}">
                        <script>
                            showSuccessToastDelete(${titleDe});
                        </script>
                    </c:if>    
                </li>
                <li class="container__feature--item" onclick="getDisplay(this, 'form-update')">
                    Update
                    <div onclick='event.stopPropagation();'  class="container__feature--form" id="form-update" style="width: 400px;">
                        <p >search</p>
                        <form class="feature-search-update"action="updateItemsInfor" method="post">
                            <input name="search-update"  type="text" placeholder="search : title + date start">
                            <button class="btn">search</button>
                            <div id="1"class="autocom-box" >
                                <!-- here list are inserted from javascript -->
                            </div>
                        </form>
                    </div>  
                    <c:if test="${checkFindUpdate}">
                        <div class="container__feature--delete" id="display-delete">
                            <div class="form-update">
                                <c:forEach items="${listItemsUpdate}" var="item">
                                    <div class="form line" id="${item.getID()}">
                                        <p>title : ${item.getTitle()}</p>
                                        <p>date start : ${item.getDateStart()} </p>
                                        <p>date end : ${item.getDateEnd()}</p>
                                        <p>description : ${item.getDetailBrief()}</p>
                                        <div class="btn" onclick="getAllHideUpdate(this)">update</div>
                                    </div> 
                                </c:forEach> 
                                <form id="form-update-input" onclick='event.stopPropagation();' action="updateItemsInfor">
                                    <input name="IDItemUpdate" style="display: none;">
                                    <table>
                                        <tr>
                                            <td><label for="">title</title></label></td>
                                            <td><input name="titleUpdate" type="text"></td>
                                        </tr>
                                        <tr>
                                            <td><label for="">date start</label></td>
                                            <td><input name="dateStartUpdate" type="date"><br></td>
                                        </tr>
                                        <tr>
                                            <td><label for="">date end</label></td>
                                            <td><input name="dateEndUpdate" type="date"><br></td>
                                        </tr>
                                        <tr>
                                            <td><label for="">description</label></td>
                                            <td><textarea name="detailUpdate" ></textarea><br></td>
                                        </tr>
                                        <tr>
                                            <td>background</td>
                                            <td>
                                                <input name="bgColorUpdate" class="background--color" type="color"
                                                       value="#d6ecd6"><br>
                                                 <input name="bgfileUpdate"type="file" value=""style="padding: 0px;">
                                            </td>
                                        </tr>
                                    </table>
                                    <button class="btn">update</button>
                                </form>  
                            </div>
                            <button class="btn" id="cancel-delete" onclick="cancelHideDelete()">cancel</button>
                        </div> 
                    </c:if>   
                    <c:if test="${doUpdate}">
                        <c:if test="${checkUpdate}">
                            <script>
                                showSuccessToastUpdate();
                            </script>
                        </c:if>  
                        <c:if test="${!checkUpdate}">
                            <script>
                                showErrorToastUpdate();
                            </script>
                        </c:if>   
                    </c:if>     
                </li>

            </ul>
        </div>
        <script src="https://kit.fontawesome.com/98a6f068d5.js" crossorigin="anonymous"></script>
        <!--        <script src="toolBase.js"></script>-->
        <script src="JS/scriptHome2.js"></script>
        <script src="JS/clickCreateClass.js"></script> 
        <script src="JS/scriptSearch.js"></script>

    </body>
</html>
