<%@page import="com.science.util.bean.BeanUtil"%>
<%@page import="com.science.domain.Mainmenu"%>
<%@page import="com.science.serviceManager.MainmenuManager"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	MainmenuManager mainmenuManager = (MainmenuManager) BeanUtil.load("mainmenuManagerImpl");
	List<Mainmenu> mainmenus = mainmenuManager.queryMainmenuContainSub();
	request.setAttribute("mainmenus", mainmenus);
%>
</style>
<div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand hidden-sm active" href="#">科研基地网站</a>
        </div>
        <div class="navbar-collapse collapse" role="navigation">
          <ul class="nav navbar-nav">
          	
          	<li><a href="homePage" class="active">首页</a></li>
          	
          	<c:forEach var="mainmenu" items="${mainmenus}">
          		 <li class="dropdown hidden-sm hidden-md">
              <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">${mainmenu.mainmenuname}<b class="caret"></b></a>
              <ul class="dropdown-menu">
              	<c:forEach var="submenu" items="${mainmenu.submenumainmenuids}">
              		<li>
                  		<a href="${submenu.submenulink}">${submenu.submenuname}</a>
               		</li>
              	</c:forEach>
              </ul>
            </li>
          	</c:forEach>
          </ul>
          <ul class="nav navbar-nav navbar-right hidden-sm">
            <!-- <li><a href="/about/" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'about'])">关于</a></li> -->
          </ul>
        </div>
      </div>
    </div>