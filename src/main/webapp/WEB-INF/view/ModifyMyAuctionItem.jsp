<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>BPSP</title>
<style>
a { color:black; text-decoration:none; }
#tstyle { border-spacing:7px; }
#tstyle {
	margin:auto;
}
</style>
</head>


<body>
<%@ include file="IncludeTop.jsp" %>
<center><h5>${userName}님의 마이페이지</h5></center>
<table>
  <tr>
    <td><%@ include file="IncludeMypageBar.jsp" %></td>
    <td colspan="2"><div> 	
    <h3>경매 상품 수정</h3>
    <form:form modelAttribute="modifyAuc" action="updateAuction">
    
    	<label for="productId">상품 카테고리</label>
    	    <c:if test="${modifyAuc.item.productId == 'S001'}">
				<form:select path="item.productId">
    				<form:option value="S001" selected="selected">유모차</form:option>
    				<form:option value="S002">장난감</form:option>
    				<form:option value="S003">옷</form:option>
    				<form:option value="S004">신발</form:option>
    				<form:option value="S005">모빌</form:option>
    			</form:select>	
			</c:if>
			<c:if test="${modifyAuc.item.productId == 'S002'}">
				<form:select path="item.productId">
    				<form:option value="S001">유모차</form:option>
    				<form:option value="S002" selected="selected">장난감</form:option>
    				<form:option value="S003">옷</form:option>
    				<form:option value="S004">신발</form:option>
    				<form:option value="S005">모빌</form:option>
    			</form:select>	
			</c:if>
			<c:if test="${modifyAuc.item.productId == 'S003'}">
				<form:select path="item.productId">
    				<form:option value="S001">유모차</form:option>
    				<form:option value="S002">장난감</form:option>
    				<form:option value="S003" selected="selected">옷</form:option>
    				<form:option value="S004">신발</form:option>
    				<form:option value="S005">모빌</form:option>
    			</form:select>	
			</c:if>
			<c:if test="${modifyAuc.item.productId == 'S004'}">
				<form:select path="item.productId">
    				<form:option value="S001">유모차</form:option>
    				<form:option value="S002">장난감</form:option>
    				<form:option value="S003">옷</form:option>
    				<form:option value="S004" selected="selected">신발</form:option>
    				<form:option value="S005">모빌</form:option>
    			</form:select>	
			</c:if>
			<c:if test="${modifyAuc.item.productId == 'S005'}">
				<form:select path="item.productId">
    				<form:option value="S001">유모차</form:option>
    				<form:option value="S002">장난감</form:option>
    				<form:option value="S003">옷</form:option>
    				<form:option value="S004">신발</form:option>
    				<form:option value="S005" selected="selected">모빌</form:option>
    			</form:select>	
			</c:if>
			
    		<br>
    	
    	<label for="item.title">상품명</label>
    		<form:input path="item.title"/>
    		<form:errors path="item.title"/>
    		<br>
    	<label for="deadline">입찰기한</label>
    		<c:out value="${modifyAuc.deadline}"/>
    		<br>
    	<label for="item.price">가격 하한선</label>
    		<c:out value="${modifyAuc.item.price}"/>
    		<br>
    	<label for="item.stock">상품 재고</label>
    		<form:input path="item.stock"/>
    		<form:errors path="item.stock"/>
    		<br>
    	<label for="item.description">상품 설명</label>
    		<form:input path="item.description"/>
    		<form:errors path="item.description"/>
    		<br>
    		
    	<form:hidden path="item.price" value="${modifyAuc.item.price}"/>
    	<form:hidden path="auctionId" value="${modifyAuc.auctionId}"/>
    	<form:hidden path="item.categoryId" value="${modifyAuc.item.categoryId}"/>
    	<form:hidden path="deadline" value="${modifyAuc.deadline}"/>
    		
<%--     	<input type="hidden" name="hItemId" value="${modifyAuc.item.itemId }"/> --%>
<%--     	<input type="hidden" name="hPrice" value="${modifyAuc.item.price }"/> --%>
    	
    	<input type="submit" value="수정"/>
    	
    </form:form>

	</div></td>
  </tr>
</table>
</body>
</html>