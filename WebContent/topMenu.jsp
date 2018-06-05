<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="floating_menu">

	<div class="home clearfix">
		<div class="home_button clearfix">
			<p><img class="clearfix" src="image/list_style_image.png" href="index.jsp"></p>
			<p class="clearfix"><a href="index.jsp#home" >Air Jordan</a></p>
		</div>
		<ul class="clearfix">
			<li class="clearfix"></li>
			<li>
				ようこそ
					<s:if test="#session.loginFlg"><s:property value="#session.LoginDTO.userName"/></s:if>
					<s:else>ゲスト</s:else>
				さん
			</li>
			<li>
			<s:if test="#session.loginFlg"><a href="<s:url action='LogoutAction' />">ログアウト</a></s:if>
			<s:else><a href="<s:url action='HomeAction' />">ログイン</a></s:else>
			</li>
			<li><a href="scraping.jsp">商品追加</a></li>
			<li><a href="<s:url action='CartAction' />">ショッピングカート</a></li>
			<li><a href="<s:url action='SneakerSellAction' />">商品一覧</a></li>
		</ul>
	</div>
</div>
