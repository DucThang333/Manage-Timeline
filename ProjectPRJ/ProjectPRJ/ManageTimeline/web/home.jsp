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
        <link rel="stylesheet" href="CSS/styleHeader.css"/>
        <link rel="stylesheet" href="CSS/styleBase3.css">
        <link rel="stylesheet"  href="CSS/styleHome7.css">
        <link rel="stylesheet" href="CSS/styletoast.css"/>
        <link rel="stylesheet" href="CSS/styleSearch1.css"/>
        <link rel="stylesheet" href="CSS/styleBoxInfor1.css"/>
        <link rel="stylesheet" href="CSS/styleEditSkub.css">
        <script src="JS/scriptToast1.js"></script>
        <%
            // get list Items
            ArrayList<ItemsLocate> listItemsInfor = (ArrayList) session.getAttribute("listItemsLocate"); 
            // get timeline
            Timeline timeline = (Timeline) session.getAttribute("timeline");
        %> 
    </head>
    <body>
        <div id="toast"></div>
        <%@include file="header.jsp" %>
        <div class="container">
            <div class="container__content" id="scroll">
                <div class="container__timeline">
                    <%for(int i = 0;i < timeline.getSegmentNumber(); i++){%>
                    <%String date = (String)timeline.getNextDate(i);%>
                    <div class="container__timeline--distance">
                        <hr width="30%" <%if(i==0){%>style="height:0px"<%}%> 
                            class="<%=timeline.getLine()?"timeline--big":""%>">
                        <p class="container__timeline--time ">
                            <%=date%>
                        </p>
                    </div>
                    <%}%>
                </div>
                <div id="contain-content" style="display: flex">
                    <%for(ItemsLocate item : listItemsInfor){%>
                    <div>
                        <div style="margin-top: <%=item.getDistance()%>px;height:
                             <%=item.getDateNow()%>px;background-color: #9d9d9de3;margin-left: 20px;width: 140px;">
                        </div>
                        <div class="container__content--box" id="<%=item.getiD()%>"
                             style="height:<%=item.getHeigth() - item.getDateNow()%>px;
                             background-image: url('IMG/download/<%=item.getBackground()%>')
                             ;background-color: <%=item.getBackground()%>;">
                            <div class="box--content">
                                <div class="img"><img src="" alt="dont have background img"></div>
                                <div class="content">
                                    <p></p><p></p><p></p><p></p><p></p> <p></p>
                                    <div class="edit-process">
                                        edit process
                                    </div>
                                </div>
                            </div>
                            <div onclick="event.stopPropagation()" class="box__edit">
                                <div  class="box__edit--feature">
                                    <div class="edit--feature edit-add" >add
                                        <div class="input__edit--content input-edit" >
                                            <form action="createSubItems" method="post">
                                                <input name="subTitle" type="text" placeholder="enter title">
                                                <input name="subDateStart"type="date" value="${dateNow}" min="${dateNow}" placeholder="enter date start">
                                                <input name="subDateEnd"type="date" value="${dateNow}" min="${dateNow}" placeholder="enter date end">
                                                <input name="datail"type="text" placeholder="enter detail">
                                                <button class="btn">submit</button>
                                                <button class="input-edit-cancel btn" >cancel</button> 
                                            </form>
                                        </div>
                                    </div>
                                    <div class="edit--feature edit-delete" >remove
                                        <div class="input__edit--number input-edit-delete">
                                            <form>
                                                <input type="number" placeholder="enter number delete">
                                                <button class="btn">submit</button>
                                                <button class="btn input-edit-cancel-delete">cancel</button> 
                                            </form>
                                        </div>
                                    </div>
                                    <div class="edit--feature">complite</div> 
                                    <div class="edit--feature edit-feature-cancel">cancel</div> 
                                </div>
                                <div class="box__edit--content">
                                </div>
                            </div> 
                        </div>  
                    </div> 
                    <%}%>
                </div>  
            </div> 
            <ul class="container__feature">
                <li class="container__feature--item" onclick="getDisplay(this, 'form-create')">
                    Create New Item
                    <div class="container__feature--form" id="form-create">
                        <p onclick='event.stopPropagation();'>information</p>
                        <form onclick='event.stopPropagation();' action="createItemsInfor" method="post">
                            <table>
                                <tr>
                                    <td><label for="">title</title></label></td>
                                    <td><input name="createTitle"type="text"></td>
                                </tr>
                                <tr>
                                    <td><label for="">date start</label></td>
                                    <td><input name="createDateStart"type="date" value="${dateNow}" min="${dateNow}"><br></td>
                                </tr>
                                <tr>
                                    <td><label for="">date end</label></td>
                                    <td><input name="createDateEnd"type="date"  value="${dateNow}" min="${dateNow}"><br></td>
                                </tr>
                                <tr>
                                    <td><label for="">description</label></td>
                                    <td><textarea name="createDescription" ></textarea><br></td>
                                </tr>
                                <tr>
                                    <td><label for="">background</label></td>
                                    <td>
                                        <input name="bgColor" class="background--color" type="color"
                                               value="#d6ecd6"><br>
                                        <input name="bgfile"type="file" value=""style="padding: 0px;">
                                    </td>
                                </tr>
                                <tr>
                                    <td><label for="">type</label></td>
                                    <td>
                                        <select name="typeInfor">
                                            <c:forEach items="${listTypeInfor}" var="item">
                                                <option>${item.getName()}</option>
                                            </c:forEach>
                                        </select>
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
                        <form class="feature-search" action="deleteItemInfor" method="get">
                            <input name="search-delete" type="text" placeholder="search : title + date start">
                            <button class="btn">search</button>
                            <div class="autocom-box">
                                <!-- here list are inserted from javascript -->
                            </div>
                        </form>
                    </div>
                    <c:if test="${checkFindDelete}">
                        <div class="container__feature--delete" id="display-delete"> 
                            <form class="form-delete" action="deleteItemInfor" method="post">
                                <input name="IDItemdelete" style="display: none">
                                <c:forEach items="${listItemsDelete}" var="item">
                                    <div class="form" id="${item.getID()}">
                                        <p>title : ${item.getTitle()}</p>
                                        <p>date start : ${item.getDateStart()} </p>
                                        <p>date end : ${item.getDateEnd()}</p>
                                        <p>description : ${item.getDetailBrief()}</p>
                                        <p>type : ${item.getTypeInfor()}</p>
                                        <div class="btn" onclick="getHideDelete(this)">delete</div>
                                    </div> 
                                </c:forEach>
                                <button class="btn" onclick="getSubmitDelete()">done</button>
                            </form>
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
                        <form class="feature-search-update"action="updateItemsInfor" method="get">
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
                                    <div class="list-form form line" id="${item.getID()}">
                                        <p>title : ${item.getTitle()}</p>
                                        <p>date start : ${item.getDateStart()} </p>
                                        <p>date end : ${item.getDateEnd()}</p>
                                        <p>description : ${item.getDetailBrief()}</p>
                                        <p>type : ${item.getTypeInfor()}</p>
                                        <div class="btn click-list-form" onclick="getAllHideUpdate(this)">update</div>
                                        <form id="form-update-input" onclick='event.stopPropagation();' action="updateItemsInfor" method="post">
                                            <input name="IDItemUpdate" value="${item.getID()}" style="display: none;">
                                            <table>
                                                <tr>
                                                    <td><label for="">title</title></label></td>
                                                    <td><input value="${item.getTitle()}" name="titleUpdate" type="text"></td>
                                                </tr>
                                                <tr>
                                                    <td><label for="">date start</label></td>
                                                    <td><input value="${item.getDateStart()}" name="dateStartUpdate"type="date" ><br></td>
                                                </tr>
                                                <tr>
                                                    <td><label for="">date end</label></td>
                                                    <td><input value="${item.getDateEnd()}" name="dateEndUpdate"type="date"><br></td>
                                                </tr>
                                                <tr>
                                                    <td><label for="">description</label></td>
                                                    <td><textarea  name="detailUpdate" >${item.getDetailBrief()}</textarea><br></td>
                                                </tr>
                                                <tr>
                                                    <td><label for="">background</label></td>
                                                    <td>
                                                        <input name="bgColorUpdate" class="background--color" type="color"
                                                               value="#d6ecd6"><br>
                                                        <input name="bgfileUpdate"type="file" value=""style="padding: 0px;">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td><label for="">type</label></td>
                                                    <td>
                                                        <select name="typeInforUpdate">
                                                            <c:forEach items="${listTypeInfor}" var="item">
                                                                <option>${item.getName()}</option>
                                                            </c:forEach> 
                                                        </select>
                                                    </td>
                                                </tr> 
                                            </table>
                                            <button class="btn">update</button>
                                        </form>   
                                    </div> 
                                </c:forEach>  
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
                <li class="container__feature--item" onclick="getDisplay(this, 'form-addType')">
                    Add type
                    <div onclick='event.stopPropagation();'  class="container__feature--form" id="form-addType" style="width: 400px;">
                        <p>add type</p> 
                        <form action="createType" method="post">
                            <label for="">name : </label>
                            <input name="nameType"type="text"><br>
                            <label for="">detail :</label>
                            <textarea name="detailType"> </textarea><br>
                            <button>add</button> 
                        </form>
                        <button style="margin-left: 21px;" class="btn" id="cancel-delete" onclick="cancelHideAdd()">cancel</button>
                    </div> 
                </li> 
            </ul>
        </div>
        <script src="https://kit.fontawesome.com/98a6f068d5.js" crossorigin="anonymous"></script>
        <script> document.getElementById('scroll').scrollTop = ${sessionScope.scrollLoca};</script>   
        <script> let suggestions = ${sessionScope.itemsIdentity};</script> 
        <script> let arrayItem = '${sessionScope.listItems}'</script> 
        <script src="JS/scriptEditSub2.js"></script>
        <script src="JS/scriptBoxInfor2.js"></script>
        <script src="JS/scriptHome6.js"></script> 
        <script src="JS/scriptSearch.js"></script>
    </body>
</html>
