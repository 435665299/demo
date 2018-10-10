<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<link type="text/css" rel="stylesheet"
	href="${ctx}/statics/css/style.css" />
</head>
<body>
<%@include file="/common/header.jsp" %>
<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
		<div class="box">
			<h1>欢迎回到易买网</h1>
			<form id="loginForm" method="post" action="" onsubmit="return checkForm(this)">
				<table>
					<tr>
						<td class="field" >用户名：</td>
						<td><input class="text" type="text" id="loginName" name="loginName" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field" >登录密码：</td>
						<td><input class="text" type="password" id="password" name="password" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-green"><input type="button" name="button" value="立即登录" onclick="login()" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<%@include file="/common/footer.jsp" %>
<script type="text/javascript" src="${ctx}/statics/scripts/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/statics/scripts/login.js"></script>
<script type="text/javascript" src="${ctx}/statics/scripts/function.js"></script>
</body>
</html>