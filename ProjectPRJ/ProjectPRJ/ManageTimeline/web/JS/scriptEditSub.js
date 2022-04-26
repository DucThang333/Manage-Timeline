/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */



let arrayElement = document.querySelectorAll(".edit-process");


for (var i = 0; i < arrayElement.length; i++) {
    getEditProcess(arrayElement[i])
}
function getEditProcess(e) {
    let boxEdit = e.parentNode.parentNode.parentNode.querySelector(".box__edit");
    let boxEditFeature = boxEdit.querySelector(".box__edit--feature");
    e.onclick = function DisplayEditProcess() {
        boxEdit.style.display = "flex";
    }; 
}



//let editAdd = document.getElementById("edit-add");
//let editDelete = document.getElementById("edit-delete");
//let editProcess = document.getElementById("edit-process");
//editAdd.onclick = function displayEditAdd(){
//    document.getElementById("input-edit").style.display = "block"; 
//};
//document.getElementById("input-edit-cancel").onclick = function hideEditAdd(e){
//    e.stopPropagation();
//    e.preventDefault();
//    document.getElementById("input-edit").style.display = "none"; 
//};
//editDelete.onclick = function displayEditDelete(){
//    document.getElementById("input-edit-delete").style.display = "block"; 
//};
//document.getElementById("input-edit-cancel-delete").onclick = function hideEditDelete(e){
//    e.stopPropagation();
//    e.preventDefault();
//    document.getElementById("input-edit-delete").style.display = "none"; 
//};
//
//document.getElementById("edit-feature-cancel").onclick = function HideEditProcess(){
//    document.getElementById("box__edit").style.display = "none";   
//};