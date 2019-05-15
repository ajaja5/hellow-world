<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
html, body {
	height: 100%;
	margin: 0
}

#articleView_layer {
	display: none;
	position: fixed;
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%
}

#articleView_layer.open {
	display: block;
	color: red
}

#articleView_layer #bg_layer {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: #000;
	opacity: .5;
	filter: alpha(opacity = 50);
	z-index: 100
}

#contents_layer {
	position: absolute;
	top: 40%;
	left: 40%;
	width: 400px;
	height: 400px;
	margin: -150px 0 0 -194px;
	padding: 28px 28px 0 28px;
	border: 2px solid #555;
	background: #fff;
	font-size: 12px;
	z-index: 200;
	color: #767676;
	line-height: normal;
	white-space: normal;
	overflow: scroll
}
</style>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script>
function logout() {
	$('#logoutFrm').submit();
}
</script>
</head>
<body>
	<h1>게시판 리스트</h1>
	<div align="right">
		<form id="logoutFrm" action="logout" method="post">
			<a href="javascript:logout()">로그아웃</a>
		</form>
	</div>
	
	<table id="one_table">
		<tr height="30">
		<td width="80" bgcolor="pink" align="center">ID</td>
		<td>${mb.m_id}</td>
		</tr>
		<tr height="30">
		<td width="80" bgcolor="pink" align="center">NAME</td>
		<td>${mb.m_name}</td>
		</tr>
		<tr height="30">
		<td width="80" bgcolor="pink" align="center">GNAME</td>
		<td>${mb.g_name}</td>
		</tr>
		<tr height="30">
		<td width="80" bgcolor="pink" align="center">POINT</td>
		<td>${mb.m_point}</td>
		</tr>
	</table>
	<hr>
	<table>
		<tr bgcolor="aqua" height="30">
			<th width="100">번호</th>
			<th width="100">제목</th>
			<th width="100">아이디</th>
			<th width="100">작성일</th>
			<th width="100">조회수</th>
		</tr>
		<c:forEach var="board" items="${bList}">
			<tr>
				<td align="center">${board.b_num}</td>
				<td align="center"><a href="#" onclick="articleView(${board.b_num})">${board.b_title}</a></td>
				<td align="center">${board.b_mid}</td>
				<td align="center">${board.b_date}</td>
				<td align="center">${board.b_views}</td>
			</tr>
		</c:forEach>
	</table>
	
	<div id="articleView_layer">
	<div id="bg_layer"></div>
	<div id="contents_layer"></div>
	</div>
</body>
<script>
function articleView(num){
	$('#articleView_layer').addClass('open');
	
	$.ajax({
		type:'get',
		url:'contents',
		data:{b_num:num},
		dataType:'html',
		success:function(data){
			alert(data);
			$('#contents_layer').html(data);
		},
		error:function(error){
			console.log(error);
		}
	});//ajax end
}//function end
//modalbox 해제
var $layerwindow=$('#articleView_layer').addClass('open');
$layerwindow.find('#bg_layer').on('mousedown',function(event){
	console.log(event);
	$layerwindow.removeClass('open');
});

</script>
</html>