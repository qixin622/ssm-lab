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
                    <h1 class="text-main text-center icon-calendar">工作量汇总列表</h1>
                    <div class="line text-center margin-big-top margin-bottom">
                        <form:form action="${ctx}/summary/workload/list" modelAttribute="workloadForm" cssClass="form-x form-inline">
                            <form:select path="term" items="${terms}" cssClass="input" />
                            <form:select path="workloadType" items="${workloadTypes}" cssClass="input"/>
                            <form:select path="type" cssClass="input">
                                <form:option value="username">教师姓名</form:option>
                                <form:option value="sn">教师编号</form:option>
                            </form:select>
                            <form:input path="keywords" class="input" placeholder="请输入搜索关键字"/>
                            <button type="submit" class="button border-main icon-search"> 搜索</button>
                            <button type="button" class="button border-green"
                                    onclick="javascript:window.location.href='${ctx}/summary/workload/list';"><span
                                    class="icon-refresh"></span> 重置
                            </button>
                        </form:form>
                    </div>
                </div>
                <div class="panel-body">
                    <c:set var="totalWorkload" value="0"/>
                    <c:set var="totalExperimentWorkload" value="0"/>
                    <c:set var="totalPracticeWorkload" value="0"/>
                    <div class="table-responsive">
                        <table class="table table-bordered text-center">
                            <tr>
                                <td colspan="7">实验工作量</td>
                            </tr>
                            <tr>
                                <td>学期</td>
                                <td>类型</td>
                                <td>课程编号</td>
                                <td>课程名称</td>
                                <td>教师编号</td>
                                <td>教师姓名</td>
                                <td>工作量</td>
                            </tr>
                            <c:forEach items="${experimentWorkloads}" var="workload">
                                <tr>
                                    <td>${workload.term}</td>
                                    <td>${workload.workloadType}</td>
                                    <td>${workload.cno}</td>
                                    <td>${workload.cname}</td>
                                    <td>${workload.teacherSn}</td>
                                    <td>${workload.userName}</td>
                                    <td>${workload.teacherWorkload} H</td>
                                    <c:set var="totalExperimentWorkload" value="${totalExperimentWorkload+workload.teacherWorkload}"/>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td colspan="6" class="text-right">工作量汇总：</td>
                                <td><span class="badge bg-yellow"><fmt:formatNumber type="number" value="${totalExperimentWorkload}" pattern="#0.00"/> H</span></td>
                            </tr>
                            <tr>
                                <td colspan="7">实践工作量</td>
                            </tr>
                            <tr>
                                <td>学期</td>
                                <td>类型</td>
                                <td>课程编号</td>
                                <td>课程名称</td>
                                <td>教师编号</td>
                                <td>教师姓名</td>
                                <td>工作量</td>
                            </tr>
                            <c:forEach items="${practiceWorkloads}" var="workload">
                                <tr>
                                    <td>${workload.term}</td>
                                    <td>${workload.workloadType}</td>
                                    <td>${workload.cno}</td>
                                    <td>${workload.cname}</td>
                                    <td>${workload.teacherSn}</td>
                                    <td>${workload.userName}</td>
                                    <td>${workload.teacherWorkload} H</td>
                                    <c:set var="totalPracticeWorkload" value="${totalPracticeWorkload+workload.teacherWorkload}"/>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td colspan="6" class="text-right">工作量汇总：</td>
                                <td><span class="badge bg-yellow"><fmt:formatNumber type="number" value="${totalPracticeWorkload}" pattern="#0.00"/> H</span></td>
                            </tr>
                            <tr>
                                <c:set var="totalWorkload" value="${totalWorkload+totalExperimentWorkload+totalPracticeWorkload}"/>
                                <td colspan="6" class="text-right">工作量总计：</td>
                                <td><span class="badge bg-yellow"><fmt:formatNumber type="number" value="${totalWorkload}" pattern="#0.00"/> H</span></td>
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
