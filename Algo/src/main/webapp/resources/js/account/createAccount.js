$("#all_Agree").on("click", (event) => {
    if (event.target.checked == true) {
        $(".options").prop("checked", true);
    } else {
        $(".options").prop("checked", false);
    }
});

//실시간으로 조건에 어긋나면 빨간 글씨로 보여주는 거 어떻게 해?
//특수문자 입력되면 빨간 글씨로 보여주기.

$("#userNameBtn").on("click", (event) => {
    const regex = /^[가-힣]{2,18}$/;
    const result = regex.test($("#userName").val());
    
    if (result) {
        alert("입력 확인");
    } else {
        alert("이름을 올바른 형식으로 입력하세요.");
    }
});

$("#userIdBtn").on("click", (event) => {
    const regex = /^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{5,15}$/;
    const result = regex.test($("#userId").val());
    
    if (result) {
        alert("사용 가능한 아이디입니다.");
    } else {
        alert("아이디는 영문, 숫자를 포함하여 5~15자 이내로 입력하세요.");
    }
});


// 아이디
// const regex = /^[a-zA-Z0-9]{5,15}$/;
// const result = regex.test("123456789aaaaaa");
// alert(result);

//비밀번호
// const regex = /^[a-zA-Z0-9]{8,15}$/;
// const result = regex.test("123456789aaaaaa");
// alert(result);

//닉네임 > 특수문자가 아예 입력이 안되게 할 수 있나?
// const regex = /^[a-zA-Z0-9ㄱ-ㅎ가-힣]{2,12}$/;
// const result = regex.test("123456789aaaaaa");
// alert(result);

//휴대폰 번호 > 특수문자가 아예 입력이 안되게 할 수 있나?
// const regex = /^[0-9]{11}$/;
// const result = regex.test("123456789aaaaaa");
// alert(result);
