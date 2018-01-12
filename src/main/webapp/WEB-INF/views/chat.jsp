<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>rest 게시판</title>
	<link rel="stylesheet" href="<c:url value="/resources/styles/default.css"/>" />
	<link rel="stylesheet" href="<c:url value="/resources/styles/input.css"/>" />
	<style>
		h2 {
			background-color: blue;
			color: white;
			font-size: 24px;
			padding: 12px;
		}
		.form {
			padding: 12px;
			border: 1px solid silver;
			background-color: #f0f0f0;
		}
		.right {
			text-align: right;
		}
	</style>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script>
		$(function() {
			$("#enterRoom").click(connect);
			$("#write").click(push);
		});
		
		// 접속 (메시지 수신)
		function connect() {
			$.ajax("<c:url value='/chat/polling'/>", {
				type : "get",
				cache : false,	// IE8 이하는 반드시 cache=false로 해야 작동
				dataType : "json"
			})
			.always(function() {
				// 접속 종료되었을 경우 재접속 (success, fail, timeout)
				connect();
			})
			.done(function(data) {
				// 메시지 취득
				if (data.message == undefined || data.message == "") {
					// 타임아웃인 경우 DeferredResult가 기본적으로 message를 공백으로 설정
					return;
				}
				
				var text = "<li>" + data.name + "-" + data.message + "</li>";
				$("#itemsHtml").append(text);				
			});
		}
		
		// 채팅하기 (메시지 송신)
		function push() {
			$.ajax("<c:url value='/chat/push'/>", {
				type : "post",
				cache : false,	// IE8 이하는 반드시 cache=false로 해야 작동
				dataType : "json",
				data : {
					name : $("#name").val(),
					body : $("#body").val()
				}
			});
		}
	</script>
</head>
<body>
	<div id="pageContainer">
		<%@ include file="/WEB-INF/views/include/header.jsp" %>
		
		<div id="content">
			<h2>실시간 chat</h2>
			<div class="form">
				<button id="enterRoom">채팅방 입장</button>
				이름 : <br/>
				<input type="text" id="name" name="name" 
					value="${sessionScope.loginUser.memberid}" /><br/><br/>
				내용 : <br/>
				<input type="text" id="body" name="body"
					value="" size="60" /><br/><br/>
				<button id="write">쓰기</button>
			</div>
		</div> 
		
		<ul id="itemsHtml"></ul>
	</div>
	
</body>
</html>