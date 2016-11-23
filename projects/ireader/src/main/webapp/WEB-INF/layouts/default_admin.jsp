<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>iReader<sitemesh:title/></title>

<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>

<link type="image/x-icon" href="${ctx}/static/img/icons.png" rel="shortcut icon">
<link href="${ctx}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/static/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/static/css/skins/_all-skins.min.css">
<sitemesh:head/>
</head>

<body>
<%@ include file="/WEB-INF/layouts/head_admin.jsp"%>
<%@ include file="/WEB-INF/layouts/left_admin.jsp"%>
<%@ include file="/WEB-INF/layouts/footer.jsp"%>
<sitemesh:body/>
<script src="${ctx}/static/plugins/jquery/jquery-2.2.3.min.js"></script>
<script src="${ctx}/static/adminlte/js/jquery-ui.min.js" type="text/javascript"></script>
<script src="${ctx}/static/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${ctx}/static/js/app.min.js" type="text/javascript"></script>
</body>
</html>