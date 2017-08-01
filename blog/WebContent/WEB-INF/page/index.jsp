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
   	 <!-- 本页样式表 -->
    <link href="asserts/blog/css/home.css" rel="stylesheet" />
</head>
<body>
   <jsp:include page="common/nav_top.jsp"></jsp:include>
    <!-- 主体（一般只改变这里的内容） -->
    <div class="blog-body">
       <%@include file="common/canvas.jsp" %>
        <!-- 这个一般才是真正的主体内容 -->
        <div class="blog-container">
            <div class="blog-main">
                <!-- 网站公告提示 -->
                <div class="home-tips shadow">
                    <i style="float:left;line-height:17px;" class="fa fa-volume-up"></i>
                    <div class="home-tips-container">
                    	<c:forEach items="${msgList }" var="msg">
                    	 <span style="color: ${msg.msgColor}">${msg.content }
                    	 <c:if test="${ not empty msg.url }"><a href="${msg.url }" target="_blank" style="color:#01AAED">点我前往</a></c:if></span>
                    	</c:forEach>
                    </div>
                </div>
                <!--左边文章列表-->
                <div class="blog-main-left">
                <c:forEach items="${articleList }" var="article">
                    <div class="article shadow">
                        <div class="article-left">
                            <img src="${article.imgUrl }" alt="${article.title }" />
                        </div>
                        <div class="article-right">
                            <div class="article-title">
                                <a href="detail.do">${article.title }</a>
                            </div>
                            <div class="article-abstract">
                               ${article.content}
                            </div>
                        </div>
                        <div class="clear"></div>
                        <div class="article-footer">
                            <span><i class="fa fa-clock-o"></i>&nbsp;&nbsp;${artice.createTime }</span>
                            <span class="article-author"><i class="fa fa-user"></i>&nbsp;&nbsp;${article.author}</span>
                            <span><i class="fa fa-tag"></i>&nbsp;&nbsp;<a href="#">Web前端</a></span>
                            <span class="article-viewinfo"><i class="fa fa-eye"></i>&nbsp;${article.viewNumber }</span>
                            <span class="article-viewinfo"><i class="fa fa-commenting"></i>&nbsp;4</span>
                        </div>
                    </div>  
                    </c:forEach>                                                                                     
                </div>
                <!--右边小栏目-->
                <div class="blog-main-right">
                    <div class="blogerinfo shadow">
                        <div class="blogerinfo-figure">
                            <img src="${user.headImgurl }" alt="Absolutely" />
                        </div>
                        <p class="blogerinfo-nickname">${user.nickname }</p>
                        <p class="blogerinfo-introduce">${user.introduction }</p>
                        <p class="blogerinfo-location"><i class="fa fa-location-arrow"></i>&nbsp;${user.addressProvince } - ${user.addressCity }</p>
                        <hr />
                        <div class="blogerinfo-contact">
                            <a target="_blank" title="QQ交流" href="javascript:layer.msg('启动QQ会话窗口')"><i class="fa fa-qq fa-2x"></i></a>
                            <a target="_blank" title="给我写信" href="javascript:layer.msg('启动邮我窗口')"><i class="fa fa-envelope fa-2x"></i></a>
                            <a target="_blank" title="新浪微博" href="javascript:layer.msg('转到你的微博主页')"><i class="fa fa-weibo fa-2x"></i></a>
                            <a target="_blank" title="码云" href="javascript:layer.msg('转到你的github主页')"><i class="fa fa-git fa-2x"></i></a>
                        </div>
                    </div>
                    <div></div><!--占位-->
                    <div class="blog-module shadow">
                        <div class="blog-module-title">热文排行</div>
                        <ul class="fa-ul blog-module-ul">
                            <!-- <li><i class="fa-li fa fa-hand-o-right"></i><a href="detail.html">Web安全之跨站请求伪造CSRF</a></li>
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="detail.html">ASP.NET MVC 防范跨站请求伪造（CSRF）</a></li>
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="detail.html">常用正则表达式</a></li>
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="detail.html">EF CodeFirst数据迁移常用指令</a></li>
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="detail.html">浅谈.NET Framework基元类型</a></li>
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="detail.html">C#基础知识回顾-扩展方法</a></li>
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="detail.html">一步步制作时光轴（一）（HTML篇）</a></li>
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="detail.html">一步步制作时光轴（二）（CSS篇）</a></li> -->
                            <c:forEach items="${hot }" var="item">
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="#">${item.title}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="blog-module shadow">
                        <div class="blog-module-title">最近分享</div>
                        <ul class="fa-ul blog-module-ul">
                            <!-- <li><i class="fa-li fa fa-hand-o-right"></i><a href="http://pan.baidu.com/s/1c1BJ6Qc" target="_blank">Canvas</a></li>
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="http://pan.baidu.com/s/1kVK8UhT" target="_blank">pagesize.js</a></li>
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="https://pan.baidu.com/s/1mit2aiW" target="_blank">时光轴</a></li> -->
                            <c:forEach items="${recent }" var="rArticle">
                            <li><i class="fa-li fa fa-hand-o-right"></i><a href="#" target="_blank">${rArticle.title}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="blog-module shadow">
                        <div class="blog-module-title">一路走来</div>
                        <dl class="footprint">
                            <dt>2017年03月12日</dt>
                            <dd>新增留言回复功能！人人都可参与回复！</dd>
                            <dt>2017年03月10日</dt>
                            <dd>烟雨楼2.0基本功能完成，正式上线！</dd>
                            <dt>2017年03月09日</dt>
                            <dd>新增文章搜索功能！</dd>
                            <dt>2017年02月25日</dt>
                            <dd>QQ互联接入网站，可QQ登陆发表评论与留言！</dd>
                        </dl>
                    </div>
                    <div class="blog-module shadow">
                        <div class="blog-module-title">后台记录</div>
                        <dl class="footprint">
                            <dt>2017年03月16日</dt>
                            <dd>分页新增页容量控制</dd>
                            <dt>2017年03月12日</dt>
                            <dd>新增管家提醒功能</dd>
                            <dt>2017年03月10日</dt>
                            <dd>新增Win10快捷菜单</dd>
                        </dl>
                    </div>
                    <div class="blog-module shadow">
                        <div class="blog-module-title">友情链接</div>
                        <ul class="blogroll">
                            <li><a target="_blank" href="http://www.layui.com/" title="Layui">Layui</a></li>
                            <li><a target="_blank" href="http://www.pagemark.cn/" title="页签">页签</a></li>
                        </ul>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div>
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
    <!-- 本页脚本 -->
    <script src="asserts/blog/js/home.js"></script>
</body>
</html>