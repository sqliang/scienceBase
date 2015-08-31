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
            <!-- <li class="dropdown hidden-sm hidden-md">
              <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">实验室概况<b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li>
                  <a href="">实验室简介</a>
                </li>
                <li>
                  <a href="" >研究方向</a>
                </li>
               	<li>
                  <a href="" >机构设置</a>
                </li>
                <li>
                  <a href="" >主任、副主任</a>
                </li>
                <li>
                  <a href="" >学术委员会</a>
                </li>
              </ul>
            </li>
            
            <li class="dropdown hidden-sm hidden-md">
              <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">研究队伍<b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li>
                  <a href="">实验室简介</a>
                </li>
                <li>
                  <a href="" >研究方向</a>
                </li>
               	<li>
                  <a href="" >机构设置</a>
                </li>
                <li>
                  <a href="" >主任、副主任</a>
                </li>
                <li>
                  <a href="" >学术委员会</a>
                </li>
              </ul>
            </li>
            <li class="dropdown hidden-sm hidden-md">
              <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">研究队伍<b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li>
                  <a href="">队伍概况</a>
                </li>
                <li>
                  <a href="" >两院院士</a>
                </li>
               	<li>
                  <a href="" >人才计划</a>
                </li>
                <li>
                  <a href="" >学术骨干</a>
                </li>
                <li>
                  <a href="" >固定队伍</a>
                </li>
                <li>
                  <a href="" >流动队伍</a>
                </li>
                 <li>
                  <a href="" >访问学者</a>
                </li>
                 <li>
                  <a href="" >博士后</a>
                </li>
              </ul>
            </li>
            <li class="dropdown hidden-sm hidden-md">
              <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">人才培养<b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li>
                  <a href="">人才培养概况</a>
                </li>
                <li>
                  <a href="" >硕士生</a>
                </li>
               	<li>
                  <a href="" >博士生</a>
                </li>
                <li>
                  <a href="" >主讲课程</a>
                </li>
                <li>
                  <a href="" >教学成果</a>
                </li>
              </ul>
            </li>
            <li class="dropdown hidden-sm hidden-md">
              <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">科学研究<b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li>
                  <a href="">科学研究概况</a>
                </li>
                <li>
                  <a href="" >科研项目</a>
                </li>
               	<li>
                  <a href="" >学术论文</a>
                </li>
                <li>
                  <a href="" >学术专著</a>
                </li>
                <li>
                  <a href="" >发明专利</a>
                </li>
                <li>
                  <a href="" >科研获奖</a>
                </li>
                <li>
                  <a href="" >代表性成果介绍</a>
                </li>
              </ul>
            </li>
            <li class="dropdown hidden-sm hidden-md">
              <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">开放与交流<b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li>
                  <a href="">国内交流</a>
                </li>
                <li>
                  <a href="" >国际交流</a>
                </li>
               	<li>
                  <a href="" >开放课题</a>
                </li>
              </ul>
            </li>
            <li class="dropdown hidden-sm hidden-md">
              <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">科研资源<b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li>
                  <a href="">开放硬件</a>
                </li>
                <li>
                  <a href="" >开放软件</a>
                </li>
               	<li>
                  <a href="" >共享办法</a>
                </li>
                <li>
                  <a href="" >使用规范</a>
                </li>
                <li>
                  <a href="" >使用统计</a>
                </li>
              </ul>
            </li>
            <li class="dropdown hidden-sm hidden-md">
              <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">运行管理<b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li>
                  <a href="">考核报告</a>
                </li>
                <li>
                  <a href="" >管理制度</a>
                </li>
              </ul>
            </li> -->
          </ul>
          <ul class="nav navbar-nav navbar-right hidden-sm">
            <!-- <li><a href="/about/" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'about'])">关于</a></li> -->
          </ul>
        </div>
      </div>
    </div>