<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.Store" %>
<%@ page import="model.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<%@include file = "header-navi.jsp"%>

	<%
		List<Product> listProd;
		Store store = (Store) session.getAttribute("store");
		if (store == null) {
			listProd = new ArrayList<Product>();
		} else {
			listProd = store.getListProd();
		}
		if (listProd.size() > 0) {
	%>

			<h1>商品一覧</h1>
			
	<%
		}	
	%>		
	
	<div class="container">
    <div class="sidebar">
        <h3 class="sub-title">カテゴリー</h3>
                <ul class="sub-menu">
                    <li><a href="toy.jsp">おもちゃ</a></li>
                    <li><a href="#">給水用品</a></li>
                    <li><a href="#">トイレ用品</a></li>
                    <li><a href="#">布団・クッション</a></li>
                    <li><a href="#">服</a></li>
                    <li><a href="#">お風呂用品</a><li>
                </ul>
    </div>

<div class="item-container">
<%
    for(int idx = 0; idx < listProd.size(); idx++) {
        Product prod = listProd.get(idx);
%>
        <div class="item">
          <img src="<%=prod.getImagePath() %>" width="200">
            <p><%=prod.getName() %></p>
            <p>￥<%=prod.getPrice() %></p>
            <form action="add-prod-servlet" method="POST">
                <input type="hidden" name="productId" value="<%=prod.getId() %>">
                <input type="submit" value="カートに追加">
            </form>
        </div>
<%
    }
%>
</div>


</body>
</html>