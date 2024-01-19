<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${ pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>알바는 알고하자 - 알고</title>
	<link rel="stylesheet" href="${ path }/resources/css/common.css">  
	<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	
	<!-- css 추가 부분 -->
	<link rel="stylesheet" href="${ path }/resources/css/board/qnaPost.css">  
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="/views/common/header.jsp" />
	
	<!-- 내용 넣기 -->
	<main>
        <!--1. 알고Q&A 배너  -->
        <section>
            <div class="banner-navi"> <a href="${ path }">홈</a> &nbsp;&nbsp; &gt; &nbsp;&nbsp; <a href="${ path }/talkBoard/">커뮤니티</a> &nbsp;&nbsp; &gt; &nbsp;&nbsp; <a href="${ path }/qnaBoard/">알고 Q&A</a> </div>
            <div class="banner">
                <div class="banner-txt">
                    <h1>알고 Q&A</h1>
                    <p><span>알바는 알고하자!</span> 아르바이트 관련 모든 질문을 자유롭게 주고 받는 공간</p>
                </div>
                <img src="https://i.ibb.co/W2SPj6c/qna.png" width="107px"></div>
            </div>
        </section>
        <!-- 2. 알고 Q&A 게시글 -->
        <section>
            <table class="postBoard">
                <tr>
                    <th colspan="2">유니클로 알바 유의사항</th>
                </tr>
                <tr style="border-bottom: 1px solid #C0C0C0;">
                    <td>알바왕&nbsp; &#124; &nbsp;서울시&nbsp; &gt; &nbsp;강남구&nbsp; &#124; &nbsp;2023.12.16 17:30</td>
                    <td class="write-r">
                        조회&nbsp;0&nbsp; &#124; &nbsp;추천&nbsp;0&nbsp; &#124; &nbsp;<a href="#">신고</a>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" class="content">
                        <p>그런거 없음</p>
                    </td>
                </tr>
                <!-- 추천 버튼 -->
                <tr class="likeButton" style="border-bottom: 1px solid #C0C0C0;">
                    <td colspan="2">
                        <button class="algo_btn2">추천해요</button>
                    </td>
                </tr>
                <tr style="border-bottom: 1px solid #C0C0C0;">
                    <td colspan="2">댓글 <strong>3</strong>개</td>
                </tr>
                <tr>
                    <td><b>알바몬</b>&nbsp; &#124; &nbsp;2023.12.16 17:30</td>
                    <td class="write-r">
                        <button class="like">추천(0)</button>
                        <button class="reply">답글</button>
                        <button class="report">신고</button>
                    </td>
                </tr>
                <tr style="border-bottom: 1px solid #C0C0C0;">
                    <td colspan="2">정보 감사합니다~</td>
                </tr>
                <tr>
                    <td><b>알바몬</b>&nbsp; &#124; &nbsp;2023.12.16 17:30</td>
                    <td class="write-r">
                        <button class="like">추천(0)</button>
                        <button class="reply">답글</button>
                        <button class="report">신고</button>
                    </td>
                </tr>
                <tr style="border-bottom: 1px solid #C0C0C0;">
                    <td colspan="2">정보 감사합니다~</td>
                </tr>
                <tr>
                    <td><b>알바몬</b>&nbsp; &#124; &nbsp;2023.12.16 17:30</td>
                    <td class="write-r">
                        <button class="like">추천(0)</button>
                        <button class="reply">답글</button>
                        <button class="report">신고</button>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">정보 감사합니다~</td>
                </tr>
            </table>
        </section>
        <!-- 3. 목록 버튼 -->
        <section class="boardList">
            <button class="algo_btn1" onclick="location.href='${ path }/qnaBoard/';">목록</button>
        </section>
	</main>
	
	<!-- 푸터 -->
   <jsp:include page="/views/common/footer.jsp" /> 
   
	<!--js 추가-->
	<script type="text/javascript" src="${ path }/resources/js/top.js"></script>
</body>
</html>