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
	
	
	<!-- 메인페이지 css -->
	<link rel="stylesheet" href="${ path }/resources/css/index.css">
	<!-- 슬라이더 css -->
	<link rel="stylesheet" href="${ path }/resources/slick/slick.css">  
	<link rel="stylesheet" href="${ path }/resources/slick/slick-theme.css">  

</head>
<body>
	
	<!-- 헤더 -->
	<jsp:include page="/views/common/header.jsp" />
	
	<main>
        <!-- 섹션1 - 배너 -->
        <section id="section1">
            <form class="search">
                <input type="search" name="search" id="searchForm1" class="searchForm">
                <button type="submit" id="btnSubmit1" class="btnSubmit">
                    <img src="https://i.ibb.co/ByBFcyt/search.png" alt="search" width="27px"/>
                </button>
            </form>
            <div class="banner-slide">
                <div class="banner-box">
                    <div class="banner-box-txt"><h3>알바에 대한 기본 정보 알기</h3>최저 시급 보러가기 →</div>
                    <img src="https://i.ibb.co/HNw9772/algo-banner1.jpg">
                </div>
                <div class="banner-box">
                    <div class="banner-box-txt"><h3>알바에 대한 기본 정보 알기</h3>최저 시급 보러가기 →</div>
                    <img src="https://i.ibb.co/TYGjRpx/algo-banner2.jpg">
                </div>
                <div class="banner-box">
                    <div class="banner-box-txt"><h3>알바에 대한 기본 정보 알기</h3>최저 시급 보러가기 →</div>
                    <img src="https://i.ibb.co/vJ6RRft/algo-banner3.jpg">
                </div>
                <div class="banner-box">
                    <div class="banner-box-txt"><h3>알바에 대한 기본 정보 알기</h3>최저 시급 보러가기 →</div>
                    <img src="https://i.ibb.co/HNw9772/algo-banner1.jpg">
                </div>
                <div class="banner-box">
                    <div class="banner-box-txt"><h3>알바에 대한 기본 정보 알기</h3>최저 시급 보러가기 →</div>
                    <img src="https://i.ibb.co/TYGjRpx/algo-banner2.jpg">
                </div>
                <div class="banner-box">
                    <div class="banner-box-txt"><h3>알바에 대한 기본 정보 알기</h3>최저 시급 보러가기 →</div>
                    <img src="https://i.ibb.co/vJ6RRft/algo-banner3.jpg">
                </div>
            </div>
            <div></div>
        </section>
    
        <!-- 섹션2 -->
        <section id="section2">
            <div class="best_slide">
                <div class="best_slide_my">
                    <div class="main_txt">
                        <h2>내 지역 베스트 기업</h2>
                        <div class="more"><a href="${ path }/companyReview">+ MORE</a></div>
                    </div>
                    <div class="best_my_box">
                   	<c:if test="${ empty list2 }">
					<c:forEach var="company" items="${ list }">
							<div class="best_my_boxess">
	                            <div class="flag"></div>
	                            <div class="best_text_box">
	                                <h3><a href="${ path }/companyReview/companyDetail?industryID=${company.industryID}">${ company.industryName }</a></h3>
	                                <p class ="star_rating" id="BCstarRate${ company.inRowNum }"></p>
	                                <p class="best_text_box_word">${ company.bestComment }</p>
	                            </div>
                        	</div>
						</c:forEach>
					</c:if>
					<c:if test="${ not empty list2 }">
						<c:forEach var="company" items="${ list2 }">
							<div class="best_my_boxess">
	                            <div class="flag"></div>
	                            <div class="best_text_box">
	                                <h3><a href="${ path }/companyReview/companyDetail?industryID=${company.industryID}">${ company.industryName }</a></h3>
	                                <p class ="star_rating" id="LCstarRate${ company.inRowNum }"></p>
	                                <p class="best_text_box_word">${ company.bestComment }</p>
	                            </div>
                        	</div>
						</c:forEach>
                    </c:if>
                    </div>
                </div>

                <div class="best_slide_all">
                    <div class="main_txt">
                        <h2>전체 지역 베스트 기업</h2>
                        <div class="more"><a href="${ path }/companyReview">+ MORE</a></div>
                    </div>
                    <div class="best_my_box">
                   <c:if test="${ empty list }">
					등록된 기업이 없습니다.
					</c:if>
					<c:if test="${ not empty list }">
						<c:forEach var="company" items="${ list }">
							<div class="best_my_boxess">
	                            <div class="flag"></div>
	                            <div class="best_text_box">
	                                <h3><a href="${ path }/companyReview/companyDetail?industryID=${company.industryID}">${ company.industryName }</a></h3>
	                                <p class ="star_rating" id="RCstarRate${company.inRowNum}"></p>
	                                <p class="best_text_box_word">${ company.bestComment }</p>
	                            </div>
                        	</div>
						</c:forEach>
                    </c:if>
                    </div>
                </div>
            </div>
        </section>

        <!-- 섹션3 -->
        <section id="section3">
            <div class="main_comu">
                <div class="main_txt">
                    <h2>베스트 커뮤니티</h2>
                </div>
                <div class="main_comu_box" id="main_alba">
                    <div style="position: relative;">
                        <h4>베스트 알고 TALK</h4>
                        <div class="more"><a href="${ path }/talkBoard/">+ MORE</a></div>
                    </div>
                    <div class="main_comu_txt">
                        <div class="main_comu_txt_box">
                            <div class="comu_1">대박 썰 푼다</div>
                            <div class="comu_2">나는야 알바맨</div>
                        </div>
                        <div class="main_comu_txt_box">
                            <div class="comu_1">대박 썰 푼다</div>
                            <div class="comu_2">나는야 알바맨</div>
                        </div>
                        <div class="main_comu_txt_box">
                            <div class="comu_1">대박 썰 푼다</div>
                            <div class="comu_2">나는야 알바맨</div>
                        </div>
                        <div class="main_comu_txt_box">
                            <div class="comu_1">대박 썰 푼다</div>
                            <div class="comu_2">나는야 알바맨</div>
                        </div>
                        <div class="main_comu_txt_box">
                            <div class="comu_1">대박 썰 푼다</div>
                            <div class="comu_2">나는야 알바맨</div>
                        </div>
                        <div class="main_comu_txt_box">
                            <div class="comu_1">대박 썰 푼다</div>
                            <div class="comu_2">나는야 알바맨</div>
                        </div>
                    </div>
                </div>

                <div class="main_comu_box" id="main_qa">
                    <div style="position: relative;">
                        <h4>베스트 알고 Q&A</h4>
                        <div class="more"><a href="${ path }/qnaBoard/">+ MORE</a></div>
                    </div>
                    <div class="main_comu_txt">
                        <div class="main_comu_txt_box">
                            <div class="comu_1">대박 썰 푼다</div>
                            <div class="comu_2">나는야 알바맨</div>
                        </div>
                        <div class="main_comu_txt_box">
                            <div class="comu_1">대박 썰 푼다</div>
                            <div class="comu_2">나는야 알바맨</div>
                        </div>
                        <div class="main_comu_txt_box">
                            <div class="comu_1">대박 썰 푼다</div>
                            <div class="comu_2">나는야 알바왕이지롱</div>
                        </div>
                        <div class="main_comu_txt_box">
                            <div class="comu_1">대박 썰 푼다</div>
                            <div class="comu_2">나는야 알바맨</div>
                        </div>
                        <div class="main_comu_txt_box">
                            <div class="comu_1">대박 썰 푼다대박 썰 푼다대박 썰 푼다대박 썰 푼다대박 썰 푼다</div>
                            <div class="comu_2">나는야 알바맨</div>
                        </div>
                        <div class="main_comu_txt_box">
                            <div class="comu_1">대박 썰 푼다</div>
                            <div class="comu_2">나는야 알바맨</div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- 섹션4 -->
        <section id="section4">
            <div class="main_icon">
                <a href="${ path }/views/alba/pricenotice.jsp">
                <div class="main_icon_box">
                    <div class="main_icon_img">
                        <img src="${ path }/resources/img/info.svg"/>
                    </div>
                </div>
                <div class="main_icon_txt">유용한 정보</div>
                </a>
            </div>
            <div class="main_icon">
                <a href="${ path }/companyReview/list">
                <div class="main_icon_box">
                    <div class="main_icon_img" style="left:48%;">
                        <img src="${ path }/resources/img/building.svg"/>
                    </div>
                </div>
                <div class="main_icon_txt">기업 리뷰</div>
                </a>
            </div>
            <div class="main_icon">
                <a href="${ path }/talkBoard/">
                <div class="main_icon_box">
                    <div class="main_icon_img">
                        <img src="${ path }/resources/img/chat.svg"/>
                    </div>
                </div>
                <div class="main_icon_txt">알고 TALK</div>
                </a>
            </div>
            <div class="main_icon">
                <a href="${ path }/qnaBoard/">
                <div class="main_icon_box">
                    <div class="main_icon_img">
                        <img src="${ path }/resources/img/qna.svg"/>
                    </div>
                </div>
                <div class="main_icon_txt">알고 Q&A</div>
                </a>
            </div>
        </section>
    </main>
	
    <!-- 푸터 -->
   <jsp:include page="/views/common/footer.jsp" /> 
   
	<!-- 메인 js -->  
	<script>
		document.addEventListener('DOMContentLoaded', function () {
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
		});
		
    	document.addEventListener('DOMContentLoaded', function () {
        	<c:forEach var="company" items="${list}">
            var baseRate_${company.inRowNum} = ${company.baseRate}; // JSP에서 가져온 값
            // 별을 표시할 공간에 별 추가
             for (var i = 1; i <= 5; i++) {
                var star = document.createElement('span');
                star.className = 'star' + (i <= baseRate_${company.inRowNum} ? ' on' : '');
                star.value = i;
                document.getElementById('RCstarRate${company.inRowNum}').appendChild(star);
            }
        	</c:forEach>
		});
	</script>
	<script type="text/javascript" src="${ path }/resources/js/index.js"></script>
	<script type="text/javascript" src="${ path }/resources/slick/slick.min.js"></script>
	<script type="text/javascript" src="${ path }/resources/js/top.js"></script>	
</body>
</html>