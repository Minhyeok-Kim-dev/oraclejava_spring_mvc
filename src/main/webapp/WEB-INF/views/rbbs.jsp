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
			loadLogs();
			
			$("#write").click(function() {
				$.ajax("<c:url value='/rbbs/write'/>", {
					type : "get",
					dataType : "json",
					data : {
						name : $("#name").val(),
						body : $("#body").val()
					}
				})
				.done(function(data) { // success 시
					$("#body").val("");
					$("#itemsHtml").html("");
					loadLogs();
				});
			});
			
			$("#refresh").click(function() {
				$("#itemsHtml").html("");
				loadLogs();
			});
		});
		
		function loadLogs() {
			$.ajax("<c:url value='/rbbs/getItems'/>", {
				type : "get",
				dataType : "json"
			})
			.done(function(data) {	// success 시
				for (var i=0; i<data.result.logs.length; i++) {
					$("#itemsHtml").append("<li>"
							+ data.result.logs[i].name + "-"
							+ data.result.logs[i].body + "</li>");	
				}
			})
			.fail(function(data) {
				alert("loadLogs failed");
			});
			
		};
	</script>
</head>
<body>
	<div id="pageContainer">
		<%@ include file="/WEB-INF/views/include/header.jsp" %>
		
		
		<div id="content">
			<h2>rest 게시판 입니다.</h2>
			<div class="form">
				이름 : <br/>
				<input type="text" id="name" name="name" 
					value="${sessionScope.loginUser.memberid}" /><br/><br/>
				내용 : <br/>
				<input type="text" id="body" name="body"
					value="" size="60" /><br/><br/>
				<button id="write">쓰기</button>
			</div>
		</div> 
		<p class="right">
			<button id="refresh">갱신</button>
		</p>
		<ul id="itemsHtml"></ul>
	</div>
	
</body>
</html>