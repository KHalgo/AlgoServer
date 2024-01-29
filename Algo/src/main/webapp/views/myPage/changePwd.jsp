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
<link rel="stylesheet" href="${ path }/resources/css/mypage/myPage.css">
<link rel="stylesheet" href="${ path }/resources/css/mypage/sideBar.css">

</head>
<body>

	<!-- 헤더 -->
	<jsp:include page="/views/common/header.jsp" />

	<!-- 내용 넣기 -->
	<main>
		<section>
			<jsp:include page="/views/myPage/mysideBar.jsp" />
            <div class="content">
                <form action="" name="sidebar">
                    <div id="mySideBar"></div>
                </form>

                <form action="" name="content">
                    <div class="mp_box">
                        <div class="w_content_box cp_content_box">
                            <h2>비밀 번호 변경</h2>
                            <div class="cp_change">
                                <input type="password" placeholder="현재 비밀번호" class="cp_m">
                            </div>
                            <div class="cp_change_border">
                                <div class="cp_change cp_d1">
                                    <input type="password" placeholder="새 비밀번호 (8~15자 영문,숫자,포함)" class="cp_m">
                                </div>
                                <div class="cp_change cp_d1">
                                    <input type="password" placeholder="새 비밀번호 확인" class="cp_m">
                                </div>
                            </div>
                            <input type="button" class="cp_btn" id="cp_btn" onclick="location.href='/Algo/myPage/changePwd/success'" value="비밀번호 변경"></input>
                        </div>
                        
                    </div>
                </form>
            </div>
        </section>
	</main>

	<!-- 푸터 -->
	<jsp:include page="/views/common/footer.jsp" />

	<!--js 추가-->
	<script type="text/javascript" src="${ path }/resources/js/top.js"></script>
	<script type="text/javascript" src="${ path }/resources/js/myPage/myPage_sideBar.js"></script>
	<script type="text/javascript" src="${ path }/resources/js/myPage/myPage.js"></script>
	
</body>
</html>