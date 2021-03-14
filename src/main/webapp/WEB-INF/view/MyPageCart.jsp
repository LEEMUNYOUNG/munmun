<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 장바구니</title>
<style>
a { color:black; text-decoration:none; }
li { list-style:none; margin-left:-1px; z-index:1; }
ul { display:inline-block; *display:inline; zoom:1; }
div { text-align:center; }
</style>
</head>
<body>
<div>
<%@ include file="IncludeTop.jsp" %>
<%@ include file="IncludeMypageBar.jsp" %>
	<ul>
		<li><strong>장바구니 리스트</strong></li>
		<c:forEach var="item" items="biddingItems">
			<li><a href="">체크박스 / 이미지공간 / 상품명 / 가격 </a></li>
		</c:forEach>
	</ul>
</div>
</body>
</html>