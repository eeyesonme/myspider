<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common/taglibs.jspf" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<title>Admin Index Page</title>
</head>
   
<body>
<div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="left-side sidebar-offcanvas">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="" class="img-circle" alt="User Image" />
                        </div>
                        <div class="pull-left info">
                            <p>Hello, Jane</p>

                            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                        </div>
                    </div>
                    <!-- search form -->
                    <form action="#" method="get" class="sidebar-form">
                        <div class="input-group">
                            <input type="text" name="q" class="form-control" placeholder="Search..."/>
                            <span class="input-group-btn">
                                <button type='submit' name='seach' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
                            </span>
                        </div>
                    </form>
                    <!-- /.search form -->
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu">
                        <li class="active">
                            <a href="index.html">
                                <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                            </a>
                        </li>
                          <c:forEach items="${menus}" var="m">
		                        <li class="treeview">
		                            <a href="#"> <i class="fa fa-bar-chart-o"></i> <span>${m.name}</span> <i class="fa fa-angle-left pull-right"></i></a>
		                             <c:forEach items="${m.children}" var="c">
			                            <ul class="treeview-menu">
			                               	 <es:submenu menu="${c}"/>
			                            </ul>
			                            </c:forEach>
		                        </li>
		                        </c:forEach>
					   </ul>
                </section>
                <!-- /.sidebar -->
            </aside>
            <aside class="right-side">
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
				                                        <tr>
				                                            <td>183</td>
				                                            <td>John Doe</td>
				                                            <td>11-7-2014</td>
				                                            <td><span class="label label-success">Approved</span></td>
				                                            <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
				                                        </tr>
				                                        <tr>
				                                            <td>219</td>
				                                            <td>Jane Doe</td>
				                                            <td>11-7-2014</td>
				                                            <td><span class="label label-warning">Pending</span></td>
				                                            <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
				                                        </tr>
				                                        <tr>
				                                            <td>657</td>
				                                            <td>Bob Doe</td>
				                                            <td>11-7-2014</td>
				                                            <td><span class="label label-primary">Approved</span></td>
				                                            <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
				                                        </tr>
				                                        <tr>
				                                            <td>175</td>
				                                            <td>Mike Doe</td>
				                                            <td>11-7-2014</td>
				                                            <td><span class="label label-danger">Denied</span></td>
				                                            <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
				                                        </tr>
				                                    </table>
				                                </div><!-- /.box-body -->
				                            </div><!-- /.box -->
				                        </div>
				                    </div>
				              </section>
				          </aside>
         </div>

</body>