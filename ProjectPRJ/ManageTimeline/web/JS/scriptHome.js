/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function getDisplay(oject, destination) {
    console.log(destination.style.display)
    document.getElementsByTagName("BODY")[0].onclick = function (e) {
        if (e.target == oject) {
            if (destination.style.display == "none") {
                destination.style.display = "block";
            }
            else {
                destination.style.display = "none";
            }
        }
        else if (e.target != destination) {
            destination.style.display = "none";
        }
    }
}
getDisplay(document.getElementById('account-img') 
, document.getElementById('account-setting'));