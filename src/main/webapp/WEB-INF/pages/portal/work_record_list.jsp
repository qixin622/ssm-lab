<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="mytag" uri="/WEB-INF/MyTag" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <%@include file="doc_head.jsp" %>
    <link rel="stylesheet" href="${ctx}/plugins/datepicker/css/datepicker.css">
</head>
<body>
<!--导航-->
<%@include file="doc_topnav.jsp" %>
<!--菜单-->
<%@include file="doc_menu.jsp" %>
<div class="container">
    <div class="line">
        <div class="padding-large-left padding-large-right">
            <div class="panel admin-panel">
                <div class="panel-head">
                    <h1 class="text-main text-center icon-calendar">工作内容记录</h1>
                    <div class="line text-center margin-big-top margin-bottom">
                        <form action="${ctx}/user/workrecord/list" method="post" class="form-x form-inline">
                            <div class="c-datepicker-date-editor J-datepicker-range-day mt10">
                                <i class="icon-clock-o"></i>
                                <input placeholder="开始日期" name="startTime" class="c-datepicker-data-input only-date" value="">
                                <span class="c-datepicker-range-separator">-</span>
                                <input placeholder="结束日期" name="endTime" class="c-datepicker-data-input only-date" value="">
                            </div>
                            <select id="type" name="type" class="input" style="width:100px; line-height:17px;">
                                <option value="userName">记录人姓名</option>
                                <option value="user_sn">记录人编号</option>
                                <option value="content">记录内容</option>
                            </select>
                            <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input"
                                   style="width:250px; line-height:17px;display:inline-block">
                            <button type="submit" class="button border-main icon-search"> 搜索</button>
                            <button type="button" class="button border-green"
                                    onclick="javascript:window.location.href='${ctx}/user/workrecord/list';"><span
                                    class="icon-refresh"></span> 刷新数据
                            </button>
                        </form>
                    </div>
                </div>
                <div class="panel-body">
                    <table class="table table-bordered text-center">
                        <tr>
                            <td>工作内容</td>
                            <td width="10%">记录人</td>
                            <td width="15%">记录时间</td>
                        </tr>
                        <c:forEach items="${pageInfo.list}" var="record">
                            <tr>
                                <td class="text-left" title="${record.content}">
                                    <mytag:convertstringtag content="${record.content}" size="40"/>
                                    <c:set var="datenow" value="<%=System.currentTimeMillis()%>" />
                                    <c:if test="${(datenow-record.createTime.time)<=86400000}">
                                        <span class="tag bg-yellow margin-big-left">new</span>
                                    </c:if>
                                </td>
                                <td>${record.user.userName}</td>
                                <td><spring:eval expression="record.createTime"/></td>
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
                                    <li><a href="${ctx}/user/workrecord/list">首页</a></li>
                                    <li><a href="${ctx}/user/workrecord/list?pn=${pageInfo.pageNum-1}"><i
                                            class="icon-angle-double-left"></i></a></li>
                                </c:if>
                                <c:forEach items="${pageInfo.navigatepageNums}" var="num">
                                    <c:if test="${pageInfo.pageNum == num}">
                                        <li class="active"><a>${num}</a></li>
                                    </c:if>
                                    <c:if test="${pageInfo.pageNum != num}">
                                        <li><a href="${ctx}/user/workrecord/list?pn=${num}">${num}</a></li>
                                    </c:if>
                                </c:forEach>

                                <c:if test="${pageInfo.hasNextPage == false}">
                                    <li class="disabled"><a><i class="icon-angle-double-right"></i></a></li>
                                    <li class="disabled"><a href="#">末页</a></li>
                                </c:if>
                                <c:if test="${pageInfo.hasNextPage}">
                                    <li><a href="${ctx}/user/workrecord/list?pn=${pageInfo.pageNum+1}"><i
                                            class="icon-angle-double-right"></i></a></li>
                                    <li><a href="${ctx}/user/workrecord/list?pn=${pageInfo.pages}">末页</a></li>
                                </c:if>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--底部-->
<%@include file="doc_footer.jsp" %>
<script src="${ctx}/plugins/datepicker/js/plugins/moment.min.js"></script>
<script src="${ctx}/plugins/datepicker/js/datepicker.all.js"></script>
<script>
    $(function(){
        var DATAPICKERAPI = {
            // 默认input显示当前月,自己获取后填充
            activeMonthRange: function () {
                return {
                    begin: moment().set({ 'date': 1, 'hour': 0, 'minute': 0, 'second': 0 }).format('YYYY-MM-DD HH:mm:ss'),
                    end: moment().set({ 'hour': 23, 'minute': 59, 'second': 59 }).format('YYYY-MM-DD HH:mm:ss')
                }
            },
            shortcutMonth: function () {
                // 当月
                var nowDay = moment().get('date');
                var prevMonthFirstDay = moment().subtract(1, 'months').set({ 'date': 1 });
                var prevMonthDay = moment().diff(prevMonthFirstDay, 'days');
                return {
                    now: '-' + nowDay + ',0',
                    prev: '-' + prevMonthDay + ',-' + nowDay
                }
            },
            // 注意为函数：快捷选项option:只能同一个月份内的
            rangeMonthShortcutOption1: function () {
                var result = DATAPICKERAPI.shortcutMonth();
                return [{
                    name: '昨天',
                    day: '-1,-1',
                    time: '00:00:00,23:59:59'
                }, {
                    name: '这一月',
                    day: result.now,
                    time: '00:00:00,'
                }, {
                    name: '上一月',
                    day: result.prev,
                    time: '00:00:00,23:59:59'
                }];
            },
            // 快捷选项option
            rangeShortcutOption1: [{
                name: '最近一周',
                day: '-7,0'
            }, {
                name: '最近一个月',
                day: '-30,0'
            }, {
                name: '最近三个月',
                day: '-90, 0'
            }],
            singleShortcutOptions1: [{
                name: '今天',
                day: '0'
            }, {
                name: '昨天',
                day: '-1',
                time: '00:00:00'
            }, {
                name: '一周前',
                day: '-7'
            }]
        };
        //年月日范围
        $('.J-datepicker-range-day').datePicker({
            hasShortcut: true,
            format: 'YYYY-MM-DD',
            isRange: true,
            shortcutOptions: DATAPICKERAPI.rangeShortcutOption1
        });
    });
</script>
</body>
</html>
