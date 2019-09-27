<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/askcody_cssTemplate.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
   <style>
  #droppable-container {overflow:scroll; width: 600px; height: 600px; padding: 0.5em; float: left; margin: 10px auto; }
  .img{width: 100px; height: 100px;}
  #main{
  	margin-left:350px;
  }
  a{
  	text-decoration: none;
  	color: black;
  }
  .button{
  background-color: black;
  border: none;
  color: white;
  padding: 10px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  }
  .button:hover {
	background-color: gray;
	cursor: pointer;
	}
	section{
	margin-left:  150px;
	}
	.ui-widget-header img{
		width: 100px;
	}
  </style>

  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  const log  = console.log;
  let img;
 
  $( function() {
	  
	  
    $( "#droppable-container .draggable" ).draggable({ revert: "invalid", connectToSortable: "#droppable1", helper: "clone"});
 
    $( "#droppable1, #droppable-container" ).sortable({
        connectWith: ".connectedSortable"
      }).disableSelection();
    $('.img').resizable();
    
    $( "#droppable1,#droppable-container" ).droppable({
      classes: {
        "ui-droppable-active": "ui-state-active",
        "ui-droppable-hover": "ui-state-hover"
      },
      drop: function( event, ui ) {
        $( this )
          .addClass( "ui-state-highlight" )
          .find( "p" )
            .html( "코디북 만들기  시작!!!" );
      }
    });
    
	
	$('#btn1').click(function () {
		  //var a = $('#droppable-container img').length;
		  var b = $('#droppable1 img').length;
		  let list =new Array;
		  	for (var i = 0; i < b; i++) {
				list.push($('#droppable1 img').eq(i).attr("src"));
		  	}; 
		  	alert(list);
			$.ajax({
				url:'savecoordi.do',
				type:'POST',
				data: {list_num: b , list:list},
				dataType: 'json',
				success:function(data){
					alert('success');
					//$('#msg').html('success')
				},
				error:function(error){
					alert('error');
					$('#msg').html('error '+error)
				}
			});
		});
  });
  
  </script>


<title> Welcome AskCody </title>
</head>

<body>
<%@include file="../temp/header.jsp" %>


<div id="main">
<section>
<!-- 여기에서부터 본문내용 시작 -->
<p><a href="makecoordi.do" class="button">코디 저장 더 하러가기</a></p>
<!-- 게시판 링크 수정은 askcody_header에서! -->
<!-- 여기에 본문 내용을 넣어주세요 -->
<form action="listcoordi.do" method="post">

<div id="droppable-container" class="ui-widget-header">
	<c:forEach var="data" items="${loadcoordibook}">
		<img alt=""src="${data.image}" style="width: 100px">
	</c:forEach>
</div>



<!-- 여기까지 본문내용 -->
</form>
</section>
<div style="clear: both;"></div>
</div>

<%@include file="../temp/footer.jsp" %>
</body>
</html>