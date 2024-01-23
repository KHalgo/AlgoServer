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
	<title>마이페이지_작성한 댓글</title>
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
            <div class="lm_content">
                <form action="" name="sidebar">
                    <div id="mySideBar"></div>
                </form>
                <form action="" name="content">
                    <div class="local_box">
                        <form action="">
                            <h3 style="font-weight: bold">지역 설정</h3>
                            <div class="lm_search">
                                <div class="lm_search_bar">
                                    <input type="search" name="lm_search" id="lm_search_input" placeholder="원하는 지역을 입력해주세요">
                                    <button id="lm_btn1"><img id="lm_img1" src="https://i.ibb.co/ByBFcyt/search.png" alt=""></button>
                                </div>
                            </div>
                        </form>
                        <div class="lm_table">
                            <p for="" class="table_title">나의 관심지역</p>
                            <table>
                                <tr class="lm_tr">
                                    <tr>
                                        <td class="lm_td">
                                            <img src="https://i.ibb.co/HhQ0sDr/location-logo.png" width="24px" height="24px" alt="location" border="0">
                                            <div class="lm_dm">서울시 강남구</div>
                                            <img src="https://i.ibb.co/V97jmW2/yellow-heart.png" alt="yellow-heart" border="0" width="24px" height="24px">
                                        </td>
                                        <td class="lm_td">
                                            <img src="https://i.ibb.co/HhQ0sDr/location-logo.png" width="24px" height="24px" alt="location" border="0">
                                            <div class="lm_dm">서울시 중구</div>
                                            <img src="https://i.ibb.co/V97jmW2/yellow-heart.png" alt="yellow-heart" border="0" width="24px" height="24px">
                                        </td>
                                    </tr>
                                    <td class="lm_td">
                                        <img src="https://i.ibb.co/HhQ0sDr/location-logo.png" width="24px" height="24px" alt="location" border="0">
                                        <div class="lm_dm">경기도 남양주시</div>
                                        <img src="https://i.ibb.co/V97jmW2/yellow-heart.png" alt="yellow-heart" border="0" width="24px" height="24px">
                                    </td>
                                    <td class="lm_td">
                                        <img src="https://i.ibb.co/HhQ0sDr/location-logo.png" width="24px" height="24px" alt="location" border="0">
                                        <div class="lm_dm">서울시 강남구</div>
                                        <img src="https://i.ibb.co/v34CvHX/yellow-heart-empty.png" alt="yellow-heart" border="0" width="24px" height="24px">
                                    </td>
                                </tr>
                            </table>
                            <div class="lm_rs">
                                <span><p id="lm_p1">현재 내가 설정한 지역은</p></span>
                                <span><a href="${ path }/myPage/location/window" class="lm_local" target="_blank">서울시 강남구</a></span>
                                <span><p id="lm_p2">입니다.</p></span>
                            </div>
                        </form>
                    </div>
                    
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