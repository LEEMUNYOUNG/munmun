<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage Main</title>
<style>
a { color:black; text-decoration:none; }
li { list-style:none; margin-left:-1px; z-index:1; }
ul { display:inline-block; *display:inline; zoom:1; }
div, h3 { text-align:center;}
</style>
</head>
<body>
<%@ include file="IncludeTop.jsp" %>
<%@ include file="IncludeMypageBar.jsp" %>
<script type="text/javascript">
var message = '${message}';
if (message != "") {
   alert(message);
}
</script>
<h3>${userName}님의 마이페이지</h3>
<div>
   <ul>
      <li><img border="0" src="../images/m_iconM.png" /></li>
   </ul>
</div>
</body>
</html>