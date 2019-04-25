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
                        <div class="panel margin-big-bottom">
                            <div class="panel-head">
                                <strong class="icon-file-text"> 最新文章</strong>
                            </div>
                            <div class="panel-body">
                                <!--轮播开始-->
                                <div class="margin-big-bottom">
                                    <div class="banner" data-interval="10" style="height:150px;">
                                        <div class="carousel">
                                            <c:forEach items="${articleListWithImage}" var="article">
                                                <div class="item"><a href="${ctx}/article/show/${article.id}"><img class="img-responsive img-border" src="<%=request.getContextPath()%>/${article.showImage}" alt="image" title="${article.title}"/></a></div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                                <!--轮播结束-->
                            </div>
                        </div>
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
                        <!--实验室简介开始-->
                        <div class="margin-big-bottom">
                            <div class="tab" data-toggle="hover">
                                <div class="tab-head">
                                    <ul class="tab-nav">
                                        <li class="active"><a href="#tab-units1">实验室发展历史</a> </li>
                                        <li><a href="#tab-units2">实验室简介</a> </li>
                                        <li><a href="#tab-units3">实验室硬件条件和课程设置</a> </li>
                                        <li><a href="#tab-units4">实验室管理和规章制度</a> </li>
                                    </ul>
                                </div>
                                <div class="tab-body tab-body-bordered">
                                    <div class="tab-panel active" id="tab-units1">
                                        <p class="text-indent">电气与信息工程学院计算机系专业实验室始建于1983年，计算机系专业实验室的前身是计算机实验室，在1997年的本科教学合格评估中，根据国家教委教备[1995]33号文件关于加强教学实验室的建设与管理，保证实验教学质量，提高实验室综合效益的精神，经研究决定，学院实行校系两级管理，特将计算机实验室更名为计算机信息控制中心实验室。</p>
                                        <p class="text-indent">在2006年，为了深化和推进我院实践教学改革，加强和规范实验室建设与管理，提高实验教学质量，迎接2007年本科教学水平评估，根据教育部和省教育厅有关高等学校实验室建设的文件精神，本着理顺管理体制、优化资源配置、管理重心下移、提高办学效益的指导思想，依照《湖北汽车工业学院教学实验室设置规定》，对我院教学实验室进行调整，特将计算机信息控制中心实验室更名为计算机技术实验中心实验室。</p>
                                        <p class="text-indent">2009年，由于学校实行二级学院管理制度，电气与信息工程学院考虑资源的合理利用和人员的管理，将原计算机实验中心和计算机信息控制中心实验室合并为计算机实验教学示范中心。</p>
                                        <p class="text-indent">2013年底，学校为电气与信息工程学院分配了电院综合实验大楼，将学院各个实验室搬迁至新实验楼，根据原计算机实验教学示范中心合并时出现的一些资源利用和教学性质不同的问题，将专业实验室从计算机实验教学示范中心中脱离，回归系部进行管理，从而形成目前的计算机系专业实验室。从纯教学实验室发展成为集教学、科研和对外服务于一体的专业实验室。</p>
                                    </div>
                                    <div class="tab-panel" id="tab-units2">
                                        <p class="text-indent">计算机系专业实验室是计算机系专业课程教学实验室，主要承担全校公共计算机基础课的实践教学以及计算机科学与技术专业、软件工程专业、电气自动化专业、信息管理与信息系统专业和电子信息工程专业共计28门课程的172个实验项目的实验教学任务，并承担课程设计、毕业设计和教学科研等实验内容。</p>
                                        <p class="text-indent">实验室实行规范化教学，制定有相应课程的实验教材或实验指导书。实验项目管理规范，实验开出率100%达到教学大纲的要求，其中有综合性、设计性实验的课程占总实验课程数的比例为98%。实验室制定有实验的考核或考试办法，实验报告全部批改并存档。</p>
                                        <p class="text-indent">为提高学生的实践能力和创新能力及学生就业工作的需要，计算机专业实验室在完成规定的实践教学计划任务外，全天候对全校学生开放，为学生的课程设计、毕业设计、开放实验、各种计算机设计竞赛等提供了充分的开放实验条件。</p>
                                        <p class="text-indent">计算机系专业实验室现有专职实验教师5人，其中高级实验师1人，实验师3人，助理实验师1人。计算机系专业实验室下设实验室主任和副主任各1名。</p>
                                    </div>
                                    <div class="tab-panel" id="tab-units3">
                                        <p class="text-indent">计算机系专业实验室下设嵌入式系统实验室、微机硬件基础实验室、计算机网络实验室和软件实验室4间。</p>
                                        <p class="text-indent">嵌入式系统实验室位于综合实验楼2楼，占地面积128平方米，拥有计算机50台套数和嵌入式车载多媒体实验箱40套，承担计算机系《嵌入式操作系统》、《嵌入式体系结构》、《嵌入式系统开发》、《车载信息系统》等课程实践教学任务。</p>
                                        <p class="text-indent">微机硬件基础实验室位于综合实验楼3楼，占地面积171平方米，拥有计算机80台套数、微机接口实验系统40台套数和微机原理实验箱45台套数等设备，承担计算机系《计算机组成原理》和《微机原理与接口技术》等课程实践教学任务。</p>
                                        <p class="text-indent">计算机网络实验室位于综合实验楼3楼，占地面积114平方米，拥有42台高性能计算机和多台Cisco交换机、路由器、网络防火墙和多路模拟电话交换机等设备，能够模拟局域网和广域网的运行环境，同时与吉林中软吉大信息技术有限公司合作，将网络协议仿真教学系统引入到计算机网络实验教学当中，为计算机网络实验教学提供了新的教学方法和工具。它以培养学生实际动手能力为主，为社会培养出高素质的实用性网络人才。实验室承担计算机系《计算机网络A》和《计算机网络B》等课程实践教学任务。</p>
                                        <p class="text-indent">软件实验室位于综合实验楼3楼，占地面积215平方米，拥有高性能计算机120台套，承担计算机系《C语言程序设计A》、《数据结构》、《面向对象程序设计》、《操作系统原理》、《Java程序设计》、《多媒体技术》、《编译原理》、《计算机动画设计》、《计算机软件技术基础》、《计算方法》、《计算机图形学》、《计算机游戏构件设计》、《软件项目管理》、《数据库系统原理》、《数据库技术》、《数据库系统实现》、《算法设计与分析》、《网络程序设计》、《UML建模技术》和《设计模式》等课程实践教学任务。</p>
                                    </div>
                                    <div class="tab-panel" id="tab-units4">
                                        <p class="text-indent">实验室是培训人才的中心，是高等学校实施素质教育、培养学生创新精神与实践能力的重要基地，是现代化大学的心脏。因此，建好实验室、用好实验室是高等学校的首要任务之一。</p>
                                        <p class="text-indent">计算机专业实验室严格执行各项规章制度，提高实验教师职业道德修养，强调敬业精神，做好业务学习和提高工作，认真做好实验室队伍建设。结合新进青年教师的工作安排，要求每个新进青年教师必须进行实验室建设环节的锻炼和培养，并以各种形式参与实验室建设，并且进行考核。创造条件，鼓励和要求教师下到实验室、关心开展实验教学，上述工作取得了一定的成效。</p>
                                        <p class="text-indent">通过加强实验教学人员政治思想教育，树立良好的职业道德和塑造具有为人师表、勤奋敬业、责任心强、工作有创新精神、热心实验教学和基地建设的一批人，同时实施业绩考核、在职培训等方式，提高实验教学技术人员的业务素质，逐步建设一支适应实验教学和科研发展需要的实验教学人员队伍。广大实验室人员充分认识到岗位对自身的要求和岗位重要性，不断加强学习、钻研业务，与教师交流，每人至少掌握3～4门以上专业实验课程，进行爱岗敬业教育，提高了出勤率和上班质量。进一步强调和完善制订了实验室各项规章制度，做到实验室管理有章可循，有章可依，按章办事。</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--实验室简介结束-->
                        <div class="doc-articlelist margin-big-bottom">
                            <div class="panel">
                                <div class="panel-head">
                                    <strong class="icon-list"> 文章列表</strong>
                                </div>
                                <div class="table-responsive">
                                    <table class="table table-hover table-responsive">
                                        <thead>
                                            <tr>
                                                <th>文章分类</th>
                                                <th>文章标题</th>
                                                <th>作者</th>
                                                <th>创建时间</th>
                                                <th class="text-right">访问量</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="article" items="${articleList}" varStatus="status">
                                                <tr>
                                                    <td>
                                                        <span class="badge bg-main bg-inverse">
                                                            <a href="${ctx}/article/list?cid=${article.category.cid}">${article.category.categoryName}</a>
                                                        </span>
                                                    </td>
                                                    <td>
                                                        <a href="${ctx}/article/show/${article.id}" title="${article.title}">
                                                            <mytag:convertstringtag content="${article.title}" size="30"/>
                                                        </a>
                                                        <c:set var="datenow" value="<%=System.currentTimeMillis()%>" />
                                                        <c:if test="${(datenow-article.createTime.time)<=86400000}">
                                                            <span class="tag bg-yellow margin-big-left">new</span>
                                                        </c:if>
                                                    </td>
                                                    <td><span><spring:eval expression="article.createTime"/></span></td>
                                                    <td><span>${article.user.userName}</span></td>
                                                    <td align="right"><span class="badge bg-main">热度 ${article.hints} ℃</span></td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
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
