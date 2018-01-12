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
	<link rel="stylesheet" href="<c:url value="/resources/styles/input.css"/>" />
	<title>자료 업로드</title>
</head>
<body>
	<div id="pageContainer">
		<%@ include file="/WEB-INF/views/include/header.jsp" %>
		
		<div id="content">
			<br/><br/><br/>
			<div id="inputcontent">
				<div id="inputmain">
					<div class="inputsubtitle">업로드 자료정보</div>
					<table>
						<tr>
							<th>제목</th>
							<td>
								${bbsform.title}
							</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td>
								${bbsform.uploader}
							</td>
						</tr>
						<tr>
							<th>조회수</th>
							<td>
								${bbsform.readcount}
							</td>
						</tr>
						<tr>
							<th>등록일자</th>
							<td>
								<fmt:formatDate value="${bbsform.regdate}" pattern="yyyy-MM-dd" />
							</td>
						</tr>
						<tr>
							<th>첨부자료</th>
							<td>
								<c:forEach var="file" items="${bbsform.fileItems}">
									<a href="<c:url value="/bbs/download/${file.bbsfileno}" />">
										${file.userfilename}
									</a> &nbsp; [${file.downloadcount}]
								</c:forEach>	
							</td>
						</tr>
						<tr>
							<th>자료설명</th>
							<td>
								${bbsform.content}
							</td>
						</tr>
					</table>
					<div class="buttons">
						<input type="submit" value="update" style="height:25px" />
						<input type="button" value="cancel" style="height:25px" 
							onclick="location.href='<c:url value="/bbs/List"/>'" />
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>