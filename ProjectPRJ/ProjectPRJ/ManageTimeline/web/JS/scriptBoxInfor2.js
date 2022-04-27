/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


arrayItem = arrayItem.replace("[", "");
arrayItem = arrayItem.replace("]", "");
arrayItem = arrayItem.replaceAll("},", "");
arrayItem = arrayItem.replace("}", "");
let arrayl = arrayItem.split("ItemsInfor{");
arrayl.shift();
let array2 = new Array;
for (let index = 0; index < arrayl.length; index++) {
    array2[index] = arrayl[index].split(",");
}

function getInformation(element) {
    for (let index = 0; index < array2.length; index++) {
        if (array2[index][0].includes(element)) {
            return array2[index];
        }
    }
}


let arrBoxContent = document.querySelectorAll(".container__content--box");
for (var i = 0; i < arrBoxContent.length; i++) {
    displayInformation(arrBoxContent[i]);
}
function displayInformation(element) {
    let boxContent = element.querySelector(".box--content");
    let content = boxContent.querySelector(".content");
    let data = getInformation(element.id);
    let arrayP = content.querySelectorAll("p");
    let bg = boxContent.querySelector(".img").querySelector("img");
    for (let i = 0; i < arrayP.length - 2; i++) {
        arrayP[i].innerHTML = data[i + 1].replaceAll("=", " : ");
    }
    if (data[data.length - 1].replaceAll("=", " : ").includes("false")) {
        arrayP[arrayP.length - 1].innerHTML = "submit : process";
    } else {
        arrayP[arrayP.length - 1].innerHTML = "submit : done";
    }
    arrayP[arrayP.length - 2].innerHTML = data[data.length - 2].replaceAll("=", " : ");
    bg.src = 'IMG/download/' + data[data.length - 3].replace(" background=", "");
    boxContent.style.display = "none";
    element.onclick = function (e) {
        if (boxContent.style.display === "none") {
            boxContent.style.display = "flex";
        } else {
            boxContent.style.display = "none";
        }
    };
}