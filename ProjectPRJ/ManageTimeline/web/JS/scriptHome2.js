/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */




function display(ojectClick, ojectDisplay) {
    document.getElementsByTagName("BODY")[0].onclick = function (e) {
        if (e.target === ojectClick) {
            if (ojectDisplay.style.display === "none") {
                ojectDisplay.style.display = "block";
            } else {
                ojectDisplay.style.display = "none";
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
let submitDelete = document.getElementById("submit-delete");
let stringHref = [];

submitDelete.onclick = function (e) {
    submitDelete.href = "deleteItemInfor?itemsDelete=" + stringHref;
};


function cancelHideDelete() {
    document.getElementById("display-delete").style.display = 'none';
}
function getHideDelete(element) {
    let faElement = element.parentNode;
    faElement.style.display = "none";
    stringHref.push(faElement.id);
}
function getAllHideUpdate(element){
    let faElement = element.parentNode;
    faFaElement = faElement.parentNode;
    listALL = faFaElement.querySelectorAll("div");
    for (let index = 0; index < listALL.length; index++) {
      if(listALL[index] === faElement)continue;
      listALL[index].style.display = "none";
    }
    document.getElementById("form-update-input").style.display = 'block';
    document.getElementsByName("IDItemUpdate")[0].value = faElement.id;
}
