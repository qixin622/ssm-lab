<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="mytag" uri="/WEB-INF/MyTag" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <%@include file="doc_head.jsp" %>
</head>
<body>
<!--导航-->
<%@include file="doc_topnav.jsp" %>
<!--菜单-->
<%@include file="doc_menu.jsp" %>
<div class="container">
    <div class="line">
        <div class="xm3 xb3 fadein-left">
            <div class="doc-siderbar">
                <div class="panel margin-big-bottom">
                    <div class="panel-head">
                        <strong class="icon-file-text"> 文章分类</strong>
                    </div>
                    <ul class="list-group">
                        <c:forEach var="category" items="${categoryList}">
                            <li></span><a href="${ctx}/article/list?cid=${category.cid}">${category.categoryName}</a></li>
                        </c:forEach>
                    </ul>
                </div>
                <%@include file="doc_link.jsp" %>
            </div>
        </div>
        <div class="xl12 xs12 xm9 xb9">
            <div class="padding-large-left">
                <div class="panel margin-big-bottom padding-large-left padding-large-right">
                    <div class="panel-head margin">
                        <span class="article-catename"><a href="${ctx}/article/list?cid=${article.categoryId}">${article.category.categoryName}</a></span>
                    </div>
                    <div class="panel-body">
                        <div class="detail">
                            <h1 class="article-title margin-big-bottom"><mytag:htmlspecialtag content="${article.title}"/></h1>
                            <div class="article-info text-center">
                                <small>创建时间：<spring:eval expression="article.createTime"/></small>
                                <small>点击次数: ${article.hints}</small>
                                字号：<span class="small" title="切换到小字体">T</span>|<span class="big" title="切换到大字体">T</span>
                            </div>
                            <div class="article-content padding-large-top padding-large-bottom">${article.content}</div>
                            <div class="article-author text-right">(编辑：${article.user.userName})</div>
                            <c:if test="${!(empty article.updateTime)}">
                                <div class="article-author text-right">最后更新时间：<spring:eval expression="article.updateTime"/></div>
                            </c:if>
                            <div class="article-preNext">
                                <div class="article-line"><strong></strong></div>
                                <ul>
                                    <li>
                                        <c:if test="${!(empty prev_article.id)}">
                                            上一篇：<a href="${ctx}/article/show/${prev_article.id}">${prev_article.title}</a>
                                        </c:if>
                                        <c:if test="${(empty prev_article.id)}">
                                            上一篇：已经没有了
                                        </c:if>
                                    </li>
                                    <li>
                                        <c:if test="${!(empty next_article.id)}">
                                            下一篇：<a href="${ctx}/article/show/${next_article.id}">${next_article.title}</a>
                                        </c:if>
                                        <c:if test="${(empty next_article.id)}">
                                            下一篇：已经没有了
                                        </c:if>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--底部-->
<%@include file="doc_footer.jsp" %>
</body>
</html>
