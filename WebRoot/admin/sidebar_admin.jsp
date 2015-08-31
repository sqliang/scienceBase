<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="sidebar-nav">
    <ul>
	    <li>
		    <a href="javascript:;" data-target=".index-menu" class="nav-header" data-toggle="collapse">
		    	<i class="fa fa-fw fa-dashboard"></i> 首页管理
		    	<i class="fa fa-collapse"></i>
		   	</a>
	   	</li>
	    <li>
		    <ul class="index-menu nav nav-list collapse in">
		    	<li><a href="homeAdmin"><span class="fa fa-caret-right"></span> 信息查看</a></li>
		        <li><a href="/scienceBase/admin/addNews_admin.jsp"><span class="fa fa-caret-right"></span> 信息发布</a></li>
		    </ul>
	    </li>

        <li>
        	<a href="javascript:;" data-target=".article-menu" class="nav-header collapsed" data-toggle="collapse">
        		<i class="fa fa-fw fa-briefcase"></i> 简介文章管理<i class="fa fa-collapse"></i>
        	</a>
       </li>
        <li>
	        <ul class="article-menu nav nav-list collapse">
	           <li ><a href="adminQueryIntrInfo"><span class="fa fa-caret-right"></span> 信息查看</a></li>
	           <li ><a href="/scienceBase/admin/addInfo_admin.jsp"><span class="fa fa-caret-right"></span> 信息发布</a></li>
	    	</ul>
    	</li>
    	
    	<li>
        	<a href="javascript:;" data-target=".lab-menu" class="nav-header collapsed" data-toggle="collapse">
        		<i class="fa fa-fw fa-briefcase"></i> 实验室概况管理<i class="fa fa-collapse"></i>
        	</a>
       </li>
        <li>
	        <ul class="lab-menu nav nav-list collapse">
	           <li ><a href="adminQueryLabInfo"><span class="fa fa-caret-right"></span> 信息查看</a></li>
	           <li ><a href="/scienceBase/admin/addLab_admin.jsp"><span class="fa fa-caret-right"></span> 信息发布</a></li>
	    	</ul>
    	</li>

        <li>
	        <a href="javascript:;" data-target=".team-menu" class="nav-header collapsed" data-toggle="collapse">
	        	<i class="fa fa-fw fa-legal"></i> 研究队伍管理<i class="fa fa-collapse"></i>
	        </a>
        </li>
        <li>
	        <ul class="team-menu nav nav-list collapse">
	           <li ><a href="adminQueryMemInfos"><span class="fa fa-caret-right"></span> 信息查看</a></li>
	           <li ><a href="/scienceBase/admin/addMem_admin.jsp"><span class="fa fa-caret-right"></span> 信息发布</a></li>
	    	</ul>
    	</li>
    	
    	<li>
	        <a href="javascript:;" data-target=".student-menu" class="nav-header collapsed" data-toggle="collapse">
	        	<i class="fa fa-fw fa-legal"></i> 人才培养管理<i class="fa fa-collapse"></i>
	        </a>
        </li>
        <li>
	        <ul class="student-menu nav nav-list collapse">
	           <li ><a href="adminQueryStudentEdu"><span class="fa fa-caret-right"></span> 信息查看</a></li>
	           <li ><a href="/scienceBase/admin/addPersonEdu_admin.jsp"><span class="fa fa-caret-right"></span> 信息发布</a></li>
	    	</ul>
    	</li>
    	
    	<li>
	        <a href="javascript:;" data-target=".science-menu" class="nav-header collapsed" data-toggle="collapse">
	        	<i class="fa fa-fw fa-legal"></i> 科学研究管理<i class="fa fa-collapse"></i>
	        </a>
        </li>
        <li>
	        <ul class="science-menu nav nav-list collapse">
	           <li ><a href="adminQueryScienceRes"><span class="fa fa-caret-right"></span> 信息查看</a></li>
	           <li ><a href="/scienceBase/admin/addScienceRes_admin.jsp"><span class="fa fa-caret-right"></span> 信息发布</a></li>
	    	</ul>
    	</li>
    	
    	<li>
	        <a href="javascript:;" data-target=".com-menu" class="nav-header collapsed" data-toggle="collapse">
	        	<i class="fa fa-fw fa-legal"></i> 开放与交流管理<i class="fa fa-collapse"></i>
	        </a>
        </li>
        <li>
	        <ul class="com-menu nav nav-list collapse">
	           <li ><a href="adminQueryComunicate"><span class="fa fa-caret-right"></span> 信息查看</a></li>
	           <li ><a href="/scienceBase/admin/addCommunicate_admin.jsp"><span class="fa fa-caret-right"></span> 信息发布</a></li>
	    	</ul>
    	</li>
    	
    	<li>
	        <a href="javascript:;" data-target=".resource-menu" class="nav-header collapsed" data-toggle="collapse">
	        	<i class="fa fa-fw fa-legal"></i>科研资源管理<i class="fa fa-collapse"></i>
	        </a>
        </li>
        <li>
	        <ul class="resource-menu nav nav-list collapse">
	           <li ><a href="adminQueryResource"><span class="fa fa-caret-right"></span> 信息查看</a></li>
	           <li ><a href="/scienceBase/admin/addResource_admin.jsp"><span class="fa fa-caret-right"></span> 信息发布</a></li>
	    	</ul>
    	</li>
    	
    	<li>
	        <a href="javascript:;" data-target=".normal-menu" class="nav-header collapsed" data-toggle="collapse">
	        	<i class="fa fa-fw fa-legal"></i> 运行管理管理<i class="fa fa-collapse"></i>
	        </a>
        </li>
        <li>
	        <ul class="normal-menu nav nav-list collapse">
	           <li ><a href="adminQueryMag"><span class="fa fa-caret-right"></span> 信息查看</a></li>
	           <li ><a href="/scienceBase/admin/addMag_admin.jsp"><span class="fa fa-caret-right"></span> 信息发布</a></li>
	    	</ul>
    	</li>
      </ul>
    </div>