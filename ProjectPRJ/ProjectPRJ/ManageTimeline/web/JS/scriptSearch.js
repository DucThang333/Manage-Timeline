/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function getCC(classname) {
    const searchWrapper = document.querySelector(classname);
    const inputBox = searchWrapper.querySelector("input");
    const suggBox = searchWrapper.querySelector(".autocom-box");


    inputBox.onkeyup = (e) => {
        e.stopPropagation();
        let userData = e.target.value;
        let Data = [];

        if (userData) {
            Data = suggestions.filter((data) => {
                return data.toLocaleLowerCase().includes(userData.toLocaleLowerCase());
            });
            Data = Data.map((data) => {
                return  '<li>' + data + '</li>';
            });
            searchWrapper.classList.add("active");
            showSuggestions(Data);
            let allList = suggBox.querySelectorAll("li");
            for (let i = 0; i < allList.length; i++) {
                //adding onclick attribute in all li tag
                allList[i].setAttribute("onclick", "select(this)");
            }
        } else {
            searchWrapper.classList.remove("active");
        }
    };
    function showSuggestions(list) {
        let listData;
        if (!list.length) {
            userValue = inputBox.value;
            listData = '<li>' + userValue + '</li>';
        } else {
            listData = list.join('');
        }
        suggBox.innerHTML = listData;
    }

}
function select(element) {
    let selectData = element.textContent;
    let divCh = element.parentNode;
    let divFa = divCh.parentNode;
    divFa.querySelector("input").value = selectData;
    divFa.classList.remove("active");
}
getCC(".feature-search");
getCC(".feature-search-update");
