<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/askcody_gallery.css">
<title> Gallery - AskCody</title>
</head>

<body>
<%@include file="./temp/header.jsp" %>
<div id="outline" style="margin: 35px auto;">
<section>
<!-- 여기에서부터 본문내용 시작 -->

<br/>
<h1 id="title"> Gallery </h1>

<div class="row">
	<div class="column">
		<img src="./img/sfw01.jpg" class="imgchoice"/>
		<img src="./img/sfw02.jpg" class="imgchoice"/>
		<img src="./img/sfw03.jpg" class="imgchoice"/>
		<img src="./img/sfw04.jpg" class="imgchoice"/>
		<img src="./img/sfw05.jpg" class="imgchoice"/>
		<img src="./img/sfw06.jpg" class="imgchoice"/>
		<img src="./img/sfw07.jpg" class="imgchoice"/>
	</div>
	<div class="column">
		<img src="./img/sfw08.jpg" class="imgchoice"/>
		<img src="./img/sfw09.jpg" class="imgchoice"/>
		<img src="./img/sfw10.jpg" class="imgchoice"/>
		<img src="./img/sfw11.jpg" class="imgchoice"/>
		<img src="./img/sfw12.jpg" class="imgchoice"/>
		<img src="./img/sfw13.jpg" class="imgchoice"/>
		<img src="./img/sfw14.jpg" class="imgchoice"/>
	</div>
	<div class="column">
		<img src="./img/sfw15.jpg" class="imgchoice"/>
		<img src="./img/sfw07.jpg" class="imgchoice"/>
		<img src="./img/sfw06.jpg" class="imgchoice"/>
		<img src="./img/sfw05.jpg" class="imgchoice"/>
		<img src="./img/sfw04.jpg" class="imgchoice"/>
		<img src="./img/sfw03.jpg" class="imgchoice"/>
		<img src="./img/sfw02.jpg" class="imgchoice"/>
	</div>
	<div class="column">
		<img src="./img/sfw14.jpg" class="imgchoice"/>
		<img src="./img/sfw13.jpg" class="imgchoice"/>
		<img src="./img/sfw12.jpg" class="imgchoice"/>
		<img src="./img/sfw11.jpg" class="imgchoice"/>
		<img src="./img/sfw10.jpg" class="imgchoice"/>
		<img src="./img/sfw09.jpg" class="imgchoice"/>
		<img src="./img/sfw08.jpg" class="imgchoice"/>
	</div>
</div>



<!-- 여기까지 본문내용 -->
</section>
</div>
<div style="clear: both;"></div>
<%@include file="./temp/footer.jsp" %>
</body>
</html>