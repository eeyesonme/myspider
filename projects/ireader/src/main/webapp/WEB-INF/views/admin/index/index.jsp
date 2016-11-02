<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common/taglibs.jspf" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<title>Admin Index Page</title>
</head>
   
<body>
<div id="menu">
    <c:forEach items="${menus}" var="m">
        <div>
            <h3><a href="#">${m.name}</a></h3>
            <div class="submenu">
                <c:forEach items="${m.children}" var="c">
                    <ul>
                        <es:submenu menu="${c}"/>
                    </ul>
                </c:forEach>
            </div>
        </div>
    </c:forEach>
</div>
</body>