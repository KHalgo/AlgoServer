window.onload = () => {
	let lm_btn1 = document.getElementById('lm_btn1');
	
	lm_btn1.addEventListener('click', function() {
		/* 지역 설정 페이지 누를시 나오는 창 */
	window.open('location/window', '_blank', 'width=900px,height=1000px');
	});
}


function isMatch(password1, password2) {
	return password1 === password2;
}
    
    let nowPass = document.querySelector(".cp_m");
    let nowPassErrorMsg = document.querySelector(".nowPassErrorMsg");
	let userPw = document.querySelector("${ loginMember.userPw }");

    if (nowPass.value.length !== 0) {
		if (isMatch(nowPass, userPw)) {
			nowPassErrorMsg.classList.add("hide"); // 실패 메시지가 가려져야 함
		} else {
			nowPassErrorMsg.classList.remove("hide"); // 실패 메시지가 보여야 함
		}
	}
	else {
		nowPassErrorMsg.classList.add("hide");
	}

