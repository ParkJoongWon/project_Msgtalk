<%@ page contentType="text/html; charset=utf-8" pageEncoding="EUC-KR"%>
<%@taglib prefix="q" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?Noto+Sans+KR:wght@500&family=Cookie&family=Roboto:wght@700&display=swap" rel="stylesheet">
<style type="text/css">
	/* xs */
	@media (max-width:767px) {
		body { background-color : #D5D5D5; }
		.c_roomTop { font-family: 'Roboto', sans-serif; font-size: 30px; margin-bottom: 0px; }
		hr { margin-top: 0px; margin-bottom: 0px; }
		.container { width: 99%; margin: 20px auto; }
		textarea { width: 93%; height: 100px; }
		.c_username { width: 30px; height: 30px; border-radius: 0.4em; }
		.apple_box { font-size: 15px; text-align: left; height: 50px; padding-left: 12px; padding-top: 5px; padding-bottom: 5px; position: relative; border-radius: 0.4em; }
		.banana_box { font-size: 15px; text-align: right; height: 50px; padding-right: 12px; padding-top: 5px; padding-bottom: 5px; position: relative; border-radius: 0.4em; }
		.c_showip_apple { font-size: 10px; padding-left: 10px; width: 150px; }
		.c_showip_banana { font-size: 10px; padding-right: 10px; width: 150px; }
		.c_fileuploader { cursor: pointer; width: 20px; height: 50px; padding: 6px 25px; border-radius: 4px; }
		.c_textBtn { width: 100%; height: 50px; font-size:20px; }
		.c_downImg { width: 15px; height: 15px; }
	}
	/* sm */
	@media (min-width:768px) {
		body { background-color : #D5D5D5; }
		.c_roomTop { font-family: 'Roboto', sans-serif; font-size: 30px; margin-bottom: 0px; }
		hr { margin-top: 0px; margin-bottom: 0px; }
		.container { width: 99%; margin: 20px auto; }
		textarea { width: 93%; height: 100px; }
		.c_username { width: 30px; height: 30px; border-radius: 0.4em; }
		.apple_box { font-size: 20px; text-align: left; height: 50px; padding-left: 12px; padding-top: 5px; padding-bottom: 5px; position: relative; border-radius: 0.4em; }
		.banana_box { font-size: 20px; text-align: right; height: 50px; padding-right: 12px; padding-top: 5px; padding-bottom: 5px; position: relative; border-radius: 0.4em; }
		.c_showip_apple { padding-left: 10px; width: 270px; }
		.c_showip_banana { padding-right: 10px; width: 270px; }
		.c_fileuploader { cursor: pointer; width: 20px; height: 50px; padding: 6px 25px; border-radius: 4px; }
		.c_textBtn { width: 100%; height: 50px; font-size:20px; }
		.c_downImg { width: 20px; height: 20px; }
	}
	/* md */
	@media (min-width:992px) {
		body { background-color : #D5D5D5; }
		.c_roomTop { font-family: 'Roboto', sans-serif; font-size: 30px; margin-bottom: 0px; }
		hr { margin-top: 0px; margin-bottom: 0px; }
		.container { width: 99%; margin: 20px auto; }
		textarea { width: 93%; height: 100px; }
		.c_username { width: 30px; height: 30px; border-radius: 0.4em; }
		.apple_box { font-size: 20px; text-align: left; height: 50px; padding-left: 12px; padding-top: 5px; padding-bottom: 5px; position: relative; border-radius: 0.4em; }
		.banana_box { font-size: 20px; text-align: right; height: 50px; padding-right: 12px; padding-top: 5px; padding-bottom: 5px; position: relative; border-radius: 0.4em; }
		.c_showip_apple { padding-left: 10px; width: 450px; }
		.c_showip_banana { padding-right: 10px; width: 450px; }
		.c_fileuploader { cursor: pointer; width: 20px; height: 50px; padding: 6px 25px; border-radius: 4px; }
		.c_textBtn { width: 100%; height: 50px; font-size:20px; }
		.c_downImg { width: 20px; height: 20px; }
	}
	/* lg */
	@media (min-width:1200px) {
		body { background-color : #D5D5D5; }
		.c_roomTop { font-family: 'Roboto', sans-serif; font-size: 30px; margin-bottom: 0px; }
		hr { margin-top: 0px; margin-bottom: 0px; }
		.container { width: 99%; margin: 20px auto; }
		textarea { width: 93%; height: 100px; }
		.c_username { width: 30px; height: 30px; border-radius: 0.4em; }
		.apple_box { font-size: 20px; text-align: left; height: 50px; padding-left: 12px; padding-top: 5px; padding-bottom: 5px; position: relative; border-radius: 0.4em; }
		.banana_box { font-size: 20px; text-align: right; height: 50px; padding-right: 12px; padding-top: 5px; padding-bottom: 5px; position: relative; border-radius: 0.4em; }
		.c_showip_apple { padding-left: 10px; width: 750px; }
		.c_showip_banana { padding-right: 10px; width: 750px; }
		.c_fileuploader { cursor: pointer; width: 20px; height: 50px; padding: 6px 25px; border-radius: 4px; }
		.c_textBtn { width: 100%; height: 50px; font-size:20px; }
		.c_downImg { width: 20px; height: 20px; }
	}
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
window.onload = function(){
	$("input[type='file']").on('change', function() {
		$(this).next('.c_fileuploader').html(event.target.files[0].name);
	});
};
</script>

</head>
<body>
	<div class="container">
		<p class="c_roomTop"><b>${roomNo} - [Member]</b></p>
		<form align="right" method="POST" action="roomlist.link">
			<input class="btn btn-primary" type="submit" value="목록으로"/>
		</form>
		<hr/>
		<div>
			</br>
			<table width="100%" border="0">
				<q:forEach items="${talk}" var="t">
					<q:if test="${t.username eq 'apple'}">
						<tr>
							<td class="c_username" bgColor="white" align="center">
								<input type="image" src="apple.png" width="20px" height="20px"/>
							</td>
							<td class="c_showip_apple" align="left">
								(${t.showip}) ${t.postdate.substring(5,16)}
							</td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td colspan='2' class="apple_box" bgColor="${t.boxColor}">
								${t.content}
								<q:if test="${t.ofn ne 'null'}">
									<form method="POST" action="down.link?fsn=${t.fsn}&ofn=${t.ofn}"" enctype="multipart/form-data">
										<a href="down.link?fsn=${t.fsn}&ofn=${t.ofn}">${t.ofn}</a>
										<input class="c_downImg" type="image" src="down.svg"/>
									</form>
								</q:if>
							</td>
							<td></td>
							<td width="30px"></td>
						</tr>
						<tr height="10px"></tr>
					</q:if>
					<q:if test="${t.username eq 'banana'}">
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td class="c_showip_banana" align="right">
								(${t.showip}) ${t.postdate.substring(5,16)}
							</td>
							<td class="c_username" bgColor="white" align="center">
								<input type="image" src="banana.png" width="20px" height="20px"/>
							</td>
						</tr>
						<tr>
							<td width="30px"></td>
							<td></td>
							<td colspan='2' class="banana_box" bgColor="${t.boxColor}">
								${t.content}
								<q:if test="${t.ofn ne 'null'}">
									<form method="POST" action="down.link?fsn=${t.fsn}&ofn=${t.ofn}"" enctype="multipart/form-data">
										<a href="down.link?fsn=${t.fsn}&ofn=${t.ofn}">${t.ofn}</a>
										<input class="c_downImg" type="image" src="down.svg"/>
									</form>
								</q:if>
							</td>
							<td width="10px"></td>
						</tr>
						<tr height="10px"></tr>
					</q:if>
				</q:forEach>
			</table>
			</br>
			<form method="POST" action="add222.link?roomNo=${roomNo}" enctype="multipart/form-data">
				<div align="right">
					<input class=" form-control" id="fileuploader" type="file" name="apple" style="display: none;"/>
					<label class="label label-primary c_fileuploader" for="fileuploader" style="font-size: 15px;">파일추가</label>
				</div>
				<label for="abcd"></label>
				<textarea class="form-control" placeholder="작성 후 하단의 버튼을 클릭하시면 됩니다" id="abcd" name="content" rows="2" style="font-size: 18px;" autofocus></textarea>
				<input class="btn btn-primary c_textBtn" type="submit" value="입력"/>
			</form>
			
		</div>
	</div>
</body>
</html>