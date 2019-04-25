<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <jsp:include page="admin_head.jsp"/>
    <link rel="stylesheet" href="${ctx}/plugins/datepicker/css/datepicker.css">
</head>
<body style="background-color:#f2f9fd;">
<jsp:include page="admin_top_left.jsp"/>
<ul class="bread">
    <li><a href="${ctx}/manage/home" target="right" class="icon-home"> 首页</a></li>
    <li><a href="${ctx}/manage/workrecord/list" id="a_leader_txt">工作内容记录管理</a></li>
</ul>
<div class="admin">
    <div class="line padding-big">
        <div class="panel admin-panel">
            <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改工作内容信息</strong></div>
            <div class="body-content margin-big-left margin-big-right">
                <form:form method="post" action="${ctx}/manage/workrecord/update" modelAttribute="record" id="updateForm" name="updateForm">
                    <form:hidden path="id"/>
                    <div class="form-group">
                        <div class="label">
                            <label for="createTime">记录时间：</label>
                        </div>
                        <div class="field">
                            <div class="c-datepicker-date-editor c-datepicker-single-editor J-datepickerTime-single mt10">
                                <i class="icon-clock-o"></i>
                                <form:input type="text" autocomplete="off" path="createTime" placeholder="选择记录时间..." cssClass=" c-datepicker-data-input" data-validate="required:请选择记录时间"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label for="content">工作内容：</label>
                        </div>
                        <div class="field">
                            <form:textarea path="content" class="input" placeholder="工作内容（最多100个字）..." data-validate="required:请输入工作内容"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field">
                            <button class="button bg-main icon-check-square-o" type="submit">提交</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="admin_bottom.jsp"/>
<script src="${ctx}/plugins/datepicker/js/plugins/moment.min.js"></script>
<script src="${ctx}/plugins/datepicker/js/datepicker.all.js"></script>
<script>
    $(function(){
        //十分年月日单个
        $('.J-datepickerTime-single').datePicker({
            format: 'YYYY-MM-DD HH:mm'
        });
    });
</script>
</body>
</html>
