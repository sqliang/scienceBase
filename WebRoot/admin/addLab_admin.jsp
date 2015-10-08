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
        			<a href="#resDirect" class="panel-heading" data-toggle="collapse">
        				研究方向发布
        			</a>
        			<div id="resDirect" class="panel-collapse panel-body collapse in">
                    	<div class="row">
                    		<div class="col-md-12">
                    			<form action="addResdirection" method="POST">
                    				<div class="form-group">
    									<label for="title">标题：</label>
    									<input type="text" name="resdirection.dirtitle" class="form-control" id="title" placeholder="输入标题">
  									</div>
  									<div class="form-group">
    									<label for="resDirContent">研究方向简介：</label>
    									<textarea name="resdirection.content" style="height:100px;resize:none;" class="form-control" id="resDirContent" placeholder="输入简介内容"></textarea>
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
		<!-- 第二个panel -->
    		<div class="panel panel-default">
        			<a href="#orgnization" class="panel-heading" data-toggle="collapse">
        				机构设置发布
        			</a>
        			<div id="orgnization" class="panel-collapse panel-body collapse in">
                    	<div class="row">
                    		<div class="col-md-12">
                    			<form action="addOrganization" method="POST">
                    				<div class="form-group">
    									<label for="title">标题：</label>
    									<input type="text" name="organization.orgtitle" class="form-control" id="title" placeholder="输入标题">
  									</div>
  									<div class="form-group">
    									<label for="resDirContent">机构设置简介：</label>
    									<textarea name="organization.content" style="height:100px;resize:none;" class="form-control" id="resDirContent" placeholder="输入简介内容"></textarea>
  									</div>
  									<div class="form-group">
                						<button type="submit" class="btn btn-primary pull-right js-btnsub">发布</button>
            						</div>
                    			</form>
                    		</div>
                    	</div>
        			</div>
    		</div>
    	<!-- 第二个panel end-->
    	<!-- 第三个panel -->
    		<!-- <div class="panel panel-default">
        			<a href="#leader" class="panel-heading" data-toggle="collapse">
        				领导人员信息发布
        			</a>
        			<div id="leader" class="panel-collapse panel-body collapse in">
                    	<div class="row">
                    		<div class="col-md-12">
                    			<form action="">
                    				<div class="form-group">
    									<label for="name">姓名：</label>
    									<input type="text" class="form-control" id="name" placeholder="输入标题">
  									</div>
  									<div class="form-group">
  										<label for="leaderType1">是否为现任领导：</label>
  										<label class="radio-inline">
  											<input type="radio" checked="ckecked" name="leaderType" id="leaderType1" value="1"> 是
										</label>
										<label class="radio-inline">
										  	<input type="radio" name="leaderType" id="leaderType2" value="0"> 否
										</label>
  									</div>
  									<div class="form-group">
    									<label for="position">职位类型：</label>
    									<select class="form-control" style="display: inline-block;width: 120px; background: transparent;">
											<option value="1">主任</option>
										    <option value="2">副主任</option>
										    <option value="3">委员</option>
										</select>
  									</div>
  									<div class="form-group">
    									<label for="officedate">任职时间：</label>
    									<input type="date" class="form-control" id="officedate">
  									</div>
  									<div class="form-group">
                						<button type="submit" class="btn btn-primary pull-right js-btnsub">发布</button>
            						</div>
                    			</form>
                    		</div>
                    	</div>
        			</div>
    		</div> -->
    	<!-- 第三个panel end-->
    	<!-- 第四个panel -->
    		<div class="panel panel-default">
        			<a href="#aca-box" class="panel-heading" data-toggle="collapse">
        				学术委员会信息发布
        			</a>
        			<div id="aca-box" class="panel-collapse panel-body collapse in">
                    	<div class="row">
                    		<div class="col-md-12">
                    			<form action="addAcaInfo" method="POST">
                    				<div class="form-group">
    									<label for="aca-name">*姓名：</label>
    									<input type="text" name="acainfo.acaname" class="form-control" id="aca-name" placeholder="输入姓名">
  									</div>
  									<div class="form-group">
  										<label for="acaSex1">*性别：</label>
  										<label class="radio-inline">
  											<input type="radio" checked="ckecked" name="acainfo.acasex" id="acaSex1" value="1"> 男
										</label>
										<label class="radio-inline">
										  	<input type="radio" name="acainfo.acasex" id="acaSex2" value="0"> 女
										</label>
  									</div>
  									<div class="form-group">
    									<label for="aca-age">年龄：</label>
    									<input type="text" name="acainfo.acaage" class="form-control" id="aca-age" placeholder="输入年龄">
  									</div>
  									<div class="form-group">
  										<label for="acaType1">*是否为现任委员会人员：</label>
  										<label class="radio-inline">
  											<input type="radio" checked="ckecked" name="acainfo.acatype" id="acaType1" value="1"> 是
										</label>
										<label class="radio-inline">
										  	<input type="radio" name="acainfo.acatype" id="acaType2" value="0"> 否
										</label>
  									</div>
  									<div class="form-group">
    									<label for="aca-position">*职位类型：</label>
    									<select name="acainfo.position" class="form-control" style="display: inline-block;width: 120px; background: transparent;">
											<option value="1">主任</option>
										    <option value="2">副主任</option>
										    <option value="3">委员</option>
										</select>
  									</div>
  									<div class="form-group">
    									<label for="officedate">*就任时间：</label>
    									<input type="date" name="acainfo.officedate" class="form-control" id="officedate" placeholder="输入日期">
  									</div>
  									<div class="form-group">
    									<label for="intrUrl">个人主页链接：</label>
    									<input type="text" name="acainfo.intrurl" class="form-control" id="intrUrl" placeholder="输入个人主页链接">
  									</div>
  									<div class="form-group">
                						<button type="submit" class="btn btn-primary pull-right js-btnsub">发布</button>
            						</div>
                    			</form>
                    		</div>
                    	</div>
        			</div>
    		</div>
    	<!-- 第四个panel end-->
        </div>
    </div>
 	<script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="lib/bootstrap/js/bootstrap.js"></script>
</body>
</html>
