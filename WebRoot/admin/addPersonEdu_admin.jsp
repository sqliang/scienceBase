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
        			<a href="#stu-box" class="panel-heading" data-toggle="collapse">
        				实验室学生信息发布
        			</a>
        			<div id="stu-box" class="panel-collapse panel-body collapse in">
                    	<div class="row">
                    		<div class="col-md-12">
                    			<form action="addStudentInfo" method="POST">
                    				<div class="form-group">
    									<label for="stu-name">*姓名：</label>
    									<input type="text" name="studentinfo.stuname" class="form-control" id="stu-name" placeholder="输入姓名">
  									</div>
  									<div class="form-group">
  										<label for="stuSex1">*性别：</label>
  										<label class="radio-inline">
  											<input type="radio" checked="ckecked" name="studentinfo.stusex" id="stuSex1" value="1"> 男
										</label>
										<label class="radio-inline">
										  	<input type="radio" name="studentinfo.stusex" id="stuSex2" value="0"> 女
										</label>
  									</div>
  									<!-- <div class="form-group">
    									<label for="mem-age">年龄：</label>
    									<input type="text" class="form-control" id="mem-age" placeholder="输入年龄">
  									</div> -->
  									<div class="form-group">
    									<label for="stu-degree">*学位：</label>
    									<select class="form-control" name="studentinfo.studegree" id="stu-degree" style="display: inline-block;width: 140px; background: transparent;">
										    <option value="博士">博士</option>
										    <option value="硕士">硕士</option>
										</select>
  									</div>
  									<div class="form-group">
    									<label for="stuTeacher">*学生导师：</label>
    									<input type="text" class="form-control" name="studentinfo.stuteacher" id="stuTeacher" placeholder="输入学生导师">
  									</div>
  									<div class="form-group">
    									<label for="stuZhuanYe">*学生专业：</label>
    									<input type="text" class="form-control" name="studentinfo.stumaster" id="stuZhuanYe" placeholder="输入学生专业">
  									</div>
  									<div class="form-group">
    									<label for="resDirection">*研究方向：</label>
    									<input type="text" class="form-control" name="studentinfo.sturesdirection" id="resDirection" placeholder="输入学生研究方向">
  									</div>
  									<div class="form-group">
    									<label for="paperTitle">学生毕业论文题目：</label>
    									<input type="text" class="form-control" name="studentinfo.papertitle" id="paperTitle" placeholder="输入学生毕业论文题目">
  									</div>
  									<div class="form-group">
    									<label for="resInfoConet">学生参与科研情况：</label>
    									<textarea name="studentinfo.resinfocontent" style="height:100px;resize:none;" class="form-control" id="resInfoConet" placeholder="输入简介内容"></textarea>
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
        			<a href="#class-box" class="panel-heading" data-toggle="collapse">
        				主讲课程信息发布
        			</a>
        			<div id="class-box" class="panel-collapse panel-body collapse in">
                    	<div class="row">
                    		<div class="col-md-12">
                    			<form action="addClassInfo" method="POST">
                    				<div class="form-group">
    									<label for="className">*课程名称：</label>
    									<input type="text" name="classinfo.classname" class="form-control" id="className" placeholder="输入课程名称">
  									</div>
  									<div class="form-group">
    									<label for="classTeacher">*主讲老师：</label>
    									<input type="text" name="classinfo.classteacher" class="form-control" id="classTeacher" placeholder="输入主讲老师">
  									</div>
  									<div class="form-group">
    									<label for="classType">*课程性质：</label>
    									<input type="text" name="classinfo.classtype" class="form-control" id="classType" placeholder="输入课程性质">
  									</div>
  									<div class="form-group">
    									<label for="toObject">*授课对象：</label>
    									<select class="form-control" name="classinfo.toobject" id="toObject" style="display: inline-block;width: 140px; background: transparent;">
										    <option value="博士">博士</option>
										    <option value="硕士">硕士</option>
										    <option value="学士">学士</option>
										</select>
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
        			<a href="#classGrade-box" class="panel-heading" data-toggle="collapse">
        				教学成果信息发布
        			</a>
        			<div id="classGrade-box" class="panel-collapse panel-body collapse in">
                    	<div class="row">
                    		<div class="col-md-12">
                    			<form action="addClassGradeInfo" method="POST">
                    				<div class="form-group">
    									<label for="gradeTitle">*标题：</label>
    									<input type="text" name="classgradeinfo.gradetitle" class="form-control" id="gradeTitle" placeholder="输入成果标题">
  									</div>
  									<div class="form-group">
  										<label for="time">教学成果获取时间：</label>
  										<input type="date" name="classgradeinfo.time" class="form-control" id="time">
            						</div>
  									<div class="form-group">
    									<label for="gradeContent">教学成果简介：</label>
    									<textarea name="classgradeinfo.gradecontent" style="height:100px;resize:none;" class="form-control" id="gradeContent" placeholder="输入成果简介内容"></textarea>
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
        </div>
    </div>
 	<script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
    $(".nav-header").addClass("collapsed");
    $(".sidebar-nav ul li ul.nav-list").removeClass("in");
    $(".nav-header").eq(4).removeClass("collapsed");
    $(".sidebar-nav ul li ul.nav-list").eq(4).addClass("in");
    </script>
</body>
</html>
