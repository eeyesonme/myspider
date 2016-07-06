<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
	<head>
		<script> 
			      $(function () { 
			        $('#myTab a:first').tab('show');//初始化显示哪个tab 
			      
			        $('#myTab a').click(function (e) { 
			          e.preventDefault();//阻止a链接的跳转行为 
			          $(this).tab('show');//显示当前选中的链接及关联的content 
			        }) 
			      }) 
   	</script>
	</head>
	<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<div class="panel panel-success">
					<div class="panel-heading">榜单</div>
							<ul class="nav nav-tabs" id="myTab">
								<li role="presentation" class="active"><a href="#recommand">总推荐</a></li>
								<li role="presentation"><a href="#hot">热书榜</a></li>
							</ul>
							<div class="tab-content">
								<div role="tabpanel" class="tab-pane fade in active" id="recommand">
									<ul class="list-group">
										<c:forEach items="${books.content}" var="book">
											<li class="list-group-item"><span>[${book.category.name}]${book.name}
											</span> <span>${book.author.name }</span></li>
										</c:forEach>
									</ul>
								</div>
								<div role="tabpanel" class="tab-pane fade" id="hot">
									<ul class="list-group">
										<li class="list-group-item">test</li>
									</ul>
							</div>
					</div>
				</div>
			</div>
			<!-- ./col-md-2 -->

			<div class="col-md-6">
				<div class="panel panel-success">
					<div class="panel-heading">推荐</div>
					<div id="carousel-example-generic" class="carousel slide"
						data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner" role="listbox">
							<div class="item active">
								<img src="${ctx}/static/images/1.png" alt="...">
								<div class="carousel-caption">

									<h3>修炼一途，乃窃阴阳，夺造化，转涅盘，握生死，掌轮回。 武之极，破苍穹，动乾坤！</h3>
								</div>
							</div>
							<div class="item">
								<img src="${ctx}/static/images/2.png" alt="...">
								<div class="carousel-caption">
									<h3>渴望掌握命运而一心追求变强的少年，带着野兽般的战斗本能，掀起一场华丽的风暴</h3>
								</div>
							</div>
						</div>

						<!-- Controls -->
						<a class="left carousel-control" href="#carousel-example-generic"
							role="button" data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
							<span class="sr-only">Previous</span>
						</a> <a class="right carousel-control"
							href="#carousel-example-generic" role="button" data-slide="next">
							<span class="glyphicon glyphicon-chevron-right"
							aria-hidden="true"></span> <span class="sr-only">Next</span>
						</a>
					</div>	<!-- ./carousel -->
				</div><!--./panel -->
			</div><!-- ./col-md-6-->
			
			<div class="col-md-3">
				<div class="panel panel-success">
						<div class="panel-heading">我的书架</div>
						<h3>欢迎使 跨平台/多设备同步阅读进度、图书，轻松实现云阅读</h3>
				</div>
			</div>
			
		</div>	<!-- /.row -->
		
		
		<div class="row">
			<div class="col-md-3">
				<div class="panel panel-success">
					<div class="panel-heading">原创风云榜·新书</div>
							<div class="list-group">
								<c:forEach items="${books.content}" var="book">
									<a href="#" class="list-group-item">[${book.category.name}]${book.name}</a>
									<a href="#" class="list-group-item">${book.author.name }</a>
								</c:forEach>
							</div>
					</div>
			</div>		<!-- ./col-md-3 -->
			
			<div class="col-md-3">
					<div class="panel panel-success">
						<div class="panel-heading">周点击榜</div>
								<div class="list-group">
									<c:forEach items="${books.content}" var="book">
										<a href="#" class="list-group-item">[${book.category.name}]${book.name}</a>
										<a href="#">${book.author.name }</a>
									</c:forEach>
								</div>
						</div>
				</div>		<!-- ./col-md-3 -->
				
				<div class="col-md-3">
					<div class="panel panel-success">
						<div class="panel-heading">周推荐票榜</div>
								<div class="list-group">
									<c:forEach items="${books.content}" var="book">
										<a href="#" class="list-group-item">[${book.category.name}]${book.name}</a>
										<a href="#">${book.author.name }</a>
									</c:forEach>
								</div>
						</div>
				</div>		<!-- ./col-md-3 -->
			
			<div class="col-md-3">
				<div class="panel panel-success">
					<div class="panel-heading">热门作者</div>
							<div class="list-group">
								<c:forEach items="${books.content}" var="book">
									<a href="#" class="list-group-item">${book.author.name }</a>
								</c:forEach>
							</div>
					</div>
			</div>		<!-- ./col-md-3 -->
		</div><!-- ./row -->
		
		<div class="row">
			<div class="panel panel-success">
					<div class="panel-heading">最近更新</div>
							<table id="contentTable"
								class="table table-striped table-bordered table-condensed">
								<thead>
									<tr>
										<th>id</th>
										<th>name</th>
										<th>description</th>
										<th>Category</th>
										<th>Author</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${books.content}" var="book">
										<tr>
											<td><a href="${ctx}/book/${book.id}">${book.id}</a></td>
											<td>${book.name}</td>
											<td>${book.description}</td>
											<td>${book.category.name}</td>
											<td>${book.author.name}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<tags:pagination page="${books}" paginationSize="10" />
			</div>
		</div>
		
	</div>		<!-- ./container -->
	</body>
</html>