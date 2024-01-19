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
            <div class="iql_content">
                <form action="" name="sidebar">
                    <div id="mySideBar"></div>
                </form>
                <form action="" name="content">
                    <div class="iql_content_box">
                        <div>
                            <h3>1:1 문의 내역</h3>
                            <button id="iqlQG" value="문의 하기" onclick="location.href='${ path }/myPage/question'">문의 하기</button>
                        </div>
                        <div class="iql_board">
                            <h4>나의 문의 내역</h4>
                            <table class="iql_board_case">
                                <tr class="iql_board_dm">
                                    <td class="iql_board_dmT"><a href="${ path }/myPage/inquiry/answer">닉네임을 변경하고 싶은데 어떻게 하면 될까요?</a></td>
                                    <td class="iql_board_dmD">2023.12.15</td>
                                    <td><button id="iql_board_dmY" value="답변 대기중">답변 대기중</button></td>
                                </tr>
                                <tr class="iql_board_dm">
                                    <td class="iql_board_dmT"><a href="${ path }/myPage/inquiry/answer">닉네임을 변경하고 싶은데 어떻게 하면 될까요?</a></td>
                                    <td class="iql_board_dmD">2023.12.14</td>
                                    <td><button id="iql_board_dmN" value="답변 완료">답변 완료</button></td>
                                </tr>
                                <tr class="iql_board_dm">
                                    <td class="iql_board_dmT"><a href="${ path }/myPage/inquiry/answer">닉네임을 변경하고 싶은데 어떻게 하면 될까요?</a></td>
                                    <td class="iql_board_dmD">2023.12.14</td>
                                    <td><button id="iql_board_dmN" value="답변 완료">답변 완료</button></td>
                                </tr>
                                <tr class="iql_board_dm">
                                    <td class="iql_board_dmT"><a href="${ path }/myPage/inquiry/answer">어제 새로운 카페를 발견했다.. 바로가자</a></td>
                                    <td class="iql_board_dmD">2023.12.14</td>
                                    <td><button id="iql_board_dmN" value="답변 완료">답변 완료</button></td>
                                </tr>
                                <tr class="iql_board_dm">
                                    <td class="iql_board_dmT"><a href="${ path }/myPage/inquiry/answer"><p>새로운 레시피를 시도해봤는데.. 맛 없어서 혼났음</p>
                                    </a></td>
                                    <td class="iql_board_dmD">2023.12.14</td>
                                    <td><button id="iql_board_dmN" value="답변 완료">답변 완료</button></td>
                                </tr>
                                <tr class="iql_board_dm">
                                    <td class="iql_board_dmT"><a href="${ path }/myPage/inquiry/answer">닉네임을 변경하고 싶은데 어떻게 하면 될까요?</a></td>
                                    <td class="iql_board_dmD">2023.12.14</td>
                                    <td><button id="iql_board_dmN" value="답변 완료">답변 완료</button></td>
                                </tr>
                                <tr class="iql_board_dm">
                                    <td class="iql_board_dmT"><a href="${ path }/myPage/inquiry/answer">아 디자인 공부를 어디서 해야할 지 모르겠다..</a></td>
                                    <td class="iql_board_dmD">2023.12.14</td>
                                    <td><button id="iql_board_dmN" value="답변 완료">답변 완료</button></td>
                                </tr>
                                <tr class="iql_board_dm">
                                    <td class="iql_board_dmT"><a href="${ path }/myPage/inquiry/answer">지역 설정을 여러개 한 번에 하고 싶은데 어떻...</a></td>
                                    <td class="iql_board_dmD">2023.12.14</td>
                                    <td><button id="iql_board_dmN" value="답변 완료">답변 완료</button></td>
                                </tr>
                                <tr class="iql_board_dm">
                                    <td class="iql_board_dmT"><a href="${ path }/myPage/inquiry/answer">닉네임을 변경하고 싶은데 어떻게 하면 될까요?</a></td>
                                    <td class="iql_board_dmD">2023.12.14</td>
                                    <td><button id="iql_board_dmN" value="답변 완료">답변 완료</button></td>
                                </tr>
                                <tr class="iql_board_dm">
                                    <td class="iql_board_dmT"><a href="${ path }/myPage/inquiry/answer">닉네임을 변경하고 싶은데 어떻게 하면 될까요?</a></td>
                                    <td class="iql_board_dmD">2023.12.14</td>
                                    <td><button id="iql_board_dmN" value="답변 완료">답변 완료</button></td>
                                </tr>
                                
                            </table>
                                <div class="pagging" id="iq_log_p">
                                    <!-- 앞/뒤 이동 버튼 구현할것 -->
                                <div class="prev_page" id="prev_page"><a href="${ path}"><</a></div>
                                <div class="pages">
                                    <span class="active"><a href="#">1</a></span>
                                    <span><a href="#">2</a></span>
                                    <span><a href="#">3</a></span>
                                    <span><a href="#">4</a></span>
                                    <span><a href="#">5</a></span>
                                </div>
                                <!-- 앞/뒤 이동 버튼 구현할것 -->
                                <div class="next_page" id="next_page"><a href="${ path}">></a></div>
                                </div>
                            </div>
                        </form>
                    </div>
            </div>
        </section>
	</main>
	
    <!-- 푸터 -->
   <jsp:include page="/views/common/footer.jsp" /> 
   
	<!--js 추가-->
	<script type="text/javascript" src="${ path }/resources/js/top.js"></script>
	<script type="text/javascript" src="${ path }/resources/js/myPage/myPage_sideBar.js"></script>	
</body>
</html>