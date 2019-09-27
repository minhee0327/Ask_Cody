<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/askcody_cssTemplate.css">
<title> Welcome AskCody </title>
<style type="text/css">
	table{
		margin: 0 auto;
		text-align: center;
		border-collapse: collapse;
		padding: 20px;
	}
	tr, td{
	padding: 10px;
	
	}
	
	h3{
		text-align: center;
	}
	table a{
		margin: 5px;
		text-decoration: none;
		color: black;
	}
	a:hover {
		color: red;
	}
	
</style>


</head>

<body>
<%@include file="./temp/header.jsp" %>
<div>
<section>
<!-- 여기에서부터 본문내용 시작 -->
<!-- 게시판 링크 수정은 askcody_header에서! -->
<!-- 여기에 본문 내용을 넣어주세요 -->
<h3>코디 아이디</h3>
<table>
<tr>
<c:forEach var="data" items="${loadcoordibook}">
<td><a href="./listcoordi.do?coordi_id=${data.coordi_id}">${data.coordi_id}</a></td>
</c:forEach>
</tr>
</table>


<!-- 여기까지 본문내용 -->
</section>
</div>
<div style="clear: both;"></div>
<%@include file="./temp/footer.jsp" %>
</body>
</html>