<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/series-label.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<link rel="stylesheet" href="./css/askcody_growth.css">
<title> Growth - AskCody </title>

<script>

let xdata;

$(()=>{
	
	$('#btn1').click(function() {
		$.ajax({
			url : 'chart_data.jsp',
			dataType : 'json',
			success : function(data){
				xdata = data;
				chart(xdata);
			},
			error : function(e){
				alert('error : '+e);
			}
		});
	});
});

function chart(data){
	Highcharts.chart('container', {
		
		title: {
			text: 'Fashion Site Growth by Sector, 2010-2018'
		},
	
		subtitle: {
			text: 'Source: thefashionfoundation.com'
		},
	
		yAxis: {
			title: {
				text: 'Profits by Visitors (millions, USD)'
			}
		},
	    
		legend: {
			layout: 'vertical',
			align: 'right',
			verticalAlign: 'middle'
		},
	
		plotOptions: {
			series: {
				label: {
					connectorAllowed: false
				},
				pointStart: 2010
			}
		},
	    
	    series: data,
	
	    responsive: {
	        rules: [{
	            condition: {
	                maxWidth: 500
	            },
	            chartOptions: {
	                legend: {
	                    layout: 'horizontal',
	                    align: 'center',
	                    verticalAlign: 'bottom'
	                }
	            }
	        }]
	    }
	});	
}

</script>
</head>

<body>
<%@include file="./temp/header.jsp" %>
<div>
<section>
<!-- 여기에서부터 본문내용 시작 -->

<br/>
<h3 class="title"> Growth of AskCody </h3>

<div class="showbutton">
	<button id="btn1"> Show the Chart </button>
</div>
<br/>

<div id="container"></div>
<br/>

<!-- 여기까지 본문내용 -->
</section>
</div>
<div style="clear: both;"></div>
<%@include file="./temp/footer.jsp" %>
</body>
</html>