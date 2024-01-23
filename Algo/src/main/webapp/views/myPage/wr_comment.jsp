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
            <div class="content">
                <form action="" name="sidebar">
                    <div id="mySideBar"></div>
                </form>
                <form action="" name="content">
                    <div class="mp_box">
                        <div class="w_content_box">
                                <h3>작성한 댓글</h3>
                            <table class="w_board_case">
                                    <thead class="w_dm_t">
                                        <th class="w_dm_cb"></th>
                                        <th class="w_dm_co">내용</th>
                                        <th class="w_dm_da">작성일</th>
                                        <th class="w_dm_ct">게시판</th>
                                        <th class="w_dm_re">추천수</th>
                                    </thead>
                                    <tr class="w_dm_d">
                                        <td class="w_dm_cb"><input type="checkbox" name="wc_cb" id="wc_cb"></td>
                                        <td class="w_dm_co"><a href="${ path }">프로토 타입 완성,전기 자동차로 해양을 가로...</a></td>
                                        <td class="w_dm_da">2023.08.01</td>
                                        <td class="w_dm_ct">알고TALK</td>
                                        <td class="w_dm_re">50</td>
                                    </tr>
                                    <tr class="w_dm_d">
                                        <td class="w_dm_cb"><input type="checkbox" name="wc_cb" id="wc_cb"></td>
                                        <td class="w_dm_co"><a href="${ path }">프로토 타입 완성,전기 자동차로 해양을 가로...</a></td>
                                        <td class="w_dm_da">2023.08.01</td>
                                        <td class="w_dm_ct">알고TALK</td>
                                        <td class="w_dm_re">50</td>
                                    </tr>
                                    <tr class="w_dm_d">
                                        <td class="w_dm_cb"><input type="checkbox" name="wc_cb" id="wc_cb"></td>
                                        <td class="w_dm_co"><a href="${ path }">프로토 타입 완성,전기 자동차로 해양을 가로...</a></td>
                                        <td class="w_dm_da">2023.08.01</td>
                                        <td class="w_dm_ct">알고TALK</td>
                                        <td class="w_dm_re">50</td>
                                    </tr>
                                    <tr class="w_dm_d">
                                        <td class="w_dm_cb"><input type="checkbox" name="wc_cb" id="wc_cb"></td>
                                        <td class="w_dm_co"><a href="${ path }">프로토 타입 완성,전기 자동차로 해양을 가로...</a></td>
                                        <td class="w_dm_da">2023.08.01</td>
                                        <td class="w_dm_ct">알고TALK</td>
                                        <td class="w_dm_re">50</td>
                                    </tr>
                                    <tr class="w_dm_d">
                                        <td class="w_dm_cb"><input type="checkbox" name="wc_cb" id="wc_cb"></td>
                                        <td class="w_dm_co"><a href="${ path }">프로토 타입 완성,전기 자동차로 해양을 가로...</a></td>
                                        <td class="w_dm_da">2023.08.01</td>
                                        <td class="w_dm_ct">알고TALK</td>
                                        <td class="w_dm_re">50</td>
                                    </tr>
                                    <tr class="w_dm_d">
                                        <td class="w_dm_cb"><input type="checkbox" name="wc_cb" id="wc_cb"></td>
                                        <td class="w_dm_co"><a href="${ path }">프로토 타입 완성,전기 자동차로 해양을 가로...</a></td>
                                        <td class="w_dm_da">2023.08.01</td>
                                        <td class="w_dm_ct">알고TALK</td>
                                        <td class="w_dm_re">50</td>
                                    </tr>
                                    <tr class="w_dm_d">
                                        <td class="w_dm_cb"><input type="checkbox" name="wc_cb" id="wc_cb"></td>
                                        <td class="w_dm_co"><a href="${ path }">프로토 타입 완성,전기 자동차로 해양을 가로...</a></td>
                                        <td class="w_dm_da">2023.08.01</td>
                                        <td class="w_dm_ct">알고TALK</td>
                                        <td class="w_dm_re">50</td>
                                    </tr>
                                    <tr class="w_dm_d">
                                        <td class="w_dm_cb"><input type="checkbox" name="wc_cb" id="wc_cb"></td>
                                        <td class="w_dm_co"><a href="${ path }">프로토 타입 완성,전기 자동차로 해양을 가로...</a></td>
                                        <td class="w_dm_da">2023.08.01</td>
                                        <td class="w_dm_ct">알고TALK</td>
                                        <td class="w_dm_re">50</td>
                                    </tr>
                                    <tr class="w_dm_d">
                                        <td class="w_dm_cb"><input type="checkbox" name="wc_cb" id="wc_cb"></td>
                                        <td class="w_dm_co"><a href="${ path }">프로토 타입 완성,전기 자동차로 해양을 가로...</a></td>
                                        <td class="w_dm_da">2023.08.01</td>
                                        <td class="w_dm_ct">알고TALK</td>
                                        <td class="w_dm_re">50</td>
                                    </tr>
                                    <tr class="w_dm_d">
                                        <td class="w_dm_cb"><input type="checkbox" name="wc_cb" id="wc_cb"></td>
                                        <td class="w_dm_co"><a href="${ path }">프로토 타입 완성,전기 자동차로 해양을 가로...</a></td>
                                        <td class="w_dm_da">2023.08.01</td>
                                        <td class="w_dm_ct">알고TALK</td>
                                        <td class="w_dm_re">50</td>
                                    </tr>
                                    
                            </table>
                            <div class="pagging">
                                <!-- 앞/뒤 이동 버튼 구현할것 -->
                                <div class="prev_page" id="prev_page"><a href="${ path}"><</a></div>
                                <div class="pages">
                                    <span class="active"><a href="">1</a></span>
                                    <span><a href="">2</a></span>
                                    <span><a href="">3</a></span>
                                    <span><a href="">4</a></span>
                                    <span><a href="">5</a></span>
                                </div>
                                <!-- 앞/뒤 이동 버튼 구현할것 -->
                                <div class="next_page" id="next_page"><a href="${ path}">></a></div>
                            </div>
                            <!-- 글 삭제 구현 할것 -->
                            <button id="wc_btn2" class="wc_btn2" value="댓글 삭제">댓글 삭제</button>
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