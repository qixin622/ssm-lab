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
    <li><a href="${ctx}/manage/category/list" id="a_leader_txt">文章分类管理</a></li>
</ul>
<div class="admin">
    <div class="line">
        <div class="panel admin-panel">
            <div class="panel-head"><strong class="icon-reorder"> 文章分类管理 </strong></div>
            <div class="panel-body">
                <div class="padding-bottom border-bottom">
                    <ul class="search" style="padding-left:10px;">
                        <li>
                            <div class="button-group">
                                <button type="button" class="button border-green"
                                        onclick="javascript:window.location.href='${ctx}/manage/category/list';"><span
                                        class="icon-refresh"></span> 刷新数据
                                </button>
                                <button type="button" class="button border-main"
                                        onclick="javascript:window.location.href='${ctx}/manage/category/to_add';"><span
                                        class="icon-plus"></span> 添加分类
                                </button>
                            </div>
                        </li>
                    </ul>
                </div>
                <table class="table table-hover text-center">
                    <tr>
                        <th>分类编号</th>
                        <th>分类名称</th>
                        <th>分类描述</th>
                        <th>访问权限</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${categoryList}" var="category">
                        <tr>
                            <td>${category.cid}</td>
                            <td class="text-left">${category.categoryName}</td>
                            <td class="text-left">${category.description}</td>
                            <td>
                                <c:if test="${category.authority == '0'}">
                                    公开
                                </c:if>
                                <c:if test="${category.authority == '1'}">
                                    私密
                                </c:if>
                            </td>
                            <td>
                                <a href="${ctx}/manage/category/to_update?cid=${category.cid}">编辑</a>
                                <a href="${ctx}/manage/category/remove?cid=${category.cid}" onclick="return conf();">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="panel-foot text-center">
                <div class="line">
                    <div class="xm12 height-large">
                        当前共有 <span class="badge"> ${categoryNum} </span> 个分类
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="admin_bottom.jsp"/>
</body>
</html>
