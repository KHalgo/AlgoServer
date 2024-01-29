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
        <!-- 2. 알고Q&A 글쓰기 페이지 -->
        <form action="${ path }/qnaBoard/update" method="POST" enctype="multipart/form-data">
        	<input type="hidden" name="no" value="${ board.postNo }">
        <section>
            <table class="writeBoard">
                <tr>
                    <th>닉네임</th>
                    <td>${ loginMember.userNick }</td>
                    <th>말머리</th>
                    <td>
                        <select name="" id="" style="background: url(https://i.ibb.co/N9HPzF3/list-arrow.png) no-repeat right 7px center;">
                            <option value="">말머리없음</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>아이디</th>
                    <td>${ loginMember.userId }</td>
                    <th>지역 설정</th>
                    <td>
                        <select name="" id="" style="background: url(https://i.ibb.co/N9HPzF3/list-arrow.png) no-repeat right 7px center;">
                            <!-- DB관련? -->
                            <option value="">관심지역1</option>
                            <option value="">관심지역2</option>
                            <option value="">관심지역3</option>
                            <option value="">관심지역4</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>제목</th>
                    <td colspan="3">
                        <input type="text" name="title" id="" class="title" placeholder="제목을 입력하시오." value="${ board.postTitle }">
                    </td>
                </tr>
                <tr>
                    <td class="contentBox" colspan="4">
                        <textarea name="content" id="" class="content" placeholder="무분별한 비방 및 욕설, 유해 사이트 홍보 등은 무통보 삭제 후 사이트 이용 제한 처리됩니다.">${ board.postContent }</textarea>
                    </td>
                </tr>
                <tr>
                    <th>첨부파일 1</th>
                    <td>
                        <input type="file" name="upfile1" id="">
	                        <c:if test="${ not empty board.postFile1 }">
	                        	<span>${ board.postFile1 }</span>
	                        </c:if>
                    </td>
                    <th>첨부파일 2</th>
                    <td>
                        <input type="file" name="" id="">
                    </td>
                </tr>
                <tr>
                    <th>첨부파일 3</th>
                    <td>
                        <input type="file" name="" id="">
                    </td>
                    <th>첨부파일 4</th>
                    <td>
                        <input type="file" name="" id="">
                    </td>
                </tr>
            </table>
        </section>
        <!-- 3. 하단 버튼 -->
        <section>
            <div class="buttons">
                <button type="submit" class="algo_btn1">완료</button>
                <button type="button" id="listButton" class="algo_btn2" onclick="location.href='${ path}/qnaBoard/';">취소</button>
            </div>
        </section>   
        </form>
        <script type="text/javascript">
	       	let listButton = document.getElementById('listButton');
	       	listButton.onclick = function() {
	       		location.href='${ path }/qnaBoard/';
	       	}
	    </script>
	</main>
	<!-- 푸터 -->
   <jsp:include page="/views/common/footer.jsp" /> 
   
	<!--js 추가-->
	<script type="text/javascript" src="${ path }/resources/js/top.js"></script>

</body>
</html>