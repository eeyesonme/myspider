<%@tag pageEncoding="UTF-8"%>
<%@attribute name="title" type="java.lang.String" required="false" %>
<%@attribute name="index" type="java.lang.Boolean" required="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7">

    <meta http-equiv="Cache-Control" content="no-store" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />

    <title>${title}</title>
    <link rel="icon" href="${ctx}/static/images/favicon.ico">
    <link rel="shortcut icon" href="${ctx}/static/images/favicon.ico">
    <%@include file="/WEB-INF/views/common/import-css.jspf"%>
    <script type="text/javascript">
        var currentURL = "${requestScope.currentURL}";
    </script>
</head>
<body <c:if test="${index eq true}">class="index bg"</c:if>>
