<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="mytag" uri="/WEB-INF/MyTag" %>
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
    <div class="line">
        <div class="panel admin-panel">
            <div class="panel-head"><strong class="icon-reorder"> 物品借出/归还管理</strong></div>
            <div class="panel-body">
                <div class="margin-big-bottom">
                    <form action="${ctx}/manage/borrow/list" method="post">
                        <ul class="search" style="padding-left:10px;">
                            <li>
                                <div class="button-group">
                                    <button type="button" class="button border-green"
                                            onclick="javascript:window.location.href='${ctx}/manage/borrow/list';"><span
                                            class="icon-refresh"></span> 刷新数据
                                    </button>
                                    <button type="button" class="button border-main"
                                            onclick="javascript:window.location.href='${ctx}/manage/borrow/to_add';"><span
                                            class="icon-plus"></span> 添加借出信息
                                    </button>
                                    <button type="button" class="button border-red" id="delete_all"><span
                                            class="icon-trash-o"></span> 批量删除
                                    </button>
                                </div>
                            </li>
                            <li>
                                <select id="type" name="type" class="input" style="width:100px; line-height:17px;">
                                    <option value="name">物品名称</option>
                                    <option value="borrowName">借用人</option>
                                    <option value="borrowHandleName">借出经手人</option>
                                    <option value="returnHandleName">归还经手人</option>
                                    <option value="flag">是否归还</option>
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
                        <td><input type="checkbox" id="check_all"/></td>
                        <td class="text-left">物品名称</td>
                        <td>数量(单位)</td>
                        <td>借用人</td>
                        <td>借出时间</td>
                        <td>借出经手人</td>
                        <td>归还时间</td>
                        <td>归还经手人</td>
                        <td>操作</td>
                    </tr>
                    <c:forEach items="${pageInfo.list}" var="borrow">
                        <tr>
                            <td><input type="checkbox" class="check_item" value="${borrow.id}"></td>
                            <td class="text-left" title="${borrow.remarks}">${borrow.name}</td>
                            <td>${borrow.num}(${borrow.unit})</td>
                            <td>${borrow.borrower.userName}</td>
                            <td><spring:eval expression="borrow.borrowTime"/></td>
                            <td>${borrow.borrowHandler.userName}</td>
                            <td>
                                <c:if test="${!empty borrow.returnTime}">
                                    <spring:eval expression="borrow.returnTime"/>
                                </c:if>
                            </td>
                            <td>
                                <c:if test="${!empty borrow.returnHanlder}">
                                    ${borrow.returnHanlder.userName}
                                </c:if>
                            </td>
                            <td>
                                <c:if test="${borrow.flag == '0'}">
                                    <button class="button button-little bg-yellow" onclick="javascript:back(${borrow.id});">归还</button>
                                    <a href="${ctx}/manage/borrow/to_update?id=${borrow.id}">编辑</a>
                                </c:if>
                                <c:if test="${borrow.flag == '1'}"><span class="badge bg-main">已归还</span></c:if>
                                <a href="${ctx}/manage/borrow/remove?id=${borrow.id}" onclick="return conf();">删除</a>
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
                        <ul class="pagination border-main">
                            <c:if test="${pageInfo.hasPreviousPage == false}">
                                <li class="disabled"><a href="#">首页</a></li>
                                <li class="disabled"><a><i class="icon-angle-double-left"></i></a></li>
                            </c:if>
                            <c:if test="${pageInfo.hasPreviousPage}">
                                <li><a href="${ctx}/manage/borrow/list">首页</a></li>
                                <li><a href="${ctx}/manage/borrow/list?pn=${pageInfo.pageNum-1}"><i
                                        class="icon-angle-double-left"></i></a></li>
                            </c:if>
                            <c:forEach items="${pageInfo.navigatepageNums}" var="num">
                                <c:if test="${pageInfo.pageNum == num}">
                                    <li class="active"><a>${num}</a></li>
                                </c:if>
                                <c:if test="${pageInfo.pageNum != num}">
                                    <li><a href="${ctx}/manage/borrow/list?pn=${num}">${num}</a></li>
                                </c:if>
                            </c:forEach>

                            <c:if test="${pageInfo.hasNextPage == false}">
                                <li class="disabled"><a><i class="icon-angle-double-right"></i></a></li>
                                <li class="disabled"><a href="#">末页</a></li>
                            </c:if>
                            <c:if test="${pageInfo.hasNextPage}">
                                <li><a href="${ctx}/manage/borrow/list?pn=${pageInfo.pageNum+1}"><i
                                        class="icon-angle-double-right"></i></a></li>
                                <li><a href="${ctx}/manage/borrow/list?pn=${pageInfo.pages}">末页</a></li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="admin_bottom.jsp"/>
<script>
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
        var del_ids = "";
        $.each($(".check_item:checked"), function () {
            //this
            //组装id字符串
            del_ids += $(this).val() + ",";
        });
        //去除del_ids多余的,
        del_ids = del_ids.substring(0, del_ids.length - 1);
        if (confirm("确认删除这些账目吗？")) {
            window.location.href = "${ctx}/manage/borrow/remove?id=" + del_ids;
        }
    });

    function back(id) {
        if(confirm("确认该物品要归还吗？")) {
            window.location.href="${ctx}/manage/borrow/back?id="+id;
        }
    }
</script>
</body>
</html>
