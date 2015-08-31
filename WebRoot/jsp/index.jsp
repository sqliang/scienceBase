<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head lang="zh-CN">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <title>首页</title>
    <link rel="stylesheet" href="/scienceBase/css/common/bootstrap.min.css" />
    <link rel="stylesheet" href="/scienceBase/css/common/reset.min.css" />
    <link rel="stylesheet" href="/scienceBase/css/common/header.css" />
    <link rel="stylesheet" href="/scienceBase/css/common/banner.css" />
    <link rel="stylesheet" href="/scienceBase/css/common/footer.css" />
    <link rel="stylesheet" href="/scienceBase/css/index.css" />
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<!-- 引入头部 -->
<jsp:include page="header.jsp"></jsp:include>
<!-- header end -->
<div class="main">
<!-- banner -->
	<div class="banner">
		<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  		  <!-- Indicators -->
		  <ol class="carousel-indicators">
		    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
		    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
		    <!-- <li data-target="#carousel-example-generic" data-slide-to="2"></li> -->
		  </ol>

		  <!-- Wrapper for slides -->
		  <div class="carousel-inner" role="listbox">
		    <div class="item active">
		      <img src="/scienceBase/img/demo3.jpg" alt="...">
		      <div class="carousel-caption">
		        <h1>tilte 1</h1>
		      </div>
		    </div>
		    <div class="item">
		      <img src="/scienceBase/img/demo4.jpg" alt="...">
		      <div class="carousel-caption">
		        <h1>tilte 4</h1>
		      </div>
		    </div>
		  </div>

		  <!-- Controls -->
		  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
		    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
		    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		    <span class="sr-only">Next</span>
		  </a>
		  <!-- Controls end -->
		</div>
	</div>
	<!-- banner end -->
	<div class="news-box clearfix">
		<div class="left-news">
		</div>
		<div class="right-news">
			<div class="art-title clearfix">
				<span class="left-title">最近新闻</span>
				<span class="right-link">
					<a href="#" target="_blank">更多&gt;&gt;</a>
				</span>
			</div>
			<ul class="info-list clearfix">
				<c:forEach var="lastNews" begin="0" end="6" items="${lastNewss}">
					<li>
						<span class="left-con">
							<a href="#" target="_blank">${lastNews.newstitle }</a>
						</span>
						<span class="news-time">${lastNews.time}</span>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div class="extra-news-info clearfix">
		<div class="extra-left">
			<div class="art-title">
				<span class="left-title">通知公告</span>
				<span class="right-link">
					<a href="#" target="_blank">更多&gt;&gt;</a>
				</span>
			</div>
			<ul class="info-list clearfix">
				<c:forEach var="noticeNews" begin="0" end="4" items="${noticeNewss}">
					<li>
						<span class="left-con">
							<a href="#" target="_blank">${noticeNews.newstitle }</a>
						</span>
						<span class="news-time">${noticeNews.time}</span>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div class="extra-between">
			<div class="art-title">
				<span class="left-title">学术报告</span>
				<span class="right-link">
					<a href="#" target="_blank">更多&gt;&gt;</a>
				</span>
			</div>
			<ul class="info-list clearfix">
				<c:forEach var="resReport" begin="0" end="4" items="${resReports}">
					<li>
						<span class="left-con">
							<a href="#" target="_blank">${resReport.newstitle }</a>
						</span>
						<span class="news-time">${resReport.time}</span>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div class="extra-right">
			<div class="art-title">
				<span class="left-title">学术动态</span>
				<span class="right-link">
					<a href="#" target="_blank">更多&gt;&gt;</a>
				</span>
			</div>
			<ul class="info-list clearfix">
				<c:forEach var="resDongTai" begin="0" end="4" items="${resDongTais}">
						<li>
							<span class="left-con">
								<a href="#" target="_blank">${resDongTai.newstitle }</a>
							</span>
							<span class="news-time">${resDongTai.time}</span>
						</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>
<div class="useful-link"></div>
<!-- 引入底部 -->
<jsp:include page="footer.jsp"></jsp:include>
<!-- footer end -->
<script src="/scienceBase/js/lib/jquery.min.js"></script>
<script src="/scienceBase/js/lib/bootstrap.min.js"></script>
</body>
</html>