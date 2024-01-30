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
<!--         1. 알고 배너  -->
        <section>
	        <div class="banner" style="margin-top: 20px">
	            <div class="banner-txt">
	                <h1>알고 고객센터 등록</h1>
	            </div>
            <img src="https://i.ibb.co/W2SPj6c/qna.png" width="107px"></div>
        </section>
<!--         2. 글쓰기 페이지 -->
   	    <form action="${path}/cscenter/writter" method="post" enctype="multipart/form-data">
	        <section>
	            <table class="writeBoard">
	                <tr>
	                    <th>닉네임</th>
	                    <td>${ loginMember.userNick }</td>
	                    <th colspan="2">카테 고리</th>
	                </tr>
	                <tr>
	                    <th>아이디</th>
	                    <td>${ loginMember.userId }</td>
	                    <td colspan="2">
	                        <select name="csCategory" id="" style="background: url(https://i.ibb.co/N9HPzF3/list-arrow.png) no-repeat right 7px center;">
	                            <option value="QNA">자주묻는 질문</option>
	                            <option value="NOICE">공지 사항</option>
	                        </select>
	                    </td>
	                </tr>
	                <tr>
	                    <th>제목</th>
	                    <td colspan="3">
	                        <input type="text" name="csTitle" id="" class="title" placeholder="제목을 입력하세요.">
	                    </td>
	                </tr>
	                <tr>
	                    <td class="contentBox" colspan="4">
	                        <textarea name="csContent" id="" class="content" placeholder="등록할 내용을 넣어주세요"></textarea>
	                    </td>
	                </tr>
	            </table>
	        </section>
	        <!-- 3. 하단 버튼 -->
	        <section>
	            <div class="buttons">
	                <button type="submit" class="algo_btn1">완료</button>
	                <button type="button" class="algo_btn2" onclick="location.href='${ path }/cscenter'">취소</button>
	            </div>
        	</section>   
        </form>
	</main>
	<!-- 푸터 -->
   <jsp:include page="/views/common/footer.jsp" /> 
   
	<!--js 추가-->
	<script type="text/javascript" src="${ path }/resources/js/top.js"></script>
	<script type="text/javascript" src="${ path }/resources/js/cscenter/cscenter.js"></script>
</body>
</html>