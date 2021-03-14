<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BPSP</title>
<style>
#t table {
	background-color: #FFFF88;	
	border: none;
	width: 170px;
	border-collapse: collapse;
}
table tr td {
    padding: 5px; 
}
</style>
</head>
<body>
<table id="t" style="border:none;border-collapse:collpase;width:15%">
	<tr>
	 <td style="text-align:left;vertical-align:top;width:100%">
      <table style="border:none;border-collapse:collapse;width:80%">
        <tr>
          <td valign="top">                    
            <!-- SIDEBAR -->
            <table id="index">
              <tr>
          	    <td>
          	      <a href="<c:url value='/shop/viewCategory.do?categoryId=sale'/>">일반</a>
          	    </td>
          	  </tr>
          	  <tr>
          	    <td>
          	      <a href="usedProduct">중고</a>
          	    </td>
          	  </tr>
          	  <tr>
          	    <td>
          	      <a href="<c:url value="/shop/auctionProduct" />">경매</a>
          	    </td>
          	  </tr>
            </table>
          </td>
        </tr>
        </table>
      </td>
    </tr>
</table>
</body>
</html>