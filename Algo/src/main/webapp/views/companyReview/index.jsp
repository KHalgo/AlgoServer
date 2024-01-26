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
	<link rel="stylesheet" href="${ path }/resources/css/companyReview/index.css">  

</head>
<body>
	
	<!-- 헤더 -->
	<jsp:include page="/views/common/header.jsp" />
	
	<!-- 내용 넣기 -->
	<main>
		<!-- 1. 기업리뷰 배너-->
        <section>
            <div class="banner-navi"> <a href="${ path }/home">홈</a> &nbsp;&nbsp; &gt; &nbsp;&nbsp; <a href="${ path }/companyReview">기업리뷰</a></div>
            <div class="banner">
                <div class="banner-txt">
                    <h1>기업 리뷰</h1>
                    <p><span>알바는 알고하자!</span> 아르바이트 관련 기업들에 대한 후기를 보는 공간</p>
                </div>
                <img src="https://i.ibb.co/Ch8wrSg/building-banner.png" width="107px"></div>
            </div>
        </section>

        <!-- 2. search 창 -->
        <section id="search_section">
            <form class="search">
                <input type="search" name="search" id="searchForm2" class="searchForm">
                <button type="submit" id="btnSubmit2" class="btnSubmit">
                    <img src="https://i.ibb.co/ByBFcyt/search.png" alt="search" width="27px"/>
                </button>
            </form>
        </section>

        <!-- 3. 지역 기업 랭킹 -->
        <section id="com-section3">
            <div class="com-lank">
                <div class="com-lank-h">
                    <h5>내 지역 기업 랭킹</h5>
                    <div class="more"><a href="${ path }/companyReview/list">+ MORE</a></div>
                </div>
                <table class="com-lank-list">
                    <c:if test="${ empty list2 }">
						<tr>
							<td colspan="5">
								조회된 기업이 없습니다.
							</td>
						</tr>	
					</c:if>
					<c:if test="${ not empty list2 }">
						<c:forEach var="company" items="${ list2 }">
		                    <tr onclick="location.href='${ path }/companyReview/companyDetail?industryID=${company.industryID}&page=${ current }'">
		                        <td>${ company.inRowNum }</td>
		                        <td>${ company.industryName }</td>
		                        <td>${ company.industryType }</td>
								<td class ="star_rating" id="LCstarRate${company.inRowNum}"></td>
		                        <td>${ company.baseRate }</td>
		                    </tr>
						</c:forEach>
                    </c:if>
                </table>
            </div>

            <div class="com-lank">
                <div class="com-lank-h">
                    <h5>전체 지역 기업 랭킹</h5>
                    <div class="more"><a href="${ path }/companyReview/list">+ MORE</a></div>
                </div>
                <table class="com-lank-list">
                    <c:if test="${ empty list }">
						<tr>
							<td colspan="5">
								조회된 기업이 없습니다.
							</td>
						</tr>	
					</c:if>
					<c:if test="${ not empty list }">
						<c:forEach var="company" items="${ list }">
		                    <tr onclick="location.href='${ path }/companyReview/companyDetail?industryID=${company.industryID}&page=${ current }'">
		                        <td>${ company.inRowNum }</td>
		                        <td>${ company.industryName }</td>
		                        <td>${ company.industryType }</td>
								<td class ="star_rating" id="BCstarRate${company.inRowNum}"></td>
		                        <td>${ company.baseRate }</td>
		                    </tr>
						</c:forEach>
                    </c:if>
                </table>
            </div>
        </section>

        <!-- 4. 지역 베스트 리뷰 -->
        <section id="com-section4">
            <div class="best-review">
                <h5>내 지역 베스트 리뷰</h5>
                <div class="best-review-box">
                    <a href="">
                        <div class="best-num">1</div>
                        <div class="best-review-co">
                            파리바게트 상계제일점
                        </div>
                        <div class="best-review-txt">
                            오늘 이 글을 읽으면서 많은 동기를 받았어요. 감사합니다.오늘 이 글을 읽으면서 많은 동기를 받았어요. 감사합니다.
                        </div>
                        <div class="best-review-ni">
                            crimsonkycrimsonkycrimsonky
                        </div>
                    </a>
                </div>
                <div class="best-review-box" style="margin: 0 14.3px;">
                    <a href="">
                        <div class="best-num">2</div>
                        <div class="best-review-co">
                            배달의 민족
                        </div>
                        <div class="best-review-txt">
                            오늘 이 글을 읽으면서 많은 동기를 받았어요. 감사합니다.
                        </div>
                        <div class="best-review-ni">
                            crimsonky
                        </div>
                    </a>
                </div>
                <div class="best-review-box">
                    <a href="">
                        <div class="best-num">3</div>
                        <div class="best-review-co">
                            배달의 민족
                        </div>
                        <div class="best-review-txt">
                            오늘 이 글을 읽으면서 많은 동기를 받았어요. 감사합니다.
                        </div>
                        <div class="best-review-ni">
                            crimsonky
                        </div>
                    </a>
                </div>
            </div>
            
            <div class="best-review">
                <h5>전체 베스트 리뷰</h5>
                <div class="best-review-box">
                    <a href="">
                        <div class="best-num">1</div>
                        <div class="best-review-co">
                            배달의 민족
                        </div>
                        <div class="best-review-txt">
                            오늘 이 글을 읽으면서 많은 동기를 받았어요. 감사합니다.
                        </div>
                        <div class="best-review-ni">
                            crimsonky
                        </div>
                    </a>
                </div>
                <div class="best-review-box"  style="margin: 0 14.3px;">
                    <a href="">
                        <div class="best-num">2</div>
                        <div class="best-review-co">
                            배달의 민족
                        </div>
                        <div class="best-review-txt">
                            오늘 이 글을 읽으면서 많은 동기를 받았어요. 감사합니다.
                        </div>
                        <div class="best-review-ni">
                            crimsonky
                        </div>
                    </a>
                </div>
                <div class="best-review-box">
                    <a href="">
                        <div class="best-num">3</div>
                        <div class="best-review-co">
                            배달의 민족
                        </div>
                        <div class="best-review-txt">
                            오늘 이 글을 읽으면서 많은 동기를 받았어요. 감사합니다.
                        </div>
                        <div class="best-review-ni">
                            crimsonky
                        </div>
                    </a>
                </div>
            </div>
        </section>

        <!-- 5. 최근 기업 리뷰 -->
        <section id="com-section5">
            <h5>최근 기업 리뷰</h5>
            <div class="fast-re">
                <div class="fast-re-box">
                    <a href="">
                    <div class="fast-re-co">
                        하얀풍차제과점 강남역
                    </div>
                    <div class="fast-re-date">
                        2023.12.20
                    </div>
                    <div class="fast-re-txt">
                        오늘 이 글을 읽으면서 많은 동기를 받았어요. 감사합니다.
                    </div>
                    </a>
                </div>
                <div class="fast-re-box2">
                    <a href="">
                    <div class="fast-re-co">
                        하얀풍차제과점 강남역
                    </div>
                    <div class="fast-re-date">
                        2023.12.20
                    </div>
                    <div class="fast-re-txt">
                        오늘 이 글을 읽으면서 많은 동기를 받았어요. 감사합니다.
                    </div>
                    </a>
                </div>
                <div class="fast-re-box">
                    <a href="">
                    <div class="fast-re-co">
                        하얀풍차제과점 강남역
                    </div>
                    <div class="fast-re-date">
                        2023.12.20
                    </div>
                    <div class="fast-re-txt">
                        오늘 이 글을 읽으면서 많은 동기를 받았어요. 감사합니다.
                    </div>
                    </a>
                </div>
                <div class="fast-re-box2">
                    <a href="">
                    <div class="fast-re-co">
                        하얀풍차제과점 강남역
                    </div>
                    <div class="fast-re-date">
                        2023.12.20
                    </div>
                    <div class="fast-re-txt">
                        오늘 이 글을 읽으면서 많은 동기를 받았어요. 감사합니다.
                    </div>
                    </a>
                </div>
                <div class="fast-re-box">
                    <a href="">
                    <div class="fast-re-co">
                        하얀풍차제과점 강남역
                    </div>
                    <div class="fast-re-date">
                        2023.12.20
                    </div>
                    <div class="fast-re-txt">
                        오늘 이 글을 읽으면서 많은 동기를 받았어요. 감사합니다.
                    </div>
                    </a>
                </div>
                <div class="fast-re-box2">
                    <a href="">
                    <div class="fast-re-co">
                        하얀풍차제과점 강남역
                    </div>
                    <div class="fast-re-date">
                        2023.12.20
                    </div>
                    <div class="fast-re-txt">
                        오늘 이 글을 읽으면서 많은 동기를 받았어요. 감사합니다.
                    </div>
                    </a>
                </div>
            </div>
        </section>
    </main>
	
    <!-- 푸터 -->
   <jsp:include page="/views/common/footer.jsp" /> 
   
	<!--js 추가-->
	<script type="text/javascript" src="${ path }/resources/js/top.js"></script>
	<script>
		window.onload = function () {
			<c:forEach var="company" items="${list2}">
            var baseRate_${company.inRowNum} = ${company.baseRate}; // JSP에서 가져온 값
            // 별을 표시할 공간에 별 추가
            for (var i = 1; i <= 5; i++) {
                var star = document.createElement('span');
                star.className = 'star' + (i <= baseRate_${company.inRowNum} ? ' on' : '');
                star.value = i;
                document.getElementById('LCstarRate${company.inRowNum}').appendChild(star);
            }
        	</c:forEach>
        	
        	<c:forEach var="company" items="${list}">
            var baseRate_${company.inRowNum} = ${company.baseRate}; // JSP에서 가져온 값
            // 별을 표시할 공간에 별 추가
             for (var i = 1; i <= 5; i++) {
                var star = document.createElement('span');
                star.className = 'star' + (i <= baseRate_${company.inRowNum} ? ' on' : '');
                star.value = i;
                document.getElementById('BCstarRate${company.inRowNum}').appendChild(star);
            }
            
        	</c:forEach>
           
		}
	</script>
</body>
</html>