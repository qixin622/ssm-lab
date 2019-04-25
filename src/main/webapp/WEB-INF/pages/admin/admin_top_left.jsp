<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="header bg-main padding-big-right">
    <div class="logo margin-big-left fadein-top">
        <h1><img src="${ctx}/${sessionScope.user.photo}" class="radius-circle rotate-hover" height="50" alt="" />实验室信息管理系统 <span class="badge bg-yellow"> V1.0</span></h1>
    </div>
    <div class="head-l">
        <span id="showtime" class="padding-big-right text-white"></span>
        <a href="${ctx}/index" class="button button-little bg-blue"><span class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;
        <a href="${ctx}/manage/user/to_change_password" class="button button-little bg-green"><span class="icon-cogs"></span> 更改密码</a> &nbsp;&nbsp;
        <a class="button button-little bg-red" href="${ctx}/logout"><span class="icon-power-off"></span> 退出登录</a>
    </div>
</div>
<div class="leftnav">
    <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
    <c:if test="${sessionScope.user.role==1}">
        <h2><span class="icon-user"></span>基本数据</h2>
        <ul style="display:block">
            <li><a href="${ctx}/manage/user/list"><span class="icon-caret-right"></span>教工管理</a></li>
            <li><a href="${ctx}/manage/course/list"><span class="icon-caret-right"></span>实验课程管理</a></li>
            <li><a href="${ctx}/manage/pcourse/list"><span class="icon-caret-right"></span>实践课程管理</a></li>
            <li><a href="${ctx}/manage/borrow/list"><span class="icon-caret-right"></span>借出帐管理</a></li>
        </ul>
        <h2><span class="icon-pencil-square-o"></span>内容管理</h2>
        <ul style="display:block">
            <li><a href="${ctx}/manage/labinfo/list"><span class="icon-caret-right"></span>实验室信息管理</a></li>
            <li><a href="${ctx}/manage/workrecord/list"><span class="icon-caret-right"></span>工作记录管理</a></li>
            <li><a href="${ctx}/manage/category/list"><span class="icon-caret-right"></span>分类管理</a></li>
            <li><a href="${ctx}/manage/article/list"><span class="icon-caret-right"></span>文章管理</a></li>
        </ul>
        <h2><span class="icon-bar-chart-o"></span>工作量管理</h2>
        <ul style="display:block">
            <li><a href="${ctx}/manage/experiment/workload/list"><span class="icon-caret-right"></span>实验工作量统计</a></li>
            <li><a href="${ctx}/manage/practice/workload/list"><span class="icon-caret-right"></span>实践工作量统计</a></li>
        </ul>
    </c:if>
</div>