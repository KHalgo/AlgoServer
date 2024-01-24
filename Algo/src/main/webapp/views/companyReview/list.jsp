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
	<link rel="stylesheet" href="${ path }/resources/css/companyReview/list.css">  

</head>
<body>
	
	<!-- 헤더 -->
	<jsp:include page="/views/common/header.jsp" />
	
	<%-- 내용 넣기 --%>
	<main>
		<!-- 1. 기업리뷰 배너-->
        <section>
            <div class="banner-navi"> <a href="${ path }">홈</a> &nbsp;&nbsp; &gt; &nbsp;&nbsp; <a href="${ path }/companyReview/">기업리뷰</a></div>
            <div class="banner">
                <div class="banner-txt">
                    <h1>기업 리뷰</h1>
                    <p><span>알바는 알고하자!</span> 아르바이트 관련 기업들에 대한 후기를 보는 공간</p>
                </div>
                <img src="https://i.ibb.co/Ch8wrSg/building-banner.png" width="107px"></div>
            </div>
        </section>

        <!-- 2. 검색 -->
        <section>
            <form class="Review_CoSh" onchange="selectOnChange(this)">
                <input type="search" name="ReviewSh" id="ReviewSh" placeholder="지역명 / 기업명을 입력하세요."/>
                <input type="submit" id="ReviewSb" value="검색">
            </form>
            <form>
                <select name="ReviewLi" id="ReviewLi">
                    <option value="score" selected>평점순</option>
                    <option value="view">조회순</option>
                    <option value="register">등록순</option>
                </select>
            </form>
        </section>

        <!-- 3. 기업 리스트 -->
        <section>
            <table class="Review_CoList">
                <thead>
                    <tr>
                        <th width="25%">기업 명</th>
                        <th width="10%">업종</th>
                        <th width="18%">위치</th>
                        <th width="10%">평점</th>
                        <th width="14%">등록일</th>
                        <th width="13%">등록된 리뷰수</th>
                        <th width="10%">조회수</th>
                    </tr>
                </thead>
                <tbody>
	                <c:if test="${ empty list }">
						<tr>
							<td colspan="7">
								조회된 게시글이 없습니다.
							</td>
						</tr>	
					</c:if>
					<c:if test="${ not empty list }">
						<c:forEach var="company" items="${ list }">
		                    <tr onclick="location.href='${ path }/companyReview/companyDetail?industryID=${company.industryID}'">
		                        <td>${ company.industryName }</td>
		                        <td>${ company.industryType }</td>
		                        <td>${ company.industryLc }</td>
		                        <td>${ company.baseRate }</td>
		                        <td><fmt:formatDate value ="${ company.industryDate }" pattern="yyyy.MM.dd"/></td>
		                        <td>${ company.count }</td>
		                        <td>${ company.readCount }</td>
		                    </tr>
						</c:forEach>
                    </c:if>
                </tbody>
            </table>
            <div class="pagging">
	            <!-- 이전 페이지로 -->
				<button class="prev_page" onclick="location.href='${ path }/companyReview/list?page=${ pageInfo.prevPage }'">&lt;</button>
                <!--  5개 페이지 목록 -->
				<c:forEach var="current" begin="${ pageInfo.startPage }" end="${ pageInfo.endPage }">
					<c:choose>
						<c:when test="${ current == pageInfo.currentPage }">
							<button disabled>${ current }</button>
						</c:when>
						<c:otherwise>
							<button onclick="location.href='${ path }/companyReview/list?page=${ current }'">${ current }</button>
						</c:otherwise>
					</c:choose>
				</c:forEach>
                <!-- 다음 페이지로 -->
				<button class="next_page" onclick="location.href='${ path }/companyReview/list?page=${ pageInfo.nextPage }'">&gt;</button>
            </div>
        </section>
    </main>
	
    <!-- 푸터 -->
   <jsp:include page="/views/common/footer.jsp" /> 
   
	<%--js 추가--%>
	<script type="text/javascript" src="${ path }/resources/js/top.js"></script>
	
</body>
</html>