<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
</style>
</head>
<body>
<%@ include file="IncludeTop.jsp" %>
<%@ include file="IncludeSidebar.jsp" %>
<form:form modelAttribute="usedInfo" method="post" action="add" enctype="multipart/form-data">
  <table id="tstyle">
     <tr>
       <td>
         <h3>중고 상품 등록</h3>
         <table>
           <tr>
             <td>상품카테고리</td>
             <td>
             <form:label path="productId"/>
             <form:select path="productId" items="${ProductType}" />
             </td> 
           </tr>
           <tr>
             <td>상품명</td>
             <td>
             <form:label path="title" />
             <form:input path="title" />
             <form:errors path="title"/>
             </td>
           </tr>
           <tr>
             <td>가격</td>
             <td>
             <form:label path="price" />
             <form:input path="price" />
             <form:errors path="price"/>
             </td>
           </tr>
           <tr>
             <td>수량</td>
             <td>
             <form:label path="stock" />
             <form:input path="stock" />
             <form:errors path="stock"/>
             </td>
           </tr>
           <tr>
             <td>사용기간</td>
             <td>
             <form:label path="usingTime" />
             <form:input path="usingTime" />
             <form:errors path="usingTime"/>
             </td>
           </tr>
           <tr>
             <td>사진</td>
             <td>
             <input type="file" name="report" />
             </td>
           </tr>
           <tr>
             <td>설명</td>
             <td>
             <form:label path="description" />
             <form:input path="description" />
             <form:errors path="description"/>
             </td>
           </tr>
         </table>
       </td>
     </tr>
     <tr>
       <td>
        <br />
      <a href="usedProduct">취소</a> &nbsp;&nbsp;
      <input type="submit" value="OK">
    </td>
  </tr>
 </table>
</form:form>
</body>
</html>