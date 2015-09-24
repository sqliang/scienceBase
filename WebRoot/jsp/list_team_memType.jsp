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
                    <div class="leader-title">
                    	<span style="">${bodao}/教授</span>
                    </div>
                    <div class="leader-list">
                    	<c:forEach var="boDaoMem" items="${boDaoMems}">
								<span>
									<c:choose>
										<c:when test="${boDaoMem.memlink == '' || boDaoMem.memlink == null}">
											<a href="javascript:;">
										</c:when>
										<c:otherwise>
											<a href="${boDaoMem.memlink}"  target="_blank">
										</c:otherwise>
									</c:choose>
										<font>
											${boDaoMem.memname}
										</font>
									</a>
								</span>
                    	</c:forEach>
                    </div>
                    </div>
                    <div class="news-list">
                    <div class="leader-title">
                    	<span style="">硕导/${profess}</span>
                    </div>
                    <div class="leader-list">
                    	<c:forEach var="profession" items="${professions}">
								<span>
									<c:choose>
										<c:when test="${profession.memlink == '' || profession.memlink == null}">
											<a href="javascript:;">
										</c:when>
										<c:otherwise>
											<a href="${profession.memlink}"  target="_blank">
										</c:otherwise>
									</c:choose>										<font>
											${profession.memname}
										</font>
									</a>
								</span>
                    	</c:forEach>
                    </div>
          		</div>		
          		
          		<div class="news-list">
                    <div class="leader-title">
                    	<span style="">${fuProfess}</span>
                    </div>
                    <div class="leader-list">
                    	<c:forEach var="fuProfession" items="${fuProfessions}">
								<span>
									<c:choose>
										<c:when test="${fuProfession.memlink == '' || fuProfession.memlink == null}">
											<a href="javascript:;">
										</c:when>
										<c:otherwise>
											<a href="${fuProfession.memlink}"  target="_blank">
										</c:otherwise>
									</c:choose>		
										<font>
											${fuProfession.memname}
										</font>
									</a>
								</span>
                    	</c:forEach>
                    </div>
          		</div>		
          		
          		<div class="news-list">
                    <div class="leader-title">
                    	<span style="">${jiangshi}</span>
                    </div>
                    <div class="leader-list">
                    	<c:forEach var="jiangShi" items="${jiangShis}">
								<span>
									<c:choose>
										<c:when test="${jiangShi.memlink == '' || jiangShi.memlink == null}">
											<a href="javascript:;">
										</c:when>
										<c:otherwise>
											<a href="${jiangShi.memlink}"  target="_blank">
										</c:otherwise>
									</c:choose>		
										<font>
											${jiangShi.memname}
										</font>
									</a>
								</span>
                    	</c:forEach>
                    </div>
          		</div>				
          		
          		<div class="news-list">
                    <div class="leader-title">
                    	<span style="">${others}</span>
                    </div>
                    <div class="leader-list">
                    	<c:forEach var="otheritem" items="${othersMem}">
								<span>
									<c:choose>
										<c:when test="${otheritem.memlink == '' || otheritem.memlink == null}">
											<a href="javascript:;">
										</c:when>
										<c:otherwise>
											<a href="${otheritem.memlink}"  target="_blank">
										</c:otherwise>
									</c:choose>	
										<font>
											${otheritem.memname}
										</font>
									</a>
								</span>
                    	</c:forEach>
                    </div>
          		</div>					
                    
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