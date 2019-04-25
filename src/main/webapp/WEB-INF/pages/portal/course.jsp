<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
                <div class="panel margin-big-bottom">
                    <div class="panel-head">
                        <h1 class="text-main text-center icon-calendar"> 课程列表</h1>
                    </div>
                    <div class="panel-body">
                        <div class="line text-center margin-bottom">
                            <form method="post" action="${ctx}/course/list" class="form-inline text-center">
                                <div class="form-group">
                                    <select id="type" name="type" class="input">
                                        <option value="cno">课程编号</option>
                                        <option value="cname">课程名称</option>
                                        <option value="property">课程性质</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <div class="field">
                                        <input type="text" class="input" id="keywords" name="keywords" size="60" placeholder="搜索条件..."/>
                                    </div>
                                </div>
                                <div class="form-button">
                                    <button class="button" type="submit"> 查询</button>
                                </div>
                            </form>
                        </div>
                        <div class="table-responsive">
                            <table class="table table-hover text-center">
                                <tr>
                                    <td height="20" align="center"></td>
                                    <td class="text-left">课程编号</td>
                                    <td class="text-left">课程名称</td>
                                    <td class="text-left">课程性质</td>
                                    <td class="text-left">总学时</td>
                                    <td class="text-left">学分</td>
                                    <td class="text-left">理论学时</td>
                                    <td class="text-left">实验学时</td>
                                </tr>
                                <c:forEach items="${pageInfo.list}" var="course">
                                    <tr>
                                        <td height="20" align="center"><span class="disimg2" id="rowid_${course.id}"
                                                                             onclick="DisplayRows('${course.id}');"></span></td>
                                        <td class="text-left">${course.cno}</td>
                                        <td class="text-left"><a href="${ctx}/course/show/${course.id}">${course.cname}</a></td>
                                        <td class="text-left">${course.property}</td>
                                        <td class="text-left">${course.totalperiod}</td>
                                        <td class="text-left">${course.credit}</td>
                                        <td class="text-left">${course.theperiod}</td>
                                        <td class="text-left">${course.expperiod}</td>
                                    </tr>
                                    <tr>
                                        <td style="padding: 0;border: none;" colspan="9">
                                            <div rel="rowpid_${course.id}" style="display: none;">
                                                <table class="table table-hover text-center">
                                                    <c:forEach items="${course.courseItems}" var="courseItem">
                                                        <tr>
                                                            <td class="text-left"><span class="sub_type infotype"></span></td>
                                                            <td class="text-left"><a href="${ctx}/courseItem/show/${courseItem.id}">${courseItem.itemname}</a></td>
                                                            <td class="text-left">${courseItem.expdemand}</td>
                                                            <td class="text-left">实验学时：${courseItem.expperiod}</td>
                                                            <td class="text-left">实验类型：${courseItem.exptype}</td>
                                                        </tr>
                                                    </c:forEach>
                                                </table>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                    <div class="panel-foot">
                        <div class="line height-big">
                            <div class="xm6">
                                当前第 <span class="badge"> ${pageInfo.pageNum} </span> 页,
                                共 <span class="badge"> ${pageInfo.pages} </span> 页,
                                共 <span class="badge"> ${pageInfo.total} </span> 条记录
                            </div>
                            <div class="xm6 text-right">
                                <ul class="pagination pagination-group pagination-small border-main">
                                    <c:if test="${pageInfo.hasPreviousPage == false}">
                                        <li class="disabled"><a href="#">首页</a></li>
                                        <li class="disabled"><a><i class="icon-angle-double-left"></i></a></li>
                                    </c:if>
                                    <c:if test="${pageInfo.hasPreviousPage}">
                                        <li><a href="${ctx}/course/list">首页</a></li>
                                        <c:if test="${type!=null and keywords!=null}">
                                            <li><a href="${ctx}/course/list?pn=${pageInfo.pageNum-1}&type=${type}&keywords=${keywords}"><i
                                                    class="icon-angle-double-left"></i></a></li>
                                        </c:if>
                                        <c:if test="${type==null}">
                                            <li><a href="${ctx}/course/list?pn=${pageInfo.pageNum-1}"><i
                                                    class="icon-angle-double-left"></i></a></li>
                                        </c:if>
                                    </c:if>
                                    <c:forEach items="${pageInfo.navigatepageNums}" var="num">
                                        <c:if test="${pageInfo.pageNum == num}">
                                            <li class="active"><a>${num}</a></li>
                                        </c:if>
                                        <c:if test="${pageInfo.pageNum != num}">
                                            <c:if test="${type!=null and keywords!=null}">
                                                <li><a href="${ctx}/course/list?pn=${num}&type=${type}&keywords=${keywords}">${num}</a></li>
                                            </c:if>
                                            <c:if test="${type==null}">
                                                <li><a href="${ctx}/course/list?pn=${num}">${num}</a></li>
                                            </c:if>
                                        </c:if>
                                    </c:forEach>
                                    <c:if test="${pageInfo.hasNextPage == false}">
                                        <li class="disabled"><a><i class="icon-angle-double-right"></i></a></li>
                                        <li class="disabled"><a href="#">末页</a></li>
                                    </c:if>
                                    <c:if test="${pageInfo.hasNextPage}">
                                        <c:if test="${type!=null and keywords!=null}">
                                            <li><a href="${ctx}/course/list?pn=${pageInfo.pageNum+1}&type=${type}&keywords=${keywords}"><i
                                                    class="icon-angle-double-right"></i></a></li>
                                        </c:if>
                                        <c:if test="${type==null}">
                                            <li><a href="${ctx}/course/list?pn=${pageInfo.pageNum+1}"><i
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
    </div>
</div>
<!--底部-->
<%@include file="doc_footer.jsp" %>
</body>
</html>
