<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
</head>
<body>		

<form name="itemsForm" method="post">
<table border="1">
	<tr>
		<td>查询条件:</td>
		<td><input name="itemsCustom.name" type="text"></td>
		<td colspan="4"><input type="button" value="查询" onclick="queryItems()"><input type="button" onclick="deleteItems()" value="删除"/> </td>
	</tr>
	<tr><td>选中</td>	
		<td>商品名称</td>
		<td>商品价格</td>
		<td>生产日期</td>
		<td>商品描述</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${itemsList }" var="item">
	<tr>
	    <td><input type="checkbox" name="items_id" value="${item.id}"></td>	
		<td>${item.name}</td>
		<td>${item.price}</td>
		<td>${item.createtime}</td>
		<td>${item.detail}</td>
		<td><a href="${pageContext.request.contextPath }/items/editItems.action?id=${item.id}">修改</a></td>
	</tr>
	</c:forEach>
</table>
</form>


</body>
<script type="text/javascript">
function deleteItems(){
	document.itemsForm.action="${pageContext.request.contextPath}/items/deleteItems.action";
	document.itemsForm.submit();
}
function queryItems(){
	document.itemsForm.action="${pageContext.request.contextPath}/items/queryItems.action";
	document.itemsForm.submit();
}

</script>

</html>