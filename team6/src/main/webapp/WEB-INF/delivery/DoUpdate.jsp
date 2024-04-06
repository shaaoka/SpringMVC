<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>修改員工資料</title>
<style>
a, a:visited {
	text-decoration: none;
	color: blue;
}

button {
	margin: 0 20px 0 35px;
}
</style>
</head>

<body style="background-color: #fdf5e6">
	<div align="center">

		<h2>修改訂單資料</h2>
		<form:form method="post" action="/team6/delivery/upd" modelAttribute="delivery">
			<table>
				<tr>
					<td>訂單編號</td>
					<td><form:input path="id"/></td>
				</tr>
				<tr>
					<td>顧客姓名</td>
					<td><form:input path="cname"/></td>
				</tr>
				<tr>
					<td>電話</td>
					<td><form:input path="phone"/></td>
				</tr>
				<tr>
					<td>產品</td>
					<td><form:input path="product"/></td>
				</tr>
				<tr>
					<td>數量</td>
					<td><form:input path="num"/></td>
				</tr>
				<tr>
					<td>價格</td>
					<td><form:input path="price"/></td>
				</tr>
				<tr>
					<td>外送員工</td>
					<td><form:input path="ename"/></td>
				</tr>
				<tr>
					<td>地址</td>
					<td><form:input path="address"/></td>
				</tr>
				<tr>
					<td>外送時間</td>
					<td><form:input path="Time"/></td>
				</tr>
			</table>
			<form:button type="submit" value="send">更新</form:button>
			<a href="/team6/delivery">回上一頁</a>
		</form:form>
	</div>
</body>

</html>