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
	<title>지역 검색</title>
	<link rel="stylesheet" href="${ path }/resources/css/common.css">  
	<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	

	<!-- css 추가 -->
	<link rel="stylesheet" href="${ path }/resources/css/mypage/myPage.css">
	

</head>
<body>
	<main>
		<section>
			<form action="">
				<div class="lw_content">
                    <h3 style="font-weight: bold">지역 검색</h3>
                    <div class="lw_search">
                        <input type="search" name="lm_search" id="lm_search_input" placeholder="원하는 지역을 입력해주세요">
                        <button id="ls_btn1"><img id="ls_img1" src="https://i.ibb.co/ByBFcyt/search.png" alt="" width="25px" ></button>
                    </div>
                    <div class="lm_table lw_table">
                        <table>
                            <tr class="lm_tr">
                                <tr>
                                    <td class="lw_td" >
                                        <img src="https://i.ibb.co/HhQ0sDr/location-logo.png" width="24px" height="24px" alt="">
                                        <div class="lw_dm"><a href="">서울시 강남구</a></div>
                                        <img src="https://i.ibb.co/V97jmW2/yellow-heart.png" width="24px" height="24px" alt="">
                                    </td>
                                    <td class="lw_td" >
                                        <img src="https://i.ibb.co/HhQ0sDr/location-logo.png" width="24px" height="24px" alt="">
                                        <div class="lw_dm"><a href="">서울시 강남구</a></div>
                                        <img src="https://i.ibb.co/v34CvHX/yellow-heart-empty.png" width="24px" height="24px" alt="">
                                    </td>
                                    <td class="lw_td" >
                                        <img src="https://i.ibb.co/HhQ0sDr/location-logo.png" width="24px" height="24px" alt="">
                                        <div class="lw_dm"><a href="">서울시 강남구</a></div>
                                        <img src="https://i.ibb.co/V97jmW2/yellow-heart.png" width="24px" height="24px" alt="">
                                    </td>
                                    <td class="lw_td" >
                                        <img src="https://i.ibb.co/HhQ0sDr/location-logo.png" width="24px" height="24px" alt="">
                                        <div class="lw_dm"><a href="">서울시 강남구</a></div>
                                        <img src="https://i.ibb.co/V97jmW2/yellow-heart.png" width="24px" height="24px" alt="">
                                    </td>
                            </tr>
                        </table>
                    </div>
                </div>
			</form>
        </section>
	</main>
	
   
</body>
</html>