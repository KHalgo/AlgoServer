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
	<title>마이페이지_메인</title>
	<link rel="stylesheet" href="${ path }/resources/css/common.css">  
	<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	

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
                        <div class="iq_content_box">
                            <div>
                                <h3>1:1 문의 내역</h3>
                            </div>
                            <div class="iq_board">
                                <div class="board_title">
                                    <h4>지역설정 어떻게 하면 되는건가요?</h4>
                                </div>
                                <div class="board_content">
                                    <div class="board_request">
                                        <p>안녕하세요. 지역설정을 하고 싶은데 어떻게 하면 되는 걸까요?</p>
                                    </div>
                                    <p id="iq_writer">알고지기 답변</p>
                                    <div class="iq_response">
                                        <p>안녕하세요. 고객님 ^^ 지역 설정에 대해 안내드리겠습니다. 마이페이지 > 좌측 상단 > 지역 설정 감사합니다. “알바는 알고하자 !”</p>
                                    </div>
                                </div>
                            </div>
                            <div class="iq_btn_c">
                                <button class="iq_btn" onclick=""><a href="#">문의 삭제</a></button>
                                <button class="iq_btn" onclick=""><a href="#">목록</a></button>
                                <button class="iq_btn" onclick=""><a href="#">문의하기</a></button>
                            </div>
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
</body>
</html>