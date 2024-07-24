<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/loginForm.css">
</head>
<body>
	<div id="wrapper">
		<div class="login-container">
			<div class="loginHeader">
				<h2>로그인</h2>
				<p>JSP 게시판</p>
			</div>
			<div class="loginBody">
				<form method="post" action="loginProc.jsp" class="loginForm">
					<input type="text" name="mid" placeholder="아이디를 입력해주세요." required />
					<input type="password" name="mpass" placeholder="비밀번호를 입력해주세요." required />
					<input type="submit" value="로그인" class="btn btn-dark" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>