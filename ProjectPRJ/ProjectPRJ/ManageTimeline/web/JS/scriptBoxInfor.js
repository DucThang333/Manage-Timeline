/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


arrayItem = arrayItem.replace("[","");
arrayItem = arrayItem.replace("]","");
arrayItem = arrayItem.replaceAll("},","");
arrayItem = arrayItem.replace("}","");
let arrayl = arrayItem.split("ItemsInfor{");
arrayl.shift();
let array2 = new Array;
for (let index = 0; index < arrayl.length; index++) {
    array2[index] = arrayl[index].split(",");
} 

function getInformation(element){ 
    for (let index = 0; index < array2.length; index++) {
        if(array2[index][0].includes(element)){
            return array2[index];
        }
    }
}

function displayInformation(element){
    let boxContent = element.querySelector(".box--content") ;
    if (boxContent.style.display === "none"){
        boxContent.style.display = "flex";
    }else{
        boxContent.style.display = "none";
        return;
    }
  
    let content = boxContent.querySelector(".content") ;
    let data = getInformation(element.id);
    let arrayP = content.querySelectorAll("p");
    for (let i = 0; i < arrayP.length; i++) {
        arrayP[i].innerHTML = data[i+1].replaceAll("="," : ");
        console.log(arrayP[i]);
    }
    boxContent.querySelector(".img").querySelector("img").src = 'IMG/download/'+data[data.length - 1].replace(" background=","");
}