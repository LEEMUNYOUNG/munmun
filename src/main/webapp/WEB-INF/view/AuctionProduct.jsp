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
a { color:black; text-decoration:none; }
li { list-style:none; margin-left:-1px; z-index:1; }
ul { display:inline-block; *display:inline; zoom:1; }
div { text-align:center; }
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
<center>
 <a href="<c:url value="/shop/auctionByProductId?categoryId=Auction&productId=S001"/>">
 	유모차 <img border="0" src="../images/separator.gif" /></a>
 <a href="<c:url value="/shop/auctionByProductId?categoryId=Auction&productId=S002"/>">
 	장난감 <img border="0" src="../images/separator.gif" /></a>
 <a href="<c:url value="/shop/auctionByProductId?categoryId=Auction&productId=S003"/>">
 	옷 <img border="0" src="../images/separator.gif" /></a>
 <a href="<c:url value="/shop/auctionByProductId?categoryId=Auction&productId=S004"/>">
 	신발 <img border="0" src="../images/separator.gif" /></a>
 <a href="<c:url value="/shop/auctionByProductId?categoryId=Auction&productId=S005"/>">
 	모빌</a>
</center>
<%@ include file="IncludeSidebar.jsp" %>
<div>
	<c:choose>
	    	<c:when test="${!empty items}">
	       		 <c:forEach var="item" items="${items}">
					<ul>
						<li><a href='<c:url value="/shop/auctionItemDetail">
				          <c:param name="itemId" value="${item.itemId}"/></c:url>'>
				          <c:if test="${not empty item.imgName}">
				          	<img id="m" src="<c:url value='/upload/${item.imgName}' />" />
				          </c:if>
				          </a></li>
						<li><a href='<c:url value="/shop/auctionItemDetail">
				          <c:param name="itemId" value="${item.itemId}"/></c:url>'>상품명 :<strong>${item.title}</strong></a></li>
						<li>가격 : ${item.price}</li>
					</ul>
				</c:forEach>
	   		</c:when>
	    	<c:otherwise>
	        	<h2>해당 상품이 존재하지 않습니다.</h2> 
	    	</c:otherwise>
	 </c:choose>
</div>
<a href="<c:url value="addAuctionItem" />">경매 상품등록</a>
</body>
</html>