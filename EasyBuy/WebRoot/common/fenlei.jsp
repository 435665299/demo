<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
			<c:forEach items="${pcList}" var="pc1">
				<dt>${pc1.productCategory.name}</dt>
				<c:forEach items="${pc1.productCategoryVoList}" var="pc1List">
				<dd><a href="product-list.html">${pc1List.productCategory.name}</a></dd>
				</c:forEach>
			</c:forEach>
			</dl>
		</div>
		<div class="spacer"></div>
		<div class="last-view">
			<h2>最近浏览</h2>
			<dl class="clearfix">
				<dt><img src="${ctx}/statics/images/product/0_tiny.gif" /></dt>
				<dd><a href="product-view.html">法国德菲丝松露精品巧克力500g/盒</a></dd>
				<dt><img src="${ctx}/statics/images/product/0_tiny.gif" /></dt>
				<dd><a href="product-view.html">法国德菲丝松露精品巧克力500g/盒</a></dd>
			</dl>
			<script type="text/javascript">
				document.write("Cookie中记录的购物车商品ID："+ getCookie("product") + "，可以在动态页面中进行读取");
			</script>
		</div>
	</div>
</body>
</html>