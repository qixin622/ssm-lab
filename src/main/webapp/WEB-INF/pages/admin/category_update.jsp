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
    <li><a href="${ctx}/manage/category/list" id="a_leader_txt">分类管理</a></li>
</ul>
<div class="admin">
    <div class="line padding-big">
        <div class="panel admin-panel">
            <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改分类</strong></div>
            <div class="body-content margin-big-left margin-big-right">
                <form:form method="post" action="${ctx}/manage/category/update" modelAttribute="category" id="updateForm" name="updateForm">
                    <form:hidden path="cid"/>
                    <div class="form-group">
                        <div class="label">
                            <label for="categoryName">分类名称：</label>
                        </div>
                        <div class="field">
                            <form:input path="categoryName" class="input" placeholder="请输入分类名称..." data-validate="required:请输入分类名称"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label for="description">分类描述：</label>
                        </div>
                        <div class="field">
                            <form:textarea path="description" class="input" placeholder="请输入分类描述..."/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label for="authority">访问权限：</label>
                        </div>
                        <div class="field">
                            <form:select path="authority" class="input">
                                <form:option value="0">公开</form:option>
                                <form:option value="1">私密</form:option>
                            </form:select>
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
</body>
</html>
