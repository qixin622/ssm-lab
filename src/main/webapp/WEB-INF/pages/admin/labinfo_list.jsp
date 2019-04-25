<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="mytag" uri="/WEB-INF/MyTag" %>
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
    <li><a href="${ctx}/manage/labinfo/list" id="a_leader_txt">实验室信息内容管理</a></li>
</ul>
<div class="admin">
    <div class="line">
        <div class="panel admin-panel">
            <div class="panel-head"><strong class="icon-reorder"> 实验室信息内容管理</strong></div>
            <div class="panel-body">
                <div class="padding-bottom border-bottom">
                    <ul class="search" style="padding-left:10px;">
                        <li>
                            <div class="button-group">
                                <button type="button" class="button border-green"
                                        onclick="javascript:window.location.href='${ctx}/manage/labinfo/list';"><span
                                        class="icon-refresh"></span> 刷新数据
                                </button>
                                <button type="button" class="button border-main"
                                        onclick="javascript:window.location.href='${ctx}/manage/labinfo/to_add';"><span
                                        class="icon-plus"></span> 添加信息
                                </button>
                            </div>
                        </li>
                    </ul>
                </div>
                <table class="table table-hover text-center">
                    <tr>
                        <th>ID</th>
                        <th>信息标题</th>
                        <th>信息内容</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${pageInfo.list}" var="labInfo">
                        <tr>
                            <td>${labInfo.id}</td>
                            <td class="text-left"><a href="${ctx}/labinfo/show/${labInfo.id}">${labInfo.title}</a></td>
                            <td class="text-left">
                                <mytag:convertstringtag content="${labInfo.content}" size="100"/>
                            </td>
                            <td>
                                <a href="${ctx}/manage/labinfo/to_update?id=${labInfo.id}">编辑</a>
                                <a href="${ctx}/manage/labinfo/remove?id=${labInfo.id}" onclick="return conf();">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="panel-foot text-center">
                <div class="line">
                    <div class="xm6 height-large">
                        当前第 <span class="badge"> ${pageInfo.pageNum} </span> 页,
                        共 <span class="badge"> ${pageInfo.pages} </span> 页,
                        共 <span class="badge"> ${pageInfo.total} </span> 条记录
                    </div>
                    <div class="xm6">
                        <ul class="pagination border-main">
                            <c:if test="${pageInfo.hasPreviousPage == false}">
                                <li class="disabled"><a href="#">首页</a></li>
                                <li class="disabled"><a><i class="icon-angle-double-left"></i></a></li>
                            </c:if>
                            <c:if test="${pageInfo.hasPreviousPage}">
                                <li><a href="${ctx}/manage/labinfo/list">首页</a></li>
                                <li><a href="${ctx}/manage/labinfo/list?pn=${pageInfo.pageNum-1}"><i
                                        class="icon-angle-double-left"></i></a></li>
                            </c:if>
                            <c:forEach items="${pageInfo.navigatepageNums}" var="num">
                                <c:if test="${pageInfo.pageNum == num}">
                                    <li class="active"><a>${num}</a></li>
                                </c:if>
                                <c:if test="${pageInfo.pageNum != num}">
                                    <li><a href="${ctx}/manage/labinfo/list?pn=${num}">${num}</a></li>
                                </c:if>
                            </c:forEach>

                            <c:if test="${pageInfo.hasNextPage == false}">
                                <li class="disabled"><a><i class="icon-angle-double-right"></i></a></li>
                                <li class="disabled"><a href="#">末页</a></li>
                            </c:if>
                            <c:if test="${pageInfo.hasNextPage}">
                                <li><a href="${ctx}/manage/labinfo/list?pn=${pageInfo.pageNum+1}"><i
                                        class="icon-angle-double-right"></i></a></li>
                                <li><a href="${ctx}/manage/labinfo/list?pn=${pageInfo.pages}">末页</a></li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="admin_bottom.jsp"/>
</body>
</html>
