<%@ page pageEncoding="UTF-8"%>
<%@ page import="model.Cart" %>
<%@ page import="model.Store" %>

	<%-- 店舗名・ユーザIDの表示 --%>
	<% 
		Cart cartHdr = (Cart) session.getAttribute("cart");
		if (cartHdr == null) {
			request.setAttribute("errorMsg", "再ログインをお願いします。");	
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
	%>
			<div class=user><%=cartHdr.getUserId() %>さん </div>
			<hr>

			<%-- ナビ表示 --%>
			<div id="menu" class="big-bg">
            <header class="page-header wrapper">
                <h1><a href="select.jsp"><img class="logo" src="images/ロゴ.png" alt="ロゴ"></a></h1>
                <nav>
                    <ul class="main-nav">
                        <li><a href="select.jsp">商品一覧</a></li>
                        <li><a href="cart.jsp">カート</a></li>
                        <li><a href="logout-servlet">ログアウト</a></li>
                    </ul>
                </nav>
            </header>

            <div class="menu-content wrapper">
	<%
		}
	%>
