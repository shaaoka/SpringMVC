<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="tw.team6.model.Delivery" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有外送訂單資料</title>
<style>
body {
	text-align: center;
	background-color : #fdf5e6;
}

.form {
	display: inline-block
}

button {
	margin:5px
}
a {
	text-decoration: none;
	
}
</style>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
</head>
<body>
<div align="center">
	<h2>所有外送訂單資料</h2>
	<br>
	
	<table  id="table_id" class="display" style="width:100%">
	<thead>
		<tr style="background-color:#8E8E8E">
			<th>訂單編號</th>
			<th>顧客姓名</th>
			<th>電話</th>
			<th>產品</th>
			<th>數量</th>
			<th>價格</th>
			<th>外送員工</th>
			<th>外送地址</th>
			<th>外送時間</th>
			<th>刪除</th>
			<th>修改</th>
		</tr>
	</thead>
	<tbody>
	<%
		List<Delivery> deliverys = (ArrayList<Delivery>) request.getAttribute("delivery");
		 if (deliverys != null) {
		        for (Delivery delivery: deliverys) {
		%>
         <tr>
			<td><%=delivery.getId()%></td>
			<td><%=delivery.getCname()%></td>
			<td><%=delivery.getPhone()%></td>
			<td><%=delivery.getProduct()%></td>
			<td><%=delivery.getNum()%></td>
			<td><%=delivery.getPrice()%></td>
			<td><%=delivery.getEname()%></td>
			<td><%=delivery.getAddress()%></td>
			<td><%=delivery.getTime()%>分鐘</td>
			<td><button id="del" onclick="confirmDelete('<%=delivery.getId()%>')">刪除</button></td>
			<td><a href="/team6/update/<%=delivery.getId()%>"><button>修改</button></a></td>
	<%}%>
<%}%>
		</tr>
    </tbody>
	</table>
</div>
	<br>
<button id="add" class="btn btn-secondary">新增</button>
<button id="home" class="btn btn-secondary">回首頁</button>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
<script>
	function confirmDelete(deliveryId) {
        var confirmDelete = confirm("您確定要刪除此項目嗎？");
        if (confirmDelete) {
            // 如果用户点击了确定，则将其重定向到删除链接
            window.location.href = "/team6/del/" + deliveryId;
        } else {
            // 如果用户点击了取消，则不执行任何操作
            return false;
        }
    }	

$(document).ready(function(){
	$('#add').click(function(){
    	let homeURL = "/team6/add";
    	window.location.href = homeURL;
	});
	$('#upd').click(function(){
    	let homeURL = "/team6/upd";
    	window.location.href = homeURL;
	});
	
	
	
	 $('#table_id').DataTable({
		 "searching": false,
		 "ordering": false,
	        columns: [
	            null, // Order ID
	            null, // Customer Name
	            null, // Phone
	            null, // Product
	            null, // Quantity - You might want to specify the actual data source for quantity
	            null, // Price
	            null, // Delivery Staff
	            null, // Delivery Address
	            null,//
	            null,//
	            null// Delivery Time
	        ],
	    })

	 
});

</script>
</body>
</html>