<%@page import="com.science.util.bean.BeanUtil"%>
<%@page import="com.science.domain.Mainmenu"%>
<%@page import="com.science.serviceManager.MainmenuManager"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	long mainMenuId = Integer.parseInt(request.getParameter("mainMenuId"));
	MainmenuManager mainmenuManager = (MainmenuManager) BeanUtil.load("mainmenuManagerImpl");
	Mainmenu mainmenu = mainmenuManager.queryByMainId(mainMenuId);
	request.setAttribute("mainmenu", mainmenu);
 %>
<div class="nav-left">
        <div class="left-title">
          <h3>${mainmenu.mainmenuname}</h3>
        </div>
        <ul>
        <c:forEach var="submenu" items="${mainmenu.submenumainmenuids}">
        	<li>
            	<a href="${submenu.submenulink}">${submenu.submenuname}</a>
            </li>
        </c:forEach>
          <!-- <li>
            <a href="">二级菜单目录2</a>
          </li>
          <li>
            <a href="">二级菜单目录3</a>
          </li>
          <li>
            <a href="">二级菜单目录4</a>
          </li>
          <li>
            <a href="">二级菜单目录5</a>
          </li>
         <li>
            <a href="">二级菜单目录6</a>
          </li>
          <li>
            <a href="">二级菜单目录7</a>
          </li>
          <li>
            <a href="">二级菜单目录8</a>
          </li> -->
        </ul>
 </div>
