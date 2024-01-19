<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="path" value="${ pageContext.request.contextPath }"/> 

	<!-- 플로팅 배너(TOP버튼)-->
    <div class="top" id="topBtn">
        <img src="https://i.ibb.co/31f0852/top.png"/>
    </div>
    
    <!-- 네비게이션 헤더 -->
	<header>
		<nav class="header_nav">
	    <ul class="left_nav">
	        <li><a href="${ path }/"><img src="https://i.ibb.co/K92Q9ps/logo-1.png" alt="로고" style="margin-top:-5px; width: 57px;"></a></li>
	    </ul>
	    <ul class="main_nav">
	        <li style="margin-left:70px;">
				<a href="${ path }/companyReview/">기업 리뷰</a>
				<ul>
					<li><a href="${ path }/">기업 리뷰</a></li>
					<li><a href="${ path }/">기업 리스트</a></li>
				</ul>
			</li>
	        <li>
				<a href="${ path }">커뮤니티</a>
				<ul>
					<li><a href="${ path }/">알고 TALK</a></li>
					<li><a href="${ path }/">알고 Q&A</a></li>
				</ul>
			</li>
	        <li><a href="${ path }/">알바 정보</a></li>
	        <li>
				<a href="${ path }/">고객센터</a>
				<ul>
					<li><a href="${ path }/">공지사항</a></li>
					<li><a href="${ path }/">1:1문의</a></li>
				</ul>
			</li>
	        <li style="padding-right:0;"><a href="">이벤트</a></li>
	    </ul>
	    <ul class="right_nav">
	        <li class="locate"><a href="${ path }/"><span style="vertical-align: middle;">강남구</span></a></li>
	        <li><a href="${ path }/views/account/login.jsp">로그인</a></li>
	        <li><a href="${ path }//views/account/createAccount.jsp">회원가입</a></li>
	    </ul>
		</nav>
	</header>