<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>后台管理系统</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="/scienceBase/admin/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="/scienceBase/admin/lib/font-awesome/css/font-awesome.css">

   
    <link rel="stylesheet" type="text/css" href="/scienceBase/admin/stylesheets/theme.css">
    <link rel="stylesheet" type="text/css" href="/scienceBase/admin/stylesheets/premium.css">

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

            <h1 class="page-title">开放与交流管理-信息查看</h1>
            <!-- <ul class="breadcrumb">
            	<li><a href="">Home</a> </li>
            	<li class="active">首页管理</li>
        	</ul> -->
        </div>
        <!-- 右侧内容header end -->
        <div class="main-content">
		<!-- 第一个panel -->
    		<div class="panel panel-default">
        			<a href="#commun-box" class="panel-heading" data-toggle="collapse">
        				交流信息查看
        			</a>
        			<div id="commun-box" class="panel-collapse panel-body collapse in">
                    	<div class="row">
	                        <div class="col-md-12">
						        <table class="table">
									  <thead>
									    <tr>
									      <th>#</th>
									      <th>交流信息标题</th>
									      <th>交流信息类别</th>
									      <th>发布时间</th>
									      <th style="width: 3.5em;"></th>
									    </tr>
									  </thead>
									  <tbody>
									  <c:forEach varStatus="status" var="communicateinfo" items="${communicateinfos}">
									    <tr>
									      <td>${status.index + 1}</td>
									      <td><a>${communicateinfo.communicatetitle}</a></td>
									      <c:choose>
									      <c:when test="${communicateinfo.communicatetype == 1}">
									      <td>国内交流</td>
									      </c:when>
									      <c:when test="${communicateinfo.communicatetype == 2}">
									      <td>国际交流</td>
									      </c:when>
									      </c:choose>
									      <td>${communicateinfo.time}</td>
									       <td>
									          <a href="delCommunicateinfoById?communicateId=${communicateinfo.communicateid}" role="button" data-toggle="modal"><i class="fa fa-trash-o"></i></a>
									      </td>
									    </tr>
									  </c:forEach>
									  </tbody>
								</table>
    						</div>
                    	</div>
        			</div>
    		</div>
    	<!-- 第一个panel end-->
    	<!-- 第二个panel -->
    		<div class="panel panel-default">
        			<a href="#public-box" class="panel-heading" data-toggle="collapse">
        				开放课题信息查看
        			</a>
        			<div id="public-box" class="panel-collapse panel-body collapse in">
                    	<div class="row">
	                        <div class="col-md-12">
						        <table class="table">
									  <thead>
									    <tr>
									      <th>#</th>
									      <th>开放课题标题</th>
									      <th>发布时间</th>
									      <th style="width: 3.5em;"></th>
									    </tr>
									  </thead>
									  <tbody>
									  <c:forEach varStatus="status" var="pubclassinfo" items="${pubclassinfos}">
									    <tr>
									      <td>${status.index + 1}</td>
									      <td><a>${pubclassinfo.pubclasstitle}</a></td>
									      <td>${pubclassinfo.time}</td>
									       <td>
									          <a href="delPubclassinfoById?pubClassId=${pubclassinfo.pubclassid}" role="button" data-toggle="modal"><i class="fa fa-trash-o"></i></a>
									      </td>
									    </tr>
									  </c:forEach>
									  </tbody>
								</table>
    						</div>
                    	</div>
        			</div>
    		</div>
    	<!-- 第二个panel end-->
        </div>
    </div>
 	<script src="/scienceBase/admin/lib/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="/scienceBase/admin/lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
    $(".nav-header").addClass("collapsed");
    $(".sidebar-nav ul li ul.nav-list").removeClass("in");
    $(".nav-header").eq(6).removeClass("collapsed");
    $(".sidebar-nav ul li ul.nav-list").eq(6).addClass("in");
    </script>
</body>
</html>
