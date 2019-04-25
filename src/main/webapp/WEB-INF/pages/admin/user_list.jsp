<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <li><a href="${ctx}/manage/user/list" id="a_leader_txt">教工管理</a></li>
</ul>
<div class="admin">
    <div class="line">
        <div class="panel admin-panel">
            <div class="panel-head"><strong class="icon-reorder"> 教工管理</strong></div>
            <div class="panel-body">
                <div class="padding-bottom border-bottom">
                    <form action="${ctx}/manage/user/list" method="post">
                        <ul class="search" style="padding-left:10px;">
                            <li>
                                <div class="button-group">
                                    <button type="button" class="button border-green"
                                            onclick="javascript:window.location.href='${ctx}/manage/user/list';"><span
                                            class="icon-refresh"></span> 刷新数据
                                    </button>
                                    <button type="button" class="button border-main"
                                            onclick="javascript:window.location.href='${ctx}/manage/user/to_add';"><span
                                            class="icon-plus"></span> 添加用户
                                    </button>
                                    <button type="button" class="button border-red" id="delete_all"><span
                                            class="icon-trash-o"></span> 批量删除
                                    </button>
                                    <button type="button" class="button border-main" id="importButton"><span
                                            class="icon-arrow-circle-o-up"></span> 导入用户
                                    </button>
                                    <button type="button" class="button border-main"
                                            onclick="javascript:window.location.href='${ctx}/manage/user/export';"><span
                                            class="icon-arrow-circle-o-down"></span> 导出用户
                                    </button>
                                </div>
                            </li>
                            <li>
                                <select id="type" name="type" class="input" style="width:100px; line-height:17px;">
                                    <option value="sn">职工号</option>
                                    <option value="userName">姓名</option>
                                    <option value="sex">性别</option>
                                    <option value="technical">职称</option>
                                    <option value="type">教师类别</option>
                                </select>
                            </li>
                            <li>
                                <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input"
                                       style="width:250px; line-height:17px;display:inline-block">
                                <button type="submit" class="button border-main icon-search"> 搜索</button>
                            </li>
                        </ul>
                    </form>
                </div>
                <table class="table table-hover text-center">
                    <tr>
                        <th><input type="checkbox" id="check_all"/></th>
                        <th>教工编号</th>
                        <th>教工姓名</th>
                        <th>性别</th>
                        <th>出生年月</th>
                        <th>职称</th>
                        <th>教师类别</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${pageInfo.list}" var="user">
                        <tr>
                            <td>
                                <c:if test="${user.role==0}">
                                    <input type="checkbox" class="check_item">
                                </c:if>
                            </td>
                            <td>${user.sn}</td>
                            <td>${user.userName}</td>
                            <td>${user.sex}</td>
                            <td><spring:eval expression="user.birthday"/></td>
                            <td>${user.technical}</td>
                            <td>${user.type}</td>
                            <td>

                                <%--todo:登录管理员不能删除自己，可以删除别人--%>
                                <c:if test="${user.role == 0}">
                                    <a href="${ctx}/manage/user/to_update?sn=${user.sn}">编辑</a>
                                    <a href="${ctx}/manage/user/remove?sn=${user.sn}" onclick="return conf();">删除</a>
                                </c:if>
                                <c:if test="${user.role == 1 and sessionScope.user.sn==user.sn}">
                                    <a href="${ctx}/manage/user/to_update?sn=${user.sn}">编辑</a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="panel-foot text-center">
                <div class="line">
                    <div class="xm6 height-large">
                        当前第 <span class="badge"> ${pageInfo.pageNum} </span> 页,
                        共 <span class="badge"> ${pageInfo.pages} </span> 页,
                        共 <span class="badge"> ${pageInfo.total} </span> 条记录
                    </div>
                    <div class="xm6">
                        <ul class="pagination pagination-group pagination-small border-main">
                            <c:if test="${pageInfo.hasPreviousPage == false}">
                                <li class="disabled"><a href="#">首页</a></li>
                                <li class="disabled"><a><i class="icon-angle-double-left"></i></a></li>
                            </c:if>
                            <c:if test="${pageInfo.hasPreviousPage}">
                                <li><a href="${ctx}/manage/user/list">首页</a></li>
                                <c:if test="${type!=null}">
                                    <li><a href="${ctx}/manage/user/list?pn=${pageInfo.pageNum-1}&type=${type}&keywords=${keywords}"><i
                                            class="icon-angle-double-left"></i></a></li>
                                </c:if>
                                <c:if test="${type==null}">
                                    <li><a href="${ctx}/manage/user/list?pn=${pageInfo.pageNum-1}"><i
                                            class="icon-angle-double-left"></i></a></li>
                                </c:if>
                            </c:if>
                            <c:forEach items="${pageInfo.navigatepageNums}" var="num">
                                <c:if test="${pageInfo.pageNum == num}">
                                    <li class="active"><a>${num}</a></li>
                                </c:if>
                                <c:if test="${pageInfo.pageNum != num}">
                                    <c:if test="${type!=null}">
                                        <li><a href="${ctx}/manage/user/list?pn=${num}&type=${type}&keywords=${keywords}">${num}</a></li>
                                    </c:if>
                                    <c:if test="${type==null}">
                                        <li><a href="${ctx}/manage/user/list?pn=${num}">${num}</a></li>
                                    </c:if>
                                </c:if>
                            </c:forEach>

                            <c:if test="${pageInfo.hasNextPage == false}">
                                <li class="disabled"><a><i class="icon-angle-double-right"></i></a></li>
                                <li class="disabled"><a href="#">末页</a></li>
                            </c:if>
                            <c:if test="${pageInfo.hasNextPage}">
                                <c:if test="${type!=null}">
                                    <li><a href="${ctx}/manage/user/list?pn=${pageInfo.pageNum+1}&type=${type}&keywords=${keywords}"><i
                                            class="icon-angle-double-right"></i></a></li>
                                </c:if>
                                <c:if test="${type==null}">
                                    <li><a href="${ctx}/manage/user/list?pn=${pageInfo.pageNum+1}"><i
                                            class="icon-angle-double-right"></i></a></li>
                                </c:if>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="admin_bottom.jsp"/>
