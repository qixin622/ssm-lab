<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="page-nav margin-big-bottom">
    <div class="container">
        <div class="line-big padding-top padding-bottom border-bottom">
            <div class="xs3 xm3 xb3">
                <button class="button icon-navicon margin-top float-right" data-target="#navbar">
                </button>
                <div class="media media-x" style="margin-top: 0;">
                    <div class="float-left txt txt-big text-main radius-small ring-hover">
                        <strong class="icon-graduation-cap"></strong>
                    </div>
                    <div class="media-body padding-top">
                        <h2 class="text-main"><strong><a href="${ctx}/index">教学管理系统</a></strong></h2>
                        实验室教学信息管理系统 v1.0
                    </div>
                </div>
            </div>
            <div class="xl12 xs9 xm9 xb9">
                <div class="doc-menu">
                    <ul class="nav nav-menu nav-inline nav-pills nav-navicon border-main padding-big-top padding-big-left" id="navbar">
                        <li><a href="javascript:void(0);">实验室简介<span class="arrow"></span></a>
                            <ul class="drop-menu">
                                <c:forEach var="labInfo" items="${labInfoList}">
                                    <li></span><a href="${ctx}/labinfo/show/${labInfo.id}">${labInfo.title}</a></li>
                                </c:forEach>
                            </ul>
                        </li>
                        <li><a href="javascript:void(0);">课程信息<span class="arrow"></span></a>
                            <ul class="drop-menu">
                                <li><a href="${ctx}/course/list">实验课程信息</a> </li>
                                <li class="divider"></li>
                                <li><a href="${ctx}/pcourse/list">实践课程信息</a> </li>
                            </ul>
                        </li>
                        <li><a href="javascript:void(0);">文章资料<span class="arrow"></span></a>
                            <ul class="drop-menu">
                                <c:forEach var="category" items="${categoryList}">
                                    <li></span><a href="${ctx}/article/list?cid=${category.cid}">${category.categoryName}</a></li>
                                </c:forEach>
                            </ul>
                        </li>
                        <c:if test="${sessionScope.user!=null}">
                            <li><a href="javascript:void(0);">教工信息<span class="arrow"></span></a>
                                <ul class="drop-menu">
                                    <li><a href="${ctx}/user/list/table">教工信息 - 表格样式</a> </li>
                                    <li><a href="${ctx}/user/list/frame">教工信息 - 列表样式</a></li>
                                    <li class="divider"></li>
                                    <li><a href="${ctx}/user/workrecord/list">工作内容记录</a></li>
                                </ul>
                            </li>
                            <li><a href="javascript:void(0);">工作量统计<span class="arrow"></span></a>
                                <ul class="drop-menu">
                                    <li><a href="${ctx}/experiment/workload/list">实验工作量明细</a> </li>
                                    <li><a href="${ctx}/practice/workload/list">实践工作量明细</a> </li>
                                    <li class="divider"></li>
                                    <li><a href="${ctx}/summary/workload/list">工作量汇总</a> </li>
                                </ul>
                            </li>
                        </c:if>

                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>