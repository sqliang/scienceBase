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

            <h1 class="page-title">科学研究管理-信息查看</h1>
            <!-- <ul class="breadcrumb">
            	<li><a href="">Home</a> </li>
            	<li class="active">首页管理</li>
        	</ul> -->
        </div>
        <!-- 右侧内容header end -->
        <div class="main-content">
		<!-- 第一个panel -->
    		<div class="panel panel-default">
        			<a href="#proj-box" class="panel-heading" data-toggle="collapse">
        				科研项目查看
        			</a>
        			<div id="proj-box" class="panel-collapse panel-body collapse in">
                    	<div class="row">
	                        <div class="col-md-12">
						        <table class="table">
									  <thead>
									    <tr>
									      <th>项目编号</th>
									      <th>项目名称</th>
									      <th>项目类型</th>
									      <th>批准部门</th>
									      <th>项目负责人</th>
									      <th>项目开始时间</th>
									      <th>项目结束时间</th>
									      <th>项目经费</th>
									      <th style="width: 3.5em;"></th>
									    </tr>
									  </thead>
									  <tbody>
									   <c:forEach var="projectinfo" items="${projectinfos}">
									    <tr>
									      <td>${projectinfo.projcode}</td>
									      <td>${projectinfo.projname}</td>
									      <td>${projectinfo.projtype}</td>
									      <td>${projectinfo.projagreeorg}</td>
									      <td>${projectinfo.projmasterperson}</td>
									      <td>${projectinfo.projstarttime}</td>
									      <td>${projectinfo.projendtime}</td>
									      <td>${projectinfo.projfee}</td>
									       <td>
									          <a href="delProjectInfoById?projId=${projectinfo.projid}" role="button" data-toggle="modal"><i class="fa fa-trash-o"></i></a>
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
        			<a href="#paper-box" class="panel-heading" data-toggle="collapse">
        				学术论文信息查看
        			</a>
        			<div id="paper-box" class="panel-collapse panel-body collapse in">
                    	<div class="row">
	                        <div class="col-md-12">
						        <table class="table">
									  <thead>
									    <tr>
									      <th>论文题目</th>
									      <th>作者</th>
									      <th>发表期刊</th>
									      <th>期刊详情信息</th>
									      <th style="width: 3.5em;"></th>
									    </tr>
									  </thead>
									  <tbody>
									  <c:forEach var="paperinfo" items="${paperinfos}">
									    <tr>
									      <td>${paperinfo.papername}</td>
									      <td>${paperinfo.paperauthor}</td>
									      <td>${paperinfo.paperjounal}</td>
									      <td>${paperinfo.journalinfo}</td>
									       <td>
									          <a href="delPaperInfoById?paperId=${paperinfo.paperid}" role="button" data-toggle="modal"><i class="fa fa-trash-o"></i></a>
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
        			<a href="#bookInfo-box" class="panel-heading" data-toggle="collapse">
        				学术专著信息查看
        			</a>
        			<div id="bookInfo-box" class="panel-collapse panel-body collapse in">
                    	<div class="row">
	                        <div class="col-md-12">
						        <table class="table">
									  <thead>
									    <tr>
									      <th>专著名称</th>
									      <th>作者</th>
									      <th style="width: 3.5em;"></th>
									    </tr>
									  </thead>
									  <tbody>
									  	<c:forEach var="bookinfo" items="${bookinfos}">
										    <tr>
										      <td>${bookinfo.bookname}</td>
										      <td>${bookinfo.bookauthor}</td>
										       <td>
										          <a href="delBookInfoById?bookId=${bookinfo.bookid}" role="button" data-toggle="modal"><i class="fa fa-trash-o"></i></a>
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
        			<a href="#paptent-box" class="panel-heading" data-toggle="collapse">
        				发明专利信息查看
        			</a>
        			<div id="paptent-box" class="panel-collapse panel-body collapse in">
                    	<div class="row">
	                        <div class="col-md-12">
						        <table class="table">
									  <thead>
									    <tr>
									      <th>专利名称</th>
									      <th>专利类型</th>
									      <th>专利发明人</th>
									      <th>批准时间</th>
									      <th>专利审核状态</th>
									      <th style="width: 3.5em;"></th>
									    </tr>
									  </thead>
									  <tbody>
									  <c:forEach var="paptentinfo" items="${paptentinfos}">
										    <tr>
										      <td>${paptentinfo.paptentname}</td>
										      <td>${paptentinfo.paptenttype}</td>
										      <td>${paptentinfo.paptentauthors}</td>
										      <td>${paptentinfo.agreetime}</td>
										      <td>${paptentinfo.paptentstatus}</td>
										       <td>
										          <a href="delPaptentInfoById?paptentId=${paptentinfo.paptentid}" role="button" data-toggle="modal"><i class="fa fa-trash-o"></i></a>
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
    	<!-- 第五个panel -->
    		<div class="panel panel-default">
        			<a href="#scienGrade-box" class="panel-heading" data-toggle="collapse">
        				科研奖励信息查看
        			</a>
        			<div id="scienGrade-box" class="panel-collapse panel-body collapse in">
                    	<div class="row">
	                        <div class="col-md-12">
						        <table class="table">
									  <thead>
									    <tr>
									      <th>奖励名称</th>
									      <th>奖励类型</th>
									      <th>奖励等级</th>
									      <th>完成人</th>
									      <th style="width: 3.5em;"></th>
									    </tr>
									  </thead>
									  <tbody>
									  <c:forEach var="labgradeinfo" items="${labgradeinfos}">
									    <tr>
									      <td>${labgradeinfo.gradename}</td>
									      <td>${labgradeinfo.gradetype}</td>
									      <td>${labgradeinfo.gradedengji}</td>
									      <td>${labgradeinfo.gradefinish}</td>
									       <td>
									          <a href="delLabGradeInfoById?labGradeId=${labgradeinfo.labgradeid}" role="button" data-toggle="modal"><i class="fa fa-trash-o"></i></a>
									      </td>
									    </tr>
									  </c:forEach>
									  </tbody>
								</table>
    						</div>
                    	</div>
        			</div>
    		</div>
    	<!-- 第五个panel end-->
    	<!-- 第五个panel -->
    		<div class="panel panel-default">
        			<a href="#presGrade-box" class="panel-heading" data-toggle="collapse">
        				代表性成果信息查看
        			</a>
        			<div id="presGrade-box" class="panel-collapse panel-body collapse in">
                    	<div class="row">
	                        <div class="col-md-12">
						        <table class="table">
									  <thead>
									    <tr>
									      <th>成果名称</th>
									      <th>成果类型</th>
									      <th style="width: 3.5em;"></th>
									    </tr>
									  </thead>
									  <tbody>
									  <c:forEach var="presentachiveinfo" items="${presentachiveinfos}">
									    <tr>
									      <td>${presentachiveinfo.presentachivetitle}</td>
									      <td>${presentachiveinfo.presentachivetype}</td>
									       <td>
									          <a href="delPresentGradeInfoById?presentAchiveId=${presentachiveinfo.presentachiveid}" role="button" data-toggle="modal"><i class="fa fa-trash-o"></i></a>
									      </td>
									    </tr>
									  </c:forEach>
									  </tbody>
								</table>
    						</div>
                    	</div>
        			</div>
    		</div>
    	<!-- 第五个panel end-->
        </div>
    </div>
 	<script src="/scienceBase/admin/lib/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="/scienceBase/admin/lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
    $(".nav-header").addClass("collapsed");
    $(".sidebar-nav ul li ul.nav-list").removeClass("in");
    $(".nav-header").eq(5).removeClass("collapsed");
    $(".sidebar-nav ul li ul.nav-list").eq(5).addClass("in");
    </script>
</body>
</html>
