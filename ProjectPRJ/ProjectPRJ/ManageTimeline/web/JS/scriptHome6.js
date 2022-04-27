/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */



function display(ojectClick, ojectDisplay) {
    document.getElementsByTagName("BODY")[0].onclick = function (e) {
        if (e.target === ojectClick) {
            if (ojectDisplay.style.display === "none") {
                ojectDisplay.style.display = "block";
            } else if (ojectDisplay.style.display === "block") {
                ojectDisplay.style.display = "none";
            } else {
                ojectDisplay.style.display = "block";
            }
        } else if (e.target !== ojectDisplay) {
            ojectDisplay.style.display = "none";
        }
    };
}
function getDisplay(ojectClick, IDDisplay) {
    display(ojectClick,
            document.getElementById(IDDisplay));
}
let stringHref = [];

function getSubmitDelete() {
    document.getElementsByName("IDItemdelete")[0].value = stringHref;
}
;


function cancelHideDelete() {
    document.getElementById("display-delete").style.display = 'none';
}
function getHideDelete(element) {
    let faElement = element.parentNode;
    faElement.style.display = "none";
    stringHref.push(faElement.id);
}


let arrayList = document.querySelectorAll(".list-form");
for (var i = 0; i < arrayList.length; i++) {
    getAllHideUpdate(arrayList[i].querySelector(".click-list-form"));
}


function getAllHideUpdate(element) {
    let faElement = element.parentNode;
    faFaElement = faElement.parentNode;
    listALL = faFaElement.querySelectorAll("div"); 
    element.onclick = function (e) {
        for (let index = 0; index < listALL.length; index++) {
            if (listALL[index] === faElement)
                continue;
            listALL[index].style.display = "none";
        }
        faElement.querySelector("form").style.display = 'block';
        faElement.querySelector("form").querySelector(".IDItemUpdate")[0].value = faElement.id;
    };
}
function cancelHideAdd(){
    document.getElementById("form-addType").style.display = "none";
}