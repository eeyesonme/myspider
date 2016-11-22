<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common/taglibs.jspf" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<title>Admin Index Page</title>
</head>
   
<body>

  <aside class="right-side">
			       	   <section class="content-header">
			                    <h1>
			                       All Users
			                        <small>preview of use lis</small>
			                    </h1>
			                    <ol class="breadcrumb">
			                        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			                        <li><a href="#">admin</a></li>
			                        <li class="active">UserManager</li>
			                    </ol>
			              </section>
              
				              <section class="content">
				              			<div class="row">
				                        <div class="col-xs-12">
				                            <div class="box">
				                                <div class="box-header">
				                                    <h3 class="box-title">User list talbe</h3>
				                                    <div class="box-tools">
				                                        <div class="input-group">
				                                            <input type="text" name="table_search" class="form-control input-sm pull-right" style="width: 150px;" placeholder="Search"/>
				                                            <div class="input-group-btn">
				                                                <button class="btn btn-sm btn-default"><i class="fa fa-search"></i></button>
				                                            </div>
				                                        </div>
				                                    </div>
				                                </div><!-- /.box-header -->
				                                <div class="box-body table-responsive no-padding">
				                                    <table class="table table-hover">
				                                        <tr>
				                                            <th>ID</th>
				                                            <th>Username</th>
				                                            <th>Email</th>
				                                            <th>Mobile</th>
				                                            <th>Password</th>
				                                             <th>Salt</th>
				                                             <th>CreateDate</th>
				                                             <th>Status</th>
				                                             <th>Admin</th>
				                                        </tr>
				                                        <c:forEach items="${users}" var="u">
				                                        	<tr>
				                                        		<td>${u.id}</td>
				                                        		<td>${u.username}</td>
				                                        		<td>${u.email}</td>
				                                        		<td>${u.mobile}</td>
				                                        		<td>${u.password}</td>
				                                        		<td>${u.salt}</td>
				                                        		<td>${u.createDate}</td>
				                                        		<td>${u.status}</td>
				                                        		<td>${u.admin}</td>
				                                        </c:forEach>
				                                    </table>
				                                </div><!-- /.box-body -->
				                            </div><!-- /.box -->
				                        </div>
				                    </div>
				              </section>
				          </aside>

</body>