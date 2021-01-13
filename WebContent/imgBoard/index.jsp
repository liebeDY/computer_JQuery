<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	var makeTbl = function(obj) {
		var html = "<table id='t_" + obj.num + "'border='1'>"; // 테이블 열기
		
		html += "<tr><th>num</th><td>" + obj.num + "</td></tr>"; // 번호
		
		html += "<tr><th>update</th><td><input type='button' value='edit'>";
		html += "<input type='button' value='delete' num='" + obj.num + "'pwd='" + obj.pwd + "'>";
		html += "</td></tr>"; // 수정, 삭제 버튼
		
		html += "<tr><th>title</th><td>" + obj.title + "</td></tr>"; // 제목
		
		html += "<tr><th>writer</th><td>" + obj.writer + "</td></tr>"; // 작성자
		
		html += "<tr><th>date</th><td>" + obj.u_date + "</td></tr>"; // 날짜
		
		html += "<tr><th>img</th><td><img src='"+obj.path+"'width=200 height=200></td></tr>"; // 이미지
		
		html += "</table>"; // 테이블 닫음
		
		$("#imglist").append(html); // div태그에 테이블 생성
		console.log(obj.path)
	}
	
	var makeList = function(arr) {
		for(i = 0; i < arr.length; i++) {
			makeTbl(arr[i]);
		}
	}
	
	$(document).ready(function(){
		$('#upload_form').hide();
		$.ajax({
			url:'${pageContext.request.contextPath}/ImgList',
			type:'get',
			success:function(result) {
				var arr = $.parseJSON(result);
				makeList(arr);
			}
		});
	
		$("#addbtn").click(function(){
			$("#title").val("");
			$("#writer").val("");
			$("#pwd").val("");
			$("#file").val("");
			$("#upload_form").show();
		});
	
		$("#upload_btn").click(function(){
			var form = $('#upload_form')[0];
			var formData = new FormData(form);
			
			$.ajax({
				url: '${pageContext.request.contextPath}/WriteController',
				data: formData,
				processData: false,
				contentType: false,
				type: "POST",
				
				success: function(result){
					var obj = $.parseJSON(result);
					makeTbl(obj);
				}
			});
		});
		
		$("#upload_form").hide();
	
	});

</script>
</head>
<body>
	<h3>이미지 게시판</h3><hr>
	
	<input type="button" id="addbtn" value="이미지 올리기">
	
	<form id="upload_form" method="post" enctype="multipart/form-data">
	
		<table border="1">
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" id="title"></td>
			</tr>
			
			<tr>
				<td>게시자</td>
				<td><input type="text" name="writer" id="writer"></td>
			</tr>
			
			<tr>
				<td>글비밀번호</td>
				<td><input type="password" name="pwd" id="pwd"></td>
			</tr>
			
			<tr>
				<td>이미지</td>
				<td><input type="file" name="file" id="file"></td>
			</tr>
			
			<tr>
				<td colspan="2"><input id="upload_btn" type="button" value="올리기"></td>
			</tr>
		</table>
	
	</form>
	
	<div id="imglist"></div>

</body>
</html>