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
	<title>ログイン</title>

</head>
<body>
	<jsp:include page="topMenu.jsp" />

	<div id="main">
		<div id="top">
			<p>Home</p>
		</div>
		<div id="text-center">
			<s:form action="HomeAction">
				<s:submit value="商品購入"/>
			</s:form>
			<s:if test="#session.id !=null">
				<p>ログアウトする場合は
					<a href='<s:url action="LogoutAction" />'>こちら</a></p>
			</s:if>
		</div>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>
</body>
</html>