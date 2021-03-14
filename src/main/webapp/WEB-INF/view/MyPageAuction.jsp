<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 경매내역</title>
<style>
a { color:black; text-decoration:none; }
li { list-style:none; margin-left:-1px; z-index:1; }
ul { display:inline-block; *display:inline; zoom:1; }
div { text-align:center; }
</style>
</head>
<body>
<%@ include file="IncludeTop.jsp" %>
<center><h5>${userName }님의 마이페이지</h5></center>
<table>
  <tr>
    <td><%@ include file="IncludeMypageBar.jsp" %></td>
    <td colspan="2"><div> 	
     <table border=1 width=160% cellspacing=0>
    	<tr align="center">
		<th>상품명</th>
		<th>등록금액</th>
<!-- 		<th>내용</th> -->
<!-- 		<th>아이템 아이디</th> -->
	</tr>
		<c:forEach var="item" items="${Items}">
		<tr>
			 <td><c:out value="${item.item.title}"/></td>
			 <td><c:out value="${item.item.price}"/></td>
			    
			 <td><a href="<c:url value='/mypage/updateAuctionForm'><c:param name='auctionId' value='${item.auctionId}'/></c:url>"><strong>수정</strong></a>
			<a href="<c:url value='/mypage/MyAuctionMain/delete'><c:param name='auctionId' value='${item.auctionId}'/></c:url>"><strong>삭제</strong></a></td>
		</tr>
		</c:forEach>
	</table>
    
    
    
<!-- <ul> -->
<!-- 		<li><strong>내가 등록한 경매 아이템 (+입찰신청된 경매아이템은 삭제불가능해서 처리해줘야함)</strong></li> -->
<!-- 		<li><br/></li> -->
<%-- 		<c:forEach var="item" items="${Items}"> --%>
<%-- 			<li>상품명: ${item.item.title} --%>
<%-- 			 / 등록금액 : ${item.item.price}  --%>
<%-- 			 / <a href="<c:url value='/mypage/updateAuctionForm'><c:param name='auctionId' value='${item.auctionId}'/></c:url>"><strong>수정버튼</strong></a> --%>
<%-- 			/ <a href="<c:url value='/mypage/MyAuctionMain/delete'><c:param name='auctionId' value='${item.auctionId}'/></c:url>"><strong>삭제버튼</strong></a> --%>
<%-- 		</c:forEach> --%>
<!-- 	</ul> -->
	</div></td>
  </tr>
</table>
</body>
</html>