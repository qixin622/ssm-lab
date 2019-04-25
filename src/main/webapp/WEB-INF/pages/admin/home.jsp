<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <jsp:include page="admin_head.jsp"/>
</head>
<body style="background-color:#f2f9fd;">
<jsp:include page="admin_top_left.jsp"/>
<ul class="bread">
    <li><a href="${ctx}/manage/home" target="right" class="icon-home"> 首页</a></li>
</ul>
<div class="admin">
    <div class="line">
        <div class="xm3">
            <div class="panel border-main">
                <div class="panel-body text-center">
                    <img src="${ctx}/${user.photo}" width="120" alt="face" class="radius-circle rotate-hover" />
                </div>
                <div class="panel-foot border-main">
                    <table class="table">
                        <tr><td>职工编号：</td><td>${user.sn}</td></tr>
                        <tr><td>职工姓名：</td><td>${user.userName}</td></tr>
                        <tr><td>性别：</td><td>${user.sex}</td></tr>
                        <tr><td>出生日期：</td><td><spring:eval expression="user.birthday"/></td></tr>
                        <tr><td>职称：</td><td>${user.technical}</td></tr>
                        <tr><td>教师类别：</td><td>${user.type}</td></tr>
                        <tr><td>角色：</td><td><c:if test="${user.role == '1'}">
                            系统管理员
                        </c:if>
                            <c:if test="${user.role == '0'}">
                                普通用户
                            </c:if></td></tr>
                    </table>
                </div>
            </div>
        </div>
        <div class="xm9 padding-big-left">
            <blockquote>
                <h4>实验室信息管理系统介绍</h4>
                <p class="text-gray padding-top text-indent">
                    实验室信息管理系统是基于SSM框架开发的一款JavaWeb应用程序，旨在解决实验室日常手工资料管理效率低下的问题，能够帮助实验教师更好的进行日常教学资料的收集和管理。
                    同时提供年终工作量计算及统计工作，将实验教师从繁重的日常管理工作中解脱出来。
                </p>
            </blockquote>
            <div class="line-big margin-big-top margin-big-bottom">
                <div class="xm6">
                    <div class="panel">
                        <div class="panel-head"><strong>站点统计</strong></div>
                        <ul class="list-group">
                            <li><span class="float-right badge bg-red">88</span><span class="icon-user"></span> 学生</li>
                            <li><span class="float-right badge bg-main">19</span><span class="icon-file"></span> 课程</li>
                            <li><span class="float-right badge bg-main">26</span><span class="icon-file-text"></span> 文章</li>
                            <li><span class="float-right badge bg-main">1</span><span class="icon-shopping-cart"></span> 管理员</li>
                        </ul>
                    </div>
                </div>
                <div class="xm6">
                    <div class="panel">
                        <div class="panel-head"><strong>系统信息</strong></div>
                        <table class="table">
                            <tr><td>Web服务器：</td><td>Apache Tomcat7.0</td></tr>
                            <tr><td>浏览器：</td><td>Microsoft IE8.0</td></tr>
                            <tr><td>程序框架：</td><td>SSM+Mybatis</td></tr>
                            <tr><td>内存：</td><td>1G以上</td></tr>
                            <tr><td>数据库：</td><td>MySQL</td></tr>
                        </table>
                    </div>
                </div>
            </div>
            <div class="alert alert-yellow"><span class="close rotate-hover"></span><strong>注意：</strong>显示分辨率 1360*768 显示效果最佳，建议使用新版浏览器!</div>
        </div>
    </div>
</div>
<jsp:include page="admin_bottom.jsp"/>
</body>
</html>
