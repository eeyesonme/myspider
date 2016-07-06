<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="container-fluid">
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <a class="navbar-brand" href="#"><img alt="Brand" src="${ctx}/static/images/favicon.ico">iReader,爱阅读，最好的中文阅读体验</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <form class="navbar-form navbar-right" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Search</button>
      </form>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
   <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">首页 <span class="sr-only">(current)</span></a></li>
        <li><a href="#">全部作品</a></li>
        <li><a href="#">排行</a></li>
        <li><a href="#">分类</a></li>
        <li><a href="#">榜单</a></li>
        <li><a href="#">书单</a></li>
        <li><a href="#">专题</a></li>
      </ul>
      </div>
  </div><!-- /.container-fluid -->
</nav>
	</div>
   