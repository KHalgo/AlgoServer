/*top 버튼 js*/
let topBtn = document.getElementById('topBtn');

const scrollWindow = function () {  
    if (window.scrollY != 0) {
        setTimeout(function () {
        window.scrollTo(0, window.scrollY - 50);
        scrollWindow();
        }, 10);
    }
};

topBtn.addEventListener('click', scrollWindow);
