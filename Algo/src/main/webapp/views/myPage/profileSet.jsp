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
                <form action="" name="content" method="POST">
                    <div class="mp_ps_box">
                        <div style="padding: 10px">
                            <h3 class="ps_h3">프로필 관리</h3>
                            <div style="margin-top: 35px">
                                <div class="ps_imgD"><img src="" alt="" id="ps_img">
                                    <span><p id="ps_nick">${ loginMember.userName }님</p></span>
                                </div>
                            </div>
                        </div>
                        <table>
                            <tr class="ps_ct">
                                <td><input type="text" var="pr_nick" class="pr_put1" placeholder="${ loginMember.userNick }"></td>
                                <td><button class="pr_ch_box" id="pr_nick_ch" value="중복 확인">중복확인</button></td>
                                <td colspan="2"><input type="email" var="pr_email" class="pr_put2" placeholder="${ loginMember.userEmail }"></td>
                            </tr>
                            <tr class="ps_ct">
                                <td colspan="2"><input type="text" var="pr_addres" class="pr_put2" placeholder="${ loginMember.sido } ${ loginMember.sigungu }"></td>
                                <td><input type="text" var="pr_tel" class="pr_put1" placeholder="${ loginMember.userPhone }"></td>
                                <td><button class="pr_ch_box" id="pr_nick_ch" value="">인증받기</button></td>
                            </tr>
                            <tr class="ps_ct">
                                <td colspan="2"><input type="text" var="pr_b_date" class="pr_put2" placeholder="${ loginMember.userBirthday }"></td>
                                <td><input type="text" var="pr_c_number" class="pr_put1" placeholder="인증번호입력"></td>
                                <td><button class="pr_ch_box" id="pr_nick_ch" value="인증확인">인증확인</button></td>
                            </tr>
                        </table>

                        <button type="submit" id="ps_btn1" >프로필 저장</button>
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