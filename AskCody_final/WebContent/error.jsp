<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage="true" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <link rel="stylesheet" href="./css/askcody_about.css">
    <link rel="stylesheet" href="./css/askcody_choice.css">
    <link rel="stylesheet" href="./css/askcody_cssTemplate.css">
    <link rel="stylesheet" href="./css/askcody_gallery.css">
        <link rel="stylesheet" href="./css/askcody_index.css">
    <link rel="stylesheet" href="./css/askcody_login.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="./temp/header.jsp" %>

<div id = "output">
		<section>
		
		<h3> error page</h3>
					<h4 style="color: red;"> 서버 점검 중입니다.</h4>
				<div style="color:red;"><%=exception %></div>
				<div style="color: red;"> ${exception} </div>
				
	</section>
</div>

<%@include file="./temp/footer.jsp" %>
</body>
</html>