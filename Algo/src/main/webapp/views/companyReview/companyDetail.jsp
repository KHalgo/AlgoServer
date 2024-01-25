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
                <button onclick="location.href='${ path }/companyReview/write?industryID=${company.industryID}'">리뷰 작성</button>
            </div>
            <div class="co-main-re-box">
                <div class="co-main-re-1">
                    <span class="co-main-re-1-txt">알바 리뷰 평점</span> (<span>${ company.count }명</span>)
                    <div>
                        <div class="star_point">${ company.baseRate }</div>
                        <div class ="star_rating" id="starRate1">
                        	<!-- 별을 표시할 공간 -->
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
                    <c:if test="${ empty bestComment.postComment }">
                    	<div class="review-word-box">
                    	 	작성된 리뷰가 없습니다.
                    	</div>
                    </c:if>
                    <c:if test="${ not empty bestComment.postComment }">
	                    <div class="review-word-box">
	                        ${ bestComment.postComment }
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
                    <div class="sub-rate-box">
	                    <div class ="star_rating" id="starRate2">
	                    </div>
	                    <div class="sub_star_point">평점 ${ company.detailRate1 }</div>
                    </div>
                </div>
                <div class="sub-rate">
                    <div class="sub-rate-txt">급여 및 복지</div>
                    <div class="sub-rate-box">
	                    <div class ="star_rating" id="starRate3">
	                    </div>
	                    <div class="sub_star_point">평점 ${ company.detailRate2 }</div>
                    </div>
                </div>
                <div class="sub-rate">
                    <div class="sub-rate-txt">근무 분위기</div>
                    <div class="sub-rate-box">
	                    <div class ="star_rating" id="starRate4">
	                    </div>
	                    <div class="sub_star_point">평점 ${ company.detailRate3 }</div>
                    </div>
                </div>
                <div class="sub-rate">
                    <div class="sub-rate-txt">재취업 의사</div>
                    <div class="sub-rate-box">
	                    <div class ="star_rating" id="starRate5">
	                    </div>
	                    <div class="sub_star_point">평점 ${ company.detailRate4 }</div>
                    </div>
                </div>
            </div>

            <div class="co-sub-re-2">
                한줄 리뷰
                <c:if test="${ not empty list }">
                	<c:forEach var="comment" items="${ list }">
		                <div class="review-word-box">
		                    ${ comment.postComment }
		                </div>
                	</c:forEach>
                </c:if>
                <c:if test="${ empty list }">
	                <div class="review-word-box">
	                    작성된 리뷰가 없습니다.
	                </div>
                </c:if>
            </div>
            <c:choose>
	            <c:when test="${ empty list }">
	            </c:when>
	            <c:otherwise>
		           <div class="pagging">
			            <!-- 이전 페이지로 -->
						<button class="prev_page" onclick="location.href='${ path }/companyReview/companyDetail?industryID=${company.industryID}&page=${ pageInfo.prevPage }'">&lt;</button>
		                <!--  5개 페이지 목록 -->
						<c:forEach var="current" begin="${ pageInfo.startPage }" end="${ pageInfo.endPage }">
							<c:choose>
								<c:when test="${ current == pageInfo.currentPage }">
									<button disabled>${ current }</button>
								</c:when>
								<c:otherwise>
									<button onclick="location.href='${ path }/companyReview/companyDetail?industryID=${company.industryID}&page=${ current }'">${ current }</button>
								</c:otherwise>
							</c:choose>
						</c:forEach>
		                <!-- 다음 페이지로 -->
						<button class="next_page" onclick="location.href='${ path }/companyReview/companyDetail?industryID=${company.industryID}&page=${ pageInfo.nextPage }'">&gt;</button>
		            </div>
	            </c:otherwise>
            </c:choose>

        </section>
        <div style="width:104px; margin:30px auto;">
            <button class="com-re-de-bu" onclick="location.href='${ path }/companyReview/list'">목록</button>
        </div>
    </main>
	
    <!-- 푸터 -->
   <jsp:include page="/views/common/footer.jsp" /> 
   
	<!--js 추가-->
	<script type="text/javascript" src="${ path }/resources/js/top.js"></script>
	<script>
		window.onload = function () {
			 // company.baseRate 값을 가져와서 해당하는 별에 'on' 클래스 추가
		    var baseRate = ${ company.baseRate }; // JSP에서 가져온 값
		    // 별을 표시할 공간에 별 추가
		    for (var i = 1; i <= 5; i++) {
		        var star = document.createElement('span');
		        star.className = 'star' + (i <= baseRate ? ' on' : '');
		        star.value = i;
		        document.getElementById('starRate1').appendChild(star);
		    }
		    
		 	// company.detailRate1 값을 가져와서 해당하는 별에 'on' 클래스 추가
		    var baseRate = ${ company.detailRate1 }; // JSP에서 가져온 값
		    // 별을 표시할 공간에 별 추가
		    for (var i = 1; i <= 5; i++) {
		        var star = document.createElement('span');
		        star.className = 'star' + (i <= baseRate ? ' on' : '');
		        star.value = i;
		        document.getElementById('starRate2').appendChild(star);
		    }
		    
		 	// company.detailRate2 값을 가져와서 해당하는 별에 'on' 클래스 추가
		    var baseRate = ${ company.detailRate2 }; // JSP에서 가져온 값
		    // 별을 표시할 공간에 별 추가
		    for (var i = 1; i <= 5; i++) {
		        var star = document.createElement('span');
		        star.className = 'star' + (i <= baseRate ? ' on' : '');
		        star.value = i;
		        document.getElementById('starRate3').appendChild(star);
		    }
		    
		 // company.detailRate3 값을 가져와서 해당하는 별에 'on' 클래스 추가
		    var baseRate = ${ company.detailRate3 }; // JSP에서 가져온 값
		    // 별을 표시할 공간에 별 추가
		    for (var i = 1; i <= 5; i++) {
		        var star = document.createElement('span');
		        star.className = 'star' + (i <= baseRate ? ' on' : '');
		        star.value = i;
		        document.getElementById('starRate4').appendChild(star);
		    }
		    
		    // company.detailRate4 값을 가져와서 해당하는 별에 'on' 클래스 추가
		    var baseRate = ${ company.detailRate4 }; // JSP에서 가져온 값
		    // 별을 표시할 공간에 별 추가
		    for (var i = 1; i <= 5; i++) {
		        var star = document.createElement('span');
		        star.className = 'star' + (i <= baseRate ? ' on' : '');
		        star.value = i;
		        document.getElementById('starRate5').appendChild(star);
		    }
		}
	</script>
</body>
</html>