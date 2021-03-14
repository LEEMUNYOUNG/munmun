<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BPSP</title>
<style>
a { color:black; text-decoration:none; font-size:15px; }
#tstyle { border-spacing:7px; }
#tstyle {
	margin:auto;
}
#m {
  display: block;
  max-width:200px;
  max-height:222px;
  width: auto;
  height: auto;
}
</style>
</head>
<body>
<%@ include file="IncludeTop.jsp" %>
<%@ include file="IncludeSidebar.jsp" %>
<script type="text/javascript">
var message = '${message}';
if (message != "") {
   alert(message);
}
</script>
<table id="tstyle">
	<tr>
		<td rowspan="8">
			<c:if test="${not empty item.imgName}">
	          	<img id="m" src="<c:url value='/upload/${item.imgName}' />" />
	        </c:if>
	    </td>
		<td><b>상품명</b>
		&nbsp;&nbsp;&nbsp;${item.title}</td>
	</tr>
	<tr>
		<td><b>가격</b>
		&nbsp;&nbsp;&nbsp;${item.price}</td>
	</tr>
	<tr>
		<td><b>판매자ID</b>
		&nbsp;&nbsp;&nbsp;${auction.sellerId}</td>
	</tr>
	<tr>
		<td><b>수량</b>
		&nbsp;&nbsp;&nbsp;${item.stock}</td>
	</tr>
	<tr>
		<td><b>게시일</b>
		&nbsp;&nbsp;&nbsp;${item.addDate}</td>
	</tr>
	<tr>
		<td><b>마감일</b>
		&nbsp;&nbsp;&nbsp;${auction.deadline}</td>
	</tr>
	<tr>
		<td><b>경매 참여자 수</b>
		&nbsp;&nbsp;&nbsp;${auction.participant}</td>
	</tr>
	<tr>
		<td><b>상세설명</b>
		&nbsp;&nbsp;&nbsp;${item.description}</td>
	</tr>
	<tr>
		<td><a href="<c:url value='/shop/addBidForm'><c:param name="itemId" value="${item.itemId}"/>
		</c:url>">입찰 참여하기</a>	
	    </td>
	</tr>
</table>
<p><a href="<c:url value='/shop/auctionProduct' />">이전으로</a></p>
</body>
</html>