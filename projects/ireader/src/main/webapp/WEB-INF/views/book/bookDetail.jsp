<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>任务管理</title>
</head>

<body>
	<div class="row">
		 <div class="panel panel-primary">
            <div class="panel-heading">
              <h3 class="panel-title">{book.name}</h3>
            </div>
            <div class="panel-body">
             <table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead><tr><th>id</th><th>title</th><th>main</th><th>Category</th><th>Author</th></tr></thead>
				<tbody>
					<c:forEach items="${book.bookContents}" var="bookContent">
					<tr>
						<td>${bookContent.id}</td>
						<td>${bookContent.contentTitle}</td>
						<td>${bookContent.contentMain}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
            </div>
          </div>
	    <tags:sort/>
	</div>
	
	

</body>
</html>
