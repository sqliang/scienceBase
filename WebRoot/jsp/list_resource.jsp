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
    <title>科研资源</title>
    <link rel="stylesheet" href="/scienceBase/css/common/bootstrap.min.css" />
    <link rel="stylesheet" href="/scienceBase/css/common/reset.min.css" />
    <link rel="stylesheet" href="/scienceBase/css/common/header.css" />
    <link rel="stylesheet" href="/scienceBase/css/common/banner.css" />
    <link rel="stylesheet" href="/scienceBase/css/common/footer.css" />
    <link rel="stylesheet" href="/scienceBase/css/common/list_and_detail.css" />
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
	<jsp:include page="banner.jsp"></jsp:include>
	<!-- banner end -->
	<div class="main-info-line"></div>
	<!-- maincontent -->
	<div class="main-content clearfix">
		<!-- main right 放置文章 -->
		<div class="content-article">
			<div class="article-title">
          		<h3>${target}列表</h3>
       		</div>
			<div class="content-con">
				<ul class="clearfix">
					<c:forEach var="resourceinfo" items="${resourceinfos}">
						<li class="class-list resource-list">
			                 <div class="leader-list">
			                 	<span class="label-title">资源名称：</span>
			                     <span>${resourceinfo.resourcetitle}</span>
			                  </div>
			                 <div class="leader-list">
			                 	<span class="label-title">共享办法：</span>
			                    <span>${resourceinfo.sharemethod}</span>
			                  </div>
			                  <div class="leader-list">
			                   	<span class="label-title">使用规范：</span>
			                    <span>${resourceinfo.useintroduce}</span>
			                  </div>
			                  <div class="leader-list">
			                    <span class="label-title">使用统计：</span>
			                    <span>${resourceinfo.usedinfo}</span>
			                  </div>
		          		</li>				
                    </c:forEach>
				</ul>
                    
			</div>
		</div><!-- main right end -->
			<!-- main left nav -->
			<jsp:include page="left_nav.jsp"></jsp:include>
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