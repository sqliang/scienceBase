<%@page import="com.science.util.SessionUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="" href="index_admin.jsp">
	          <span class="navbar-brand">
	          	<span class="fa fa-paper-plane"></span>  科研基地后台管理系统
	          </span>
          </a>
        </div>

        <div class="navbar-collapse collapse" style="height: 1px;">
          <ul id="main-menu" class="nav navbar-nav navbar-right">
            <li class="dropdown hidden-xs">
                <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-user padding-right-small" style="position:relative;top: 3px;"></span>
                    <%=SessionUtil.getSession().get("userName").toString()%>
                    <i class="fa fa-caret-down"></i>
                </a>

              <ul class="dropdown-menu">
               <!--  <li><a href="javascript:;">个人中心</a></li> -->
               <!--  <li class="divider"></li>
                <li class="dropdown-header">Admin Panel</li>
                <li><a href="">Security</a></li>
                <li><a tabindex="-1" href="">Payments</a></li>
                <li class="divider"></li> -->
                <li><a tabindex="-1" href="logoutAction">退出</a></li>
              </ul>
            </li>
          </ul>
        </div>
      </div>