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
	<title>알바는 알고하자 - 알고</title>
	<link rel="stylesheet" href="${ path }/resources/css/common.css">  
	<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	
	<%-- css 추가 --%>
	<link rel="stylesheet" href="${ path }/resources/css/companyReview/write.css">  

</head>
<body>
	
	<!-- 헤더 -->
	<jsp:include page="/views/common/header.jsp" />
	
	<%-- 내용 넣기 --%>
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

        <!-- 2. 기업리뷰 작성파트 -->
        <section>
            <form action="${ path }/companyReview/write?industryID=${company.industryID} " method="POST">
                <fieldset>
                <div class="com-ti-wr">
                    ${ company.industryName }
                </div>
                    <div class="com-rate">
                        <p>기업 총 평점 <span>이 기업에 몇 점을 주고 싶나요?</span></p>
                        <div class ="star_rating" id="starRate1">
                            <span class="star on" value="1"> </span>
                            <span class="star" value="2"> </span>
                            <span class="star" value="3"> </span>
                            <span class="star" value="4"> </span>
                            <span class="star" value="5"> </span>
                        </div>
                    </div>
    
                    <div class="com-rate-box">
                        <p>평가</p>
                        <div id="detailRate1">
                            <p>일과 삶의 균형</p>
                            <div class ="star_rating" id="starRate2">
                                <span class="star on" value="1"> </span>
                                <span class="star" value="2"> </span>
                                <span class="star" value="3"> </span>
                                <span class="star" value="4"> </span>
                                <span class="star" value="5"> </span>
                            </div>
                        </div>
                        <div id="deatilRate2">
                            <p>급여 및 복지</p>
                            <div class ="star_rating" id="starRate3">
                                <span class="star on" value="1"> </span>
                                <span class="star" value="2"> </span>
                                <span class="star" value="3"> </span>
                                <span class="star" value="4"> </span>
                                <span class="star" value="5"> </span>
                            </div>
                        </div>
                        <div id="deatilRate3">
                            <p>근무 분위기</p>
                            <div class ="star_rating" id="starRate4">
                                <span class="star on" value="1"> </span>
                                <span class="star" value="2"> </span>
                                <span class="star" value="3"> </span>
                                <span class="star" value="4"> </span>
                                <span class="star" value="5"> </span>
                            </div>
                        </div>
                        <div id="deatilRate4">
                            <p>재취업 의사</p>
                            <div class ="star_rating" id="starRate5">
                                <span class="star on" value="1"> </span>
                                <span class="star" value="2"> </span>
                                <span class="star" value="3"> </span>
                                <span class="star" value="4"> </span>
                                <span class="star" value="5"> </span>
                            </div>
                        </div>
                    </div>
                    <div class="com-rate-write">
                        <label for="comWrite">한줄평 작성</label>
                        <br>
                        <textarea class="comWrite" name="comWrite" id="comWrite"></textarea>
                        <p><span id="currentLength">0</span>/<span id="maxLength">100</span></p>
                    </div>
                </fieldset>
                
                <input type="hidden" name="inputStarRate1" value="1"/>
                <input type="hidden" name="inputStarRate2" value="1"/>
                <input type="hidden" name="inputStarRate3" value="1"/>
                <input type="hidden" name="inputStarRate4" value="1"/>
                <input type="hidden" name="inputStarRate5" value="1"/>

                <!-- 버튼 -->
                <div class="com-button">
                    <input type="submit" class="com-wr-btn01" value="작성완료"/>
                    <input type="button" class="com-wr-btn02" onClick="location.href='${ path }/companyReview/list'" value="목록"/>
                </form>
                </div>
        </section>
    </main>
	
    <!-- 푸터 -->
   <jsp:include page="/views/common/footer.jsp" /> 
   
	<%--js 추가--%>
	 <script src="${ path }/resources/js/companyReview/ratingStar.js"></script>
	<script>
    $('#comWrite').on('keyup', (event) => {
        let target = $(event.target);
        let currentLength = target.val().length;
        let maxLength= parseInt($('#maxLength').text());

        console.log(currentLength, maxLength);

        if(currentLength > maxLength){
            target.val(target.val().substr(0, maxLength));
        }else{
            $('#currentLength').text(currentLength);
        }
     });
     $(document).ready(function(){

         $('div[id^=starRate] span').click(function(event){
            console.log($(event.target).parents('div').attr('id'));
            console.log($(event.target).attr('value'));
            let idIdxStr = $(event.target).parents('div').attr('id').replace('starRate', '');
            let valueStr = $(event.target).attr('value');
            $('input[name=inputStarRate'+ idIdxStr + ']').val(valueStr);
         });
     });
	</script>
	<script type="text/javascript" src="${ path }/resources/js/top.js"></script>
	
</body>
</html>