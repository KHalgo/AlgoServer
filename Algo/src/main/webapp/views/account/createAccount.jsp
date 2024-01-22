<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="path" value="${ pageContext.request.contextPath }"/>    
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>알바는 알고하자 - 알고</title>
	<link rel="stylesheet" href="${ path }/resources/css/common.css">
	<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	

	<!-- css 추가 -->
	<link rel="stylesheet" href="${ path }/resources/css/account/createAccount.css">
	

</head>
<body>
	
	<!-- 헤더 -->
	<jsp:include page="/views/common/header.jsp" />
	
	<!-- 내용 넣기 -->
	<main>
		<section>
		<div class="top_div">
                <img class="createAccount_logo" src="https://i.ibb.co/K6dj7KV/logo-3.png" alt="" />
                회원가입
            </div>
            <div class="main_div">
                <h3>약관 동의</h3>
                <div class="inner_top_div">
                    <input type="checkbox" name="" id="all_Agree" />
                    <label for="all_Agree">전체 동의하기</label> <br />
                    <input type="checkbox" name="" id="required_option1" />
                    <label for="required_option1"
                        ><span class="required_option">(필수)</span> 만 15세 이상입니다. <span class="manual"><a href="#">(약관보기)</a></span></label
                    >
                    <br />
                    <input type="checkbox" name="" id="required_option2" />
                    <label for="required_option2"
                        ><span class="required_option">(필수)</span> 만 15세 이상입니다. <span class="manual"><a href="#">(약관보기)</a></span></label
                    >
                    <br />
                    <input type="checkbox" name="" id="required_option3" />
                    <label for="required_option3"
                        ><span class="required_option">(필수)</span> 만 15세 이상입니다. <span class="manual"><a href="#">(약관보기)</a></span></label
                    >
                    <br />
                    <input type="checkbox" name="" id="select_option1" />
                    <label for="select_option1"
                        ><span class="select_option">(선택)</span> 만 15세 이상입니다. <span class="manual"><a href="#">(약관보기)</a></span></label
                    >
                    <br />
                    <input type="checkbox" name="" id="select_option2" />
                    <label for="select_option2"
                        ><span class="select_option">(선택)</span> 만 15세 이상입니다. <span class="manual"><a href="#">(약관보기)</a></span></label
                    >
                    <br />
                    <input type="checkbox" name="" id="select_option3" />
                    <label for="select_option3"
                        ><span class="select_option">(선택)</span> 만 15세 이상입니다. <span class="manual"><a href="#">(약관보기)</a></span></label
                    >
                    <br />
                </div>
                <table>
                    <tr>
                        <th>이름<span>*</span></th>
                        <td><input type="text" class="user_info_input_tag1" /></td>
                    </tr>
                    <tr>
                        <th>생년월일</th>
                        <td><input type="text" class="user_info_input_tag1" /></td>
                    </tr>
                    <tr>
                        <th>아이디<span>*</span></th>
                        <td><input type="text" class="user_info_input_tag1" placeholder="5~15자 영문, 숫자 포함" /></td>
                        <td><input type="button" class="algo_btn200" value="중복확인" /></td>
                    </tr>
                    <tr>
                        <th>비밀번호<span>*</span></th>
                        <td><input type="text" class="user_info_input_tag1" placeholder="8~15자 영문, 숫자 포함" /></td>
                    </tr>
                    <tr>
                        <th>비밀번호 확인<span>*</span></th>
                        <td><input type="text" class="user_info_input_tag1" placeholder="8~15자 영문, 숫자 포함" /></td>
                    </tr>
                    <tr>
                        <th>닉네임<span>*</span></th>
                        <td><input type="text" class="user_info_input_tag1" placeholder="2~12자 이내" /></td>
                        <td><input type="button" class="algo_btn200" value="중복확인" /></td>
                    </tr>
                    <tr>
                        <th>휴대폰 번호<span>*</span></th>
                        <td><input type="text" class="user_info_input_tag2" placeholder="휴대폰 번호 '-' 제외하고 입력" /></td>
                        <td><input type="button" class="algo_btn200" value="인증받기" /></td>
                    </tr>
                    <tr>
                        <th></th>
                        <td><input type="text" class="user_info_input_tag2" placeholder="인증번호 입력" /></td>
                        <td><input type="button" class="algo_btn200" value="확인" /></td>
                    </tr>
                    <tr>
                        <th>이메일<span>*</span></th>
                        <td><input type="text" class="user_info_input_tag1" /></td>
                    </tr>
                    <tr>
                        <th>주소<span>*</span></th>
                        <td><input type="text" class="user_info_input_tag1" /></td>
                        <td><input type="button" class="algo_btn200" value="우편번호" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="text" class="user_info_input_tag1" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="text" class="user_info_input_tag1" /></td>
                    </tr>
                </table>
            </div>
            <div class="signInBtn">
                <input type="button" class="algo_btn100" value="회원가입" onclick="location.href='${ path }/account/createAccountComplete'" />
            </div>
		</section>
    </main>
	
    <!-- 푸터 -->
   <jsp:include page="/views/common/footer.jsp" /> 
   
	<!--js 추가-->
	<script type="text/javascript" src="${ path }/resources/js/top.js"></script>
</body>
</html>