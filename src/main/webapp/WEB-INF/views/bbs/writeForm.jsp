<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="<c:url value="/resources/styles/default.css"/>" />
	<link rel="stylesheet" href="<c:url value="/resources/styles/input2.css"/>" />
	<title>자료 등록</title>
</head>
<body>
	<div id="pageContainer">
		<%@ include file="/WEB-INF/views/include/header.jsp" %>
		
		<div id="content">
			<br/><br/><br/>
			<div id="inputcontent">
				<div id="inputmain">
					<div class="inputsubtitle">자료정보</div>
					
					<!-- 파일 전송시 enctype 추가 -->
					<form:form modelAttribute="bbsForm" method="post" 
						enctype="multipart/form-data">
						<table>
							<tr>
								<th>제목</th>
								<td>
									<form:input path="title" style="width:580px"/>
								</td>
							</tr>
							<tr>
								<th>작성자</th>
								<td>
									${sessionScope.loginUser.memberid}
									<form:hidden path="uploader" value="${sessionScope.loginUser.memberid}" />
								</td>
							</tr>
							<tr>
								<th>첨부자료</th>
								<td>
									<form:input path="files" multiple="multiple" type="file"
									 style="width:580px;height:20px" />
								</td>
							</tr>
							<tr>
								<th>자료설명</th>
								<td>
									<form:textarea path="content" rows="15" style="width:580px"></form:textarea>
								</td>
							</tr>
						</table>
						<div class="buttons">
							<input type="submit" value="write" style="height:25px" />
							<input type="button" value="cancel" style="height:25px" 
								onclick="location.href='<c:url value="/bbs/List"/>'" />
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>