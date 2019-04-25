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
    <li><a href="${ctx}/manage/user/list" id="a_leader_txt">教工管理</a></li>
</ul>
<div class="admin">
    <div class="line padding-big">
        <div class="panel admin-panel">
            <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改员工</strong></div>
            <div class="body-content margin-big-left margin-big-right">
                <form:form method="post" action="${ctx}/manage/user/update" modelAttribute="user" id="updateForm" name="updateForm"
                           enctype="multipart/form-data" onsubmit="return checksubmit();">
                    <div class="form-group">
                        <div class="label">
                            <label for="sn">教工编号：</label>
                        </div>
                        <div class="field">
                            <form:input path="sn" class="input" placeholder="请输入教工编号..." readonly="true"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label for="userName">教工姓名：</label>
                        </div>
                        <div class="field">
                            <form:input path="userName" class="input" placeholder="请输入教工姓名..."
                                        data-validate="required:请输入教工姓名,chinese:请输入真实姓名"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label>性别：</label>
                        </div>
                        <div class="field">
                            <div class="button-group radio">
                                <c:if test="${user.sex=='男'}">
                                    <label class="button active">
                                        <input name="sex" type="radio" value="男" checked="checked"/><span
                                            class="icon icon-male"></span> 男
                                    </label>
                                    <label class="button">
                                        <input name="sex" type="radio" value="女"/><span class="icon icon-female"></span> 女
                                    </label>
                                </c:if>
                                <c:if test="${user.sex=='女'}">
                                    <label class="button">
                                        <input name="sex" type="radio" value="男"/><span
                                            class="icon icon-male"></span> 男
                                    </label>
                                    <label class="button active">
                                        <input name="sex" type="radio" value="女" checked="checked"/><span class="icon icon-female"></span> 女
                                    </label>
                                </c:if>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label for="technical">职称：</label>
                        </div>
                        <div class="field">
                            <form:select path="technical" items="${technicalList}" class="input"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label for="type">教师类别：</label>
                        </div>
                        <div class="field">
                            <form:select path="type" items="${typeList}" class="input"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label for="role">角色：</label>
                        </div>
                        <div class="field">
                            <form:select path="role" class="input">
                                <form:option value="0">角色：普通用户</form:option>
                                <form:option value="1">角色：系统管理员</form:option>
                            </form:select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label for="birthday">出生日期：</label>
                        </div>
                        <div class="field">
                            <div class="c-datepicker-date-editor c-datepicker-single-editor J-datepicker-day mt10">
                                <i class="icon-clock-o"></i>
                                <form:input type="text" autocomplete="off" path="birthday"  placeholder="请选择出生日期..." class=" c-datepicker-data-input only-date" readonly="readonly" data-validate="required:请选择出生日期"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label for="phone">电话号码：</label>
                        </div>
                        <div class="field">
                            <form:input path="phone" class="input" placeholder="请输入电话号码(可选)..."/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label for="email">电子邮件：</label>
                        </div>
                        <div class="field">
                            <form:input path="email" class="input" placeholder="请输入电子邮件(可选)..." data-validate="email:请输入正确的电子邮件"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label>照片：</label>
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
                            <img alt="" height="150" width="150" id="showPhoto" class="img-border radius"/>
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
        //年月日单个
        $('.J-datepicker-day').datePicker({
            format:'YYYY-MM-DD'
        });
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
            if (image.files[0].size > 1024000) {
                alert("图片尺寸大于1M，请重新选择");
                return false;
            }
        }
        return true;
    }
</script>
</body>
</html>
