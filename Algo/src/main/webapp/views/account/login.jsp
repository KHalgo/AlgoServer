<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="path" value="${ pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>알바는 알고하자 - 알고</title>
<link rel="stylesheet" href="${ path }/resources/css/common.css">
<script type="text/javascript"
	src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript"
	src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>


<!-- css 추가 -->
<link rel="stylesheet" href="${ path }/resources/css/account/login.css">


</head>
<body>

	<!-- 헤더 -->
	<jsp:include page="/views/common/header.jsp" />

	<!-- 내용 넣기 -->
	<main>
		<section>
			<form action="">
				<div id="biglogo">
					<img src="https://i.ibb.co/K6dj7KV/logo-3.png" alt="로고"
						style="width: 130px" />
				</div>
				<div class="first_div">
					<div class="login-box">
						<input type="text" name="input_id" id="input_id" placeholder="아이디" />
						<br /> <input type="password" name="input_pass" id="input_pass"
							placeholder="비밀번호" />
						<div class="login_info_save">
							<input type="checkbox" name="" id="login_info_save" /> <label
								for="login_info_save">로그인 정보 저장</label>
						</div>
						<button type="button" class="login_btn" onclick="location.href='${ path }'">로그인</button>
						<br /> <br />
						<div class="label_signAndIdPass">
							<div class="label_signup">
								<a href="${ path }/views/account/createAccount">회원가입</a>
							</div>
							<div class="label_pass">
								<a href="${ path }/views/account/findPwd">비밀번호 찾기</a>
							</div>
							<div class="label_id">
								<a href="${ path }/views/account/findId">아이디 찾기</a>
							</div>
						</div>
					</div>
				</div>
			</form>
		</section>
	</main>

	<!-- 푸터 -->
	<jsp:include page="/views/common/footer.jsp" />

	<!--js 추가-->
	<script type="text/javascript" src="${ path }/resources/js/top.js"></script>
</body>
</html>