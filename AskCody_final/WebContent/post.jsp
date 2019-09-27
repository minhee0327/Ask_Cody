<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/askcody_post.css">
<link rel="stylesheet" href="./css/askcody_cssTemplate.css">
<title> Welcome AskCody </title>
</head>

<body>
<%@include file="./temp/header.jsp" %>
<div>
<section>
<!-- 여기에서부터 본문내용 시작 -->


<!-- 게시판 링크 수정은 askcody_header에서! -->
<!-- 여기에 본문 내용을 넣어주세요 -->
<div id="post">
	<div id=titlediv>
	<table>
		<tbody>
			<tr><td>
			<span id="title" ><strong>제목 :  ${title} </strong></span> 
			</td>
			<td class="bordertd"></td>
			<td>
			
			<a id="golist" href="listBoard.do">목록으로</a>
			
			<c:set var="id" value="${id}" />
			<c:set var="user_id" value="${user_id}" />
			<c:set var="role" value="${role}" />
		
		<c:choose>
			<c:when test="${user_id eq id}">
				<a id="modify" href="go_board_modify.do?post_id=${postid}">수정</a>
				<a id="delete" href="board_delete.do?post_id=${postid}">삭제</a>
			</c:when>

			<c:when test="${role eq 'admin'}">
				<a id="delete" href="board_delete.do?post_id=${postid}">삭제</a>
			</c:when>

		</c:choose>
			
			</td>
			</tr>
		</tbody>
	</table>
	</div>
	<hr>
	<p>${content}</p>
</div>

<!-- 여기까지 본문내용 -->
</section>
</div>
<div style="clear: both;"></div>
<%@include file="./temp/footer.jsp" %>
</body>
</html>