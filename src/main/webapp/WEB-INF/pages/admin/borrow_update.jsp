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
    <li><a href="${ctx}/manage/borrow/list" id="a_leader_txt">物品借出/归还管理</a></li>
</ul>
<div class="admin">
    <div class="line padding-big">
        <div class="panel admin-panel">
            <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改借出信息</strong></div>
            <div class="body-content margin-big-left margin-big-right">
                <form:form method="post" action="${ctx}/manage/borrow/update" modelAttribute="borrow" id="updateForm" name="updateForm">
                    <form:hidden path="id"/>
                    <div class="form-group">
                        <div class="label">
                            <label for="name">借用物品名称：</label>
                        </div>
                        <div class="field">
                            <form:input path="name" class="input" placeholder="借用物品名称..." data-validate="required:请输入借用物品名称"/>
                        </div>
                    </div>
                    <div class="line">
                        <div class="xs6 xm3 xb3">
                            <div class="form-group">
                                <div class="label">
                                    <label for="num">借用物品数量：</label>
                                </div>
                                <div class="field">
                                    <form:input path="num" class="input" placeholder="借用物品数量..." data-validate="required:请输入借用物品数量,number:请输入数字"/>
                                </div>
                            </div>
                        </div>
                        <div class="xs6 xm3 xb3">
                            <div class="form-group margin-left">
                                <div class="label">
                                    <label for="unit">单位：</label>
                                </div>
                                <div class="field">
                                    <form:select path="unit" class="input">
                                        <form:option value="把">把</form:option>
                                        <form:option value="台">台</form:option>
                                        <form:option value="个">个</form:option>
                                        <form:option value="只">只</form:option>
                                        <form:option value="套">套</form:option>
                                    </form:select>
                                </div>
                            </div>
                        </div>
                        <div class="xs6 xm3 xb3">
                            <div class="form-group margin-left">
                                <div class="label">
                                    <label for="borrowSn">借用人：</label>
                                </div>
                                <div class="field">
                                    <input id="borrowSn" name="borrowSn" value="${borrow.borrowSn} ${borrow.borrower.userName}" class="input" list="teachers">
                                    <datalist id="teachers">
                                        <c:forEach items="${userList}" var="user">
                                            <option value="${user.sn} ${user.userName}"></option>
                                        </c:forEach>
                                    </datalist>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label for="remarks">备注：</label>
                        </div>
                        <div class="field">
                            <div class="button-group radio">
                                <form:textarea path="remarks" style="width:700px;height:200px;" placeholder="备注信息..."></form:textarea>
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
</body>
</html>
