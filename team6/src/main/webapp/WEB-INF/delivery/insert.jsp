<%@page import="tw.team6.model.Delivery"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增外送訂單</title>
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

</style>
</head>
<body>

<div align="center" class="container mt-5">
  <h2>新增外送訂單</h2>
  <form  action="/team6/insert" method="post">
   <table>
  	<tr>
    <td>顧客姓名
    <td><input type="text" name="cname" value="" required/>
   	<tr>
   	<td>電話
    <td><input type="text" name="phone" value="" pattern="[0]{1}[2-9]{1}[0-9]{8}" required/>
  	<tr>
    <td>產品
    <td>
    <select name="product" id="product" required> 
	    <option value="夏威夷德國披薩">夏威夷德國披薩</option>
	    <option value="海鮮德國披薩">海鮮德國披薩</option>
	    <option value="牛肉k吧德國披薩">牛肉k吧德國披薩</option>
	    <option value="義大利雞肉焗烤麵">義大利雞肉焗烤麵</option>
	    <option value="牛肉k吧焗烤薯條">牛肉k吧焗烤薯條</option>
	    <option value="炸物拼盤">炸物拼盤</option>
	    <option value="蘋果肉桂德國烤餅">蘋果肉桂德國烤餅</option>
	    <option value="原味布丁">原味布丁</option>
	    <option value="可口可樂">可口可樂</option>
	</select>
	<tr>
   	<td>數量
    <td><input type="text" name="num" value="1" min=1 max=10/>
	<tr>
   	<td>價格
    <td><input type="text" name="price" value="" id="price"/>
  	<tr>
    <td>外送員工
    <td>
    <select name="ename">
	    <option value="Henry">Henry</option>
	    <option value="Allen">Allen</option>
	    <option value="David">David</option>
	    <option value="John">John</option>
    </select>
	<tr>
   	<td>地址
   	<td>
   	<select name="address" id="address">
	    <option value="中原大學">中原大學</option>
	    <option value="健行科技大學">健行科技大學</option>
	    <option value="中壢運動園區">中壢運動園區</option>
	    <option value="中壢火車站">中壢火車站</option>
	    <option value="內壢火車站">內壢火車站</option>
	    <option value="家樂福中壢店">家樂福 中壢店</option>
	    <option value="家樂福內壢店">家樂福 內壢店</option>
	    <option value="桃園市立龍興國民中學">桃園市立龍興國民中學</option>
	    <option value="莒光環保公園">莒光環保公園</option>
	    <option value="天晟醫院">天晟醫院</option>
    </select>
   	<tr>
    <td>外送時間
   	<td><input type="text" name="time" value="" />
  	</table>
   	<button type="submit" value="send">送出</button>
 </form>
 	<button id="home">返回</button>
 </div>
 <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
 <script>
 $(document).ready(function() {
	 
	 $("#home").click(function(){
		    let homeURL = "http://localhost:8080/team6/home";
		    window.location.href = homeURL;
		});
		
		// 產品選擇框的 change 事件處理程序
			$("#product").change(function() {
				let Product = $(this).val();
				let newPrice = getNewPrice(Product);
				// 取得選擇的產品值
				$("#price").val(newPrice);
			});
			$("#product").trigger("change");
		});

		function getNewPrice(product) {
			switch (product) {
			case "夏威夷德國披薩":
				return "279";
			case "海鮮德國披薩":
				return "289";
			case "牛肉k吧德國披薩":
				return "259";
			case "義大利雞肉焗烤麵":
				return "160";
			case "炸物拼盤":
				return "189";
			case "蘋果肉桂德國烤餅":
				return "160";
			case "原味布丁":
				return "50";
			case "可口可樂":
				return "39";
			case "牛肉k吧焗烤薯條":
				return "170";
			default:
				return "0";
			}
		}
</script>
</body>
</html>