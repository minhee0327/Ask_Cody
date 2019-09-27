<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/askcody_location.css">
<script src="https://maps.google.com/maps/api/js?sensor=false"></script>
<title> Location - AskCody</title>
</head>

<body>
<%@include file="./temp/header.jsp" %>
<div>
<section>
<!-- 여기에서부터 본문내용 시작 -->

<br/>
<h3 class="title"> LOCATION </h3>

<div id="map"></div>
<script type="text/javascript">

const log = console.log;

navigator.geolocation.getCurrentPosition(initmap)

function initmap(position){
	
	let p = {
		lat : 37.4993,
		lng : 127.02929
	};
	
	let map = new google.maps.Map(document.getElementById('map'), 
			{zoom:16, center:p});
	
	let marker = new google.maps.Marker({
		position: {
			lat : 37.4993,
			lng : 127.02929
		},
		map: map,
		label: 'AskCody',
		href:"http://www.daum.net"
	});
	
}

</script>

<div class="publictrans">
<p>
주소: 서울특별시 강남구 테헤란로5길 11 YBM빌딩 2층, AskCody
</p>
</div>

<br/><br/><br/>

<!-- 여기까지 본문내용 -->
</section>
</div>
<div style="clear: both;"></div>
<%@include file="./temp/footer.jsp" %>
</body>
</html>