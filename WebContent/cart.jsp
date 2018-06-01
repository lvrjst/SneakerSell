<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="#session.LoginDTO.userId" />のカート</title>
</head>
<body>
	<jsp:include page="topMenu.jsp" />

	<s:if test='cartDTOList.isEmpty()'>
		<p>かーとに入れた商品はありません。</p>
	</s:if>
	<s:else>
		<s:iterator value="cartDTOList">
			<%-- <s:property value="productName" />
			<s:property value="productNameKana" />
			<s:property value="releaseDate" />
			<s:property value="releaseCompany" />

			 --%>
			<s:property value="itemName" />
			<s:property value="itemPrice" />
			<s:property value="itemCount" />
			<img src="<s:property value='topPicUrl' />" />
			<s:property value="itemTotalPrice" />
			<s:form action="CartDeleteAction">
				<input type="hidden" name="itemId" value="<s:property value='itemId'/>" />
				<s:submit value="削除"/>
			</s:form>
		</s:iterator>
			<s:property value="totalPrice" />
	</s:else>



</body>
</html>