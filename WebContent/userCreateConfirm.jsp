<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/floating_menu.css">
	<jsp:include page="karicss.jsp" />

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>
	<meta http-equiv="imagegettoolbar" content="no"/>
	<meta name="description" content=""/>
	<meta http-equiv="keywords" content=""/>
	<title>登録確認</title>
</head>
<body>
	<jsp:include page="topMenu.jsp" />

	<div id="main">
		<div id="top">
			<p>UserCreateConfirm</p>
		</div>
		<div>
			<h3>登録する内容は以下でよろしいですか。</h3>
			<table>
			<s:form action="UserCreateCompleteAction">
			<tr id="box">
				<td>
					<label>ログインID:</label>
				</td>
				<td>
					<s:property value="loginUserId" escape="false" />
				</td>
			</tr>
			<tr id="box">
				<td>
					<label>パスワード</label>
				</td>
				<td>
					<s:property value="loginPassword" escape="false" />
				</td>
			</tr>
			<tr id="box">
				<td>
					<label>ユーザー名</label>
				</td>
				<td>
					<s:property value="userName" escape="false" />
				</td>
				<tr>
					<td>
						<s:submit value="完了"/>
					</td>
				</tr>
			</s:form>
			</table>
		</div>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>
</body>
</html>