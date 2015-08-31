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
        </div>
        <!-- 右侧内容header end -->
        <div class="main-content">
    	<!-- 第一个panel -->
    		<div class="panel panel-default">
        			<a href="#mem-box" class="panel-heading" data-toggle="collapse">
        				实验室人员信息发布
        			</a>
        			<div id="mem-box" class="panel-collapse panel-body collapse in">
                    	<div class="row">
                    		<div class="col-md-12">
                    			<form action="">
                    				<div class="form-group">
    									<label for="mem-name">*姓名：</label>
    									<input type="text" class="form-control" id="mem-name" placeholder="输入姓名">
  									</div>
  									<div class="form-group">
  										<label for="memSex1">*性别：</label>
  										<label class="radio-inline">
  											<input type="radio" checked="ckecked" name="memSex" id="memSex1" value="1"> 男
										</label>
										<label class="radio-inline">
										  	<input type="radio" name="memSex" id="memSex2" value="0"> 女
										</label>
  									</div>
  									<div class="form-group">
    									<label for="mem-age">年龄：</label>
    									<input type="text" class="form-control" id="mem-age" placeholder="输入年龄">
  									</div>
  									<div class="form-group">
    									<label for="mem-degree">*学位：</label>
    									<select class="form-control" id="mem-degree" style="display: inline-block;width: 140px; background: transparent;">
											<option value="博士后">博士后</option>
										    <option value="博士">博士</option>
										    <option value="硕士">硕士</option>
										    <option value="学士">学士</option>
										</select>
  									</div>
  									<div class="form-group">
    									<label for="memJobTitle">*职称：</label>
    									<select class="form-control" id="memJobTitle" style="display: inline-block;width: 140px; background: transparent;">
											<option value="教授">教授</option>
										    <option value="副教授">副教授</option>
										    <option value="研究员">研究员</option>
										</select>
  									</div>
  									<div class="form-group">
    									<label for="memType">*人才类型：</label>
    									<select class="form-control" id="memType" style="display: inline-block;width: 140px; background: transparent;">
											<option value="固定队伍">固定队伍</option>
										    <option value="流动队伍">流动队伍</option>
										</select>
  									</div>
  									<div class="form-group">
    									<label for="mem-chenghao">人才称号：</label>
    									<label class="checkbox-inline">
										  <input type="checkbox" name="memChengHao" id="mem-chenghao1" value="两院院士"> 两院院士
										</label>
										<label class="checkbox-inline">
										  <input type="checkbox" name="memChengHao" id="mem-chenghao2" value="人才计划"> 人才计划
										</label>
										<label class="checkbox-inline">
										  <input type="checkbox" name="memChengHao" id="mem-chenghao3" value="学术骨干"> 学术骨干
										</label>
										<label for="mem-chenghao4">&nbsp;&nbsp;&nbsp;其他：</label>
    									<input style="display:inline-block;width:140px;" type="text" class="form-control" name="mem-chenghao" id="mem-chenghao4" placeholder="输入人才称号">
  									</div>
  									<div class="form-group">
    									<label for="memJobAge">工作年限：</label>
    									<input type="text" class="form-control" id="memJobAge" placeholder="输入在实验室工作年限">
  									</div>
  									<div class="form-group">
  										<label for="foreignType1">*是否为访问学者：</label>
  										<label class="radio-inline">
  											<input type="radio" checked="ckecked" name="foreignType" id="foreignType1" value="0"> 否
										</label>
										<label class="radio-inline">
										  	<input type="radio" name="foreignType" id="foreignType2" value="1"> 是
										</label>
  									</div>
  									<div class="foreign-box" style="border:1px solid #ddd;padding:10px;margin-bottom:10px;border-radius:4px;background:#DDD;">
	  									<div class="form-group">
	    									<label for="foreginOrgName">访问学者原单位名称：</label>
	    									<input type="text" class="form-control" id="officedate" placeholder="输入原单位名称">
	  									</div>
	  									<div class="form-group">
	    									<label for="intrUrl">访问学者个人外连主页链接：</label>
	    									<input type="text" class="form-control" id="intrUrl" placeholder="输入个人主页链接">
	  									</div>
  									</div>
  									<div class="form-group">
                						<button type="submit" class="btn btn-primary pull-right js-btnsub">发布</button>
            						</div>
                    			</form>
                    		</div>
                    	</div>
        			</div>
    		</div>
    	<!-- 第一个panel end-->
        </div>
    </div>
 	<script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="lib/bootstrap/js/bootstrap.js"></script>
</body>
</html>
