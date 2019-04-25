<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <div class="padding-large-left padding-large-right">
            <div class="panel margin-big-bottom">
                <div class="panel-head">
                    <h1 class="text-main text-center icon-calendar"> 实验工作量列表</h1>
                </div>
                <div class="panel-body">
                    <div class="line text-center margin-bottom">
                        <form:form action="${ctx}/experiment/workload/list" modelAttribute="workloadForm" cssClass="form-x form-inline">
                            <form:select path="term" items="${terms}" cssClass="input" />
                            <form:select path="workloadType" items="${workloadTypes}" cssClass="input"/>
                            <form:select path="type" cssClass="input">
                                <form:option value="cno">课编号</form:option>
                                <form:option value="cname">课程名称</form:option>
                            </form:select>
                            <form:input path="keywords" class="input" placeholder="请输入搜索关键字"/>
                            <button type="submit" class="button border-main icon-search"> 搜索</button>
                            <button type="button" class="button border-green"
                                    onclick="javascript:window.location.href='${ctx}/experiment/workload/list';"><span
                                    class="icon-refresh"></span> 重置
                            </button>
                        </form:form>

                    </div>
                    <div class="table-responsive">
                        <table class="table table-bordered text-center">
                            <tr>
                                <td>学期</td>
                                <td class="text-left">课程名称</td>
                                <td>类型</td>
                                <td>实验学时</td>
                                <td>总人数</td>
                                <td>班级数</td>
                                <td>实验工作量</td>
                                <td>准备工作量</td>
                                <td>总工作量</td>
                                <td>扣除准备工作量</td>
                                <td>教师姓名</td>
                                <td>工作量</td>
                            </tr>
                            <c:set var="wid" value="0"/>
                            <c:set var="totalLabWorkload" value="0"/>
                            <c:set var="totalPreWorkload" value="0"/>
                            <c:set var="totalWorkload" value="0"/>
                            <c:set var="totalDeductPreWorkload" value="0"/>
                            <c:forEach items="${workloads}" var="workload">
                                <c:set var="totalLabWorkload" value="${totalLabWorkload+workload.labWorkload}"/>
                                <c:set var="totalPreWorkload" value="${totalPreWorkload+workload.preWorkload}"/>
                                <c:set var="totalWorkload" value="${totalWorkload+workload.totalWorkload}"/>
                                <c:set var="totalDeductPreWorkload" value="${totalDeductPreWorkload+workload.deductPreWorkload}"/>
                                <c:forEach items="${workload.items}" var="item">
                                    <tr>
                                        <c:if test="${workload.id!=wid}">
                                            <td rowspan="${workload.items.size()}">${workload.term}</td>
                                            <td rowspan="${workload.items.size()}" class="text-left" title="课程号：${workload.course.cno} 课程性质：${workload.course.property}">${workload.course.cname}</td>
                                            <td rowspan="${workload.items.size()}">${workload.workloadType}</td>
                                            <td rowspan="${workload.items.size()}">${workload.course.expperiod} H</td>
                                            <td rowspan="${workload.items.size()}">${workload.stuNumbers}</td>
                                            <td rowspan="${workload.items.size()}" title="${workload.classes}">${workload.classNumbers}</td>
                                            <td rowspan="${workload.items.size()}">${workload.labWorkload} H</td>
                                            <td rowspan="${workload.items.size()}">${workload.preWorkload} H</td>
                                            <td rowspan="${workload.items.size()}">${workload.totalWorkload} H</td>
                                            <td rowspan="${workload.items.size()}">${workload.deductPreWorkload} H</td>
                                        </c:if>
                                        <td title="${item.teacherSn}">${item.teacher.userName}</td>
                                        <td>${item.teacherWorkload} H</td>
                                        <c:set var="wid" value="${workload.id}"/>
                                    </tr>
                                </c:forEach>
                            </c:forEach>
                            <tr>
                                <td colspan="6">工作量汇总：</td>
                                <td><span class="badge bg-yellow"><fmt:formatNumber type="number" value="${totalLabWorkload}" pattern="#0.00"/> H</span></td>
                                <td><span class="badge bg-yellow"><fmt:formatNumber type="number" value="${totalPreWorkload}" pattern="#0.00"/> H</span></td>
                                <td><span class="badge bg-yellow"><fmt:formatNumber type="number" value="${totalWorkload}" pattern="#0.00"/> H</span></td>
                                <td><span class="badge bg-yellow"><fmt:formatNumber type="number" value="${totalDeductPreWorkload}" pattern="#0.00"/> H</span></td>
                                <td colspan="2"></td>
                            </tr>

                        </table>
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
