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
    <li><a href="${ctx}/manage/labinfo/list" id="a_leader_txt">实验室信息内容管理</a></li>
</ul>
<div class="admin">
    <div class="line padding-big">
        <div class="panel admin-panel">
            <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>添加实验室信息内容</strong></div>
            <div class="body-content margin-big-left margin-big-right">
                <form:form method="post" action="${ctx}/manage/labinfo/add" modelAttribute="labInfo" id="addForm" name="addForm" >
                    <div class="form-group">
                        <div class="label">
                            <label for="title">内容标题：</label>
                        </div>
                        <div class="field">
                            <form:input path="title" class="input" placeholder="内容标题..." data-validate="required:请输入内容标题"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label for="content">实验室信息内容：</label>
                        </div>
                        <div class="field">
                            <div class="button-group radio">
                                <form:textarea path="content" style="width:100%;height:400px;visibility:hidden;" placeholder="实验室信息内容..."></form:textarea>
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
