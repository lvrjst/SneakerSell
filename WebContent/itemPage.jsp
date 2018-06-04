<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/floating_menu.css">
<link rel="stylesheet" type="text/css" href="css/itemPage.css">


<script type="text/javascript">
function showimg0(){
    document.getElementById("area1").src = "<s:property value='#session.ItemPageDTO.picUrl0'/>";
}
function showimg1(){
     document.getElementById("area1").src = src="<s:property value='#session.ItemPageDTO.picUrl1'/>";
}
function showimg2(){
     document.getElementById("area1").src = src="<s:property value='#session.ItemPageDTO.picUrl2'/>";
}
function showimg3(){
     document.getElementById("area1").src = src="<s:property value='#session.ItemPageDTO.picUrl3'/>";
}
function showimg4(){
    document.getElementById("area1").src = src="<s:property value='#session.ItemPageDTO.picUrl4'/>";
}
function showimg5(){
    document.getElementById("area1").src = src="<s:property value='#session.ItemPageDTO.picUrl5'/>";
}
function showimg6(){
    document.getElementById("area1").src = src="<s:property value='#session.ItemPageDTO.picUrl6'/>";
}
function showimg7(){
    document.getElementById("area1").src = src="<s:property value='#session.ItemPageDTO.picUrl7'/>";
}
function showimg8(){
    document.getElementById("area1").src = src="<s:property value='#session.ItemPageDTO.picUrl8'/>";
}
</script>

<title><s:property value="#session.ItemPageDTO.itemTitle" /></title>
</head>
<body>
	<header>
	</header>
	<div id="contents">
		<jsp:include page="topMenu.jsp" />
		<div class="container">
			<p id="<s:property value='#session.ItemPageDTO.itemId' />"><s:property value="#session.ItemPageDTO.itemName" /></p>

			<div class="leftbox">

				<img src="<s:property value='#session.ItemPageDTO.picUrl0'/>" id="area1" >


				<span onclick="showimg0()"><img src="<s:property value='#session.ItemPageDTO.picUrl0'/>"></span>
				<span onclick="showimg1()"><img src="<s:property value='#session.ItemPageDTO.picUrl1'/>"></span>
				<span onclick="showimg2()"><img src="<s:property value='#session.ItemPageDTO.picUrl2'/>"></span>
				<span onclick="showimg3()"><img src="<s:property value='#session.ItemPageDTO.picUrl3'/>"></span>
				<span onclick="showimg4()"><img src="<s:property value='#session.ItemPageDTO.picUrl4'/>"></span>
				<span onclick="showimg5()"><img src="<s:property value='#session.ItemPageDTO.picUrl5'/>"></span>
				<span onclick="showimg6()"><img src="<s:property value='#session.ItemPageDTO.picUrl6'/>"></span>
				<span onclick="showimg7()"><img src="<s:property value='#session.ItemPageDTO.picUrl7'/>"></span>
				<span onclick="showimg8()"><img src="<s:property value='#session.ItemPageDTO.picUrl8'/>"></span>

			</div>

			<div class="rightbox">

				<p class="item_text"><s:property value="#session.ItemPageDTO.itemText" /></p>
				<h2>金額:<s:if test='#session.ItemPageDTO.itemPrice == -1'>未定</s:if>
				<s:else><s:property value="#session.ItemPageDTO.itemPrice" />円(税別)</s:else></h2>
				<p><s:property value="#session.ItemPageDTO.postTime" /></p>
				<p><s:property value="#session.ItemPageDTO.maker" /></p>
				<p><s:property value="#session.ItemPageDTO.color1" /></p>
				<p><s:property value="#session.ItemPageDTO.color2" /></p>

				<s:form action="CartInsertAction">
					<s:textarea name="itemCount" />
					<s:submit value="カートに入れる" />
				</s:form>
		</div>
		</div>
	</div>
	<footer>
	</footer>
</body>
</html>