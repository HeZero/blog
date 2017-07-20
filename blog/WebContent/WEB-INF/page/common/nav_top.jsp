<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String url=request.getRequestURI();
	url=url.substring(url.lastIndexOf("/")+1,url.lastIndexOf("."));
%>
    <input type="hidden" id="navName" value="<%=url%>"/>
 <!-- 导航 -->
    <nav class="blog-nav layui-header">
        <div class="blog-container">
            <!-- QQ互联登陆 -->
            <a href="javascript:;" class="blog-user">
                <i class="fa fa-qq"></i>
            </a>
            <a href="javascript:;" class="blog-user layui-hide">
                <img src="asserts/blog/images/Absolutely.jpg" alt="Absolutely" title="Absolutely" />
            </a>
            <!-- 烟雨楼 -->
            <a class="blog-logo" href="home.html">烟雨楼</a>
            <!-- 导航菜单 -->
            <ul class="layui-nav" lay-filter="nav">
                <li id="index" class="layui-nav-item">
                    <a href="/index"><i class="fa fa-home fa-fw"></i>&nbsp;网站首页</a>
                </li>
                <li id="article" class="layui-nav-item">
                    <a href="/article"><i class="fa fa-file-text fa-fw"></i>&nbsp;文章专栏</a>
                </li>
                <li id="res_share" class="layui-nav-item">
                    <a href="/res_share"><i class="fa fa-tags fa-fw"></i>&nbsp;资源分享</a>
                </li>
                <li id="time_line" class="layui-nav-item">
                    <a href="/time_line"><i class="fa fa-hourglass-half fa-fw"></i>&nbsp;点点滴滴</a>
                </li>
                <li id="about" class="layui-nav-item">
                    <a href="/about"><i class="fa fa-info fa-fw"></i>&nbsp;关于本站</a>
                </li>
            </ul>
            <!-- 手机和平板的导航开关 -->
            <a class="blog-navicon" href="javascript:;">
                <i class="fa fa-navicon"></i>
            </a>
        </div>
    </nav>
    <!--导航定位  -->
     <script type="text/javascript">
    	//$("ul li").attr("class","layui-nav-item");
    	var nav=document.getElementById("navName").value;
    	document.getElementById(nav).setAttribute("class","layui-nav-item layui-this");
    </script>