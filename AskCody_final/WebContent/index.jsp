<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/askcody_index.css">
<title> Welcome AskCody </title>
</head>

<body>
<%@include file="./temp/header.jsp" %>
<div>
<section>

<div class="center">
	<img src="./img/main.jpg" alt="메인" class="main">
<br/><br/>		

	<h2 id="midmsg"> Get Your Style </h2>
	
	<ul class="newul">
		<li>
			<a href="#">
				<img src="./img/main1.gif" alt="새로운상품" class="submainimg">
			</a>
		</li>
		<li>
			<a href="#">
				<img src="./img/main2.gif" alt="새로운상품" class="submainimg">
			</a>
		</li>
	</ul>
</div>

</section>
</div>
<div style="clear: both;"></div>
<%@include file="./temp/footer.jsp" %>
</body>
</html>