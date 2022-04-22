/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */




function display(ojectClick, ojectDisplay) {
  document.getElementsByTagName("BODY")[0].onclick = function (e) {
      if (e.target === ojectClick) {
          if (ojectDisplay.style.display === "none") {
            ojectDisplay.style.display = "block";
          }
          else {
            ojectDisplay.style.display = "none";
          }
      }
      else if (e.target !== ojectDisplay) {
        ojectDisplay.style.display = "none";
      }
  };
}
function getDisplay(ojectClick, IDDisplay){
  display(ojectClick,
  document.getElementById(IDDisplay));
}