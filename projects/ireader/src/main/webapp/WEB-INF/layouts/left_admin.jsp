  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <%@include file="/WEB-INF/views/common/taglibs.jspf" %>
  
  <aside class="main-sidebar">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="${ctx}/static/img/avatar.png" class="img-circle" alt="User Image" />
                        </div>
                        <div class="pull-left info">
                            <p>${user.username}</p>

                            <a href="#"><i class="fa fa-circle text-success"></i> ${user.status}</a>
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
                    <li class="header">MAIN NAVIGATION</li>
                        <li class="active treeview">
                            <a href="#">
                                <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                            </a>
                        </li>
                          <c:forEach items="${menus}" var="m">
		                        <li class="treeview">
		                            <a href="#"> <i class="fa fa-bar-chart-o"></i>
			                             <span>${m.name}</span> 
			                             <span class="pull-right-container">
			                              <i class="fa fa-angle-left pull-right"></i>
	           							 </span>
           							</a>
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