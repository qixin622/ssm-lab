<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>学生信息管理系统-404页面错误</title>
        <meta name="keywords" content="管理系统,javaweb,servlet,ajax" />
        <meta name="description" content="数据库系统实现课程开发案例" />
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/css/pintuer.css">
    </head>
    <body>
        <div class="container">
            <div class="panel margin-big-top">
                <div class="text-center">
                    <br>
                    <h2  class="padding-top">
                        <strong>404错误！抱歉您要找的页面已被外星人劫持</strong>
                    </h2>
                    <img src="<%=request.getContextPath() %>/images/404.jpg" width=500 height=500 alt="404错误" />
                    <div class="padding-big">
                        <a href="<%=request.getContextPath() %>/" class="button bg-yellow">返回首页</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
