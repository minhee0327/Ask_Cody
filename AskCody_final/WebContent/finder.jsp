<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/askcody_finder.css">
<title> Choice - AskCody</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js"></script>

<script>

function f1(){
	$('.alert').slideUp(1000);
}

</script>
</head>


<body>

<%@include file="./temp/header.jsp" %>
<div>
<section>
<!-- 여기에서부터 본문내용 시작 -->


<br/>
<h1 id="title"> Look for Your AskCody </h1>

<form action="filterClothes.do" method="get" name="please">
<div class="table">

		<div class="column1"> 
			<span class="sbox01"><b>/TYPE/</b></span><br/>
			<span class="sbox01"><b>/COLOR/</b></span>
		</div>
	
		<div class="column2">
			<label><input type="radio" id="1" name="cloth_type" value="alltype" checked="checked"><span class="sbox02">All</span></label>
			<label><input type="radio" name="cloth_type" value="top"><span class="sbox03">Top</span></label>
			<label><input type="radio" name="cloth_type" value="bottom"><span class="sbox04">Bottom</span></label>
			<label><input type="radio" name="cloth_type" value="cap"><span class="sbox">Cap</span></label>
		<br/>
			<label><input type="radio" name="cloth_color" value="allcolor" checked="checked"><span class="sbox02">All</span></label>
			<label><input type="radio" name="cloth_color" value="black"><span class="sbox03" style="color: black;">Black</span></label>
			<label><input type="radio" name="cloth_color" value="navy"><span class="sbox04" style="color: navy;">Navy</span></label>
			<label><input type="radio" name="cloth_color" value="pink"><span class="sbox" style="color: rgb(254, 127, 206);">Pink</span></label>
			<label><input type="radio" name="cloth_color" value="white"><span class="sbox" style="color: silver;">White</span></label>
		</div>

</div>

<div style="cursor: pointer" class="alert" onclick="f1()">

	<h2>Read Me!</h2>
	<p>If you want to look for some styles along with types and colors, 
	select one <b>type</b> button and one <b>color</b> button. 
	After you select all buttons by category, Click <b>'Ask Cody'</b> button below. 
	They may help you what to wear today or someday. Enjoy your styles at AskCody.
	</p>
	
	<p>Click if you want to close this alert.</p>
	
</div>
<br/><br/>

<div class="search">
	<button type="submit" id="submit" name="submit" class="btnsearch" value="Ask Cody">Ask Cody</button>
</div>

<!-- !PAGE CONTENT! -->
<div class="w3-padding" style="max-width:1200px; margin: 15px auto;">

<!-- First Photo Grid-->
<div class="w3-row-padding w3-padding-16 w3-center" id="">
<c:forEach var="data" items="${filteredlist}">
	<div class="w3-quarter">
		<a href="#">
			<img src="${data.image}" alt="" style="width:100%; height: 400px;">
		</a>
		<h3>The Perfect Sandwich, A Real NYC Classic</h3>
		<p>Just some random text, lorem ipsum text praesent tincidunt ipsum lipsum.</p>
	</div>
</c:forEach>
</div>

<!-- Second Photo Grid-->

</div>
</form>

<!-- Pagination -->
<div class="w3-center w3-padding-32">
	<div class="w3-bar" id="paging">
		<a href="#" class="w3-bar-item w3-button w3-hover-black">«</a>
		<a href="#" class="w3-bar-item w3-black w3-button">1</a>
		<a href="#" class="w3-bar-item w3-button w3-hover-black">2</a>
		<a href="#" class="w3-bar-item w3-button w3-hover-black">3</a>
		<a href="#" class="w3-bar-item w3-button w3-hover-black">4</a>
		<a href="#" class="w3-bar-item w3-button w3-hover-black">5</a>
		<a href="#" class="w3-bar-item w3-button w3-hover-black">»</a>
	</div>
</div>


<div>
</div>


<!-- 여기까지 본문내용 -->
</section>
</div>
<div style="clear: both;"></div>
<%@include file="./temp/footer.jsp" %>
</body>
</html>