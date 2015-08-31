<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head lang="zh-CN">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <title>首页</title>
    <link rel="stylesheet" href="../css/common/bootstrap.min.css" />
    <link rel="stylesheet" href="../css/common/reset.min.css" />
    <link rel="stylesheet" href="../css/common/header.css" />
    <link rel="stylesheet" href="../css/common/banner.css" />
    <link rel="stylesheet" href="../css/common/footer.css" />
    <link rel="stylesheet" href="../css/common/list_and_detail.css" />
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
	<div class="banner clearfix">
		<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <!-- <li data-target="#carousel-example-generic" data-slide-to="2"></li> -->
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="../img/demo3.jpg" alt="...">
      <div class="carousel-caption">
        <h1>tilte 1</h1>
      </div>
    </div>
    <div class="item">
      <img src="../img/demo4.jpg" alt="...">
      <div class="carousel-caption">
        <h1>tilte 4</h1>
      </div>
    </div>
  </div>

  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
  <!-- Controls end -->
</div>
	</div>
	<!-- banner end -->
	<div class="main-info-line"></div>
	<!-- maincontent -->
	<div class="main-content clearfix">
		<!-- main right 放置文章 -->
		<div class="content-article">
			<div class="article-title">
          		<h3>标题题目就在这里</h3>
       		</div>
			<div class="content-con">
	           <p><strong>一、会议背景</strong></p>
				<p>继北京大学、南京大学、中南大学、中国科学院研究生院、大连理工大学、西南财经大学、天津大学、上海交通大学、中山大学成功举办中国管理学年会后，第十届（2015）中国管理学年会将于2015年11月6-8日在合肥举行。中国管理学年会是中国管理学领域规模最大、层次最高的综合性学术会议，旨在加强中国管理学界的合作与交流，推动中国管理科学研究的发展，提升中国管理实践的水平。从第七届年会开始，中国管理学年会与复旦管理学奖励基金会联合举办年会。</p>
				<p>本届年会将以“互联时代的产业变革和管理创新”为主题。随着云计算、互联网、大数据等新兴信息技术与各行各业的深度融合，对国家的产业政策、行业的管理规范、企业的运营管理产生了深刻的影响，加快产业变革和管理创新正面临着前所未有的机遇和挑战。本届论坛诚邀学术界、产业界及社会各界的专家学者参加，围绕互联时代的产业变革和管理创新等相关管理问题开展跨学科、跨行业、跨地区的学术研讨，为加快我国产业变革和管理创新做出新的贡献。本届年会也是换届年会，欢迎广大学者踊跃参会。</p>
				<p>本届年会将举办“校长论坛”、“院长论坛”、“女管理学家论坛”、“期刊论坛”、“企业家论坛”以及“高层次人才招聘会”等，旨在加强管理理论和实务界的沟通和了解，加强国内各大高校商学院（管理学院）之间的合作与了解，建设高水平学术交流和高层次人才交流的平台，共同探讨互联时代的产业变革和管理创新问题。</p>
				<p><strong>二、会议主题</strong></p>
				<p>互联时代的产业变革和管理创新</p>
				<p><strong>三、会议议题</strong></p>
				<div style="margin-left:40px;">
					<span style="font-size:16px;">
					      1、组织与战略<br>
					      2、会计与财务<br>
					      3、金融管理<br>
					      4、组织行为与人力资源管理<br>
					      5、运作管理<br>
					      6、市场营销<br>
					      7、管理与决策科学<br>
					      8、信息管理<br>
					      9、公共管理<br>
					      10、创业与中小企业管理<br>
					      11、技术与创新管理<br>
					      12、城市与区域管理<br>
					      13、平行管理<br>
					      14、商务智能<br>
					      15、公司治理<br>
					      16、管理案例研究<br>
					      17、决策模拟<br>
					      18、国际商务谈判<br>
					      19、廉政建设与治理研究<br>
					      20、中国经济与社会安全研究<br>
					      21、风险投资<br>
					      22、政府战略与公共政策研究  
					   </span>
				   </div>
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
<script src="../js/lib/jquery.min.js"></script>
<script src="../js/lib/bootstrap.min.js"></script>

</body>
</html>