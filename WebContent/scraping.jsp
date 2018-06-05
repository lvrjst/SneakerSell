<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/floating_menu.css">

	<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>
	<meta http-equiv="imagegettoolbar" content="no"/>
	<meta name="description" content=""/>
	<meta http-equiv="keywords" content=""/>
	<title>商品追加ページ</title>
</head>
<body>
	<jsp:include page="topMenu.jsp" />
	<div id="main">
		<div>
			<s:if test="errorMessage!=''">
				<s:property value="errorMessage" escape="false"/>
			</s:if>
			<p>url:</p><a href="http://sneakerwars.jp/">こちらのページ</a>
			<table>
			<s:form action="ScrapingItemAction">
			<tr>
				<td><img src="scrapingItem.png"></td>
				<td>
					<label>一つの商品を追加する場合のURL</label>
				</td>
				<td>
					<s:textfield name="scrapingItemUrl"/>
				</td>
			</tr>
			<s:submit value="登録"/>
			</s:form>

			<s:form action="ScrapingPageAction">
			<tr>
				<td><img src="scrapingItem.png"></td>
				<td>
					<label>最初のページを除く、Page1つ(１６商品)を追加する場合のURL</label>
				</td>
				<td>
					<s:textfield name="scrapingPageUrl"/>
				</td>
			</tr>
					<s:submit value="登録"/>
			</s:form>
			</table>
		</div>
	</div>
</body>
</html>