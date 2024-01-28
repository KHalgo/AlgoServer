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
	<link rel="stylesheet" href="${ path }/resources/css/board/qnaWrite.css">  
</head>
<body>

	<!-- 헤더 -->
	<jsp:include page="/views/common/header.jsp" />
	
	<!-- 내용 넣기 -->
	<main>
<!--         1. 알고Q&A 배너  -->
        <section>
	        <div class="banner" style="margin-top: 20px">
	            <div class="banner-txt">
	                <h1>알고 고객센터 등록</h1>
	            </div>
            <img src="https://i.ibb.co/W2SPj6c/qna.png" width="107px"></div>
        </section>
<!--         2. 알고Q&A 글쓰기 페이지 -->
        <section>
            <table class="writeBoard">
                <tr>
                    <th>닉네임</th>
                    <td>알고지기</td>
                    <th colspan="2"></th>
                </tr>
                <tr>
                    <th>아이디</th>
                    <td>${ cscenter.csWriterId }</td>
                    <td colspan="2">
                        <select name="" id="" style="background: url(https://i.ibb.co/N9HPzF3/list-arrow.png) no-repeat right 7px center;">
                            <option value="">자주묻는 질문</option>
                            <option value="">공지 사항</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>제목</th>
                    <td colspan="3">
                        <input type="text" name="" id="" class="title" placeholder="제목을 입력하시오.">
                    </td>
                </tr>
                <tr>
                    <td class="contentBox" colspan="4">
                        <textarea name="" id="" class="content" placeholder="무분별한 비방 및 욕설, 유해 사이트 홍보 등은 무통보 삭제 후 사이트 이용 제한 처리됩니다."></textarea>
                    </td>
                </tr>
            </table>
        </section>
        <!-- 3. 하단 버튼 -->
        <section>
            <div class="buttons">
                <button type="submit" class="algo_btn1">완료</button>
                <button class="algo_btn2" onclick="location.href='${ path }/cscenter/notice'">취소</button>
            </div>
        </section>   
	</main>
	<!-- 푸터 -->
   <jsp:include page="/views/common/footer.jsp" /> 
   
	<!--js 추가-->
	<script type="text/javascript" src="${ path }/resources/js/top.js"></script>
	<script type="text/javascript" src="${ path }/resources/js/cscenter/cscenter.js"></script>
</body>
</html>