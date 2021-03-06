<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <li><a href="${ctx}/manage/experiment/workload/list" id="a_leader_txt">实验工作量管理</a></li>
</ul>
<div class="admin">
    <div class="line padding-big">
        <form:form method="post" action="${ctx}/manage/experiment/workload/update" modelAttribute="info" id="updateForm"
                   name="updateForm">
            <form:hidden path="workload.id"/>
            <div class="panel admin-panel">
                <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改实验工作量</strong>
                </div>
                <div class="body-content margin-big-left margin-big-right">
                    <div class="line">
                        <div class="xs6 xm2 xb2">
                            <div class="form-group">
                                <div class="label">
                                    <label for="workload.term">学期：</label>
                                </div>
                                <div class="field">
                                    <form:input path="workload.term" cssClass="input" list="terms" data-validate="required:请输入或选择学期"/>
                                    <datalist id="terms" style="display:none;">
                                        <c:forEach items="${terms}" var="term">
                                            <option value="${term}">${term}</option>
                                        </c:forEach>
                                    </datalist>
                                </div>
                            </div>
                        </div>
                        <div class="xs6 xm1 xb1">
                            <div class="form-group margin-left">
                                <div class="label">
                                    <label for="workload.workloadType">类型：</label>
                                </div>
                                <div class="field">
                                    <form:select class="input" path="workload.workloadType" items="${workloadTypes}"/>
                                </div>
                            </div>
                        </div>
                        <div class="xs6 xm5 xb5">
                            <div class="form-group margin-left">
                                <div class="label">
                                    <label for="workload.cid">课程：</label>
                                </div>
                                <div class="field">
                                    <select id="workload.cid" name="workload.cid"  class="input" onchange="addExpperiod()">
                                        <c:forEach items="${courses}" var="course">
                                            <c:if test="${info.workload.cid==course.id}">
                                                <option value="${course.id}" period="${course.expperiod}" selected="selected">课程号:${course.cno}
                                                    课程名:${course.cname} 实验学时:${course.expperiod}</option>
                                            </c:if>
                                            <c:if test="${info.workload.cid!=course.id}">
                                                <option value="${course.id}" period="${course.expperiod}">课程号:${course.cno}
                                                    课程名:${course.cname} 实验学时:${course.expperiod}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="xs6 xm4 xb4">
                            <div class="form-group margin-left">
                                <div class="label">
                                    <label for="workload.classes">班级：</label>
                                </div>
                                <div class="field">
                                    <form:input class="input" path="workload.classes" placeholder="请输入班级信息..." data-validate="required:请输入班级信息"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="line">
                        <div class="xs6 xm1 xb1">
                            <div class="form-group">
                                <div class="label">
                                    <label for="expperiod">实验学时：</label>
                                </div>
                                <div class="field">
                                    <input class="input" id="expperiod" name="expperiod"
                                           data-validate="required:请输入实验学时"/>
                                </div>
                            </div>
                        </div>
                        <div class="xs6 xm1 xb1">
                            <div class="form-group margin-left">
                                <div class="label">
                                    <label for="workload.stuNumbers">总人数：</label>
                                </div>
                                <div class="field">
                                    <form:input class="input" path="workload.stuNumbers"
                                                data-validate="required:请输入总人数"/>
                                </div>
                            </div>
                        </div>
                        <div class="xs6 xm1 xb1">
                            <div class="form-group margin-left">
                                <div class="label">
                                    <label for="workload.classNumbers">班级数：</label>
                                </div>
                                <div class="field">
                                    <form:input class="input" path="workload.classNumbers"/>
                                </div>
                            </div>
                        </div>
                        <div class="xs6 xm2 xb2">
                            <div class="form-group margin-left">
                                <div class="label">
                                    <label for="workload.labWorkload">实验工作量：</label>
                                </div>
                                <div class="field">
                                    <form:input class="input" path="workload.labWorkload"/>
                                </div>
                            </div>
                        </div>
                        <div class="xs6 xm2 xb2">
                            <div class="form-group margin-left">
                                <div class="label">
                                    <label for="workload.preWorkload">准备工作量：</label>
                                </div>
                                <div class="field">
                                    <form:input class="input" path="workload.preWorkload"/>
                                </div>
                            </div>
                        </div>
                        <div class="xs6 xm1 xb1">
                            <div class="form-group margin-left">
                                <div class="label">
                                    <label for="workload.totalWorkload">总工作量：</label>
                                </div>
                                <div class="field">
                                    <form:input class="input" path="workload.totalWorkload"/>
                                </div>
                            </div>
                        </div>
                        <div class="xs6 xm2 xb2">
                            <div class="form-group margin-left">
                                <div class="label">
                                    <label for="workload.deductPreWorkloadRate">扣除比例(%)：</label>
                                </div>
                                <div class="field">
                                    <form:input cssClass="input rate" path="workload.deductPreWorkloadRate"/>
                                </div>
                            </div>
                        </div>
                        <div class="xs6 xm2 xb2">
                            <div class="form-group margin-left">
                                <div class="label">
                                    <label for="workload.deductPreWorkload">扣除准备工作量：</label>
                                </div>
                                <div class="field">
                                    <form:input cssClass="input workload" path="workload.deductPreWorkload"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="items">
                        <c:forEach items="${info.items}" var="item" varStatus="sta">
                        <div class="line">
                            <div class="xs6 xm4 xb4">
                                <div class="form-group">
                                    <div class="label">
                                        <label for="items[${sta.index}].teacherSn">实验教师：</label>
                                    </div>
                                    <div class="field">
                                        <form:hidden path="items[${sta.index}].id"/>
                                        <form:hidden path="items[${sta.index}].experimentWorkloadId"/>
                                        <input id="items[${sta.index}].teacherSn" name="items[${sta.index}].teacherSn" value="${item.teacherSn} ${item.teacher.userName}" class="input" list="teachers">
                                        <datalist id="teachers">
                                            <c:forEach items="${users}" var="user">
                                                <option value="${user.sn} ${user.userName}"></option>
                                            </c:forEach>
                                        </datalist>
                                    </div>
                                </div>
                            </div>
                            <div class="xs6 xm3 xb3">
                                <div class="form-group margin-left">
                                    <div class="label">
                                        <label for="items[${sta.index}].teacherWorkloadRate">承担比例(%)：</label>
                                    </div>
                                    <div class="field">
                                        <form:input cssClass="input rate" path="items[${sta.index}].teacherWorkloadRate"/>
                                    </div>
                                </div>
                            </div>
                            <div class="xs6 xm3 xb3">
                                <div class="form-group margin-left">
                                    <div class="label">
                                        <label for="items[${sta.index}].teacherWorkload">承担工作量：</label>
                                    </div>
                                    <div class="field">
                                        <form:input cssClass="input workload" path="items[${sta.index}].teacherWorkload"/>
                                    </div>
                                </div>
                            </div>
                            <div class="xs6 xm2 xb2">
                                <div class="form-group margin-left padding-large-top">
                                    <button type="button" class="button border-main"><span class="icon-minus"></span></button>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                    <div class="line">
                        <div class="xs6 xm2 xb2">
                            <div class="form-group">
                                <div class="label">
                                    <label for="totalWorkload">核对总工作量：</label>
                                </div>
                                <div class="field">
                                    <input class="input" id="totalWorkload" value="0" readonly="true"/>
                                </div>
                            </div>
                        </div>
                        <div class="xs6 xm8 xb8"></div>
                        <div class="xs6 xm2 xb2">
                            <div class="form-group margin-left">
                                <div class="label" style="height: 30px;">
                                    <label for="addItemButton">  </label>
                                </div>
                                <div class="field">
                                    <button type="button" class="button border-main" id="addItemButton"><span class="icon-plus"></span></button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-foot text-right">
                    <button class="button bg-main icon-reply" type="button" onclick="javascript:window.history.go(-1);"> 返回</button>
                    <button class="button bg-main icon-check-square-o" type="submit" onclick="return validate_add_form();"> 提交</button>
                </div>
            </div>
        </form:form>
    </div>
</div>
<jsp:include page="admin_bottom.jsp"/>
<script src="${ctx}/js/experiment_items.js"></script>
</body>
</html>
