<%-- 
    Document   : diagram
    Created on : Apr 26, 2022, 8:19:25 PM
    Author     : Thang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://cdn.jsdelivr.net/npm/chart.js@3.7.1/dist/chart.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script> 
        <link rel="stylesheet" href="CSS/styleHeader.css"/>
        <link rel="stylesheet" href="CSS/styleBase3.css"/> 
        <style>
            body{
                background-color: black;
            }
            .chart{
                background-color: #1a1a1b;
                margin-top: 30px;
                width: 1300px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <%@include file="header.jsp" %>
            <div class="chart">
                <canvas id="line-chart" width="300" height="150"></canvas>
            </div>
        </div>
        <script>
            new Chart(document.getElementById("line-chart"), {
                type: 'line',
                data: {
                    labels: [1500, 1600, 1700, 1750, 1800, 1850, 1900, 1950, 1999, 2050],
                    datasets: [{
                            data: [86, 114, 106, 106, 107, 111, 133],
                            label: "travel",
                            borderColor: "#3e95cd",
                            fill: false
                        }, {
                            data: [282, 350, 411, 502, 635, 809, 947, 1402, 3700, 5267],
                            label: "learning",
                            borderColor: "#8e5ea2",
                            fill: false
                        }, {
                            data: [168, 170, 178, 190, 203, 276, 408, 547, 675, 734],
                            label: "game",
                            borderColor: "#3cba9f",
                            fill: false
                        }, {
                            data: [40, 20, 10, 16, 24, 38, 74, 167, 508, 784],
                            label: "working",
                            borderColor: "#e8c3b9",
                            fill: false
                        }, {
                            data: [6, 3, 2, 2, 7, 26, 82, 172, 312, 433],
                            label: "unknow",
                            borderColor: "#c45850",
                            fill: false
                        }
                    ]
                },
            });
        </script>
    </body> 
</html>
