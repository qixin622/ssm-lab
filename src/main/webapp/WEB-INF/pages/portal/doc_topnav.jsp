<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="layout bg-main bg-inverse" >
    <div class="container padding">
        <div class="line height-big">
            <div class="x6">
                欢迎光临实验室教学信息管理系统
            </div>
            <div class="x6 text-right">
                <c:if test="${empty sessionScope.user}">
                    <a class="button button-little bg-blue margin-big-left" href="${ctx}/to_login"><span class="icon-user"></span> 用户登录</a>
                </c:if>
                <c:if test="${!empty sessionScope.user}">
                    <img src="${ctx}/${sessionScope.user.photo}" width="30" alt="face" class="radius-circle rotate-hover" />
                    欢迎您，${sessionScope.user.userName}
                    <c:if test="${sessionScope.user.role == '1'}">
                        <a class="button button-little bg-blue margin-big-left" href="${ctx}/manage/home"><span class="icon-home"></span> 后台页面</a>
                    </c:if>
                    <a class="button button-little bg-yellow margin-big-left" href="${ctx}/user/to_change_password"><span class="icon-cogs"></span> 修改密码</a>
                    <a class="button button-little bg-blue margin-big-left" href="${ctx}/user/to_update"><span class="icon-edit"></span> 修改用户信息</a>
                    <a class="button button-little bg-red margin-big-left" href="${ctx}/logout"><span class="icon-power-off"></span> 退出登录</a>
                </c:if>

            </div>
        </div>
    </div>
</div>