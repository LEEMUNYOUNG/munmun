<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%@ include file="IncludeTop.jsp" %>
<center><h5>${userName}님의 마이페이지</h5></center>
<table>
  <tr>
    <td><%@ include file="IncludeMypageBar.jsp" %></td>
    <td colspan="2"><div>    
    <form:form modelAttribute="modifyReq" method="post" action="modify">
<label for="userId">아이디 : </label>
         <c:out value="${modifyReq.userId}"></c:out> 
         <br>
      
      <form:hidden path="userId" value="${userId}"/>
      
      <label for="password">비밀번호 :  </label>
         <form:password path="password"/> 
         <form:errors path="password"/>
         <br>
      <label for="cPassword">비밀번호 확인</label>
         <form:password path="cPassword"/> 
         <form:errors path="cPassword"/>
         <br>
         
      <label for="name">이름 : </label>
         <form:input path="name"/>
         <form:errors path="name"/> <br>
         
      <label for="email">이메일 : </label>
         <form:input path="email"/>
         <form:errors path="email"/> <br>
         
      <label for="address">주소</label>
         <form:input path="address"/>
         <form:errors path="address"/>
       <br>
       
      <label for="phone">전화번호 : </label>
         <form:input path="phone"/>
         <form:errors path="phone"/>
         <br>
      <label for="birth">생년월일 </label>
         <form:input path="birth"/>
         <form:errors path="birth"/> 
         <br>
      
      성별 : 
         <c:if test="${modifyReq.sex == 'F'}">
            Female<input type="radio" name="sex" value="F" checked="checked">
            Male<input type="radio" name="sex" value="M">
         </c:if>
         <c:if test="${modifyReq.sex == 'M'}">
            Female<input type="radio" name="sex" value="F">
            Male<input type="radio" name="sex" value="M" checked="checked">
         </c:if>
          <br>
          
          
      <a href="<c:url value="/mypage/memberDetail" />">취소</a>
      <input type="submit" value="완료"/>
</form:form>
   </div></td>
  </tr>
</table>


</body>
</html>