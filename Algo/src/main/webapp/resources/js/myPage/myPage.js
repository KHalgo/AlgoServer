var lm_btn1 = document.getElementById('lm_btn1');

lm_btn1.addEventListener('click', function() {
window.open('${ pageContext.request.contextPath }/myPage/location/window', '_blank', 'width=720,height=600');
});