<!-- ajax upload -->
<script src="${ctx}/plugins/ajaxupload/ajaxupload.js"></script>
<script>
    $(function () {
        //import
        new AjaxUpload('#importButton', {
            action: '${ctx}/manage/user/import',
            name: 'file',
            autoSubmit: true,
            responseType: "json",
            onSubmit: function (file, extension) {
                if (!(extension && /^(xlsx)$/.test(extension.toLowerCase()))) {
                    alert('只支持xlsx格式的文件！', {
                        icon: "error",
                    });
                    return false;
                }
            },
            onComplete: function (file, r) {
                if (r.resultCode == 200) {
                    alert("成功导入" + r.data + "条记录！");
                    //页面重定向到用户列表
                    window.location.href="${ctx}/manage/user/list";
                    return true;
                } else {
                    alert(r.message);
                    return false;
                }
            }
        });
    });

    //完成全选/全不选功能
    $("#check_all").click(function () {
        //attr获取checked是undefined;
        //我们这些dom原生的属性；attr获取自定义属性的值；
        //prop修改和读取dom原生属性的值
        $(".check_item").prop("checked", $(this).prop("checked"));
    });

    //check_item
    $(document).on("click", ".check_item", function () {
        //判断当前选择中的元素是否5个
        var flag = $(".check_item:checked").length == $(".check_item").length;
        $("#check_all").prop("checked", flag);
    });

    //点击全部删除，就批量删除
    $("#delete_all").click(function () {
        if ($(".check_item:checked").length === 0) {
            alert("请选择要删除的数据!");
            return;
        }
        var del_names = "";
        var del_sns = "";
        $.each($(".check_item:checked"), function () {
            //this
            del_names += $(this).parents("tr").find("td:eq(2)").text() + ",";
            //组装员工id字符串
            del_sns += $(this).parents("tr").find("td:eq(1)").text() + ",";
        });
        //去除empNames多余的,
        del_names = del_names.substring(0, del_names.length - 1);
        //去除删除的id多余的-
        del_sns = del_sns.substring(0, del_sns.length - 1);
        if (confirm("确认删除【" + del_names + "】吗？")) {
            window.location.href = "${ctx}/manage/user/remove?sn=" + del_sns;
        }
    });
</script>
</body>
</html>
