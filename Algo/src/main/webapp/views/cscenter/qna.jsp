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
	<link rel="stylesheet" href="${ path }/resources/css/cscenter/qna.css">  
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="/views/common/header.jsp" />

	<!-- 내용 넣기 -->
	<main>
        <div class="bar-box">
            <!--자주하는 질문 메인 창  -->
            <section>
                <div class="cs-board-box">
                    <div class="cs-board-h">
                        <h2>자주하는 질문</h2>
                        <form class="searching">
	                        <c:if test="${ not empty loginMember && loginMember.userId == 'admin' }">
							    <button type="button" class="algo_btn1" id="cscenterwritter" onclick="location.href='${ path }/cscenter/writter'">글 쓰기</button>
							</c:if>
                            <input class="box2" type="search" placeholder="본문+제목 검색">
                            <input class="board_btn2" type="submit" value="검색">
                        </form>
                    </div>
                    <table class="board_list">
                        <thead>
                            <tr>
                                <th width="10%"></th>
                                <th width="50%" style="padding-left: 20px;">제목</th>
                                <th width="25%">작성일</th>
                                <th width="15%">조회</th>
                            </tr>
                        </thead>
                        <tbody>
					        <c:forEach var="cscenter" items="${list}">
					            <tr>
					                <td><img src="https://i.ibb.co/N9HPzF3/list-arrow.png" class="toggleButton" data-target="answerBox${cscenter.csNo}"></td>
					                <td class="question" id="qTitle${ cscenter.csNo }"><p>${cscenter.csTitle}</p></td>
					                <td>${cscenter.csCreateDate}</td>
					                <td>${cscenter.csView}</td>
					            </tr>
					            <tr class="answerBox" id="answerBox${cscenter.csNo}">
					                <td colspan="4">
					                	<br>
					                    <div style="font-weight: bold">${cscenter.csTitle}</div>
					                    <br><br>
					                    <h4>알고지기의 답변</h4>
					                    <br>
					                    <div>${cscenter.csContent}</div>
					                    <br>
					                </td>
					            </tr>
					        </c:forEach>
                        </tbody>
                    </table>
                <div class="pagging">
                	<!-- 이전 페이지로 -->
                	<button class="prev_page" onclick="location.href='${ path }/cscenter/qna?page=${ pageInfo.prevPage }'">&lt;</button>
                    <!-- 5개 페이지 목록 -->
					<c:forEach var="current" begin="${ pageInfo.startPage }" end="${ pageInfo.endPage }">
						<c:choose>
							<c:when test="${ current == pageInfo.currentPage }">
								<button disabled>${ current }</button>
							</c:when>
							
							<c:otherwise>
								<button onclick="location.href='${ path }/cscenter/qna?page=${ current }'">${ current }</button>
							</c:otherwise>
						</c:choose>
					</c:forEach>
                    <!-- 다음 페이지로 -->
                    <button class="next_page" onclick="location.href='${ path }/cscenter/qna?page=${ pageInfo.nextPage }'">&gt;</button>
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
	<script type="text/javascript" src="${ path }/resources/js/cscenter/cscenter.js"></script>
</body>
</html>