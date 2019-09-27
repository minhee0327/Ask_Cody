<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet" href="./css/askcody_cssTemplate.css?1">
<link rel="stylesheet" href="./css/askcody_boardwriter.css">
<title> Welcome AskCody </title>
</head>

<body>
<%@include file="./temp/header.jsp" %>
<div>
<section>
<!-- 여기에서부터 본문내용 시작 -->


<!-- 게시판 링크 수정은 askcody_header에서! -->
<!-- 여기에 본문 내용을 넣어주세요 -->
	<form action="write.do" method="get" enctype="multipart/form-data">
		<span>제목</span> <input type="text" id="title" name="title"> <br>
		<%-- <%=" 첨부파일	" %> <input type="file" id="image" name="image" multiple="multiple"> <br> --%>
		
		<input type="text" id="content" name="content"> 
		<br>
		<input id="button" type="submit" class="btn_writer button" value="확인"> <a class="btn_writer button" href="listBoard.do">취소</a> 
	</form>
<!-- 여기까지 본문내용 -->
</section>
</div>
<div style="clear: both;"></div>
<%@include file="./temp/footer.jsp" %>
</body>
</html>