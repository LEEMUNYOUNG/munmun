<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>아이템 상세보기 페이지</title>
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
	<td rowspan="5">
		<img id="m" src="<c:url value='/upload/${item.imgName}' />" />
	</td>
    <td colspan="3">상품이름:&nbsp;${item.title}</td>
</tr>
<tr>
    <td colspan="3">가격:&nbsp;${item.price}</td>
</tr>
<tr>
    <td colspan="3">수량 :&nbsp;${item.stock}</td>
</tr>
<tr>
    <td><a href='<c:url value="/shop/addItemToCart">
          <c:param name="workingItemId" value="${item.itemId}"/><c:param name="categoryId" value="${item.categoryId}"/>
          </c:url>'><img border="0" src="../images/button_add_to_cart.gif" alt="" /></a>
        </td>
    <td><a href="<c:url value='/shop/reviewForm?itemId=${item.itemId}'/>"><img border="0" src="../images/button_review.png" alt="" /></a></td>
    <td><a href="<c:url value='/shop/viewReview/itemId/${item.itemId}'/>"><img border="0" src="../images/button_review_show.png" alt="" /></a></td>
</tr>
<tr>
    <td colspan="5">상품설명 : ${item.description}</td>
</tr>
</table>
</body>
</html>


