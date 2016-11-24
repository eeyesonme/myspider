<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/views/common/taglibs.jspf" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
 <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<title>iReader Admin Page</title>

<link type="image/x-icon" href="${ctx}/static/img/icons.png" rel="shortcut icon">
<link href="${ctx}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/static/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/static/css/skins/_all-skins.min.css">
 <!-- Font Awesome -->
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<%--  <!-- Font Awesome -->
 <link rel="stylesheet" href="${ctx}/static/css/font-awesome.min.css">
  <!-- Ionicons -->
 <link rel="stylesheet" href="${ctx}/static/css/ionicons.min.css"> --%>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
<%@ include file="/WEB-INF/views/admin/index/header.jsp"%>
<%@ include file="/WEB-INF/views/admin/index/menu.jsp"%>
<%@ include file="/WEB-INF/views/admin/index/main.jsp"%>
</div>
<script src="${ctx}/static/plugins/jquery/jquery-2.2.3.min.js" type="text/javascript"></script>
<script src="${ctx}/static/plugins/jqueryui/jquery-ui.min.js" type="text/javascript"></script>
<script src="${ctx}/static/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${ctx}/static/js/app.min.js" type="text/javascript"></script>


<script type="text/javascript">
$(document).ready(function () {
    $('li').click(function (e) {
        e.preventDefault();    
    });
});
function showAtRight(url) {
    var xmlHttp;
    
    if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        xmlHttp=new XMLHttpRequest();    //创建 XMLHttpRequest对象
    }
    else {
        // code for IE6, IE5
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlHttp.onreadystatechange=function() {        
        //onreadystatechange — 当readystate变化时调用后面的方法
        
        if (xmlHttp.readyState == 4) {
            //xmlHttp.readyState == 4    ——    finished downloading response
            
            if (xmlHttp.status == 200) {
                //xmlHttp.status == 200        ——    服务器反馈正常            
                
                document.getElementById("content").innerHTML=xmlHttp.responseText;    //重设页面中id="content"的div里的内容
            }
            //错误状态处理
            else if (xmlHttp.status == 404){
                alert("出错了☹   （错误代码：404 Not Found），……！"); 
                /* 对404的处理 */
                return;
            }
            else if (xmlHttp.status == 403) {  
                alert("出错了☹   （错误代码：403 Forbidden），……"); 
                /* 对403的处理  */ 
                return;
            }
            else {
                alert("出错了☹   （错误代码：" + request.status + "），……"); 
                /* 对出现了其他错误代码所示错误的处理   */
                return;
            }   
        } 
            
      }
    
    //把请求发送到服务器上的指定文件（url指向的文件）进行处理
    xmlHttp.open("GET", url, true);        //true表示异步处理
    xmlHttp.send();
}        
</script>
</body>
</html>