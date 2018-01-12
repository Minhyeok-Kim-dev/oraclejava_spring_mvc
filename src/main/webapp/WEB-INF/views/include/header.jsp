<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="header">
	<div class="title">
		<a href="<c:url value="/"/>">SPRING MVC DEMO</a>
	</div>
	<div class="links">
		<c:if test="${empty sessionScope.loginUser}">
			<a href="<c:url value="/account/login"/>">로그인</a>
			<a href="<c:url value="/account/register"/>">등록</a>
		</c:if>
		<c:if test="${!empty sessionScope.loginUser}">
			${sessionScope.loginUser.memberid} 님 환영합니다.
			<a href="<c:url value="/account/logout"/>">로그아웃</a>
		</c:if>
	</div>
</div>
<div id=menu>
	<div>
		<ul>
			<li><a href="<c:url value="/bbs/list"/>">게시판</a></li>
			<li><a href="<c:url value="/rbbs/"/>">rest게시판</a></li>
			<li><a href="<c:url value="/chat/"/>">실시간chat</a></li>
		</ul>
	</div>
</div>