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
	
	<!-- css 추가 -->
	<link rel="stylesheet" href="${ path }/resources/css/companyReview/company_detail.css">  

</head>
<body>
	
	<!-- 헤더 -->
	<jsp:include page="/views/common/header.jsp" />
	
	<!-- 내용 넣기 -->
	<main>
		<!-- 1. 기업리뷰 배너-->
        <section>
            <div class="banner-navi"> <a href="${ path }">홈</a> &nbsp;&nbsp; &gt; &nbsp;&nbsp; <a href="${ path }/companyReview/">기업리뷰</a></div>
            <div class="banner">
                <div class="banner-txt">
                    <h1>기업 리뷰</h1>
                    <p><span>알바는 알고하자!</span> 아르바이트 관련 기업들에 대한 후기를 보는 공간</p>
                </div>
                <img src="https://i.ibb.co/Ch8wrSg/building-banner.png" width="107px">
            </div>
        </section>

        <!-- 2. 메인 평점 -->
        <section id="co-section-2">
            <div class="co-main-box">
                <h3>${ company.industryName }</h3>
                <button onclick="location.href='${ path }/companyReview/write'">리뷰 작성</button>
            </div>
            <div class="co-main-re-box">
                <div class="co-main-re-1">
                    <span class="co-main-re-1-txt">알바 리뷰 평점</span> (<span>${ company.count }명</span>)
                    <div>
                        <div class="star_point">${ company.baseRate }</div>
                        <div class ="star_rating" id="starRate1">
                            <span class="star on" value="1"> </span>
                            <span class="star on" value="2"> </span>
                            <span class="star on" value="3"> </span>
                            <span class="star on" value="4"> </span>
                            <span class="star on" value="5"> </span>
                        </div>
                    </div>
                </div>
                <table class="co-main-re-2">
                    <tr>
                        <th>위치</th>
                        <td>${ company.industryLc }</td>
                    </tr>
                    <tr>
                        <th>업계</th>
                        <td>${ company.industryType }</td>
                    </tr>
                    <tr>
                        <th>동일업계순위</th>
                        <td>4위</td>
                    </tr>
                    <tr>
                        <th>홈페이지</th>
                        <td>${ company.industryHp }</td>
                    </tr>
                </table>
                <div class="co-main-re-3">
                    BEST 알고 한줄평
                    <c:if test="${ empty company.bestComment }">
                    	<div class="review-word-box">
                    		조회된 한줄평이 없습니다.
                    	</div>
                    </c:if>
                    <c:if test="${ not empty company.bestComment }">
	                    <div class="review-word-box">
	                        ${ company.bestComment }
	                    </div>
	                </c:if>
                </div>
            </div>
        </section>

        <!-- 3. 디테일 평점 -->
        <section class="co-main-re-box2">
            <div class="co-sub-re-1">
                평가
                <div class="sub-rate" style="margin-top:25px;">
                    <div class="sub-rate-txt">일과 삶의 균형</div>
                    <div class ="star_rating" id="starRate2">
                        <span class="star on" value="1"> </span>
                        <span class="star on" value="2"> </span>
                        <span class="star on" value="3"> </span>
                        <span class="star on" value="4"> </span>
                        <span class="star on" value="5"> </span>
                        <div class="sub_star_point">평점 ${ company.detailRate1 } </div>
                    </div>
                </div>
                <div class="sub-rate">
                    <div class="sub-rate-txt">급여 및 복지</div>
                    <div class ="star_rating" id="starRate3">
                        <span class="star on" value="1"> </span>
                        <span class="star on" value="2"> </span>
                        <span class="star on" value="3"> </span>
                        <span class="star on" value="4"> </span>
                        <span class="star on" value="5"> </span>
                        <div class="sub_star_point">평점 ${ company.detailRate2 }</div>
                    </div>
                </div>
                <div class="sub-rate">
                    <div class="sub-rate-txt">근무 분위기</div>
                    <div class ="star_rating" id="starRate4">
                        <span class="star on" value="1"> </span>
                        <span class="star on" value="2"> </span>
                        <span class="star on" value="3"> </span>
                        <span class="star on" value="4"> </span>
                        <span class="star" value="5"> </span>
                        <div class="sub_star_point">평점 ${ company.detailRate3 }</div>
                    </div>
                </div>
                <div class="sub-rate">
                    <div class="sub-rate-txt">재취업 의사</div>
                    <div class ="star_rating" id="starRate4">
                        <span class="star on" value="1"> </span>
                        <span class="star on" value="2"> </span>
                        <span class="star on" value="3"> </span>
                        <span class="star on" value="4"> </span>
                        <span class="star on" value="5"> </span>
                        <div class="sub_star_point">평점 ${ company.detailRate4 }</div>
                    </div>
                </div>
            </div>

            <div class="co-sub-re-2">
                한줄 리뷰
                <div class="review-word-box">
                    연소자의 근로는 특별한 보호를 받는다. 제2항의 재판관중 3인은 국회에서 선출하는 자를, 3인은 대법원장이 지명하는 자를 임명한다.
                </div>
                <div class="review-word-box">
                    연소자의 근로는 특별한 보호를 받는다. 제2항의 재판관중 3인은 국회에서 선출하는 자를, 3인은 대법원장이 지명하는 자를 임명한다.
                </div>
                <div class="review-word-box">
                    연소자의 근로는 특별한 보호를 받는다. 제2항의 재판관중 3인은 국회에서 선출하는 자를, 3인은 대법원장이 지명하는 자를 임명한다.
                </div>
            </div>
            <div class="pagging">
                <div class="prev_page" id="prev_page">&lt;</div>
                <div class="pages">
                    <span class="active">1</span>
                    <span>2</span>
                    <span>3</span>
                    <span>4</span>
                    <span>5</span>
                </div>
                <div class="next_page" id="next_page">&gt;</div>
            </div>
        </section>
        <div style="width:104px; margin:30px auto;">
            <button class="com-re-de-bu" onclick="location.href='${ path }/companyReview/list'">목록</button>
        </div>
    </main>
	
    <!-- 푸터 -->
   <jsp:include page="/views/common/footer.jsp" /> 
   
	<!--js 추가-->
	<script type="text/javascript" src="${ path }/resources/js/top.js"></script>
</body>
</html>