<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<head>
<meta charset="UTF-8">
<title> Welcome AskCody </title>

<link rel="stylesheet" href="./css/askcody_cssTemplate.css">
<style type="text/css">

#search {
	margin: auto;
}
#move {
	text-align: center;
	
}
#move a{
	text-decoration: none;
}
.move_board{
	margin: 5px;
}
.button{
	background-color: black;
  border: none;
  color: white;
  padding: 2px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  }
  .button:hover {
	background-color: gray;
	cursor: pointer;
}
select {
	 padding-bottom: 4px; 
	 padding-top: 1px;
}
td{
	cursor: pointer;
}
</style>

<script type="text/javascript">
$(function() {
	/*  */
	$('.list').click(function() {
		let postid = $(this).find('#post_id').text();
		
		location.href='post.do?post_id='+postid;
	})
})

</script>

</head>

<body>
<%@include file="./temp/header.jsp" %>
<div>
<section>
<!-- 여기에서부터 본문내용 시작 -->
<div id="main">
		<table class="table">
			<thead>
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="data" items="${boardlist}">
				<tr class="list">
					<td id="post_id">${data.post_id}</td>
					<td>${data.user_id}</td>
					<td>${data.title}</td>
					<td>${data.post_date}</td>
					<td>${data.count}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<p id=move>
		<a class="move_board" href="moveboard.do?keyword=${keyword}&condition=${condition}&board_num=1"><<&nbsp</a>
		<c:set var="list_num" value="${list_num}"/>
		<%
		int list_num = (int)pageContext.getAttribute("list_num");
			
		for(int i=1; i <= list_num;i++) { %>
			<a class="move_board" href="moveboard.do?keyword=${keyword}&condition=${condition}&board_num=<%=i%>"><%=i%></a>
		<%}%>
		<a class="move_board" href="moveboard.do?keyword=${keyword}&condition=${condition}&board_num=${list_num}">&nbsp>></a>
		</p>
		<br>
		<c:if test="${id ne null}">		
		<a id="write_btn" class="btn btn-default pull-right button" href="boardwriter.jsp"> 글쓰기 </a>
		</c:if>
		<c:if test="${id eq null}">		
		<a id="write_btn" class="btn btn-default pull-right button" href="login.jsp"> 글쓰기 </a>
		</c:if>
		
		<form action="${pageContext.request.contextPath}/board_search.do" method="post">
    <table id=search>
        <tr>
           <td>
              <select name="condition">
                  <option value="title">제목</option>
                  <option value="user_name">작성자</option>
              </select>
              <input type="text" name="keyword">
              <input type="submit" value="검색" class="button">
           </td>
        </tr>
    </table>
</form>
	</div>
<!-- 여기까지 본문내용 -->
</section>
</div>
<div style="clear: both;"></div>
<%@include file="./temp/footer.jsp" %>
</body>
</html>