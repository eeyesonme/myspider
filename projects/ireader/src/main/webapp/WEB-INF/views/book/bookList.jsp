<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>任务管理</title>
</head>

<body>
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	<div class="row">
		<div class="span4 offset7">
			<form class="form-search" action="#">
				<label>名称：</label> <input type="text" name="search_LIKE_name" class="input-medium" value="${param.search_LIKE_name}"> 
				<button type="submit" class="btn" id="search_btn">Search</button>
		    </form>
	    </div>
	    <tags:sort/>
	</div>
	
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>id</th><th>name</th><th>description></th><th>Category</th><th>Author</th></tr></thead>
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
	
	<tags:pagination page="${books}" paginationSize="50"/>

</body>
</html>
