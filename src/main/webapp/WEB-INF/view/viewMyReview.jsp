<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript">
function moveDelete(){
	
	location.href='/mypage/deleteReview';
}
</script>
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
		<th>제목</th>
		<th>별점</th>
		<th>내용</th>
		<th>아이템 아이디</th>
	</tr>
    <c:forEach var="rl" items="${reviewList}" varStatus="status">
	<tr align="center">
		<td><c:out value="${rl.title }"></c:out></td> 			
		<td><c:out value="${rl.rating }"></c:out></td>
		<td><c:out value="${rl.content }"></c:out></td>
		<td><a href="<c:url value='/shop/viewItemDetail.do'><c:param name='itemId' value='${rl.itemId}'/></c:url>">
			<c:out value="${rl.itemId }" /></a></td> 
		
		<td><a href="<c:url value='/mypage/updateForm?reviewId=${rl.reviewId}'/>">수정</a>
		<a href="<c:url value='/mypage/deleteReview/${rl.reviewId}'/>">삭제</a></td>
		
	</tr>
	</c:forEach> 
	</table>
	
	</div></td>
  </tr>
</table>
</body>
</html>