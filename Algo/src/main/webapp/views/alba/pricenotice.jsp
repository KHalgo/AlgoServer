<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="path" value="${ pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>알바는 알고하자 - 알고</title>
<link rel="stylesheet" href="${ path }/resources/css/common.css" />
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page="/views/common/header.jsp" />

	<!-- 내용 넣기 -->
	
	<img src="https://i.ibb.co/fq4VDg0/price-notice.jpg" alt="price-notice" border="0" 
		 style="
		 	width: 1100px; 
		 	height: 950px;
		 	margin: auto;
    		display: block;
		 ">

	<!-- 푸터 -->
	<jsp:include page="/views/common/footer.jsp" />

	<!--js 추가-->
	<script type="text/javascript" src="${ path }/resources/js/top.js"></script>
</body>
</html>