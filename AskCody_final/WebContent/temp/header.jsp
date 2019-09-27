<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>

<div id="users">
	<c:if test="${null eq id}">
	<span><a href="login.jsp" class="reg"> LOGIN </a></span> 
	</c:if>
	<c:if test="${null ne id}">
	<span><a href="logout.do" class="reg"> LOGOUT(로그인정보:${user_name}) </a></span> 
	</c:if>
	<span><a href="signup.jsp" class="reg"> SIGN UP </a></span>
</div>
<br/>

<div id="logo">
	<a href="index.jsp">
		<img src="./img/logo.png" alt="로고">
	</a>
</div>
<br/>

<div id="dropdown">
	<ul>
		<li><a href="#" class="menu"> OOTD </a>
			<ul>
				<li><a href="gallery.jsp"> Gallery </a></li>
			</ul>
		</li>
		<li><a href="#" class="menu"> CUSTOM </a>
			<ul>
				<li><a href="finder.jsp"> Finder </a></li>
				<li><a href="makecoordi.do"> Coordi </a></li>
				<li><a href="z_coordi.jsp"> Z_Coordi </a></li>
			</ul>
		</li>
		<li><a href="#" class="menu"> BOARD </a>
			<ul>
				<li><a href="listBoard.do"> FreeBoard </a></li>
			</ul>
		</li>
		<li><a href="#" class="menu"> ASKCODY </a>
			<ul>
				<li><a href="about.jsp"> About </a></li>
				<li><a href="growth.jsp"> Growth </a></li>
				<li><a href="location.jsp"> Location </a></li>
			</ul>
		</li>
	</ul>
</div>
<br/><br/>

<hr noshade/>
</header>