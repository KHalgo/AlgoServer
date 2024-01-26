window.onload = () => {
	let lm_btn1 = document.getElementById('lm_btn1');
	
	lm_btn1.addEventListener('click', function() {
		/* 지역 설정 페이지 누를시 나오는 창 */
	window.open('location/window', '_blank', 'width=900px,height=1000px');
	});
}

