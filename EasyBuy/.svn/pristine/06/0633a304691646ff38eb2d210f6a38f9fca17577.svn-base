<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 注册页面</title>
</head>
<body>
<%@include file="/common/header.jsp" %>
<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
		<div class="box">
			<h1>欢迎注册易买网</h1>
			<ul class="steps clearfix">
				<li class="current"><em></em>填写注册信息</li>
				<li class="last"><em></em>注册成功</li>
			</ul>
			<form id="regForm" method="post" action="" onsubmit="return checkForm(this);">
				<table>
					<tr>
						<td class="field">*用户名：</td>
						<td><input class="loginName" type="text" name="loginName" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">*登录密码：</td>
						<td><input class="passWord_1" type="password" id="passWord_1" name="passWord" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">*确认密码：</td>
						<td><input class="passWord_2" type="password" name="rePassWord_2" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">*姓名：</td>
						<td><input class="userName" type="text" name="userName" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">姓别：</td>
						<td>
							<input class="sex" type="checkbox" name="sex" value="1">男</input>
							<input class="sex" type="checkbox" name="sex" value="2">女</input>
							<span></span>
						</td>
					</tr>
					<tr>
						<td class="field">手机号：</td>
						<td><input class="mobile" type="text" name="mobile" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">身份证号：</td>
						<td><input class="identityCode" type="text" name="identityCode" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">邮箱地址：</td>
						<td><input class="email" type="text" name="email" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-green"><input type="button" name="submit" value="提交注册" onclick="register()"/></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<%@include file="/common/footer.jsp" %>
<script type="text/javascript" src="${ctx}/statics/scripts/register.js"></script>
</body>
</html>
