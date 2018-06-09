<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>Insert title here</title>
</head>
<body>
	접속id : ${sessionScope.id }
	<c:if test="${sessionScope.id == null}">
		<form method="POST" action="<%=request.getContextPath() %>/login/login.do" >
			<input type="text" name="user_id"/>
			<input type="password" name="password" />
			<input type="submit" value="login"/>
		</form>
	</c:if>
	<c:if test="${sessionScope.id == admin}">
		
		<ul>
			<a href="${pageContext.request.contextPath}/torrent/index"><li>토렌트 다운</li></a>
			<a href="${pageContext.request.contextPath}/ticketLink/index"><li>티켓링크 예매</li></a>
		</ul>
	
	</c:if>
</body>
</html>