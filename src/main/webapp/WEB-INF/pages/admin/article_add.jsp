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
    <li><a href="${ctx}/manage/article/list" id="a_leader_txt">文章内容管理</a></li>
</ul>
<div class="admin">
    <div class="line padding-big">
        <div class="panel admin-panel">
            <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>添加文章</strong></div>
            <div class="body-content margin-big-left margin-big-right">
                <form:form method="post" action="${ctx}/manage/article/add" modelAttribute="article" id="addForm" name="addForm" enctype="multipart/form-data" onsubmit="return checksubmit()">
                    <div class="form-group">
                        <div class="label">
                            <label for="categoryId">所属分类：</label>
                        </div>
                        <div class="field">
                            <form:select class="input" path="categoryId" items="${categoryList}" itemLabel="categoryName" itemValue="cid" placeholder="所属分类..."/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label for="title">文章标题：</label>
                        </div>
                        <div class="field">
                            <form:input path="title" class="input" placeholder="文章标题..." data-validate="required:请输入文章标题"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label for="content">文章内容：</label>
                        </div>
                        <div class="field">
                            <div class="button-group radio">
                                <form:textarea path="content" style="width:100%;height:400px;visibility:hidden;" placeholder="文章内容..."></form:textarea>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label>文章配图：</label>
                        </div>
                        <div class="field">
                            <a class="button bg-blue input-file" href="javascript:void(0);">+ 请选择上传文件
                                <input data-validate="regexp#.+.(jpg|jpeg|png|gif)$:只能上传jpg|gif|png格式文件"
                                       type="file" id="image" name="image" onchange="upload(this)"/></a>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label>照片预览：</label>
                        </div>
                        <div class="field">
                            <img alt="" height="150" width="263" id="showPhoto" class="img-border radius"/>
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
    var showPhoto = document.getElementById("showPhoto");
    var image = document.getElementById("image");

    function upload(obj) {
        showPhoto.src = window.URL.createObjectURL(obj.files[0]);
    }

    function checksubmit() {
        if (!image.files[0]) {
            return true;
        } else {
            if (image.files[0].size > 1024000*5) {
                alert("图片尺寸大于5M，请重新选择");
                return false;
            }
        }
        return true;
    }
</script>
</body>
</html>
