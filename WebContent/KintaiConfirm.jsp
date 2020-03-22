<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>勤怠管理</h1>
		<p>対象年月を入力してください</p>
		<form action="/KintaiKanr/Servlet" method="post">
			<p><input type="text">年</p>
			<p><input type="text">月</p>
			<p><input type="submit"value="選択"></p>
		</form>
		<%

		%>
		<p><input type="submit"value="登録"></p>
		<%  %>
	</body>
</html>