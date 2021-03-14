<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 입찰내역</title>
<style>
table.t1 {
    border-collapse: collapse;
    text-align:center;
    margin: auto;
    align:center;
}

</style>
</head>
<body>
<div>
<%@ include file="IncludeTop.jsp" %>
<%@ include file="IncludeMypageBar.jsp" %>
   <table class="t1" border='1'>
      <tr><td colspan='5'><strong>입찰 중</strong></td></tr>
      <tr><td>상품명</td><td>입찰신청금액</td><td>현재최고금액</td><td>입찰종료일</td><td></td></tr>
      <c:forEach var="bidItem" items="${bidingList}">
         <tr><td>${bidItem.auction.item.title}</td><td>${bidItem.price}</td><td>${bidItem.maxPrice}</td><td>${bidItem.auction.deadline}</td>
            <td>
               <a href="<c:url value='/mypage/MyBidMain/delete'><c:param name='bidId' value='${bidItem.bidId}'/></c:url>"><strong>삭제</strong></a>
            </td>
         </tr>
      </c:forEach>
   </table>
   <br/>
   <hr width="50% align="left"> 
   <br/>
   <table class="t1" border='1'>
      <tr><td colspan='4'><strong>경매 종료</strong></td></tr>
      <tr><td>상품명</td><td>입찰신청금액</td><td>현재최고금액</td><td>입찰종료일</td><td></td></tr>
      <c:forEach var="bidItem" items="${endBidList}">
         <tr><td>${bidItem.auction.item.title}</td><td>${bidItem.price}</td><td>${bidItem.maxPrice}</td><td>${bidItem.auction.deadline}</td>
         <td rawspan='2'><c:if test="${bidItem.check == 1}" ><a href='<c:url value="/shop/AuctionOrder"><c:param name="itemId" value="${bidItem.auction.auctionId}"/></c:url>'>구매</a></c:if></td>
         </tr>
      </c:forEach>
   </table>

</body>
</html>