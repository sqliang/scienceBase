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
    <title>${subMenuName}</title>
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
	<!-- maincontent -->
	<div class="main-content clearfix">
		<!-- main right 放置文章 -->
		<div class="content-article">
			<div class="article-title">
          		<h3>${subMenuName}列表</h3>
       		</div>
			<div class="content-con">
				<div style="height:20px;"></div>
				<table class="table table-bordered">
							<thead>
								<tr>
									<th style="font-weight:bold;text-align:center;">#</th>
									<th style="font-weight:bold;text-align:center;">论文题目</th>
									<th style="font-weight:bold;text-align:center;">论文作者</th>
								    <th style="font-weight:bold;text-align:center;">期刊名称</th>
								    <th style="font-weight:bold;text-align:center;">期刊信息</th>
								    <th style="font-weight:bold;text-align:center;">论文收录情况</th>
								</tr>
							</thead>
							<tbody>
                    	<c:forEach varStatus="status" var="paperinfo" items="${paperinfos}">
							 <tr>
							 	<td style="text-align:center;">${status.index + 1}</td>
							 	<td style="text-align:center;">${paperinfo.papername}</td>
								<td style="text-align:center;">${paperinfo.paperauthor}</td>
								<td style="text-align:center;">${paperinfo.paperjounal}</td>
								<td style="text-align:center;">${paperinfo.journalinfo}</td>
								<td style="text-align:center;">${paperinfo.paperinclude}</td>
							 </tr>
                    	</c:forEach>
							</tbody>
				</table>
                 <!-- 分页 -->
          			<div class="page-fenye">
          				<c:choose>
	          				<c:when test="${pageNow > 1}">
							<a href="queryPaperinfos?pageNow=${pageNow - 1}&subMenuName=${subMenuName}" class="page-prev">上一页</a>
	          				</c:when>
          				</c:choose>
						<c:forEach var="index" begin="1" end="${totalPages}" step="1">
							<c:choose>
								<c:when test="${pageNow == index}">
									<span class="page-cur">${pageNow}</span>
								</c:when>
								<c:otherwise>
									<a href="queryPaperinfos?pageNow=${index}&subMenuName=${subMenuName}" pageno="${index}">${index}</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<!-- <a href="#" pageno="1">3</a>
						<a href="#" pageno="1">4</a> -->
						<c:choose>
							<c:when test="${pageNow < totalPages}">
								<a href="queryPaperinfos?pageNow=${pageNow + 1}&subMenuName=${subMenuName}" pageno="${pageNow + 1}" class="page-next">下一页</a> 
							</c:when>
						</c:choose>
						<span class="page-op">共${totalPages}页</span>
					</div>
					<!-- end -->				   
			</div>
		</div><!-- main right end -->
			<!-- main left nav -->
			<jsp:include page="left_nav.jsp">
				<jsp:param value="${mainMenuId}" name="mainMenuId"/>
			</jsp:include>
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