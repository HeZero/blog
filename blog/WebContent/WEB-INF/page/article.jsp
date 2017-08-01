<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; Charset=gb2312">
    <meta http-equiv="Content-Language" content="zh-CN">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <title>你是飞在天上的猫 享受孤独和自由</title>
   	<%@include file="common/style.jsp" %>
   	  <!--本页样式表-->
    <link href="asserts/blog/css/article.css" rel="stylesheet" />
</head>
<body>
   <jsp:include page="common/nav_top.jsp"></jsp:include>
    <!-- 主体（一般只改变这里的内容） -->
    <jsp:include page="main/article_main.jsp"></jsp:include>
    <!-- 底部 -->
   <%@include file="common/footer.jsp" %>
    <!--分享窗体-->
    <div class="blog-share layui-hide">
        <div class="blog-share-body">
            <div style="width: 200px;height:100%;">
                <div class="bdsharebuttonbox">
                    <a class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
                    <a class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
                    <a class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
                    <a class="bds_sqq" data-cmd="sqq" title="分享到QQ好友"></a>
                </div>
            </div>
        </div>
    </div>
    <!--遮罩-->
    <div class="blog-mask animated layui-hide"></div>
   	<%@include file="common/javascript.jsp" %>
</body>
</html>