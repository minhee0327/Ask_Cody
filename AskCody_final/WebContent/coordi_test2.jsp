<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/askcody_cssTemplate.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <style>
  .draggable{ width: 100px; height: 100px; padding: 0.5em; float: left; margin: 10px 10px 10px 0; }
  #droppable1, #droppable-container { width: 600px; height: 600px; padding: 0.5em; float: left; margin: 10px; }
  .img{width: 100px; height: 100px;}
  #main{
  	margin-left: 100px;
  }
  a{
  	text-decoration: none;
  }
  #button{
  	text-align: right;
  	margin-right: 222px;
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
    
  	
    $('#reset').click(function(){
		 $('#droppable1 .draggable').remove(); 
	  });
	$('#btn1').click(function () {
		  //var a = $('#droppable-container img').length;
		  var b = $('#droppable1 img').length;
		  let list =new Array;
		  	for (var i = 0; i < b; i++) {
				list.push($('#droppable1 img').eq(i).attr("src"));
		  	}; 
			$.ajax({
				url:'savecoordi.do',
				type:'POST',
				data: {list_num: b , list:list},
				//dataType: 'json',
				success:function(data){
		  			alert("코디에 저장되었습니다. 저장목록에서 확인해주세요");
				},
				error:function(request,error){
					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error)
				}
			});
			 $('#droppable1 .draggable').remove(); 
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
<div id="button">
<button id="btn1"  class="button">저장</button>
<input id="reset"  class="button" type="reset" value="처음부터">
<a  href="listcoordibook.do" class="button">옷 저장 목록</a>
</div>
<!-- 게시판 링크 수정은 askcody_header에서! -->
<!-- 여기에 본문 내용을 넣어주세요 -->
<form method="post">
<div style="overflow:scroll" id="droppable1" class="ui-widget-header">
  <p>여기에 옷을 놓아주세요</p>
</div>

<div style="overflow:scroll" id="droppable-container" class="ui-widget-header">
	
<c:forEach var="data" items="${suggestion}">
	<div class="draggable ui-widget-content">
	<input type="hidden" value="${data.image}" name="coordi_id" >
	  <img class="img" src="${data.image}">
	</div>
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