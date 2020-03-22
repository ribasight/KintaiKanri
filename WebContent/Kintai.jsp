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
		<form action="/KintaiKanri/Servlet" method="post">
			<input type="text" name="year">年
			<p><input type="text" name="month">月</p>
			<p><input type="submit"value="選択"></p>
		</form>
	<% String hoge = (String) request.getAttribute("year");
		out.println(hoge);
		System.out.println(hoge);
	%>

		<p><input type="submit"value="登録"></p>
		<%  %>
	</body>
</html>