<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common/taglibs.jspf" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<title>登录页</title>
</head>

<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <a href="../../index2.html"><b>Admin</b>LTE</a>
  </div>
		<div class="login-box-body">
            <div class="header">Sign In</div>
            <form id="loginForm"  method="post">
                <div class="body bg-gray">
                    <div class="form-group">
                        <input type="text" name="username" class="form-control" placeholder="用户名、邮箱或手机号"/>
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" placeholder="密码"/>
                    </div>          
                   <div class="form-group">
	                        <input type="text" id="jcaptchaCode" name="jcaptchaCode"
	                                class="input-medium ajaxJcaptchaCall" placeholder="请输入验证码">
                   		  <img class="jcaptcha-btn jcaptcha-img" style="margin-left: 10px;" src="${ctx}/jcaptcha.jpg" title="点击更换验证码">
                     	  <a class="jcaptcha-btn btn btn-link">换一张</a>
               		 </div>
                    <div class="form-group">
                        <input type="checkbox" name="remember_me"/> Remember me
                    </div>
                </div>
                <div class="footer">                     
                	<input id="submitForm" type="submit" class="btn bg-olive btn-block" value="登录">                                          
                    <p><a href="#">忘记密码</a></p>
                    <a href="register.html" class="text-center">注册</a>
                </div>
            </form>

            <div class="margin text-center">
                <span>Sign in using social networks</span>
                <br/>
                <button class="btn bg-light-blue btn-circle"><i class="fa fa-facebook"></i></button>
                <button class="btn bg-aqua btn-circle"><i class="fa fa-twitter"></i></button>
                <button class="btn bg-red btn-circle"><i class="fa fa-google-plus"></i></button>

            </div>
        </div>
       </div>
	<script type="text/javascript">
    $(function() {
        $("#username").focus();
        $(".jcaptcha-btn").click(function() {
            var img = $(".jcaptcha-img");
            var imageSrc = img.attr("src");
            if(imageSrc.indexOf("?") > 0) {
                imageSrc = imageSrc.substr(0, imageSrc.indexOf("?"));
            }
            imageSrc = imageSrc + "?" + new Date().getTime();
            img.attr("src", imageSrc);
        });
    });
</script>
</body>
</html>
