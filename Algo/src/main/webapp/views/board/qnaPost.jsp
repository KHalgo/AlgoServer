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
	<link rel="stylesheet" href="${ path }/resources/css/board/qnaPost.css">  
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
        <!-- 2. 알고 Q&A 게시글 -->
        <section>
            <table class="postBoard">
                <tr>
                    <th colspan="2">${ board.postTitle }</th>
                </tr>
                <tr style="border-bottom: 1px solid #C0C0C0;">
                    <td>${ board.userNick }&nbsp; &#124; &nbsp;${ board.sido }&nbsp; &gt; &nbsp;${ board.sigungu }&nbsp; &#124; &nbsp;${ board.postDate }</td>
                    <td class="write-r">
                        조회&nbsp;${ board.postViewCount }&nbsp; &#124; &nbsp;추천&nbsp;${ board.postLikeCount }&nbsp; &#124; &nbsp;<a href="#">신고</a>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" class="content">
                        <p>${ board.postContent }</p>
                    </td>
                </tr>
                
                <!-- 추천 버튼 -->
                <tr class="likeButton" style="border-bottom: 1px solid #C0C0C0;">
                    <td colspan="2">
                        <button class="algo_btn2">추천해요</button>
                    </td>
                </tr>
                
                <tr>
                	<td colspan="2">
                		<c:if test="${ empty board.postFile1 }">
                			첨부파일 : <span>  </span>
                		</c:if>
                		<a href="javascript:" id="fileDown">
	                		<c:if test="${ not empty board.postFile1 }">
	                			첨부파일 : <span> ${ board.postFile1 } </span>
	                		</c:if>
                		</a>
                	</td>
                </tr>
                
                <!--  댓글 입력 -->
                <tr style="border-bottom: 1px solid #C0C0C0;">
	                <form action="${ path }/qnaBoard/reply" method="POST">
	                	<td colspan="2">
	                		<input type="hidden" name="postNo" value="${ board.postNo }">
	                		<textarea name="content" id="replyContent" placeholder="댓글을 입력하시오."></textarea>
	                		<button type="submit" id="btn-insert" class="algo_btn3">댓글</button>
	                	</td>
	                </form>
                </tr>
                
                <!-- 댓글 목록 -->
                <tr style="border-bottom: 1px solid #C0C0C0;">
                    <td colspan="2">댓글</td>
                </tr>
                
                 
                <c:if test="${ empty board.replies }">
                	<td>등록된 댓글이 없습니다.</td>
                </c:if>
                
                
                <c:if test="${ not empty board.replies }">
	                <c:forEach var="reply" items="${ board.replies }">
		                <tr>
		                    <td><b><c:out value="${ reply.writerId }"></c:out></b>&nbsp; &#124; &nbsp;<span><c:out value="${ reply.commentDate }"></c:out> </span></td>
		                    <td class="write-r">
		                        <button class="like">추천(0)</button>
		                        <button class="reply">답글</button>
		                        <button class="report">신고</button>
		                    </td>
		                </tr>
		                <tr style="border-bottom: 1px solid #C0C0C0;">
		                    <td colspan="2"><c:out value="${ reply.commentContent }"/> </td>
		                </tr>
	                </c:forEach>
                </c:if> 
            </table>
        </section>
        <!-- 3. 목록 버튼 -->
        <section class="boardList">
        	<!-- 포스팅한 유저에게만 노출되는 수정, 삭제 버튼 -->
        	<c:if test="${ not empty loginMember and loginMember.userId == board.writerId }">
	  	      	<button type="button" onclick="location.href='${path}/qnaBoard/update?no=${ board.postNo }'" class="algo_btn1">수정</button>
	        	<button type="button" class="algo_btn2" id="btnDelete">삭제</button>
        	</c:if>
            <button class="algo_btn1" onclick="location.href='${ path }/qnaBoard/';">목록</button>
        </section>
	</main>
	
	<script type="text/javascript">
			$(document).ready(() => {
				$('#btnDelete').on('click', () => {
					if (confirm('게시글을 삭제 하시겠습니까?')) {
						location.replace('${ path }/qnaBoard/delete?no=${ board.postNo }');
					}
				});
				
				$('#replyContent').on('click', () => {
					if(${ empty loginMember }) {
						alert("로그인 후 이용해주세요.");
						
						$("#userId").focus();				
					}
				});
			});
		</script>
	
	<!-- 푸터 -->
   <jsp:include page="/views/common/footer.jsp" /> 
   
	<!--js 추가-->
	<script type="text/javascript" src="${ path }/resources/js/top.js"></script>
</body>
</html>