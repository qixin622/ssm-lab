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
            <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改课程</strong></div>
            <div class="body-content margin-big-left margin-big-right">
                <form:form method="post" action="${ctx}/manage/course/update" modelAttribute="course" id="updateForm" name="updateForm" enctype="multipart/form-data" onsubmit="return checksubmit()">
                    <form:hidden path="id"/>
                    <div class="form-group">
                        <div class="label">
                            <label for="cno">课程编号：</label>
                        </div>
                        <div class="field">
                            <form:input path="cno" class="input" placeholder="课程编号..." data-validate="required:请输入实验课程编号,number:课程编号只能是数字"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label for="cname">课程名称：</label>
                        </div>
                        <div class="field">
                            <form:input path="cname" class="input" placeholder="课程名称..." data-validate="required:请输入实验课程名称"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label for="property">课程性质：</label>
                        </div>
                        <div class="field">
                            <form:select class="input" path="property" items="${propertyList}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label for="precourse">先修课程：</label>
                        </div>
                        <div class="field">
                            <form:input path="precourse" class="input" placeholder="先修课程..."/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label for="totalperiod">总学时数：</label>
                        </div>
                        <div class="field">
                            <form:input path="totalperiod" class="input" placeholder="总学时数..." data-validate="required:请输入总学时数,plusinteger:总学时数只能为正整数"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label for="credit">学分：</label>
                        </div>
                        <div class="field">
                            <form:input path="credit" class="input" placeholder="学分..." data-validate="required:请输入学分"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label for="theperiod">理论学时：</label>
                        </div>
                        <div class="field">
                            <form:input path="theperiod" class="input" placeholder="理论学时..." data-validate="required:请输入理论学时,plusinteger:理论学时数只能为正整数"/>
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
                            <label for="level">适合层次：</label>
                        </div>
                        <div class="field">
                            <form:input path="level" class="input" placeholder="适合层次..." data-validate="required:请输入适合层次" value="本科"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label for="specialty">适合专业：</label>
                        </div>
                        <div class="field">
                            <form:input path="specialty" class="input" placeholder="适合专业..." data-validate="required:请输入适合专业"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label for="content">大纲内容：</label>
                        </div>
                        <div class="field">
                            <div class="button-group radio">
                                <form:textarea path="content" style="width:100%;height:400px;visibility:hidden;" placeholder="大纲内容..."></form:textarea>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label>上传大纲：</label>
                        </div>
                        <div class="field">
                            <a class="button bg-blue input-file" href="javascript:void(0);">+ 请选择上传文件
                                <input data-validate="regexp#.+.(doc|docx|pdf)$:只能上传doc|docx|pdf格式文件"
                                       type="file" id="dlurlFile" name="dlurlFile" onchange="upload(this)"/></a>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label>上传实验指导书：</label>
                        </div>
                        <div class="field">
                            <a class="button bg-blue input-file" href="javascript:void(0);">+ 请选择上传文件
                                <input data-validate="regexp#.+.(doc|docx|pdf)$:只能上传doc|docx|pdf格式文件"
                                       type="file" id="bookurlFile" name="bookurlFile" onchange="upload(this)"/></a>
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

    var dlurlFile = document.getElementById("dlurlFile");
    var bookurlFile = document.getElementById("dlurlFile");

    function checksubmit() {
        if (!dlurlFile.files[0]) {
            return true;
        } else {
            if (dlurlFile.files[0].size > 1024000*50) {
                alert("大纲文件大于50M，请重新选择!");
                return false;
            }
        }
        if (!bookurlFile.files[0]) {
            return true;
        } else {
            if (bookurlFile.files[0].size > 1024000*50) {
                alert("实验指导书文件大于50M，请重新选择!");
                return false;
            }
        }
        return true;
    }
</script>
</body>
</html>
