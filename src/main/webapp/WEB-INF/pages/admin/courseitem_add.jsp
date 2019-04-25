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
    <li><a href="${ctx}/manage/course/list" id="a_leader_txt">实验课程管理</a></li>
</ul>
<div class="admin">
    <div class="line padding-big">
        <div class="panel admin-panel">
            <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>添加实验项目</strong></div>
            <div class="body-content margin-big-left margin-big-right">
                <form:form method="post" action="${ctx}/manage/courseitem/add" modelAttribute="courseitem" id="addForm" name="addForm">
                    <input type="hidden" name="cid" value="${course.id}"/>
                    <div class="margin-big-bottom">所属课程：${course.cname}</div>
                    <div class="form-group">
                        <div class="label">
                            <label for="itemname">实验项目名称：</label>
                        </div>
                        <div class="field">
                            <form:input path="itemname" class="input" placeholder="实验项目名称..." data-validate="required:请输入实验项目名称"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label for="expdemand">实验项目要求：</label>
                        </div>
                        <div class="field">
                            <form:select class="input" path="expdemand" items="${expdemandList}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label for="expperiod">实验学时：</label>
                        </div>
                        <div class="field">
                            <form:input path="expperiod" class="input" placeholder="实验学时..." data-validate="required:请输入实验学时,plusinteger:实验学时数只能为正整数"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label for="exptype">实验项目类型：</label>
                        </div>
                        <div class="field">
                            <form:select class="input" path="exptype" items="${exptypeList}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label for="content">实验内容：</label>
                        </div>
                        <div class="field">
                            <div class="button-group radio">
                                <form:textarea path="content" style="width:100%;height:400px;visibility:hidden;" placeholder="大纲内容..."></form:textarea>
                            </div>
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
<link rel="stylesheet" href="${ctx}/editor/themes/default/default.css" />
<link rel="stylesheet" href="${ctx}/editor/plugins/code/prettify.css" />
<script charset="utf-8" src="${ctx}/editor/kindeditor-min.js"></script>
<script charset="utf-8" src="${ctx}/editor/lang/zh_CN.js"></script>
<script charset="utf-8" src="${ctx}/editor/plugins/code/prettify.js"></script>
<script>
    KindEditor.ready(function(K) {
        var editor1 = K.create('textarea[name="content"]', {
            cssPath: '${ctx}/editor/plugins/code/prettify.css',
            uploadJson: '${ctx}/editor/jsp/upload_json.jsp',
            fileManagerJson: '${ctx}/editor/jsp/file_manager_json.jsp',
            allowFileManager: true
        });
        prettyPrint();
    });
</script>
</body>
</html>
