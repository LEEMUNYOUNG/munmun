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
</style>
</head>
<body>
<%@ include file="IncludeTop.jsp" %>
<%@ include file="IncludeSidebar.jsp" %>
<a href='<c:url value="/"/>'>
<b><font color="black" size="2">&lt;&lt; 처음으로</font></b></a>
<script type="text/javascript">
var message = '${message}';
if (message != "") {
   alert(message);
}
</script>
<div>
      <h1>Shopping Cart</h1>
      <h3>일반 상품</h3>
      <form action='<c:url value="/shop/updateCartQuantities"/>' method="post">
        <table id="cart" align="center">
          <tr>
            <td><b>상품명</b></td>
            <td><b>상품설명</b></td>
            <td><b>재고여부</b></td>
            <td><b>상품가격</b></td>
            <td><b>수량</b></td>
            <td><b>상품촘액</b></td>
            <td>&nbsp;</td>
          </tr>

          <c:if test="${cart.numberOfItems == 0}">	<%-- 장바구니가 비어있다면 띄움 --%>
            <tr>
              <td colspan="8"><b>장바구니가 비어 있습니다.</b></td>
            </tr>
          </c:if>

          <c:forEach var="cartItem" items="${cart.cartItemList.pageList}">
            <tr>
              <td><b>
                <a href='<c:url value="/shop/viewItemDetail.do">
                  <c:param name="itemId" value="${cartItem.item.itemId}"/></c:url>'>
                  <c:out value="${cartItem.item.title}" />		<%-- 상품명 --%>
                </a></b></td>
              <td><c:out value="${cartItem.item.description}" /></td>	<%-- 상품 설명 --%>
              <td style="text-align:center"><c:out value="${cartItem.inStock}" /></td>	<%-- 상품 재고 여부 --%>
              <td style="text-align:right"><fmt:formatNumber
                  value="${cartItem.item.price}" /></td>		<%-- 상품 1개 가격 --%>
              <td style="text-align:center">
                <input type="text" size="3"
                  name='<c:out value="${cartItem.item.itemId}"/>'
                  value='<c:out value="${cartItem.quantity}"/>' /></td>		<%-- 상품 수량 설정 --%>
              <td style="text-align:right"><fmt:formatNumber
                  value="${cartItem.totalPrice}" /></td>		<%-- 상품 전체 가격 --%>
              <td><a href='<c:url value="/shop/removeItemFromCart">		<%-- 상품 삭제 --%>
                    <c:param name="workingItemId" value="${cartItem.item.itemId}"/></c:url>'>
                    <img border="0" src="../images/button_remove.gif" alt="" /></a>
              </td>
            </tr>
          </c:forEach>
          <tr>
            <td colspan="7" align="right">
              <b>총 가격: <fmt:formatNumber value="${cart.subTotal}" /></b><br><br> 
              <input type="image" src="../images/button_update_cart.gif" name="update" />
            </td>
            <td>&nbsp;</td>
          </tr>
        </table>
        <div style="text-align:center">
          <c:if test="${!cart.cartItemList.firstPage}">
            <a href='<c:url value="viewCart.do?page=previousCart"/>'>
              <font color="green"><B>&lt;&lt; 이전페이지</B></font></a>
          </c:if>
          <c:if test="${!cart.cartItemList.lastPage}">
            <a href='<c:url value="viewCart.do?page=nextCart"/>'>
              <font color="green"><B>다음페이지 &gt;&gt;</B></font></a>
          </c:if>
        </div>
      </form>     
      
      <h3>중고</h3>
      <form action='<c:url value="/shop/updateCartQuantities"/>' method="post">
        <table id="cart" align="center">
          <tr>
           <td><b>상품명</b></td>
            <td><b>상품설명</b></td>
            <td><b>재고여부</b></td>
            <td><b>상품가격</b></td>
            <td><b>수량</b></td>
            <td><b>상품촘액</b></td>
            <td>&nbsp;</td>
          </tr>

          <c:if test="${cart.numberOfUsedItems == 0}">	<%-- 장바구니가 비어있다면 띄움 --%>
            <tr>
              <td colspan="8"><b>장바구니가 비어 있습니다.</b></td>
            </tr>
          </c:if>
          
          <c:forEach var="cartItem" items="${cart.usedCartItemList.pageList}">
            <tr>
              <td><b>
                <a href='<c:url value="viewProduct">
                  <c:param name="itemId" value="${cartItem.item.itemId}"/></c:url>'>
                  <c:out value="${cartItem.item.title}" />		<%-- 상품명 --%>
                </a></b></td>
              <td><c:out value="${cartItem.item.description}" /></td>	<%-- 상품 설명 --%>
              <td style="text-align:center"><c:out value="${cartItem.inStock}" /></td>
              <td style="text-align:right"><fmt:formatNumber
                  value="${cartItem.item.price}" /></td>		<%-- 상품 1개 가격 --%>
              <td style="text-align:center">
                <input type="text" size="3"
                  name='<c:out value="${cartItem.item.itemId}"/>'
                  value='<c:out value="${cartItem.quantity}"/>' /></td>		<%-- 상품 수량 설정 --%>
              <td style="text-align:right"><fmt:formatNumber
                  value="${cartItem.totalPrice}" /></td>		<%-- 상품 전체 가격 --%>
              <td><a href='<c:url value="/shop/removeItemFromCart">		<%-- 상품 삭제 --%>
                    <c:param name="workingItemId" value="${cartItem.item.itemId}"/></c:url>'>
                    <img border="0" src="../images/button_remove.gif" alt="" /></a>
              </td>
            </tr>
          </c:forEach>
          <tr>
            <td colspan="7" align="right">
              <b>총 가격: <fmt:formatNumber value="${cart.usedSubTotal}" /></b><br><br> 
              <input type="image" src="../images/button_update_cart.gif" name="update" />
            </td>
            <td>&nbsp;</td>
          </tr>
        </table>
        <div style="text-align:center">
          <c:if test="${!cart.usedCartItemList.firstPage}">
            <a href='<c:url value="viewCart.do?page=previousCart"/>'>
              <font color="green"><B>&lt;&lt; 이전페이지</B></font></a>
          </c:if>
          <c:if test="${!cart.usedCartItemList.lastPage}">
            <a href='<c:url value="viewCart.do?page=nextCart"/>'>
              <font color="green"><B>다음페이지 &gt;&gt;</B></font></a>
          </c:if>
          
        </div>
      </form> 
      <div style="text-align:center">
         <a href='<c:url value="/shop/newOrder.do"/>'>
            <img border="0" src="../images/button_checkout.gif" alt="" /></a>
      </div>   
</div>
</body>
</html>