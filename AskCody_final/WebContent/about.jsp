<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/askcody_about.css">
<title> AskCody - About </title>
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>

<body>
<%@include file="./temp/header.jsp" %>
<div>
<section>
<!-- 여기에서부터 본문내용 시작 -->


<br/>
<h1 id="title"> About </h1>

<div class="center">
	<img src="./img/logo.png" alt="메인로고" class="mainlogo">
</div>
<br/>

<div class="title">
<h2>Executives of AskCody</h2>
<p>For better styles, AskCody</p>
</div>

<div class="container">
  <img src="./img/seonghyeon.jpg" alt="Avatar" style="width:90px">
  <p><span>Seonghyeon Kim</span> CEO at AskCody</p>
  <p>조장 및 자유게시판</p>
</div>

<div class="container">
  <img src="./img/minhee.jpg" alt="Avatar" style="width:90px">
  <p><span>Minhee Kang</span> Executives at AskCody</p>
  <p>코디북</p>
</div>

<div class="container">
  <img src="./img/jihye.jpg" alt="Avatar" style="width:90px">
  <p><span>Jihye Seong</span> Executives at AskCody</p>
  <p>로그인, 회원가입</p>
</div>

<div class="container">
  <img src="./img/eunseok.jpg" alt="Avatar" style="width:90px">
  <p><span>Eunseok Shin</span> Executives at AskCody</p>
  <p>코디 파인더 및 UI</p>
</div>



<br/><br/>


<!-- 여기까지 본문내용 -->
</section>
</div>
<div style="clear: both;"></div>
<%@include file="./temp/footer.jsp" %>
</body>
</html>