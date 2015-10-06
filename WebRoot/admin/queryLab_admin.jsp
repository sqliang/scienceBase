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

            <h1 class="page-title">实验室概况管理-信息查看</h1>
            <!-- <ul class="breadcrumb">
            	<li><a href="">Home</a> </li>
            	<li class="active">首页管理</li>
        	</ul> -->
        </div>
        <!-- 右侧内容header end -->
        <div class="main-content">
		<!-- 第一个panel -->
    		<div class="panel panel-default">
        			<a href="#article-box" class="panel-heading" data-toggle="collapse">
        				研究方向查看
        			</a>
        			<div id="article-box" class="panel-collapse panel-body collapse in">
                    	<div class="row">
	                        <div class="col-md-12">
						        <table class="table">
									  <thead>
									    <tr>
									      <th>#</th>
									      <th>研究方向标题</th>
									      <th>发布时间</th>
									      <th style="width: 3.5em;"></th>
									    </tr>
									  </thead>
									  <tbody>
									  	<c:forEach varStatus="status" var="resdirection" items="${resdirections}">
									    <tr>
									      <td>${status.index + 1}</td>
									      <td><a>${resdirection.dirtitle}</a></td>
									      <td>${resdirection.time}</td>
									       <td>
									          <a href="delResdirectionById?dirId=${resdirection.dirid}" role="button" data-toggle="modal"><i class="fa fa-trash-o"></i></a>
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
        			<a href="#orgnaiz-box" class="panel-heading" data-toggle="collapse">
        				机构设置查看
        			</a>
        			<div id="orgnaiz-box" class="panel-collapse panel-body collapse in">
                    	<div class="row">
	                        <div class="col-md-12">
						        <table class="table">
									  <thead>
									    <tr>
									      <th>#</th>
									      <th>机构名称</th>
									      <th>发布时间</th>
									      <th style="width: 3.5em;"></th>
									    </tr>
									  </thead>
									  <tbody>
									  <c:forEach varStatus="status" var="organization" items="${organizations}">
									    <tr>
									      <td>${status.index + 1}</td>
									      <td><a>${organization.orgtitle}</a></td>
									      <td>${organization.time}</td>
									       <td>
									          <a href="delOrgById?orgId=${organization.orgid}" role="button" data-toggle="modal"><i class="fa fa-trash-o"></i></a>
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
    	<!-- 第三个panel -->
    		<div class="panel panel-default">
        			<a href="#leader-box" class="panel-heading" data-toggle="collapse">
        				领导人员信息查看
        			</a>
        			<div id="leader-box" class="panel-collapse panel-body collapse in">
                    	<div class="row">
	                        <div class="col-md-12">
						        <table class="table">
									  <thead>
									    <tr>
									      <th>#</th>
									      <th>姓名</th>
									      <th>职位</th>
									      <th>是否现任领导</th>
									      <th>任职日期</th>
									      <th style="width: 3.5em;"></th>
									    </tr>
									  </thead>
									  <tbody>
									  <c:forEach varStatus="status" var="leaderinfo" items="${leaderinfos}">
									    <tr>
									      <td>${status.index + 1}</td>
									      <td><a>${leaderinfo.memberinfomemid.memname}</a></td>
									      <td>${leaderinfo.position}</td>
									      <c:choose>
									      <c:when test="${leaderinfo.leadertype == 1}">
									      	<td>是</td>
									      </c:when>
									      <c:when test="${leaderinfo.leadertype == 0}">
									      	<td>否</td>
									      </c:when>
									      </c:choose>
									      <td>${leaderinfo.officedate}</td>
									       <td>
									          <a href=""><i class="fa fa-pencil"></i></a>
									          <a href="" role="button" data-toggle="modal"><i class="fa fa-trash-o"></i></a>
									      </td>
									    </tr>
									  </c:forEach>
									  </tbody>
								</table>
    						</div>
                    	</div>
        			</div>
    		</div>
    	<!-- 第三个panel end-->
    	<!-- 第四个panel -->
    		<div class="panel panel-default">
        			<a href="#aca-box" class="panel-heading" data-toggle="collapse">
        				学术委员会信息查看
        			</a>
        			<div id="aca-box" class="panel-collapse panel-body collapse in">
                    	<div class="row">
	                        <div class="col-md-12">
						        <table class="table">
									  <thead>
									    <tr>
									      <th>#</th>
									      <th>姓名</th>
									      <th>性别</th>
									      <th>职位</th>
									      <th>是否现任委员会人员</th>
									      <th>任职日期</th>
									      <th>个人主页链接</th>
									      <th style="width: 3.5em;"></th>
									    </tr>
									  </thead>
									  <tbody>
									  <c:forEach varStatus="status" var="acainfo" items="${acainfos}">
									    <tr>
									      <td>${status.index + 1}</td>
									      <td><a>${acainfo.acaname}</a></td>
									      <td>${acainfo.acasex}</td>
									      <td>${acainfo.position}</td>
									      <c:choose>
									      <c:when test="${acainfo.acatype == 1}">
										      <td>是</td>
									      </c:when>
									      <c:when test="${acainfo.acatype == 0}">
									      	<td>否</td>
									      </c:when>
									      </c:choose>
									      <td>${acainfo.officedate}</td>
									      <td><a>${acainfo.intrurl}</a></td>
									       <td>
									          <a href=""><i class="fa fa-pencil"></i></a>
									          <a href="" role="button" data-toggle="modal"><i class="fa fa-trash-o"></i></a>
									      </td>
									    </tr>
									  </c:forEach>
									  </tbody>
								</table>
    						</div>
                    	</div>
        			</div>
    		</div>
    	<!-- 第四个panel end-->
        </div>
    </div>
 	<script src="/scienceBase/admin/lib/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="/scienceBase/admin/lib/bootstrap/js/bootstrap.js"></script>
</body>
</html>
