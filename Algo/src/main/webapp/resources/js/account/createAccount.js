$("#all_Agree").on('click', (event) => {
    if(event.target.checked == true){
        $('.options').prop('checked', true);
    } else {
        $('.options').prop('checked', false);
    }
})

// 아이디 부분 정규표현식 어떻게? > (정규표현식).test("문자열") - 문자열이 정규표현식과 매칭되면
// true, 아니면 false 반환.
// const regex = /정규표현식/
// regex.test("사용자가 입력한 아이디 값."); > 아이디 값을 문자열로 받아와? 변수에 담아서 못받아?

//실시간으로 조건에 어긋나면 빨간 글씨로 보여주는 거 어떻게 해?
//특수문자 입력되면 빨간 글씨로 보여주기.

//이름
// const regex = /^[가-힣]{2,18}$/;
// const result = regex.test("123456789aaaaaa");
// alert(result);

//생년월일
// const regex = /^[0-9]{8}$/;
// const result = regex.test("123456789aaaaaa");
// alert(result);

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
