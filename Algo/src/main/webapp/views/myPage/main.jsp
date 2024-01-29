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
            <form action="" name="sidebar">
                <div id="mySideBar"></div>
            </form>
            <form action="" name="content">
                <div class="content">
                    <div class="mp_box">
                        <!-- <h2>${"userName"}님 어서 오세요</h2> -->
                        <h2 id="mp_h2">${ loginMember.userName }님 어서 오세요</h2>
                        <div class="prBox1">
                            <p class="pr_lText">게시글 관리</p>
                            <div class="prBox1_hr"></div>
                            <div class="mp_content_m_box">
                                <p><a href="#">1</a><br>작성한 기업 리뷰</p>
                            </div>
                            <div class="mp_content_m_box">
                                <div>
                                    <p><a href="#">2</a><br>작성한 게시글</p>
                                </div>
                            </div>
                            <div class="mp_content_m_box">
                                <p><a href="#">3</a><br>작성한 댓글</p>
                            </div>
                            <div class="mp_content"></div>
                        </div>
                        <div class="prBox2" style="float: left">
                            <span><p class="pr_lText">지역 설정</p></span>
                            <div class="more pr_more"><a href="">+ MORE</a></div>
                            <div class="mp_content_box">
                                <div class="mp_content_text">
                                    <p style="padding-top: 0px">현재 ${ loginMember.userName }님의 지역은</p>
                                    <a href="" style="font-weight: bold">${ loginMember.sido } ${ loginMember.sigungu }</a>
                                    <p>입니다.</p>
                                </div>
                            </div>
                        </div>
                        <div class="prBox2" style="float: right">
                            <div class="pr_lTitle">
                                <span><p class="pr_lText">1:1 문의</p></span>
                                <div class="more pr_more"><a href="">+ MORE</a></div>
                                <div class="mp_content_box">
                                    <div class="mp_dm">
                                        <a href="">
                                            <span class="mp_dm_ti">최근에 본 좋은 영화 있어요?</span>
                                            <span class="mp_dm_de">2023.12.15</span>
                                        </a>
                                    </div>

                                    <div class="mp_dm">
                                        <a href="">
                                            <span class="mp_dm_ti">최근에 본 좋은 영화 있어요?</span>
                                            <span class="mp_dm_de">2023.12.15</span>
                                        </a>
                                    </div>

                                    <div class="mp_dm">
                                        <a href="">
                                            <span class="mp_dm_ti">최근에 본 좋은 영화 있어요?</span>
                                            <span class="mp_dm_de">2023.12.15</span>
                                        </a>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </section>
    </main>
    <!-- 푸터 -->
    <footer>
        <div id="footers"></div>
    </footer>
    <script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script type="text/javascript" src="../js/main.js"></script>
    <script type="text/javascript" src="../js/my_page/myPage_sideBar.js"></script>
</body>
</html>