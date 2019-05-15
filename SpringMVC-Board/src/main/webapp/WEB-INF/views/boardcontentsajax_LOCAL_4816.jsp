<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Board & Reply Contents</h3>
<a href="boardDelete?b_num=${board.b_num}">삭제</a>
<table>
	<tr height="30">
	<td bgcolor="pink" align="center">NUM</td>
	<td colspan="5">${board.b_num}</td>testsssssssssssssssssss222222
	</tr>
	<tr height="30">
	<td bgcolor="pink" align="center">WRITER</td>
	<td>${board.b_mid}</td>
	</tr>
	<tr height="30">
	<td bgcolor="pink" align="center">DATE</td>
	<td>${board.b_date}</td>
	</tr>
	<tr height="30">
	<td bgcolor="pink" align="center">VIEWS</td>
	<td>${board.b_views}</td>
	</tr>
	<tr height="30">
	<td bgcolor="pink" align="center">TITLE</td>
	<td colspan="5">${board.b_title }</td>
	</tr>
	<tr height="200">
	<td bgcolor="pink" align="center">CONTENTS</td>
	<td colspan="5">${board.b_contents}</td>
	</tr>
</table>
<table>
<tr bgcolor="skyblue" align="center" height="30">
	<td width="100">WRITER</td>
	<td width="100">CONTENTS</td>
	<td width="100">DATE</td>
	</tr>
	<c:forEach items="${rList}" var="reply">
	<tr height="25" align="center">
	<td width="100">${reply.r_mid}</td>
	<td width="200">${reply.r_contents}</td>
	<td width="200">${reply.r_date}</td>
	</tr>
	
	</c:forEach>
	</table>
	
	
</body>
</html>





