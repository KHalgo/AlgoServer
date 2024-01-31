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
	<link rel="stylesheet" href="${ path }/resources/css/board/talkBoard.css">  
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="/views/common/header.jsp" />
	
	<!-- 내용 넣기 -->
	<main>
        <!--1. 알고Q&A 배너  -->
        <section>
            <div class="banner-navi"> <a href="${ path }/home">홈</a> &nbsp;&nbsp; &gt; &nbsp;&nbsp; <a href="${ path }/talkBoard/">커뮤니티</a> &nbsp;&nbsp; &gt; &nbsp;&nbsp; <a href="${ path }/qnaBoard/">알고 Q&A</a> </div>
            <div class="banner">
                <div class="banner-txt">
                    <h1>알고 Q&A</h1>
                    <p><span>알바는 알고하자!</span> 아르바이트 관련 모든 질문을 자유롭게 주고 받는 공간</p>
                </div>
                <img src="https://i.ibb.co/W2SPj6c/qna.png" width="107px"></div>
            </div>
        </section>
    
        <!-- 2. search 창 -->
        <section>
            <div class="searchBox">
                <button class="board_btn1" onclick="location.href='${ path }/qnaBoard/qnaWrite';">글쓰기</button>
                <form class="searching">
                    <select class="box1" name="" id="" style="background: url(https://i.ibb.co/N9HPzF3/list-arrow.png) no-repeat right 7px center;">
                        <option>말머리없음</option>
                    </select>
                    <input class="box2" type="search" placeholder="본문+제목 검색">
                    <input class="board_btn2" type="submit" value="검색">
                </form>
            </div>
        </section>
        <!-- 3. 게시판 목록 창 -->
        <section>
            <!-- 3-1) 전체 글 count -->
            <div class="list-top">
                <p class="total">
                    전체 글 <span>${ listCount }</span>개
                </p>
            </div>
            <!-- 3-2) 게시판 글 목록 -->
            <div class="board_list_wrap">
                <table class="board_list">
                    <caption>게시판 목록</caption>
                    <thead>
                        <tr>
                            <th>글번호</th>
                            <th>제목</th>
                            <th>닉네임</th>
                            <th>작성일</th>
                            <th>조회</th>
                            <th>추천</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr class="notice">
                            <td>
                                <img src="https://i.ibb.co/whGDStd/notice-img.png" class="noticeImg">
                            </td>
                            <td class="noticeImg">
                                <a href="#"><b>공지사항 1</b></a>
                            </td>
                            <td><b>알고지기</b></td>
                            <td>2023-08-16</td>
                            <td>15421</td>
                            <td></td>
                        </tr>
                        <tr class="notice">
                            <td>
                                <img src="https://i.ibb.co/whGDStd/notice-img.png" class="noticeImg">
                            </td>
                            <td>
                                <a href="#"><b>공지사항 2</b></a>
                            </td>
                            <td><b>알고지기</b></td>
                            <td>2023-09-22</td>
                            <td>16487</td>
                            <td></td>
                        </tr>
                        
                        <c:if test="${ empty list }">
	                        <tr>
	                        	<td colspan="6">
	                        	조회된 게시글이 없습니다.
	                        	</td>
	                        </tr>                        
                        </c:if>
                        
                        <c:if test="${ not empty list }">
                        	<c:forEach var="board" items="${ list }">
	                        	<tr>
		                            <td>${ board.rowNum }</td>
		                            <td>
		                                <a href="${ path }/qnaBoard/qnaPost?no=${board.postNo}">
		                                	${ board.postTitle }
		                                </a>
		                            </td>
		                            <td>${ board.writerId }</td>
		                            <td>${ board.postDate }</td>
		                            <td>${ board.postViewCount }</td>
		                            <td>${ board.postLikeCount }</td>
		                        </tr>
                        	</c:forEach>                        
                        </c:if>
                    </tbody>
                </table>
                <!-- 3-3) 목록 페이지 넘버 -->
                <div class="pagging">
                	<!-- 이전 페이지로 -->
                	<button class="prev_page" onclick="location.href='${ path }/qnaBoard/?page=${ pageInfo.prevPage }'">&lt;</button>
                    <!-- 5개 페이지 목록 -->
					<c:forEach var="current" begin="${ pageInfo.startPage }" end="${ pageInfo.endPage }">
						<c:choose>
							<c:when test="${ current == pageInfo.currentPage }">
								<button disabled>${ current }</button>
							</c:when>
							
							<c:otherwise>
								<button onclick="location.href='${ path }/qnaBoard/?page=${ current }'">${ current }</button>
							</c:otherwise>
						</c:choose>
					
					</c:forEach>
 
                    <!-- 다음 페이지로 -->
                    <button class="next_page" onclick="location.href='${ path }/qnaBoard/?page=${ pageInfo.nextPage }'">&gt;</button>
                </div>
            </div>
        </section>
    </main>
    
    <!-- 푸터 -->
   <jsp:include page="/views/common/footer.jsp" /> 
   
	<!--js 추가-->
	<script type="text/javascript" src="${ path }/resources/js/top.js"></script>
</body>
</html>