<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>后台管理系统</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" type="text/css" href="stylesheets/premium.css">
</head>
<body class=" theme-blue">


    
    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .navbar-default .navbar-brand, .navbar-default .navbar-brand:hover { 
            color: #fff;
        }
    </style>

    

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  

  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
   
  <!--<![endif]-->
<!-- 头部 开始   -->
    <jsp:include page="header_admin.jsp"></jsp:include>
   <!-- header end --> 
<!-- 左侧开始 begin -->
    <jsp:include page="sidebar_admin.jsp"></jsp:include>
<!-- sidebar end -->
    <div class="content">
    <!-- 右侧内容header 开始 -->
        <div class="header">
            <!-- <div class="stats">
    			<p class="stat"><span class="label label-info">5</span> Tickets</p>
    			<p class="stat"><span class="label label-success">27</span> Tasks</p>
    			<p class="stat"><span class="label label-danger">15</span> Overdue</p>
			</div> -->

            <h1 class="page-title">信息发布</h1>
            <!-- <ul class="breadcrumb">
            	<li><a href="">Home</a> </li>
            	<li class="active">首页管理</li>
        	</ul> -->
        </div>
        <!-- 右侧内容header end -->
        <div class="main-content">
    		<div class="panel panel-default">
        			<div class="panel-collapse panel-body collapse in">
                    	<div class="row">
	                        <div class="col-md-12">
	                        	<form action="addNewsinfo" method="post">
	                        		<div class="form-group">
    									<label for="newsTitle">标题：</label>
    									<input type="text" name="newsinfo.newstitle" value="${newsinfo.newstitle}" class="form-control" id="newsTitle" placeholder="输入标题">
  									</div>
  									<div class="form-group">
    									<label for="author">作者：</label>
    									<input type="text" name="newsinfo.author" value="${newsinfo.author}" class="form-control" id="author" placeholder="输入作者">
  									</div>
  									<div class="form-group">
    									<label for="newsType">新闻类型：</label>
    									<select class="form-control" name="newsinfo.newstype" style="display: inline-block;width: 120px; background: transparent;">
											<option <c:if test="${newsinfo.newstype==1}">selected</c:if> value="1">新闻动态</option>
										    <option <c:if test="${newsinfo.newstype==2}">selected</c:if> value="2">通知公告</option>
										    <option <c:if test="${newsinfo.newstype==3}">selected</c:if> value="3">学术报告</option>
										    <option <c:if test="${newsinfo.newstype==4}">selected</c:if> value="4">学术动态</option>
										</select>
  									</div>
  									<div class="form-group">
  										<label for="newsStatus1">是否设为焦点新闻：</label>
  										<c:choose>
  										<c:when test="${newsinfo.status  == 0}">
  											<label class="radio-inline">
  												<input type="radio" checked="ckecked" name="newsinfo.status" id="newsStatus1" value="0"> 否
											</label>
											<label class="radio-inline">
											  	<input type="radio" name="newsinfo.status" id="newsStatus2" value="1"> 是
											</label>
  										</c:when>
  										<c:otherwise>
	  										<label class="radio-inline">
	  											<input type="radio" name="newsinfo.status" id="newsStatus1" value="0"> 否
											</label>
											<label class="radio-inline">
											  	<input type="radio" checked="ckecked" name="newsinfo.status" id="newsStatus2" value="1"> 是
											</label>
  										</c:otherwise>
  										</c:choose>
  									</div>
  									<div class="form-group">
						                <label for="content">内容：</label>
						                <!-- <textarea name="content" id="content"></textarea> -->
						                <!-- 加载编辑器的容器 -->
									    <script id="content" name="newsinfo.newscontent" type="text/plain">${newsinfo.newscontent}</script>
						            </div>
						             <div class="form-group">
                						<button type="submit" class="btn btn-primary js-btnsub">发布</button>
            						</div>
	                        	</form>
    						</div>
                    	</div>
        			</div>
    		</div>
    	<!-- panel end-->
    	
        </div>
    </div>
 	<script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" src="../ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="../ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript" src="lib/addInfo_admin.js"></script>
</body>
</html>
