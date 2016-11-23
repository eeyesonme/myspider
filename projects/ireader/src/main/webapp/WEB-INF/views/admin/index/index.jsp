<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common/taglibs.jspf" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<title>Admin Index Page</title>
</head>
   
<body >
  <div class="content-wrapper">
			       	   <section class="content-header">
			                    <h1>
			                        Simple Tables
			                        <small>preview of simple tables</small>
			                    </h1>
			                    <ol class="breadcrumb">
			                        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			                        <li><a href="#">Tables</a></li>
			                        <li class="active">Simple</li>
			                    </ol>
			              </section>
              
				              <section class="content">
				              			<div class="row">
				                        <div class="col-xs-12">
				                            <div class="box">
				                                <div class="box-header">
				                                    <h3 class="box-title">Responsive Hover Table</h3>
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
				                                            <th>User</th>
				                                            <th>Date</th>
				                                            <th>Status</th>
				                                            <th>Reason</th>
				                                        </tr>
				                                    </table>
				                                </div><!-- /.box-body -->
				                            </div><!-- /.box -->
				                        </div>
				                    </div>
				              </section>
</div>
</body>