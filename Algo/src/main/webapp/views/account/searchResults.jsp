<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="path" value="${ pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>알바는 알고하자 - 알고</title>
<link rel="stylesheet" href="${ path }/resources/css/common.css">
<script type="text/javascript"
	src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript"
	src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>


<!-- css 추가 -->
<link rel="stylesheet" href="${ path }/resources/css/account/searchResults.css">


</head>
<body>

	<!-- 헤더 -->
	<jsp:include page="/views/common/header.jsp" />

	<!-- 내용 넣기 -->
	<main>
		<section>
			<div>
				<form class="search1">
					<input type="search" name="search" id="searchForm1"
						class="searchForm" />
					<button type="submit" id="btnSubmit1" class="btnSubmit">
						<img src="https://i.ibb.co/ByBFcyt/search.png" alt="search"
							width="27px" />
					</button>
				</form>
			</div>
			<div class="communitySearchResultForm">
				<p class="communitySearchResult">
					<strong>커뮤니티 - '<span>검색명</span>'
					</strong> 검색결과 ('<span class="searchResultNumber">123</span>'건)
				</p>
				<br />
				<hr />
				<div>
					<a href="#">
						<h4>이 부분도 검색 결과가 없다면 아래와 같이 처리하나요....?</h4>
						<p class="postDetail">안녕하세요 을지로에 있는 한 카페에서 일한 피해자입니다. 저같은 피해자가
							더이상 나오지 않길 바라며 한번 적어봅니다. 저는 10월말부터 11월 말까지 그 카페에서 일을 했습니다. 첫번째로는,
							수습기간 일주일...</p>
						<p class="postlocation">서울시 > 중구 | 댓글 3</p>
					</a>
				</div>
				<div>
					<a class="aTag" href="#">
						<h4>주휴수당에 대해 잘 아시는 분 계실까요?</h4>
						<p class="postDetail">안녕하세요 을지로에 있는 한 카페에서 일한 피해자입니다. 저같은 피해자가
							더이상 나오지 않길 바라며 한번 적어봅니다. 저는 10월말부터 11월 말까지 그 카페에서 일을 했습니다. 첫번째로는,
							수습기간 일주일...</p>
						<p class="postlocation">서울시 > 중구 | 댓글 3</p>
					</a>
				</div>
				<div>
					<a href="#">
						<h4>주휴수당에 대해 잘 아시는 분 계실까요?</h4>
						<p class="postDetail">안녕하세요 을지로에 있는 한 카페에서 일한 피해자입니다. 저같은 피해자가
							더이상 나오지 않길 바라며 한번 적어봅니다. 저는 10월말부터 11월 말까지 그 카페에서 일을 했습니다. 첫번째로는,
							수습기간 일주일...</p>
						<p class="postlocation">서울시 > 중구 | 댓글 3</p>
					</a>
				</div>
				<div>
					<a href="#">
						<h4>주휴수당에 대해 잘 아시는 분 계실까요?</h4>
						<p class="postDetail">안녕하세요 을지로에 있는 한 카페에서 일한 피해자입니다. 저같은 피해자가
							더이상 나오지 않길 바라며 한번 적어봅니다. 저는 10월말부터 11월 말까지 그 카페에서 일을 했습니다. 첫번째로는,
							수습기간 일주일...</p>
						<p class="postlocation">서울시 > 중구 | 댓글 3</p>
					</a>
				</div>
				<div>
					<a href="#">
						<h4>주휴수당에 대해 잘 아시는 분 계실까요?</h4>
						<p class="postDetail">안녕하세요 을지로에 있는 한 카페에서 일한 피해자입니다. 저같은 피해자가
							더이상 나오지 않길 바라며 한번 적어봅니다. 저는 10월말부터 11월 말까지 그 카페에서 일을 했습니다. 첫번째로는,
							수습기간 일주일...</p>
						<p class="postlocation">서울시 > 중구 | 댓글 3</p>
					</a>
				</div>
				<div class="moreButton">
					<input type="button" value="더보기" class="algo_btn2" />
				</div>
			</div>
			<div class="albaInfoSearchResultForm">
				<p class="albaInfoSearchResult">
					<strong>알바 정보 - '<span>검색명</span>'
					</strong> 검색결과 ('<span class="searchResultNumber">123</span>'건)
				</p>
				<br />
				<hr />
				<div>
					<a href="#">
						<h4>이 부분은 검색관련이 없는 경우 어떻게 하나요...?</h4>
						<p class="postDetail">안녕하세요 을지로에 있는 한 카페에서 일한 피해자입니다. 저같은 피해자가
							더이상 나오지 않길 바라며 한번 적어봅니다. 저는 10월말부터 11월 말까지 그 카페에서 일을 했습니다. 첫번째로는,
							수습기간 일주일...</p>
						<p class="postlocation">서울시 > 중구 | 댓글 3</p>
					</a>
				</div>
				<div>
					<a href="#">
						<h4>이 부분도 위에처럼 5개까지만 보여주는걸로...?</h4>
						<p class="postDetail">안녕하세요 을지로에 있는 한 카페에서 일한 피해자입니다. 저같은 피해자가
							더이상 나오지 않길 바라며 한번 적어봅니다. 저는 10월말부터 11월 말까지 그 카페에서 일을 했습니다. 첫번째로는,
							수습기간 일주일...</p>
						<p class="postlocation">서울시 > 중구 | 댓글 3</p>
					</a>
				</div>
				<div>
					<a href="#">
						<h4>만약에 검색결과가 2개라면 버튼은 마지막 검색결과 게시물 밑에 붙도록 처리하나요...?</h4>
						<p class="postDetail">안녕하세요 을지로에 있는 한 카페에서 일한 피해자입니다. 저같은 피해자가
							더이상 나오지 않길 바라며 한번 적어봅니다. 저는 10월말부터 11월 말까지 그 카페에서 일을 했습니다. 첫번째로는,
							수습기간 일주일...</p>
						<p class="postlocation">서울시 > 중구 | 댓글 3</p>
					</a>
				</div>
				<div class="moreButton">
					<input type="button" value="더보기" class="algo_btn2" />
				</div>

			</div>
		</section>
	</main>

	<!-- 푸터 -->
	<jsp:include page="/views/common/footer.jsp" />

	<!--js 추가-->
	<script type="text/javascript" src="${ path }/resources/js/top.js"></script>
</body>
</html>