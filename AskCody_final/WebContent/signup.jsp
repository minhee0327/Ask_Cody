<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="./css/askcody_signup.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>Sign Up - AskCody</title>

<style type="text/css">
.error {
	color: red;
}
</style>

<script type="text/javascript">
	const log = console.log;
	let xdata;
	$(function() {
		$('#id_check').click(function() {
			idcheck();
		});
	});

	function idcheck() {
	$.ajax({
			url : 'json/id_check.jsp',
			dataType : 'json',
			data : {
				id : $('#id').val()
			},
			success : function(data) {
				if (data.id == undefined) {
					$('#msg1').html('사용가능한아이디입니다.')
				} else {
					$('#msg1').html('사용중인아이디입니다.')
				}
			},
			error : function() { 
				alert("error " + e);
			}
		});
	}


	$(function() {
		$('#pw').keyup(function(){
			$('#checkNotice').html('');
		});
		
		$('#pw_check').keyup(function(){
			
			if($('#pw').val() != $('#pw_check').val()) {
				$('#checkNotice').html('비밀번호 일치하지 않음');
				$('#checkNotice').attr('color', 'red');
			} else {
				$('#checkNotice').html('비밀번호 일치함');
				$('#checkNotice').attr('color', 'blue');
			}
		});
	});

</script>

</head>


<body>
<br/><br/><br/>
<%@include file="./temp/loginheader.jsp"%>
<div>
<section>
<!-- 여기에서부터 본문내용 시작 -->


<br/>

<h2 id="title"> Sign Up </h2>
<br/>
<h4 id="subtitle">아래 사항을 기입해주세요.</h4>
<br/><br/>

<form action="insertusers.do" method="post">

	<div class="table">
		<div class="idoutline">
		<span class="legend"><label for="id">아이디</label></span><br/>
			<div class="tr1">
				<input type="text" class="realinput" id="id" name="id" value="" placeholder="아이디를 입력해주세요."/><br/><br/>
				<input type="button" value="ID중복체크" id="id_check">&nbsp;&nbsp;<span id="msg1" class="error"></span>
			</div>
		</div>
		<div>
		<span class="legend"><label for="password">비밀번호 (영문 대문자,소문자,숫자포함 5글자 이상)</label></span><br/>
			<div class="tr1">
				<input type="password" class="realinput" id="pw" name="password" value="" placeholder="비밀번호를 입력해주세요."
				required="required" pattern="(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{5,}"/>	
			</div>
		</div>
		<div>
		<span class="legend"><label for="pw_check">비밀번호확인</label></span><br/>
			<div class="tr1">
				<input type="password" class="realinput" id="pw_check" value="" placeholder="비밀번호를 한 번 더 입력해주세요."/> <br/><br/> 
				<span id="msg5" class="error"></span> <font id="checkNotice" size="2"></font>
			</div>
		</div>
		<div>
		<span class="legend"><label for="name">이름</label></span><br/>
			<div class="tr1">
				<input type="text" class="realinput" id="name" name="user_name" value="" placeholder="이름을 입력해주세요."/>
			</div>
		</div>
		<div>
		<span class="legend"><label for="birthday">생년월일</label></span><br/>
			<div class="tr1">
				<input type="date" class="realinput" min="1950-01-01" max="2018-01-01" name="birthday" value=""/>
			</div>
		</div>
		<div>
		<span class="legend"><label for="email">이메일주소</label></span><br/>
			<div class="tr1">
				<input type="text" class="realinput" name="email" value="" placeholder="이메일주소를 입력해주세요."/>
			</div>
		</div>
		<div>
		<span class="legend"><label for="role">ROLE</label></span><br/>
			<div class="role" >
				<input type="radio" name="role" value="admin">Admin /
				<input type="radio" name="role" value="user">User
			</div><br/>
		</div>
		<div class="">
			<input type="submit" class="lcbtns" id="s" value="회원가입">
			<input type="reset" class="lcbtns" id="u" value="취소">
		</div>
	</div>
<br/><br/>
</form>


<!-- 여기까지 본문내용 -->
</section>
</div>
<div style="clear: both;"></div>
<%@include file="./temp/footer.jsp" %>
</body>
</html>