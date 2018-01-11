<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>게시판 목록</title>
	<link rel="stylesheet" href="<c:url value="/resources/styles/default.css"/>" />
</head>
<body>
	<div id="pageContainer">
		<%@ include file="/WEB-INF/views/include/header.jsp" %>
		
		<div style="padding-top:25px;text-align:center">
			[<a href="<c:url value="/bbs/write" />">자료등록</a>]
			<br/><br/>
			
			<table border="1" style="width:600px" align="center">
				<tr style="background-color:orange;height:30px">
					<th style="width:50px">번호</th>
					<th style="width:400px">제목</th>
					<th style="width:150px;text-align:center">작성일</th>
				</tr>
				<c:forEach var="bbs" items="${bbsList}">
					<tr style="height:30px">
						<td>${bbs.bbsno}</td>
						<td style="text-align:left;padding-left:10px">
							<a href="<c:url value="/bbs/detail/${bbs.bbsno}"/>">${bbs.title}</a>
						</td>
						<td>
							<fmt:formatDate value="${bbs.regdate}" pattern="yyyy-MM-dd" />
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>