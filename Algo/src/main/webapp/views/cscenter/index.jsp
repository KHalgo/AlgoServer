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
	<link rel="stylesheet" href="${ path }/resources/css/cscenter/index.css">  
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="/views/common/header.jsp" />
	
	<!-- 내용 넣기 -->
	<main>
        <div class="bar-box">
            <section>
                <!-- 1. cs 메인 창  -->
                <div class="cs-board-box">
                    <h2 class="cs">고객센터</h2>
                    <!-- 1-1) 자주하는 질문 -->
                    <div class="cs-qna">
                        <div class="cs-qna-h">
                            <h4>자주하는 질문</h4>
                            <div class="more">
                                <a href="${ path }/cscenter/qna">+ MORE</a>
                            </div>
                        </div>
                        <table class="cs-qna-list">
                            <tbody>
                                <c:forEach var="cscenter" items="${listQ}" varStatus="status">
								    <c:if test="${ status.count < 5}">
									    <tr>
									        <td>
									            <a href="${ path }/cscenter/qna">${ cscenter.csTitle }</a>
									        </td>
									    </tr>
								    </c:if>
								</c:forEach>
                            </tbody>
                        </table>
                    </div>
                    
                    <div class="cs-bottom">
                        <!-- 1-2) 공지사항 -->
                        <div class="cs-notice">
                            <div class="cs-notice-h">
                                <h4>공지사항</h4>
                                <div class="more">
                                    <a href="${ path }/cscenter/notice">+ MORE</a>
                                </div>
                            </div>
                            <table class="cs-notice-list">
                                <tbody>
                                	<c:forEach var="cscenter" items="${ listN }" varStatus="status">
	                                    <c:if test="${status.count < 4}">
		                                    <tr>
		                                        <td>
		                                            <a class="cs-a" href="${ path }/cscenter/noticeDetail?no=${ cscenter.csNo }" >${ cscenter.csTitle }</a>
		                                        </td>
		                                        <td>${ cscenter.csCreateDate }</td>
		                                    </tr>
									    </c:if>
                                	</c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <c:if test="${ not empty loginMember }">
                        <!-- 1-3) 나의 문의 내역 -->
	                        <div class="cs-my">
	                            <div class="cs-notice-h">
	                                <h4>나의 문의 내역</h4>
	                                <div class="more">
	                                    <a href="${ path }/myPage/inquiryLog">+ MORE</a>
	                                </div>
	                            </div>
	                            <table class="cs-notice-list">
	                                <tbody>
	                                    <tr>
	                                        <td>
	                                            <a class="cs-a" href="#">글제목이들어갑니다글제목이들어갑니다</a>
	                                        </td>
	                                        <td>2024.01.01</td>
	                                    </tr>
	                                    <tr>
	                                        <td>
	                                            <a href="#">글제목</a>
	                                        </td>
	                                        <td>2024.01.01</td>
	                                    </tr>
	                                    <tr>
	                                        <td>
	                                            <a href="#">글제목</a>
	                                        </td>
	                                        <td>2024.01.01</td>
	                                    </tr>
	                                </tbody>
	                            </table>
	                        </div>
                        </c:if>
                    </div>
                </div>
            </section>
            <!-- 사이드바 메뉴 창 -->
            <section>
                <aside class="sidebar">
                    <ul>
                        <li class="s-first">
                            <a href="${ path }/cscenter/" >고객센터 홈</a>
                        </li>
                        <li>
                            <a href="${ path }/cscenter/notice">공지사항</a>
                        </li>
                        <li>
                            <a href="${ path }/cscenter/qna">자주하는 질문</a>
                        </li>
                    </ul>
                </aside>
            </section>
        </div>
    </main>
    
     <!-- 푸터 -->
   <jsp:include page="/views/common/footer.jsp" /> 
   
	<!--js 추가-->
	<script type="text/javascript" src="${ path }/resources/js/top.js"></script>

</body>
</html>