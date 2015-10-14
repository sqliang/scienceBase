<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
        <!-- 第一个panel -->
        <div class="panel panel-default">
        			<a href="#communicate" class="panel-heading" data-toggle="collapse">
        				交流信息发布
        			</a>
        			<div id="communicate" class="panel-collapse panel-body collapse in">
                    	<div class="row">
                    		<div class="col-md-12">
                    			<form action="">
                    				<div class="form-group">
    									<label for="communicateTitle">*交流信息标题：</label>
    									<input type="text" class="form-control" id="communicateTitle" placeholder="输入交流信息标题">
  									</div>
  									<div class="form-group">
    									<label for="communicateType">*交流信息类型：</label>
    									<select class="form-control" id="communicateType" style="display: inline-block;width: 140px; background: transparent;">
											<option value="1">国内交流</option>
										    <option value="2">国际交流</option>
										</select>
  									</div>
  									<div class="form-group">
    									<label for="sub-time">*时间：</label>
    									<input type="date" class="form-control" id="sub-time">
  									</div>
  									<div class="form-group">
						                <label for="comContent">交流信息内容：</label>
						                <!-- <textarea name="content" id="content"></textarea> -->
						                <!-- 加载编辑器的容器 -->
									    <script id="comContent" name="content" type="text/plain">请输入内容</script>
						            </div>
  									<div class="form-group">
                						<button type="submit" class="btn btn-primary pull-right js-btnsub">发布</button>
            						</div>
                    			</form>
                    		</div>
                    	</div>
        			</div>
    		</div>
        <!-- panel end -->
        <!-- 第二个 panel -->
    		<div class="panel panel-default">
        			<a href="#pubClass" class="panel-heading" data-toggle="collapse">
        				开放课题信息发布
        			</a>
        			<div id="pubClass" class="panel-collapse panel-body collapse in">
                    	<div class="row">
                    		<div class="col-md-12">
                    			<form action="">
                    				<div class="form-group">
    									<label for="pubClassTitle">开放课题标题：</label>
    									<input type="text" class="form-control" id="pubClassTitle" placeholder="输入开放课题标题">
  									</div>
  									<div class="form-group">
    									<label for="subTime">时间：</label>
    									<input type="date" class="form-control" id="subTime">
  									</div>
  									<div class="form-group">
						                <label for="pubClassContent">内容：</label>
						                <!-- <textarea name="content" id="content"></textarea> -->
						                <!-- 加载编辑器的容器 -->
									    <script id="pubClassContent" name="content" type="text/plain">请输入内容</script>
						            </div>
  									<div class="form-group">
                						<button type="submit" class="btn btn-primary pull-right js-btnsub">发布</button>
            						</div>
                    			</form>
                    		</div>
                    	</div>
        			</div>
    		</div>
    		<!-- panel end -->
        </div>
    </div>
 	<script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" src="../ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="../ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript">
	$(function(){
		var option = {
		        initialFrameHeight : 800,
		        scaleEnabled : false,
		        wordCount : true
		};
		var ueCom = UE.getEditor('comContent',option);
		var uePubClass = UE.getEditor('pubClassContent');
	    $(".nav-header").addClass("collapsed");
	    $(".sidebar-nav ul li ul.nav-list").removeClass("in");
	    $(".nav-header").eq(6).removeClass("collapsed");
	    $(".sidebar-nav ul li ul.nav-list").eq(6).addClass("in");
	});
	</script>
</body>
</html>
