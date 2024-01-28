<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
	<link rel="stylesheet" href="${ path }/resources/css/cscenter/notice.css">  
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="/views/common/header.jsp" />
	<!-- 내용 넣기 -->
	<main>
        <div class="bar-box">
            <!-- 공지사항 메인 창  -->
            <section>
                <div class="cs-board-box">
                    <div class="cs-board-h">
                        <h2>공지사항</h2>
                        <form class="searching">
                        <c:if test="${ not empty loginMember && cscenter.csWriterId == 'admin' }">
                        	<button class="algo_btn1" id="cscenterwritter">글 쓰기</button>
                        </c:if>
                            <input class="box2" type="search" placeholder="본문+제목 검색">
                            <input class="board_btn2" type="submit" value="검색">
                        </form>
                    </div>
                    <table class="board_list">
                        <thead>
                            <tr>
                                <th width="50%" style="padding-left: 50px;">제목</th>
                                <th widtd="30%">작성일</th>
                                <th width="20%">조회</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${ empty list }">
	                            <tr>
	                            <td colspan="3">
	                           		조회된 게시글이 없습니다.
	                            </td>
	                            </tr>
                            </c:if>
                            <c:if test="${ not empty list }">
	                            <c:forEach var="cscenter" items="${ list }">
									<tr>
		                               <td>
		                                   <a href="${ path }/cscenter/noticeDetail?no=${ cscenter.csNo }" >
		                                   		${ cscenter.csTitle }
		                                   </a>
		                               </td>
		                               <td><fmt:formatDate value="${ cscenter.csCreateDate }" dateStyle="default"/></td>
		                               <td>${ cscenter.csView }</td>
									</tr>
	                            </c:forEach>
                            </c:if>
                        </tbody>
                    </table>
                    <!-- 3-3) 목록 페이지 넘버 -->
                    <div class="pagging">
                	<!-- 이전 페이지로 -->
	                	<button class="prev_page" onclick="location.href='${ path }/cscenter/notice?page=${ pageInfo.prevPage }'">&lt;</button>
	                    <!-- 5개 페이지 목록 -->
						<c:forEach var="current" begin="${ pageInfo.startPage }" end="${ pageInfo.endPage }">
							<c:choose>
								<c:when test="${ current == pageInfo.currentPage }">
									<button disabled>${ current }</button>
								</c:when>
								
								<c:otherwise>
									<button onclick="location.href='${ path }/cscenter/notice?page=${ current }'">${ current }</button>
								</c:otherwise>
							</c:choose>
						</c:forEach>
	                    <!-- 다음 페이지로 -->
	                    <button class="next_page" onclick="location.href='${ path }/cscenter/notice?page=${ pageInfo.nextPage }'">&gt;</button>
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