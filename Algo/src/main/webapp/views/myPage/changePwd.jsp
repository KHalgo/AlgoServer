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
<link rel="stylesheet" href="${ path }/resources/css/mypage/changePwd.css">


</head>
<body>

	<!-- 헤더 -->
	<jsp:include page="/views/common/header.jsp" />

	<!-- 내용 넣기 -->
	<main>
		<section>
			<form action="">
				<div>
					<img src="https://i.ibb.co/K6dj7KV/logo-3.png" alt="로고"
						class="Pwd_logo" /> <strong
						style="font-size: 30px; color: #003566">비밀 번호 변경</strong>
				</div>
				<div>
					<div class="acc-table">
						<table>
							<tr>
								<th>새 비밀번호</th>
								<td><input class="user_info_input_tag1" type="password"
									name="" id="" placeholder="8~15자 영문, 숫자 포함" /></td>
							</tr>
							<tr>
								<th>새 비밀번호 확인</th>
								<td><input class="user_info_input_tag1" type="password"
									name="" id="" placeholder="8~15자 영문, 숫자 포함" /></td>
							</tr>
						</table>
						<div style="margin: -50px auto; text-align: center">
							<button class="algo_btn1" type="button"
								onclick="location.href='${ path }/account/findPwdComplete'">변경하기</button>
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