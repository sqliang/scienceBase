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
				<div class="news-list">
                    <!-- <div class="leader-title">
                    	<span style="">现任学术委员会</span>
                    </div> -->
                    <div class="leader-list">
                    	<!-- <h2 class="label-title">主任：</h2> -->
						<table class="table table-bordered">
							<thead>
								<tr>
									<th style="font-weight:bold;text-align:center;">#</th>
									<th style="font-weight:bold;text-align:center;">姓名</th>
									<th style="font-weight:bold;text-align:center;">专业</th>
								    <th style="font-weight:bold;text-align:center;">导师</th>
								    <th style="font-weight:bold;text-align:center;">研究方向</th>
								    <th style="font-weight:bold;text-align:center;">毕业论文题目</th>
								</tr>
							</thead>
							<tbody>
                    	<c:forEach var="studentinfo" varStatus="status" items="${studentinfos}">
							 <tr>
							 	<td style="text-align:center;">${status.index + 1}</td>
								<td style="text-align:center;">${studentinfo.stuname}</td>
								<td style="text-align:center;">${studentinfo.stumaster}</td>
								<td style="text-align:center;">${studentinfo.stuteacher}</td>
								<td style="text-align:center;">${studentinfo.sturesdirection}</td>
								<td style="text-align:center;">${studentinfo.papertitle}</td>
							 </tr>
                    	</c:forEach>
							</tbody>
						</table>
                    </div>
          		</div>
          		<!-- 分页 -->
          			<div class="page-fenye">
          				<c:choose>
	          				<c:when test="${pageNow > 1}">
							<a href="queryStudentsByDegree?pageNow=${pageNow - 1}&subMenuName=${subMenuName}&stuDegree=${stuDegree}" class="page-prev">上一页</a>
	          				</c:when>
          				</c:choose>
						<c:forEach var="index" begin="1" end="${totalPages}" step="1">
							<c:choose>
								<c:when test="${pageNow == index}">
									<span class="page-cur">${pageNow}</span>
								</c:when>
								<c:otherwise>
									<a href="queryStudentsByDegree?pageNow=${index}&subMenuName=${subMenuName}&stuDegree=${stuDegree}" pageno="${index}">${index}</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<!-- <a href="#" pageno="1">3</a>
						<a href="#" pageno="1">4</a> -->
						<c:choose>
							<c:when test="${pageNow < totalPages}">
								<a href="queryStudentsByDegree?pageNow=${pageNow + 1}&subMenuName=${subMenuName}&stuDegree=${stuDegree}" pageno="${pageNow + 1}" class="page-next">下一页</a> 
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