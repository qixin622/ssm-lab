<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="mytag" uri="/WEB-INF/MyTag" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <jsp:include page="admin_head.jsp"/>
    <link rel="stylesheet" href="${ctx}/css/style.css">
</head>
<body style="background-color:#f2f9fd;">
<jsp:include page="admin_top_left.jsp"/>
<ul class="bread">
    <li><a href="${ctx}/manage/home" target="right" class="icon-home"> 首页</a></li>
    <li><a href="${ctx}/manage/course/list" id="a_leader_txt">实验课程管理</a></li>
</ul>
<div class="admin">
    <div class="line">
        <div class="panel admin-panel">
            <div class="panel-head">
                <strong class="icon-reorder"> 实验课程管理</strong>
            </div>
            <div class="panel-body">
                <div class="margin-big-bottom">
                    <form action="${ctx}/manage/course/list" method="post">
                        <ul class="search" style="padding-left:10px;">
                            <li>
                                <div class="button-group">
                                    <button type="button" class="button border-green"
                                            onclick="javascript:ShowAllRows();"><span
                                            class="icon-minus-square-o"></span> 展开
                                    </button>
                                    <button type="button" class="button border-green"
                                            onclick="javascript:HideAllRows();"><span
                                            class="icon-plus-square-o"></span> 隐藏
                                    </button>
                                    <button type="button" class="button border-green"
                                            onclick="javascript:window.location.href='${ctx}/manage/course/list';"><span
                                            class="icon-refresh"></span> 刷新数据
                                    </button>
                                    <button type="button" class="button border-main"
                                            onclick="javascript:window.location.href='${ctx}/manage/course/to_add';"><span
                                            class="icon-plus"></span> 添加课程
                                    </button>
                                </div>
                            </li>
                            <li>
                                <select id="type" name="type" class="input" style="width:100px; line-height:17px;">
                                    <option value="cno">课程编号</option>
                                    <option value="cname">课程名称</option>
                                    <option value="property">课程性质</option>
                                </select>
                            </li>
                            <li>
                                <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input"
                                       style="width:250px; line-height:17px;display:inline-block">
                                <button type="submit" class="button border-main icon-search"> 搜索</button>
                            </li>
                        </ul>
                    </form>
                </div>
                <div class="table-responsive">
                    <table class="table table-hover text-center">
                        <tr>
                            <td height="20" align="center"></td>
                            <td class="text-left">课程编号</td>
                            <td class="text-left">课程名称</td>
                            <td class="text-left">课程性质</td>
                            <td class="text-left">总学时</td>
                            <td class="text-left">学分</td>
                            <td class="text-left">理论学时</td>
                            <td class="text-left">实验学时</td>
                            <td class="text-right">操作</td>
                        </tr>
                        <c:forEach items="${pageInfo.list}" var="course">
                            <tr>
                                <td height="20" align="center"><span class="disimg2" id="rowid_${course.id}"
                                                                     onclick="DisplayRows('${course.id}');"></span></td>
                                <td class="text-left">${course.cno}</td>
                                <td class="text-left"><a href="${ctx}/course/show/${course.id}">${course.cname}</a></td>
                                <td class="text-left">${course.property}</td>
                                <td class="text-left">${course.totalperiod}</td>
                                <td class="text-left">${course.credit}</td>
                                <td class="text-left">${course.theperiod}</td>
                                <td class="text-left">${course.expperiod}</td>
                                <td class="text-right">
                                    <a href="${ctx}/manage/courseitem/to_add?cid=${course.id}">添加项目</a>
                                    <a href="${ctx}/manage/course/to_update?id=${course.id}">编辑课程</a>
                                    <a href="${ctx}/manage/course/remove?id=${course.id}" onclick="return conf();">删除</a>
                                </td>
                            </tr>
                            <tr>
                                <td style="padding: 0;border: none;" colspan="9">
                                    <div rel="rowpid_${course.id}" style="display: none;">
                                        <table class="table table-hover text-center">
                                            <c:forEach items="${course.courseItems}" var="courseItem">
                                                <tr>
                                                    <td class="text-left"><span class="sub_type infotype"></span></td>
                                                    <td class="text-left"><a href="${ctx}/courseItem/show/${courseItem.id}">${courseItem.itemname}</a></td>
                                                    <td class="text-left">${courseItem.expdemand}</td>
                                                    <td class="text-left">实验学时：${courseItem.expperiod}</td>
                                                    <td class="text-left">实验类型：${courseItem.exptype}</td>
                                                    <td class="text-right">
                                                        <a href="${ctx}/manage/courseitem/to_update?id=${courseItem.id}">编辑项目</a>
                                                        <a href="${ctx}/manage/courseitem/remove?id=${courseItem.id}"
                                                           onclick="return conf();">删除</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </table>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>


                </div>
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
                                <li><a href="${ctx}/manage/course/list">首页</a></li>
                                <li><a href="${ctx}/manage/course/list?pn=${pageInfo.pageNum-1}"><i
                                        class="icon-angle-double-left"></i></a></li>
                            </c:if>
                            <c:forEach items="${pageInfo.navigatepageNums}" var="num">
                                <c:if test="${pageInfo.pageNum == num}">
                                    <li class="active"><a>${num}</a></li>
                                </c:if>
                                <c:if test="${pageInfo.pageNum != num}">
                                    <li><a href="${ctx}/manage/course/list?pn=${num}">${num}</a></li>
                                </c:if>
                            </c:forEach>

                            <c:if test="${pageInfo.hasNextPage == false}">
                                <li class="disabled"><a><i class="icon-angle-double-right"></i></a></li>
                                <li class="disabled"><a href="#">末页</a></li>
                            </c:if>
                            <c:if test="${pageInfo.hasNextPage}">
                                <li><a href="${ctx}/manage/course/list?pn=${pageInfo.pageNum+1}"><i
                                        class="icon-angle-double-right"></i></a></li>
                                <li><a href="${ctx}/manage/course/list?pn=${pageInfo.pages}">末页</a></li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="admin_bottom.jsp"/>
<script src="${ctx}/js/home.js"></script>
</body>
</html>
