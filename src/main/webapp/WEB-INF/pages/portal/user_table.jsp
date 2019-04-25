<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
                        <h1 class="text-main text-center icon-calendar"> 教工基本信息列表</h1>
                    </div>
                    <div class="panel-body">
                        <div class="line text-center">
                            <form method="post" action="${ctx}/user/list/table" class="form-inline text-center">
                                <div class="form-group">
                                    <select id="type" name="type" class="input">
                                        <option value="sn">职工号</option>
                                        <option value="userName">姓名</option>
                                        <option value="sex">性别</option>
                                        <option value="technical">职称</option>
                                        <option value="type">教师类别</option>
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
                                    <td>教工编号</td>
                                    <td>教工姓名</td>
                                    <td>教工性别</td>
                                    <td>出生年月</td>
                                    <td>职称</td>
                                    <td>教师类别</td>
                                </tr>
                                <c:forEach items="${pageInfo.list}" var="user">
                                    <tr>
                                        <td>${user.sn}</td>
                                        <td>${user.userName}</td>
                                        <td>${user.sex}</td>
                                        <td><spring:eval expression="user.birthday"/></td>
                                        <td>${user.technical}</td>
                                        <td>${user.type}</td>
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
                                        <li><a href="${ctx}/user/list/table">首页</a></li>
                                        <c:if test="${type!=null}">
                                            <li><a href="${ctx}/user/list/table?pn=${pageInfo.pageNum-1}&type=${type}&keywords=${keywords}"><i
                                                    class="icon-angle-double-left"></i></a></li>
                                        </c:if>
                                        <c:if test="${type==null}">
                                            <li><a href="${ctx}/user/list/table?pn=${pageInfo.pageNum-1}"><i
                                                    class="icon-angle-double-left"></i></a></li>
                                        </c:if>
                                    </c:if>
                                    <c:forEach items="${pageInfo.navigatepageNums}" var="num">
                                        <c:if test="${pageInfo.pageNum == num}">
                                            <li class="active"><a>${num}</a></li>
                                        </c:if>
                                        <c:if test="${pageInfo.pageNum != num}">
                                            <c:if test="${type!=null}">
                                                <li><a href="${ctx}/user/list/table?pn=${num}&type=${type}&keywords=${keywords}">${num}</a></li>
                                            </c:if>
                                            <c:if test="${type==null}">
                                                <li><a href="${ctx}/user/list/table?pn=${num}">${num}</a></li>
                                            </c:if>
                                        </c:if>
                                    </c:forEach>

                                    <c:if test="${pageInfo.hasNextPage == false}">
                                        <li class="disabled"><a><i class="icon-angle-double-right"></i></a></li>
                                        <li class="disabled"><a href="#">末页</a></li>
                                    </c:if>
                                    <c:if test="${pageInfo.hasNextPage}">
                                        <c:if test="${type!=null}">
                                            <li><a href="${ctx}/user/list/table?pn=${pageInfo.pageNum+1}&type=${type}&keywords=${keywords}"><i
                                                    class="icon-angle-double-right"></i></a></li>
                                        </c:if>
                                        <c:if test="${type==null}">
                                            <li><a href="${ctx}/user/list/table?pn=${pageInfo.pageNum+1}"><i
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
