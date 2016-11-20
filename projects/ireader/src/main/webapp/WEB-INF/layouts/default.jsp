<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>iReader<sitemesh:title/></title>

<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>

<link type="image/x-icon" href="${ctx}/static/images/favicon.ico" rel="shortcut icon">
<link href="${ctx}/static/adminlte/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<!-- font Awesome -->
<link href="${ctx}/static/adminlte/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<!-- Ionicons -->
<link href="${ctx}/static/adminlte/css/ionicons.min.css" rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link href="${ctx}/static/adminlte/css/AdminLTE.css" rel="stylesheet" type="text/css" />
<sitemesh:head/>
</head>

<body>
<%@ include file="/WEB-INF/layouts/header.jsp"%>
<sitemesh:body/>
<%-- <%@ include file="/WEB-INF/layouts/footer.jsp"%>
 --%>	
	 <!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script> -->
	 	<script src="${ctx}/static/jquery/jquery-1.9.1.min.js"></script>
        <!-- jQuery UI 1.10.3 -->
        <script src="${ctx}/static/adminlte/js/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
        <!-- Bootstrap -->
        <script src="${ctx}/static/adminlte/js/bootstrap.min.js" type="text/javascript"></script>
        
         <script src="${ctx}/static/adminlte/js/AdminLTE/app.js" type="text/javascript"></script>
</body>
</html>