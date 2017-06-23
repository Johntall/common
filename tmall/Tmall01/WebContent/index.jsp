<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>天猫商城</title>
<script src="js/index.js" type="text/javascript"></script>
<style type="text/css">
	*{
		margin: 0px;
		padding: 0px;
	}
	#headmenu{
		padding: 10px 5px 10px 5px;
		background-color: 000000;
		color: grey;
	}
	#headmenu span{
		padding: 10px 5px 10px 5px;
		
	}
	#order,#cart{
		position: relative;
		left: 600px;
	}

	#catmenu{
	position:absolute;
	}
	#catmenu>ul>li{
		float: left;
		list-style: none;
		padding: 10px 40px 10px 40px;
		background-color: red;
		border-right: solid black 1px;
		
	}
	#catbody{
	padding:45px;
	clear: both;
	
	}
	#catlist{
	background-color: gray;
	position:relative;
	}
	#catlist>div{
	display: none;
	}
	#search{
	text-align:center;
	}
	#lunbo{
	width:1180px;
	height:500px;
	}

</style>
</head>
<body>
<%




%>
<sql:setDataSource var="snapshot" driver="org.mariadb.jdbc.Driver" 
url="jdbc:mariadb://127.0.0.1:3306/tmall?useUnicode=true&characterEncoding=utf-8" 
user="jttest" password="9933"/>
<sql:query dataSource="${snapshot}" var="result">
select * from category;
</sql:query>

<div id="headmenu">
<span><a href="index.jsp">天猫首页</a></span>
<span>欢迎来天猫！</span>
<span><a href="login.html">请登录</a></span>
<span><a href="regist.html">免费注册</a></span>
<span id="order"><a href="order.html">我的订单</a></span>
<span id="cart"><a href="cart.html">购物车 ? 件</a></span>

</div>
<div id="search">
<form action="searchServlet" method="get">
<p><input type="text" name="want"/><input type="submit" value="搜索"/></p>



</form>

</div>
<div id="category">
<div id="catmenu">
<ul>
<li id="catlist"><a>商品分类</a>
<div>
<c:forEach var="row" items="${result.rows}">
<p id="<c:out value="${row.id}"/>"><c:out value="${row.name}"/></p>


</c:forEach>



</div>
</li>
<li><a>天猫超市</a></li>
<li><a>天猫国际</a></li>
<li><a>平板</a></li>
<li><a>电视</a></li>
<li><a>冰箱</a></li>
<li><a>电热水器</a></li>

</ul>

</div>
<div id="catbody">

<div id="lunbo">
<img  alt="" src="img/lunbo/1.jpg">

</div>
</div>
</div>
<div id="result"></div>



</body>
</html>