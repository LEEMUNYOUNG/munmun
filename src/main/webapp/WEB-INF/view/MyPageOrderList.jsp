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
</head>
<body>
<%@ include file="IncludeTop.jsp" %>
<%@ include file="IncludeMypageBar.jsp" %>
<div align="center">
	<table>
	 <tr>
	 <td align="center" colspan="2"><font size="4">
		<b>${userName}'s Order List</b></font> <br />
	 </td>
	 </tr>
	 <c:forEach var="orders" items="${orders}">
	    <tr>
	 		<td colspan="2"><font color="darkgreen" size="4"><b>Order Date :</b></font> ${orders.orderDate}</td>
	 	</tr>
	 	<tr>
	 	<td colspan="2"><font color="yellowgreen" size="2"><b>Item :</b></font>
	 		<c:if test='${not empty items[orders.itemId]}'>
	 		<c:if test='${items[orders.itemId].categoryId.equals("sale")}'>
                 	<a href='<c:url value="/shop/viewItemDetail.do">
                  	<c:param name="itemId" value="${orders.itemId}"/></c:url>'>
                    <font color="black">${items[orders.itemId].title}</font></a>
                 </c:if>
                 <c:if test='${items[orders.itemId].categoryId.equals("used")}'>
                 	<a href='<c:url value="/shop/viewProduct">
                 	<c:param name="itemId" value="${orders.itemId}"/></c:url>'>
                    <font color="black">${items[orders.itemId].title}</font></a>
                 </c:if>
                 <c:if test='${items[orders.itemId].categoryId.equals("Auction")}'>
                 	<a href='<c:url value="/shop/auctionItemDetail">
                 	<c:param name="itemId" value="${orders.itemId}"/></c:url>'>
                    <font color="black">${items[orders.itemId].title}</font></a>
            </c:if>
            </c:if>
       		<c:if test='${empty items[orders.itemId]}'>
				<c:out value="존재하지 않는 상품입니다."/>
       		</c:if>
            </td>
	 	</tr>
	 	<tr>
	 		<td colspan="2"><font color="yellowgreen" size="2"><b>Address :</b></font> ${orders.address}</td>
	 		<td colspan="2"><font color="yellowgreen" size="2"><b>Ship Address :</b></font> ${orders.shipAddress}</td>
	 	</tr>
	 	<tr>
	 	    <td colspan="2"><font color="yellowgreen" size="2"><b>Card Type :</b></font> ${orders.cardType}</td>
	 		<td colspan="2"><font color="yellowgreen" size="2"><b>Card Number :</b></font> ${orders.cardNumber}</td>
	 	</tr>
	 	<tr>
	 	<td align="right"></td>
	 	<td align="right"><a href='<c:url value="/mypage/MyOrderList/cancel">
	 	<c:param name="orderId" value="${orders.orderId}"/></c:url>'>Cancel Order</a></td>
	 </c:forEach>
    </table>
</div>
</body>
</html>