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
<link rel="stylesheet" href="${ path }/resources/css/account/findId.css">


</head>
<body>

	<!-- 헤더 -->
	<jsp:include page="/views/common/header.jsp" />

	<!-- 내용 넣기 -->
	<main>
		<section>
			<div>
				<img src="https://i.ibb.co/K6dj7KV/logo-3.png" alt="로고"
					class="findPwd_logo" /> <strong
					style="font-size: 30px; color: #003566">아이디 찾기</strong>
			</div>
			<div>
				<div class="acc-table">
					<table>
						<tr>
							<th>이름</th>
							<td><input class="user_info_input_tag1" type="text" name=""
								id="" /></td>
						</tr>
						<tr>
							<th>생년월일</th>
							<td><input class="user_info_input_tag1" type="text" name=""
								id="" /></td>
						</tr>
						<tr>
							<th>휴대폰 번호</th>
							<td><input class="user_info_input_tag2" type="text" name=""
								id="" placeholder="휴대폰 번호 '-' 제외하고 입력" /></td>
							<td><input class="algo_btn2" type="button" value="인증받기" />
							</td>
						</tr>
						<tr>
							<td></td>
							<td><input class="user_info_input_tag2" type="text" name=""
								id="" placeholder="인증번호 입력" /></td>
							<td><input class="algo_btn2" type="button" value="확인" /></td>
						</tr>
					</table>
					<div style="margin: -50px auto; text-align: center">
						<button class="algo_btn1" type="submit" onclick="location.href='${ path }/account/findIdComplete'">아이디 찾기</button>
					</div>
				</div>
			</div>
		</section>
	</main>

	<!-- 푸터 -->
	<jsp:include page="/views/common/footer.jsp" />

	<!--js 추가-->
	<script type="text/javascript" src="${ path }/resources/js/top.js"></script>
</body>
</html>