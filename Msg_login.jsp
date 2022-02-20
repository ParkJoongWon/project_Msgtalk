<%@ page contentType="text/html; charset=utf-8" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?Noto+Sans+KR:wght@500&family=Cookie&family=Roboto:wght@300&display=swap" rel="stylesheet">
<style type="text/css">
	/* xs */
	@media (max-width:767px) {
		h1 { font-family: 'Cookie', cursive; text-align: center; font-size: 120px; color:#353535; margin-block-start: 1em; margin-block-end: 0.2em; }
		p { font-family: 'Roboto', sans-serif; text-align: center; font-size: 18px; }
		.container { width: 300px;}
		.logoImg { transform: scaleX(-1); }
		body { background-color : #D5D5D5; }
		.c_userID { width: 270px; height:50px; font-size:20px; }
	}
	/* sm */
	@media (min-width:768px) {
		h1 { font-family: 'Cookie', cursive; text-align: center; font-size: 120px; color:#353535; margin-block-start: 1em; margin-block-end: 0.2em; }
		p { font-family: 'Roboto', sans-serif; text-align: center; font-size: 20px; }
		.container { width: 400px;}
		.logoImg { transform: scaleX(-1); }
		body { background-color : #D5D5D5; }
		.c_userID { width: 370px; height:50px; font-size:20px; }
	}
	/* md */
	@media (min-width:992px) {
		h1 { font-family: 'Cookie', cursive; text-align: center; font-size: 120px; color:#353535; margin-block-start: 1em; margin-block-end: 0.2em; }
		p { font-family: 'Roboto', sans-serif; text-align: center; font-size: 20px; }
		.container { width: 400px;}
		.logoImg { transform: scaleX(-1); }
		body { background-color : #D5D5D5; }
		.c_userID { width: 370px; height:50px; font-size:20px; }
	}
	/* lg */
	@media (min-width:1200px) {
		h1 { font-family: 'Cookie', cursive; text-align: center; font-size: 120px; color:#353535; margin-block-start: 1em; margin-block-end: 0.2em; }
		p { font-family: 'Roboto', sans-serif; text-align: center; font-size: 20px; }
		.container { width: 400px;}
		.logoImg { transform: scaleX(-1); }
		body { background-color : #D5D5D5; }
		.c_userID { width: 370px; height:50px; font-size:20px; }
	}
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script>
window.onload = function(){
	$(function(){
		$("h1").on("click", function() {
			location.href = "http://pukyung20.cafe24.com/login.link"
		});
	});
};
</script>

</head>
<body>
	<h1><b>Msg</b><img class="logoImg" src="logo.svg" width="100px" height="100px"/></h1>
	<div class="container">
		<form method="POST" action="login2.link">
			<label for="user_id"></label>
			<input class="c_userID form-control" type="text" id="user_id" placeholder=" 아이디를 입력하세요" name="userID" style="border:solid 1px #353535;" autofocus/>
			<label for="user_pw"></label>
			<input class="c_userID form-control" type="password" id="user_pw" placeholder=" 비밀번호를 입력하세요" name="userPassword" style="border:solid 1px #353535;"/>
			</br>
			<input class="btn btn-primary c_userID" type="submit" value="LOGIN"/> 
		</form>
	</div>
	</br>
	<p>id: test</p>
	<p>pw: 1111 -Leader</p>
	<p>pw: 2222 -Member</p>
	<p>pw: 3333 -Guest</p>
</body>
</html>
<!-- backup

	

-->