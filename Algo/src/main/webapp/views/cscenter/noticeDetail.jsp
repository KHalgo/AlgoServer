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
	<link rel="stylesheet" href="${ path }/resources/css/cscenter/noticeDetail.css">  
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="/views/common/header.jsp" />
	
	<!-- 내용 넣기 -->
	<main>
        <div class="bar-box">
            <section>
                <!-- 공지사항 페이지 창  -->
                <div class="cs-board-box">
                    <h2>공지사항</h2>
                    <table class="noticeBox">
                        <tr>
                            <td class="title">${ cscenter.csTitle }</td>
                        </tr>
                        <tr>
                            <td class="writeInfo"><b>알고지기</b> &nbsp; &#124; &nbsp; ${ cscenter.csCreateDate }</td>
                        </tr>
                        <tr>
                            <td class="content">
                                ${ cscenter.csContent }
                            </td>
                        </tr>
                    </table>
                    <div class="noticeList">
                        <button class="algo_btn1" onclick="location.href='${ path }/cscenter/notice'">목록</button>
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