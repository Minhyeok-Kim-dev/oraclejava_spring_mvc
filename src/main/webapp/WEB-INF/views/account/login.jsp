<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8" />
	<title>login</title>
	<link rel="stylesheet" href="<c:url value="/resources/styles/default.css"/>" />
	<link rel="stylesheet" href="<c:url value="/resources/styles/input.css"/>" />
</head>
<body>
	<div id="pageContainer">
		<%@ include file="/WEB-INF/views/include/header.jsp" %>
		
		<div id="inputcontent">
			<br/><br/>
			<div id="inputmain">
				<div class="inputsubtitle">로그인 정보</div>
				
				<form:form method="post" modelAttribute="memberForm">
					<table>
						<tr>
							<th>아이디(id)</th>
							<td>
								<form:input path="memberId" style="width: 280px" />
							</td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td>
								<form:password path="passwd" style="width: 280px" /></td>
						</tr>
					</table>
					<div class="buttons">
						<input type="submit" value="login" style="height: 25px" /> 
						<input type="button" value="cancel" style="height: 25px"
							onclick="location.href='<c:url value="/"/>'" />
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>