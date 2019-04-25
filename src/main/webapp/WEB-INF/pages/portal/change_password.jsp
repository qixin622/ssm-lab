<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="mytag" uri="/WEB-INF/MyTag" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="doc_head.jsp" %>
    </head>
    <body>
        <!--导航-->
        <%@include file="doc_topnav.jsp" %>
        <!--菜单-->
        <%@include file="doc_menu.jsp" %>
        <div class="container">
            <div class="line">
                <div class="xm3 xb3 fadein-left">
                    <div class="doc-siderbar">
                        <%@include file="doc_link.jsp" %>
                    </div>
                </div>
                <div class="xl12 xs12 xm9 xb9">
                    <div class="padding-large-left padding-large-right">
                        <div class="panel admin-panel">
                            <div class="panel-head"><strong class="icon-reorder"> 修改用户密码 </strong></div>
                            <div class="panel-body">
                                <form method="post" class="form-x" action="#" onsubmit="return false;">
                                    <div class="form-group">
                                        <div class="label">
                                            <label>用户帐号：</label>
                                        </div>
                                        <div class="field">
                                            <label style="line-height:33px;">
                                                ${sessionScope.user.sn} - ${sessionScope.user.userName}
                                            </label>
                                        </div>
                                    </div>
                                    <div id="errMsg" style="display:none;">
                                        <div class="form-group">
                                            <div class="label">
                                                <label>错误信息：</label>
                                            </div>
                                            <div class="field">
                                                <span style="color: red; line-height:33px;">${error}</span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="label">
                                            <label for="oldpass">原始密码：</label>
                                        </div>
                                        <div class="field">
                                            <input type="password" class="input w50" id="oldpass" name="oldpass" size="50" placeholder="请输入原始密码" data-validate="required:请输入原始密码" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="label">
                                            <label for="newpass">新密码：</label>
                                        </div>
                                        <div class="field">
                                            <input type="password" class="input w50" id="newpass" name="newpass" size="50" placeholder="请输入新密码" data-validate="required:请输入新密码,length#>=6:新密码不能小于6位" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="label">
                                            <label for="renewpass">确认新密码：</label>
                                        </div>
                                        <div class="field">
                                            <input type="password" class="input w50" id="renewpass" name="renewpass" size="50" placeholder="请再次输入新密码" data-validate="required:请再次输入新密码,repeat#newpass:两次输入的密码不一致" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="label">
                                            <label></label>
                                        </div>
                                        <div class="field">
                                            <button class="button bg-main icon-check-square-o" type="submit" onclick="change_password()"> 提交</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--底部-->
        <%@include file="doc_footer.jsp" %>
        <script>
            function change_password() {
                var oldpass = $("#oldpass").val();
                var newpass = $("#newpass").val();
                var renewpass = $("#renewpass").val();
                $.ajax({
                    type: "POST",//方法类型
                    dataType: "json",//预期服务器返回的数据类型
                    url: "${ctx}/user/change_password",
                    data: {oldpass: oldpass, newpass: newpass, renewpass:renewpass},
                    success: function (result) {
                        if (result.resultCode == 200) {
                            $('#errMsg').css("display", "none");
                            alert("密码修改成功!");
                            window.location.href = "${ctx}/index";
                        }
                        if (result.resultCode == 500) {
                            $('#errMsg').css("display", "block");
                            $("#errMsg").find("span").text(result.message);
                            return;
                        }
                    },
                    error: function () {
                        $('#errMsg').css("display", "block");
                        $("#errMsg").find("span").text("接口异常，请联系管理员！");
                        return;
                    }
                });
            }
        </script>
    </body>
</html>
