// 전체동의 체크시 체크박스 모두 체크
$("#all_Agree").on("click", (event) => {
    if (event.target.checked == true) {
        $(".options").prop("checked", true);
    } else {
        $(".options").prop("checked", false);
    }
});

// 1. 비밀번호 입력창 정보 가져오기
let elInputPassword = document.querySelector("#userPw"); // input#password

// 2. 비밀번호 확인 입력창 정보 가져오기
let elInputPasswordRetype = document.querySelector("#userPw2"); // input#password-retype

// 3. 실패 메시지 정보 가져오기 (비밀번호 불일치)
let elMismatchMessage = document.querySelector(".mismatch-message"); // div.mismatch-message.hide

// 4. 실패 메시지 정보 가져오기 (8글자 이상, 영문, 숫자, 특수문자 미사용)
let elStrongPasswordMessage = document.querySelector(".strongPassword-message"); // div.strongPassword-message.hide

// 비번 정규식 체크
function strongPassword(str) {
    return /^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{8,15}$/.test(str);
}

// 비번, 비번확인 일치여부 체크
function isMatch(password1, password2) {
    return password1 === password2;
}

// 비번 조건에 맞게 입력했는지 체크
elInputPassword.onkeyup = function () {
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
elInputPasswordRetype.onkeyup = function () {

	// console.log(elInputPasswordRetype.value);
	if (elInputPasswordRetype.value.length !== 0) {
	  if(isMatch(elInputPassword.value, elInputPasswordRetype.value)) {
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
});
