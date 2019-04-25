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
                        <strong class="icon-file-text"> 实验室信息展示</strong>
                    </div>
                    <ul class="list-group">
                        <c:forEach var="labInfo" items="${labInfoList}">
                            <li></span><a href="${ctx}/labinfo/show/${labInfo.id}">${labInfo.title}</a></li>
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
                        <span class="article-catename">实验室简介</span>
                    </div>
                    <div class="panel-body">
                        <div class="detail">
                            <h1 class="article-title margin-big-bottom"><mytag:htmlspecialtag content="${labInfo.title}"/></h1>
                            <div class="article-info text-center">
                                字号：<span class="small" title="切换到小字体">T</span>|<span class="big" title="切换到大字体">T</span>
                            </div>
                            <div class="article-content padding-large-top padding-large-bottom">${labInfo.content}</div>
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
