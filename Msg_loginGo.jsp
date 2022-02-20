<%@ page contentType="text/html; charset=utf-8" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?Noto+Sans+KR:wght@500&family=Cookie&family=Roboto:wght@300&display=swap" rel="stylesheet">
<style text="css/text">
	/* xs */
	@media (max-width:767px) {
		h1 { font-family: 'Cookie', cursive; text-align: center; font-size: 120px; color:#353535; margin-block-start: 1em; margin-block-end: 0.2em; }
		p { font-family: 'Roboto', sans-serif; text-align: center; font-size: 18px; }
		.container { width: 300px }
		.logoImg { transform: scaleX(-1); }
		body { background-color : #D5D5D5; }
		.c_userID { align: center; width: 270px; height:50px; font-size:20px; }
	}
	/* sm */
	@media (min-width:768px) {
		h1 { font-family: 'Cookie', cursive; text-align: center; font-size: 120px; color:#353535; margin-block-start: 1em; margin-block-end: 0.2em; }
		p { font-family: 'Roboto', sans-serif; text-align: center; font-size: 20px; }
		.container { width: 400px }
		.logoImg { transform: scaleX(-1); }
		body { background-color : #D5D5D5; }
		.c_userID { width: 370px; height:50px; font-size:20px; }
	}
	/* md */
	@media (min-width:992px) {
		h1 { font-family: 'Cookie', cursive; text-align: center; font-size: 120px; color:#353535; margin-block-start: 1em; margin-block-end: 0.2em; }
		p { font-family: 'Roboto', sans-serif; text-align: center; font-size: 20px; }
		.container { width: 400px }
		.logoImg { transform: scaleX(-1); }
		body { background-color : #D5D5D5; }
		.c_userID { width: 370px; height:50px; font-size:20px; }
	}
	/* lg */
	@media (min-width:1200px) {
		h1 { font-family: 'Cookie', cursive; text-align: center; font-size: 120px; color:#353535; margin-block-start: 1em; margin-block-end: 0.2em; }
		p { font-family: 'Roboto', sans-serif; text-align: center; font-size: 20px; }
		.container { width: 400px }
		.logoImg { transform: scaleX(-1); }
		body { background-color : #D5D5D5; }
		.c_userID { width: 370px; height:50px; font-size:20px; }
	}
	
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<h1><b>Msg</b><img class="logoImg" src="logo.svg" width="100px" height="100px"/></h1>
	<p>로그인을 하셔야 이용이 가능합니다.</p>
	<p>암호와 아이디를 다시 한 번 확인해주시기 바랍니다.</p>
	</br>
	<div class="container">
		<form style="width: 300px;" method="POST" action="login.link">
			<input class="btn btn-primary c_userID" type="submit" value="로그인 창으로 이동"/> 
		</form>
	</div>
		
</body>
</html>