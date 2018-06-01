<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/floating_menu.css">
	<jsp:include page="karicss.jsp" />

	<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>
	<meta http-equiv="imagegettoolbar" content="no"/>
	<meta name="description" content=""/>
	<meta http-equiv="keywords" content=""/>
	<title>新規会員登録</title>
</head>
<body>
	<jsp:include page="topMenu.jsp" />
	<div id="main">
		<div id="top">
			<p>UserCreate</p>
		</div>
		<div>
			<s:if test="errorMessage!=''">
				<s:property value="errorMessage" escape="false"/>
			</s:if>
			<table>
			<s:form action="UserCreateConfirmAction">
			<tr>
				<td>
					<label>希望ログインID</label>
				</td>
				<td>
					<s:textfield name="loginId"/>
				</td>
			</tr>
			<tr>
				<td>
					<label>パスワード</label>
				</td>
				<td>
					<s:textfield name="loginPass"/>
				</td>
			</tr>
			<tr>
				<td>
					<label>ユーザー名</label>
				</td>
				<td>
					<s:textfield name="userName"/>
				</td>
			</tr>
			<tr>
				<td>
					<label>お名前</label>
				</td>
				<td>
					<s:textfield name="name" />
				</td>
			</tr>
			<tr>
				<td>
					<label>フリガナ</label>
				</td>
				<td>
					<s:textfield name="furigana" />
				</td>
			</tr>
			<tr>
				<td>
					<label>郵便番号</label>
				</td>
				<td>
					<s:textfield name="zip" size="10" maxlength="8" onKeyUp="AjaxZip3.zip2addr(this,'','addrres','addrres');" />
				</td>
			</tr>
			<tr>
				<td>
					<label>住所</label>
				</td>
				<td>
					<s:textfield name="address" size="60" />
				</td>
			</tr>
			<tr>
				<td>
					<label>電話番号</label>
				</td>
				<td>
					<s:textfield name="telephone" />
				</td>
			</tr>
			<tr>
				<td>
					<label>メールアドレス</label>
				</td>
				<td>
					<s:textfield name="mailAddress" />
				</td>
			</tr>
			<tr>
				<td>
					<label>生年月日</label>
				</td>
				<td>
					<s:textfield name="birthdayYear" placeholder="西暦" />
					年
		            <s:textfield name="birthdayMonth" />
					月
		            <s:textfield name="birthdayDay" />
		            日
				</td>
			</tr>
			<tr>
				<td>
					<label>お知らせ</label>
				</td>
				<td>
					<s:checkbox name="directMail" value="checked" fieldValue="1" />
					<label for="directMail">受け取る(新商品の情報などをお届けいたします。)</label>
				</td>
			</tr>
				<s:submit value="登録"/>
			</s:form>
			</table>
			<div>
				<span>前画面に戻る場合は</span>
				<a href="<s:url value='SneakerSellAction'/>">こちら</a>
			</div>
		</div>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>
</body>
</html>