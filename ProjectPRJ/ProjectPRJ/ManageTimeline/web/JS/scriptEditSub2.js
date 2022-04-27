/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */



let arrayElement = document.querySelectorAll(".edit-process");


for (var i = 0; i < arrayElement.length; i++) {
    getEditProcess(arrayElement[i]);
}
function getEditProcess(e) {
    let boxEdit = e.parentNode.parentNode.parentNode.querySelector(".box__edit");
    let boxEditFeature = boxEdit.querySelector(".box__edit--feature");
    let editAdd = boxEditFeature.querySelector(".edit-add");
    let editDelete = boxEditFeature.querySelector(".edit-delete");
    e.onclick = function () {
        boxEdit.style.display = "flex";
    };
    editAdd.onclick = function () {
        editAdd.querySelector(".input-edit").style.display = "block";
    };
    editAdd.querySelector(".input-edit").querySelector("form").querySelector(".input-edit-cancel").onclick = function (e) {
        e.stopPropagation();
        e.preventDefault();
        editAdd.querySelector(".input-edit").style.display = "none";
    };
    editDelete.onclick = function () {
        editDelete.querySelector(".input-edit-delete").style.display = "block";
    };
    editDelete.querySelector(".input-edit-delete").querySelector("form").querySelector(".input-edit-cancel-delete").onclick = function (e) {
        e.stopPropagation();
        e.preventDefault();
        editDelete.querySelector(".input-edit-delete").style.display = "none";
    };
    boxEdit.querySelector(".edit-feature-cancel").onclick = function () {
        boxEdit.style.display = "none";
    }; 
}










