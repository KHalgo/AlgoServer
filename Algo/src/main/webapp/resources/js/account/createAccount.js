// 전체동의 체크시 체크박스 모두 체크
$("#all_Agree").on("click", (event) => {
	if (event.target.checked == true) {
		$(".options").prop("checked", true);
	} else {
		$(".options").prop("checked", false);
	}
});

// 이메일 입력창의 값을 가져오기.
let inputEmail = document.querySelector("#inputEmail");

// 비밀번호 입력창 정보 가져오기
let elInputPassword = document.querySelector("#userPw");

// 비밀번호 확인 입력창 정보 가져오기
let elInputPasswordRetype = document.querySelector("#userPw2");

// 실패 메시지 정보 가져오기 (비밀번호 불일치)
let elMismatchMessage = document.querySelector(".mismatch-message");

// 실패 메시지 정보 가져오기 (8글자 이상, 영문, 숫자, 특수문자 미사용)
let elStrongPasswordMessage = document.querySelector(".strongPassword-message");

// 실패 메시지 정보 가져오기 (이메일)
let emailerrormsg = document.querySelector(".emailerrormsg");

// 이메일 정규식 체크
function emailCheck(str) {
	return /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-za-z0-9\-]+/.test(str);
}

// 비번 정규식 체크
function strongPassword(str) {
    return /^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{8,15}$/.test(str);
}

// 비번, 비번 확인 일치여부 체크
function isMatch(password1, password2) {
	return password1 === password2;
}

// 생년월일에 숫자만 입력 가능하게 하는 코드
function inputNum(id) {
	var element = document.getElementById('input1');
	element.value = element.value.replace(/[^0-9]/gi, "");
}

// 비번 조건에 맞게 입력했는지 체크
elInputPassword.onkeyup = function() {
	if (elInputPassword.value.length !== 0) {
		if (strongPassword(elInputPassword.value)) {
			elStrongPasswordMessage.classList.add("hide"); // 실패 메시지가 가려져야 함
		} else {
			elStrongPasswordMessage.classList.remove("hide"); // 실패 메시지가 보여야 함
		}
	}
	else {
		elStrongPasswordMessage.classList.add("hide");
	}
};

// 비번, 비번확인 일치여부 체크
elInputPasswordRetype.onkeyup = function() {
	if (elInputPasswordRetype.value.length !== 0) {
		if (isMatch(elInputPassword.value, elInputPasswordRetype.value)) {
			elMismatchMessage.classList.add('hide'); // 실패 메시지가 가려져야 함
		}
		else {
			elMismatchMessage.classList.remove('hide'); // 실패 메시지가 보여야 함
		}
	}
	else {
		elMismatchMessage.classList.add('hide'); // 실패 메시지가 가려져야 함
	}
};

//이메일 형식에 맞게 입력했는지 확인하는 코드
inputEmail.onkeyup = function() {
	if (inputEmail.value.length !== 0) {
		if (emailCheck(inputEmail.value)) {
			emailerrormsg.classList.add("hide"); // 실패 메시지가 가려져야 함
		} else {
			emailerrormsg.classList.remove("hide"); // 실패 메시지가 보여야 함
		}
	}
	else {
		emailerrormsg.classList.add("hide");
	}
};

// 아이디 중복 확인
$(document).ready(() => {
	$("#userIdBtn").on("click", () => {
		let userId = $("#userId").val().trim();
		const regex = /^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{5,15}$/;
		const result = regex.test($("#userId").val());

		if (userId == "") {
			alert("아이디를 입력해 주세요.");
		} else if (!result) {
			alert("아이디는 영문, 숫자를 포함하여 5~15자 이내로 입력하세요.");
		} else {
			$.ajax({
				type: "GET",
				url: "/Algo/AccountIdCheckServlet",
				dataType: "json",
				data: {
					userId, //userId: userId
				},
				success: (obj) => {
					console.log(obj);

					if (obj.duplicate) {
						alert("이미 사용 중인 아이디입니다.");
					} else {
						alert("사용 가능한 아이디 입니다.");
					}
				},
				error: (error) => {
					console.log(error);
				},
			});
		}
	});
});

// 닉네임 중복확인
$(document).ready(() => {
	$("#nickBtn").on("click", () => {
		let userNick = $("#userNick").val().trim();
		const regex = /^[a-zA-Z0-9ㄱ-ㅎ가-힣]{2,12}$/;
		const result = regex.test($("#userNick").val());

		if (userNick == "") {
			alert("닉네임을 입력해 주세요.");
		} else if (!result) {
			alert("닉네임은 영문, 숫자를 포함하여 2~12자 이내로 입력하세요.");
		} else {
			$.ajax({
				type: "GET",
				url: "/Algo/AccountNickCheckServlet",
				dataType: "json",
				data: {
					userNick,
				},
				success: (obj) => {
					console.log(obj);

					if (obj.duplicate) {
						alert("이미 사용 중인 닉네임입니다.");
					} else {
						alert("사용 가능한 닉네임 입니다.");
					}
				},
				error: (error) => {
					console.log(error);
				},
			});
		}
	});

	$('#address').on('change', (event) => {
		let sidoName = $(event.target).val();

		$.ajax({
			type: "GET",
			url: "/Algo/sigungu",
			dataType: "json",
			data: {
				sidoName, // sidoId: sidoId
			},
			success: (obj) => {
                let result = '';
				console.log(obj);
				
                obj.forEach(element => {
                    result += `<option value="${element.sigunguName}">${element.sigunguName}</option>`;
                });

                $('#sigungu').empty();
                $('#sigungu').append(result);
			},
			error: (error) => {
				console.log(error);
			},
		});
	});
});

// btnActive() 호출
$('#sigungu').on('click',(event) => {
	btnActive();
})

// 조건에 맞게 모두 입력했는지 확인하는 코드
function btnActive() {
	let option1 = $('#required_option1').prop('checked') // boolean값
	let option2 = $('#required_option2').prop('checked') // boolean값
	let option3 = $('#required_option3').prop('checked') // boolean값
	let userName = $('#userName').val();
	let userId = $('#userId').val();
	let userPw = $('#userPw').val();
	let userPw2 = $('#userPw2').val();
	let userNick = $('#userNick').val();
	let userPhone = $('#userPhone').val();
	let inputEmail = $('#inputEmail').val();
	let address = $('#address').val();
	let sigungu = $('#sigungu').val();

	if( option1 == true && 
		option2 == true && 
		option3 == true && 
		userName != null && 
		userId != null && 
		userPw != null && 
		userPw2 != null && 
		userNick != null && 
		userPhone != null && 
		inputEmail != null && 
		address != null && 
		sigungu != null
		) {
			$('.algo_btn100').prop('disabled', false);
			$('.algo_btn100').css('background', '#004591');
	} else {
        $('.algo_btn100').prop('disabled', true);
    };

}
