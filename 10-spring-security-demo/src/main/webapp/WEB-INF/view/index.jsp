<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglib/import.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home Security Page</title>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid">
		<div>
			<h1>Welcome to Spring Security Tutorials</h1>
	
			<hr>
				
			<h3>User: <sec:authentication property="principal.username"/></h3>
			<h3>Role: <sec:authentication property="principal.authorities"/></h3>
			
			<div>
				<sec:authorize access="hasRole('MANAGER')">
					<a href="${contextPath}/leaders">Leadership meeting</a> (Only for manager peeps)
				</sec:authorize>
				<sec:authorize access="hasRole('ADMIN')">
					<a href="${contextPath}/admin">IT systems meeting</a> (Only for admin peeps)
				</sec:authorize>
			</div>
			
			<hr>
	
			<form action="${contextPath}/logout" method="post">
				<input class="btn btn-success" type="submit" value="logout">
				
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			</form>
		</div>
	</div>
	
</body>
</html>