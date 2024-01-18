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
	<title>마이페이지_문의하기 작성</title>
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
                <form action="" name="content">
                    <div class="content">
                        <!-- 사이드바 입력 -->
                        <div id="mySideBar"></div>
                        <div class="qcontent">
                            <h2 id="q_main_title">문의하기</h2>
                            <fieldset class="qs_board">
                                <div class="q_notion">
                                    <input type="text" id="q_title" name="title" placeholder="제목을 입력하세요"/>
                                </div>
                                <hr/>
                                <div class="form-group">
                                    <textarea id="q_content" name="bcontent" placeholder="문의 내용을 입력하세요" cols="30" rows="20"></textarea>
                                </div>
                                <div class="q_sub_btn">
                                    <button type="submit" id="q_btn1">문의하기</button>
                                </div>
                            </fieldset>
                        </div>
                    </div>
                </form>
            </section>
	</main>
	
    <!-- 푸터 -->
   <jsp:include page="/views/common/footer.jsp" /> 
   
	<!--js 추가-->
	<script type="text/javascript" src="${ path }/resources/js/top.js"></script>
	<script type="text/javascript" src="${ path }/resources/js/myPage/myPage_sideBar.js"></script>	
</body>
</html>