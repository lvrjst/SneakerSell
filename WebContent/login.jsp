<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="floating_menu.css">
	<jsp:include page="karicss.jsp" />

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>
	<meta http-equiv="imagegettoolbar" content="no"/>
	<meta name="description" content=""/>
	<meta http-equiv="keywords" content=""/>
	<title>Login画面</title>


</head>
<body>
	<jsp:include page="topMenu.jsp" />

	<div id="main">
		<div>
			<h3>商品を購入する際にはログインをお願いします。</h3>
			<table>
			<s:form action="LoginAction">
			<tr>
				<td>
					<label>ログインID:</label>
				</td>
				<td>
					<s:textfield name="loginId" />
				</td>
			</tr>
			<tr>
				<td>
					<label>パスワード:</label>
				</td>
				<td>
					<s:password name="loginPass" />
				</td>
			</tr>
				<s:submit value="ログイン"/>
			</s:form>
			</table>
			<br/>
			<div>
				<p>新規ユーザー登録は
					<a href='<s:url action="UserCreateAction"/>'>こちら</a></p>
				<p>Homeへ戻る場合は
					<a href='<s:url action="SneakerSellAction"/>'>こちら</a></p>
			</div>
		</div>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>
</body>
</html>