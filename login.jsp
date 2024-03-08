<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

	<h2>ログイン</h2>

	<form action="login-servlet" method="post">
	<br>
	<br>
	<br>
	<br>
	<br>
		ユーザID： <input type="text" name="userId" placeholder="ユーザIDを入力してください" required><br><br>
		パスワード： <input type="password" name="password" placeholder="パスワードを入力してください" required><br><br>
		<input type="submit" value="ログイン">
	</form>

	<% 
		String errorMsg = (String)request.getAttribute("errorMsg");
		if (errorMsg != null) {
	%>
			<p class="error-msg"><%= errorMsg %></p>
	<%
		} 
	%>

</body>
</html>
