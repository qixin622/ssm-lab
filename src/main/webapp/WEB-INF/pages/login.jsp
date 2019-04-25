<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>登录</title>
    <link rel="stylesheet" href="${ctx}/css/pintuer.css">
    <link rel="stylesheet" href="${ctx}/css/admin.css">
    <link rel="shortcut icon" href="${ctx}/images/favicon.ico">
    <script src="${ctx}/js/jquery.js"></script>
    <script src="${ctx}/js/pintuer.js"></script>
</head>
<body>
<div class="bg"></div>
<div class="container">
    <div class="xs6 xm4 xs3-move xm4-move">
        <div style="margin-top: 30%">
        </div>
        <div align="center">
            <form action="${ctx}/login" method="post">
                <div class="panel padding" style="width: 450px;text-align: left;">
                    <div class="text-center">
                        <br>
                        <h2><strong>欢迎使用实验室信息管理系统</strong></h2></div>
                    <div class="" style="padding:30px;">
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="text" class="input" name="sn" placeholder="教工编号" data-validate="required:请填写教工编号,length#==8:教工长度为8"/>
                                <span class="icon icon-user"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="password" class="input" name="password" placeholder="教工密码" data-validate="required:请填写教工密码"/>
                                <span class="icon icon-key"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field">
                                <input type="text" class="input" name="code" placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码,ajax#login_checkCode?code=:验证码不正确" />
                                <img src="${ctx}/captchaServlet" alt="" width="80" height="32" class="passcode" style="cursor:pointer;" onclick="this.src=this.src+'?'">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field">
                                <span style="color: red" id="errMsg">${error}</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field">
                                <button class="button button-block bg-main text-big">立即登录</button>
                            </div>
                        </div>
                        <div class="text-right text-small text-gray padding-top"><a class="text-gray" target="_blank" href="http://www.pintuer.com">湖北汽车工业学院</a> 版权所有</div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>