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
        			<a href="#project" class="panel-heading" data-toggle="collapse">
        				科研项目信息发布
        			</a>
        			<div id="project" class="panel-collapse panel-body collapse in">
                    	<div class="row">
                    		<div class="col-md-12">
                    			<form action="">
                    				<div class="form-group">
    									<label for="project-code">项目编号：</label>
    									<input type="text" class="form-control" id="project-code" placeholder="输入项目编号">
  									</div>
                    				<div class="form-group">
    									<label for="proj-name">项目名称：</label>
    									<input type="text" class="form-control" id="proj-name" placeholder="输入项目名称">
  									</div>
  									<div class="form-group">
    									<label for="proj-type">项目类型：</label>
    									<input type="text" class="form-control" id="proj-type" placeholder="输入项目名称">
  									</div>
  									<div class="form-group">
    									<label for="projAgreeOrg">批准部门：</label>
    									<input type="text" class="form-control" id="projAgreeOrg" placeholder="输入批准部门">
  									</div>
  									<div class="form-group">
    									<label for="projMasterPerson">项目负责人：</label>
    									<input type="text" class="form-control" id="projMasterPerson" placeholder="输入项目负责人">
  									</div>
  									<div class="form-group">
    									<label for="projStartTime">项目开始时间：</label>
    									<input type="date" class="form-control" id="projStartTime">
  									</div>
  									<div class="form-group">
    									<label for="projEndTime">项目结束时间：</label>
    									<input type="date" class="form-control" id="projEndTime">
  									</div>
  									<div class="form-group">
    									<label for="projFee">项目经费：</label>
    									<input type="text" class="form-control" id="projFee" placeholder="输入项目经费">
  									</div>
  									<div class="form-group">
    									<label for="projContent">项目简介：</label>
    									<textarea style="height:100px;resize:none;" class="form-control" id="projContents" placeholder="输入简介内容"></textarea>
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
        			<a href="#paper" class="panel-heading" data-toggle="collapse">
        				学术论文信息发布
        			</a>
        			<div id="paper" class="panel-collapse panel-body collapse in">
                    	<div class="row">
                    		<div class="col-md-12">
                    			<form action="">
                    				<div class="form-group">
    									<label for="paperName">论文题目：</label>
    									<input type="text" class="form-control" id="paperName" placeholder="输入论文名称">
  									</div>
  									<div class="form-group">
    									<label for="paperAuthor">作者：</label>
    									<input type="text" class="form-control" id="paperAuthor" placeholder="输入作者名字">
  									</div>
  									<div class="form-group">
    									<label for="paperJournal">发表期刊名称：</label>
    									<input type="text" class="form-control" id="paperJournal" placeholder="输入批准部门">
  									</div>
  									<div class="form-group">
    									<label for="JournalInfo">期刊信息：</label>
    									<input type="text" class="form-control" id="JournalInfo" placeholder="输入期刊信息，如：年／卷／期">
  									</div>
  									<div class="form-group">
    									<label for="paperInclude">收录情况：</label>
    									<textarea style="height:100px;resize:none;" class="form-control" id="paperInclude" placeholder="输入收录情况信息"></textarea>
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
    		<div class="panel panel-default">
        			<a href="#bookInfo" class="panel-heading" data-toggle="collapse">
        				学术专著信息发布
        			</a>
        			<div id="bookInfo" class="panel-collapse panel-body collapse in">
                    	<div class="row">
                    		<div class="col-md-12">
                    			<form action="">
                    				<div class="form-group">
    									<label for="bookName">专著名称：</label>
    									<input type="text" class="form-control" id=""bookName"" placeholder="输入专著名称">
  									</div>
  									<div class="form-group">
    									<label for="bookAuthor">作者：</label>
    									<input type="text" class="form-control" id="paperAuthor" placeholder="输入作者名字">
  									</div>
  									<div class="form-group">
    									<label for="bookIntr">专著简介：</label>
    									<textarea style="height:100px;resize:none;" class="form-control" id="bookIntr" placeholder="输入专著简介信息"></textarea>
  									</div>
  									<div class="form-group">
                						<button type="submit" class="btn btn-primary pull-right js-btnsub">发布</button>
            						</div>
                    			</form>
                    		</div>
                    	</div>
        			</div>
    		</div>
    	<!-- 第三个panel end-->
    	<!-- 第四个panel -->
    		<div class="panel panel-default">
        			<a href="#paptent" class="panel-heading" data-toggle="collapse">
        				发明专利信息发布
        			</a>
        			<div id="paptent" class="panel-collapse panel-body collapse in">
                    	<div class="row">
                    		<div class="col-md-12">
                    			<form action="">
                    				<div class="form-group">
    									<label for="paptentName">*专利名称：</label>
    									<input type="text" class="form-control" id="paptentName" placeholder="输入专利名称">
  									</div>
  									<div class="form-group">
    									<label for="paptentType">*专利类型：</label>
    									<input type="text" class="form-control" id="paptentType" placeholder="输入专利类型">
  									</div>
  									<div class="form-group">
    									<label for="paptentAuthors">*专利发明人：</label>
    									<input type="text" class="form-control" id="paptentAuthors" placeholder="输入专利发明人">
  									</div>
  									<div class="form-group">
    									<label for="agreeTime">*批准时间：</label>
    									<input type="date" class="form-control" id="agreeTime">
  									</div>
  									<div class="form-group">
    									<label for="paptentStatus">*专利审核状态：</label>
    									<select class="form-control" id="paptentStatus" style="display: inline-block;width: 140px; background: transparent;">
											<option value="授权">授权</option>
										    <option value="实审">实审</option>
										</select>
  									</div>
  									<div class="form-group">
    									<label for="paptentIntr">专利简介：</label>
    									<textarea style="height:100px;resize:none;" class="form-control" id="paptentIntr" placeholder="输入简介信息"></textarea>
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
    	<!-- 第五个panel -->
    	<div class="panel panel-default">
        			<a href="#grade-box" class="panel-heading" data-toggle="collapse">
        				科研获奖信息发布
        			</a>
        			<div id="grade-box" class="panel-collapse panel-body collapse in">
                    	<div class="row">
                    		<div class="col-md-12">
                    			<form action="">
                    				<div class="form-group">
    									<label for="gradeName">*奖励名称：</label>
    									<input type="text" class="form-control" id="gradeTitle" placeholder="输入成果标题">
  									</div>
  									<div class="form-group">
  										<label for="gradeType">*奖励类型：</label>
  										<input type="text" class="form-control" id="gradeType" placeholder="输入奖励类型">
            						</div>
            						<div class="form-group">
  										<label for="gradeDengJi">*奖励等级：</label>
  										<input type="text" class="form-control" id="gradeDengJi" placeholder="输入奖励等级">
            						</div>
            						<div class="form-group">
  										<label for="gradeFinish">*完成人：</label>
  										<input type="text" class="form-control" id="gradeFinish" placeholder="输入完成人">
            						</div>
  									<div class="form-group">
    									<label for="gradeIntr">科研奖励简介：</label>
    									<textarea style="height:100px;resize:none;" class="form-control" id="gradeIntr" placeholder="输入成果简介内容"></textarea>
  									</div>
  									<div class="form-group">
                						<button type="submit" class="btn btn-primary pull-right js-btnsub">发布</button>
            						</div>
                    			</form>
                    		</div>
                    	</div>
        			</div>
    		</div>
    		<!-- 第五个panel end -->
    		<!-- the sixth panel -->
    		<div class="panel panel-default">
        			<a href="#presentAchive" class="panel-heading" data-toggle="collapse">
        				代表性成果信息发布
        			</a>
        			<div id="presentAchive" class="panel-collapse panel-body collapse in">
                    	<div class="row">
                    		<div class="col-md-12">
                    			<form action="">
                    				<div class="form-group">
    									<label for="presentAchiveTitle">*成果名称：</label>
    									<input type="text" class="form-control" id="presentAchiveTitle" placeholder="输入成果标题">
  									</div>
  									<div class="form-group">
  										<label for="presentAchiveType">*成果类型：</label>
  										<input type="text" class="form-control" id="presentAchiveType" placeholder="输入成果类型">
            						</div>
  									<div class="form-group">
    									<label for="presentAchiveContent">成果简介：</label>
    									<textarea style="height:100px;resize:none;" class="form-control" id="presentAchiveContent" placeholder="输入成果简介内容"></textarea>
  									</div>
  									<div class="form-group">
                						<button type="submit" class="btn btn-primary pull-right js-btnsub">发布</button>
            						</div>
                    			</form>
                    		</div>
                    	</div>
        			</div>
    		</div>
    		<!--the sixth panel end -->
        </div>
    </div>
 	<script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="lib/bootstrap/js/bootstrap.js"></script>
</body>
</html>
