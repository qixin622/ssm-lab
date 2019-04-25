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
                        <strong class="icon-file-text"> 实验项目</strong>
                    </div>
                    <ul class="list-group">
                        <c:forEach var="courseItem" items="${course.courseItems}">
                            <li></span><a href="${ctx}/courseItem/show/${courseItem.id}">${courseItem.itemname}</a></li>
                        </c:forEach>
                    </ul>
                </div>
                <%@include file="doc_link.jsp" %>
            </div>
        </div>
        <div class="xl12 xs12 xm9 xb9">
            <div class="padding-large-left">
                <div class="panel margin-big-bottom padding-large-left padding-large-right">
                    <div class="panel-body">
                        <div class="detail">
                            <h1 class="article-title margin-bottom">${course.cno} - ${course.cname}</h1>
                            <div class="article-info">
                                <div>
                                    <small>课程性质：${course.property}</small>
                                    <small>先修课程：${course.precourse}</small>
                                    <c:if test="${!empty course.dlurl}">
                                        <small><a href="${ctx}/${course.dlurl}"><i class="icon-download"></i> 课程大纲下载</a></small>
                                    </c:if>
                                    <c:if test="${!empty course.bookurl}">
                                        <small><a href="${ctx}/${course.bookurl}"><i class="icon-download"></i> 实验指导书下载</a></small>
                                    </c:if>
                                    <small>字号：<span class="small" title="切换到小字体">T</span>|<span class="big" title="切换到大字体">T</span> </small>
                                </div>
                                <div>
                                    <small>总学时数：${course.totalperiod}</small>
                                    <small>学分：${course.credit}</small>
                                    <small>理论学时：${course.theperiod}</small>
                                    <small>实验学时：${course.expperiod}</small>
                                </div>
                                <div>
                                    <small>适合层次：${course.level}</small>
                                    <small>适合专业：${course.specialty}</small>
                                </div>
                            </div>
                            <div class="article-content padding-large-top padding-large-bottom">
                                <c:if test="${!empty course.content}">
                                    ${course.content}
                                </c:if>
                                <c:if test="${empty course.content}">
                                    无
                                </c:if>
                            </div>


                            <div class="article-preNext">
                                <div class="article-line"><strong></strong></div>
                                <ul>
                                    <li>
                                        <c:if test="${!(empty prev_course.id)}">
                                            上一篇：<a href="${ctx}/course/show/${prev_course.id}">${prev_course.cname}</a>
                                        </c:if>
                                        <c:if test="${(empty prev_course.id)}">
                                            上一篇：已经没有了
                                        </c:if>
                                    </li>
                                    <li>
                                        <c:if test="${!(empty next_course.id)}">
                                            下一篇：<a href="${ctx}/course/show/${next_course.id}">${next_course.cname}</a>
                                        </c:if>
                                        <c:if test="${(empty next_course.id)}">
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
