<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <li><a href="${ctx}/manage/practice/workload/list" id="a_leader_txt">实践工作量管理</a></li>
</ul>
<div class="admin">
    <div class="line">
        <div class="panel admin-panel">
            <div class="panel-head"><strong class="icon-reorder"> 实践工作量管理</strong></div>
            <div class="panel-body">
                <div class="padding-bottom border-bottom">
                    <form:form action="${ctx}/manage/practice/workload/list" modelAttribute="workloadForm">
                        <ul class="search" style="padding-left:10px;">
                            <li>
                                <div class="button-group">
                                    <button type="button" class="button border-green"
                                            onclick="javascript:window.location.href='${ctx}/manage/practice/workload/list';"><span
                                            class="icon-refresh"></span> 刷新数据
                                    </button>
                                    <button type="button" class="button border-main"
                                            onclick="javascript:window.location.href='${ctx}/manage/practice/workload/to_add';"><span
                                            class="icon-plus"></span> 添加工作量
                                    </button>
                                    <button type="button" class="button border-red" id="delete_all"><span
                                            class="icon-trash-o"></span> 批量删除
                                    </button>
                                    <button type="button" class="button border-main" id="exportWorkload"><span
                                            class="icon-arrow-circle-o-down"></span> 导出工作量
                                    </button>
                                </div>
                            </li>
                            <li>
                                <form:select path="term" items="${terms}" cssClass="input" cssStyle="line-height:17px;"/>
                            </li>
                            <li>
                                <form:select path="workloadType" items="${workloadTypes}" cssClass="input" cssStyle="line-height:17px;"/>
                            </li>
                            <li>
                                <form:select path="type" cssClass="input" cssStyle="line-height:17px;">
                                    <form:option value="cno">课编号</form:option>
                                    <form:option value="cname">课程名称</form:option>
                                </form:select>
                            </li>
                            <li>
                                <form:input path="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" placeholder="请输入搜索关键字"/>
                                <button type="submit" class="button border-main icon-search"> 搜索</button>
                            </li>
                        </ul>
                    </form:form>
                </div>
                <table class="table table-bordered text-center">
                    <tr>
                        <td><input type="checkbox" id="check_all"/></td>
                        <td>学期</td>
                        <td class="text-left">课程名称</td>
                        <td>工作量类型</td>
                        <td>实践类型</td>
                        <td>工作量性质</td>
                        <td>周数</td>
                        <td>人数</td>
                        <td>班级数</td>
                        <td>总工作量</td>
                        <td>准备工作量</td>
                        <td>教师姓名</td>
                        <td>工作量</td>
                        <td>操作</td>
                    </tr>
                    <c:set var="wid" value="0"/>
                    <c:set var="totalWorkload" value="0"/>
                    <c:set var="totalPreWorkload" value="0"/>
                    <c:forEach items="${workloads}" var="workload">
                        <c:set var="totalWorkload" value="${totalWorkload+workload.totalWorkload}"/>
                        <c:set var="totalPreWorkload" value="${totalPreWorkload+workload.preWorkload}"/>
                        <c:forEach items="${workload.items}" var="item">
                            <tr>
                                <c:if test="${workload.id!=wid}">
                                    <td rowspan="${workload.items.size()}"><input type="checkbox" class="check_item" value="${workload.id}"></td>
                                    <td rowspan="${workload.items.size()}">${workload.term}</td>
                                    <td rowspan="${workload.items.size()}" class="text-left" title="课程号：${workload.course.cno} 课程性质：${workload.course.property}">${workload.course.cname}</td>
                                    <td rowspan="${workload.items.size()}">${workload.workloadType}</td>
                                    <td rowspan="${workload.items.size()}">${workload.practiceType}</td>
                                    <td rowspan="${workload.items.size()}">${workload.workloadProperty}</td>
                                    <td rowspan="${workload.items.size()}">${workload.weekNumbers}</td>
                                    <td rowspan="${workload.items.size()}">${workload.stuNumbers}</td>
                                    <td rowspan="${workload.items.size()}">${workload.classNumbers}</td>
                                    <td rowspan="${workload.items.size()}">${workload.totalWorkload}</td>
                                    <td rowspan="${workload.items.size()}">${workload.preWorkload}</td>
                                </c:if>
                                <td title="${item.teacherSn}">${item.teacher.userName}</td>
                                <td>${item.teacherWorkload}</td>
                                <c:if test="${workload.id!=wid}">
                                    <td rowspan="${workload.items.size()}">
                                        <a href="${ctx}/manage/practice/workload/to_update?id=${workload.id}">编辑</a>
                                        <a href="${ctx}/manage/practice/workload/remove?id=${workload.id}" onclick="return conf();">删除</a>
                                    </td>
                                </c:if>
                                <c:set var="wid" value="${workload.id}"/>
                            </tr>
                        </c:forEach>
                    </c:forEach>
                    <tr>
                        <td colspan="9">工作量汇总：</td>
                        <td><fmt:formatNumber type="number" value="${totalWorkload}" pattern="#0.00"/></td>
                        <td><fmt:formatNumber type="number" value="${totalPreWorkload}" pattern="#0.00"/></td>
                        <td colspan="3"></td>
                    </tr>

                </table>
            </div>
        </div>
    </div>
</div>
<jsp:include page="admin_bottom.jsp"/>
<script>
    //完成全选/全不选功能
    $("#check_all").click(function () {
        //attr获取checked是undefined;
        //我们这些dom原生的属性；attr获取自定义属性的值；
        //prop修改和读取dom原生属性的值
        $(".check_item").prop("checked", $(this).prop("checked"));
    });

    //check_item
    $(document).on("click", ".check_item", function () {
        //判断当前选择中的元素是否5个
        var flag = $(".check_item:checked").length == $(".check_item").length;
        $("#check_all").prop("checked", flag);
    });

    //点击全部删除，就批量删除
    $("#delete_all").click(function () {
        if ($(".check_item:checked").length === 0) {
            alert("请选择要删除的数据!");
            return;
        }
        var del_ids = "";
        $.each($(".check_item:checked"), function () {
            //this
            //组装id字符串
            del_ids += $(this).val() + ",";
        });
        //去除del_ids多余的,
        del_ids = del_ids.substring(0, del_ids.length - 1);
        if (confirm("确认删除这些记录吗？")) {
            window.location.href = "${ctx}/manage/practice/workload/remove?id=" + del_ids;
        }
    });
    $("#exportWorkload").click(function () {
        var term = $("#term").val();
        var workloadType = $("#workloadType").val();
        if (confirm("确定要导出记录吗？")) {
            window.location.href = "${ctx}/manage/practice/workload/export?term="+term+"&workloadType="+workloadType;
        }
    });
</script>
</body>
</html>
