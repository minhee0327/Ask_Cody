<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/askcody_login.css">
<title> AskCody - Login </title>
</head>


<body>
<br/><br/><br/>
<%@include file="./temp/loginheader.jsp" %>
<div>
<section>
<!-- 여기에서부터 본문내용 시작 -->


<br/>

<h2 id="title"> LOGIN </h2>

<br/><br/>

<form action="login.do" method="post" onsubmit="return check()">

	<div class="table">
		<div class="tr1" >
			<input style="cursor: pointer" type="text" class="idpw" id="id" name="id" value="${id}" placeholder="아이디"/>
		</div>
		<div class="tr1">
			<input style="cursor: pointer" type="password" class="idpw" id="pw" name="pw" value="" placeholder="비밀번호"/>
		</div>
		<div class="tr2">
			<input style="cursor: pointer" type="submit" class="lcbtns" value="로그인">
		</div>
		<div class="tr2">
			<input style="cursor: pointer" type="reset" class="lcbtns" value="취소">
		</div>
	</div>

<br/>
<hr class="midline"/>

<div class="signup">
	<a href="signup.jsp" id="btnsignup">회원가입</a><br/>
	<span style="color: red;">${msg}</span>
</div>

</form>

<br/><br/>

<script>
function check(){
	let id = document.querySelector("#id");
	let pw = document.querySelector("#pw");

	if(id.value.trim().length < 5 ){
		alert("ID를 5글자 이상 입력하세요.");
		id.focus();
		return false;
	}
	return true;
}

</script>

<!-- 여기까지 본문내용 -->
</section>
</div>
<div style="clear: both;"></div>
<%@include file="./temp/footer.jsp" %>
</body>
</html>