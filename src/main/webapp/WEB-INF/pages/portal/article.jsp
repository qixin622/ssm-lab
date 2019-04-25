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
                <div class="panel margin-big-bottom">
                    <div class="panel-head">
                        <strong class="icon-file-text"> 文章分类</strong>
                    </div>
                    <ul class="list-group">
                        <c:forEach var="category" items="${categoryList}">
                            <li><span class="float-right badge bg-main">${category.nums}</span><a href="${ctx}/article/list?cid=${category.cid}">${category.categoryName}</a></li>
                        </c:forEach>
                    </ul>
                </div>
                <%@include file="doc_link.jsp" %>
            </div>
        </div>
        <div class="xl12 xs12 xm9 xb9">
            <div class="padding-large-left padding-large-right">
                <div class="panel margin-big-bottom">
                    <div class="panel-head">
                        <h1 class="text-main text-center icon-calendar"> 文章列表</h1>
                    </div>
                    <div class="panel-body">
                        <div class="line text-center">
                            <form method="post" action="${ctx}/article/list" class="form-inline text-center">
                                <input type="hidden" name="cid"/>
                                <div class="form-group">
                                    <select id="type" name="type" class="input">
                                        <option value="title">标题</option>
                                        <option value="content">内容</option>
                                        <option value="userName">作者</option>
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
                                    <td class="text-left">文章分类</td>
                                    <td class="text-left">文章标题</td>
                                    <td>作者</td>
                                    <td>创建时间</td>
                                    <td class="text-right">访问量</td>
                                </tr>
                                <c:forEach items="${pageInfo.list}" var="article">
                                    <tr>
                                        <td class="text-left"><span class="badge bg-main bg-inverse"><a href="${ctx}/article/list?cid=${article.categoryId}">${article.category.categoryName}</a></span></td>
                                        <td class="text-left">
                                            <a href="${ctx}/article/show/${article.id}"><mytag:convertstringtag content="${article.title}" size="30"/></a>
                                            <c:set var="datenow" value="<%=System.currentTimeMillis()%>" />
                                            <c:if test="${(datenow-article.createTime.time)<=86400000}">
                                                <span class="tag bg-yellow margin-big-left">new</span>
                                            </c:if>
                                        </td>
                                        <td>${article.user.userName}</td>
                                        <td><spring:eval expression="article.createTime"/></td>
                                        <td class="text-right"><span class="badge bg-main">热度 ${article.hints} ℃</span></td>
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
                                        <li><a href="${ctx}/article/list">首页</a></li>
                                        <c:if test="${cid!=null}">
                                            <c:if test="${type!=null and keywords!=null}">
                                                <li><a href="${ctx}/article/list?pn=${pageInfo.pageNum-1}&cid=${cid}&type=${type}&keywords=${keywords}"><i
                                                        class="icon-angle-double-left"></i></a></li>
                                            </c:if>
                                            <c:if test="${type==null}">
                                                <li><a href="${ctx}/article/list?pn=${pageInfo.pageNum-1}&cid=${cid}"><i
                                                        class="icon-angle-double-left"></i></a></li>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${cid==null}">
                                            <c:if test="${type!=null and keywords!=null}">
                                                <li><a href="${ctx}/article/list?pn=${pageInfo.pageNum-1}&type=${type}&keywords=${keywords}"><i
                                                        class="icon-angle-double-left"></i></a></li>
                                            </c:if>
                                            <c:if test="${type==null}">
                                                <li><a href="${ctx}/article/list?pn=${pageInfo.pageNum-1}"><i
                                                        class="icon-angle-double-left"></i></a></li>
                                            </c:if>
                                        </c:if>
                                    </c:if>
                                    <c:forEach items="${pageInfo.navigatepageNums}" var="num">
                                        <c:if test="${pageInfo.pageNum == num}">
                                            <li class="active"><a>${num}</a></li>
                                        </c:if>
                                        <c:if test="${pageInfo.pageNum != num}">
                                            <c:if test="${cid!=null}">
                                                <c:if test="${type!=null and keywords!=null}">
                                                    <li><a href="${ctx}/article/list?pn=${num}&cid=${cid}&type=${type}&keywords=${keywords}">${num}</a></li>
                                                </c:if>
                                                <c:if test="${type==null}">
                                                    <li><a href="${ctx}/article/list?pn=${num}&cid=${cid}">${num}</a></li>
                                                </c:if>
                                            </c:if>
                                            <c:if test="${cid==null}">
                                                <c:if test="${type!=null and keywords!=null}">
                                                    <li><a href="${ctx}/article/list?pn=${num}&type=${type}&keywords=${keywords}">${num}</a></li>
                                                </c:if>
                                                <c:if test="${type==null}">
                                                    <li><a href="${ctx}/article/list?pn=${num}">${num}</a></li>
                                                </c:if>
                                            </c:if>
                                        </c:if>
                                    </c:forEach>
                                    <c:if test="${pageInfo.hasNextPage == false}">
                                        <li class="disabled"><a><i class="icon-angle-double-right"></i></a></li>
                                        <li class="disabled"><a href="#">末页</a></li>
                                    </c:if>
                                    <c:if test="${pageInfo.hasNextPage}">
                                        <c:if test="${cid!=null}">
                                            <c:if test="${type!=null and keywords!=null}">
                                                <li><a href="${ctx}/article/list?pn=${pageInfo.pageNum+1}&cid=${cid}&type=${type}&keywords=${keywords}"><i
                                                        class="icon-angle-double-right"></i></a></li>
                                            </c:if>
                                            <c:if test="${type==null}">
                                                <li><a href="${ctx}/article/list?pn=${pageInfo.pageNum+1}&cid=${cid}"><i
                                                        class="icon-angle-double-right"></i></a></li>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${cid==null}">
                                            <c:if test="${type!=null and keywords!=null}">
                                                <li><a href="${ctx}/article/list?pn=${pageInfo.pageNum+1}&type=${type}&keywords=${keywords}"><i
                                                        class="icon-angle-double-right"></i></a></li>
                                            </c:if>
                                            <c:if test="${type==null}">
                                                <li><a href="${ctx}/article/list?pn=${pageInfo.pageNum+1}"><i
                                                        class="icon-angle-double-right"></i></a></li>
                                            </c:if>
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
