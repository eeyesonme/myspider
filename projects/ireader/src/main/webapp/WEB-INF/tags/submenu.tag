<%@tag pageEncoding="UTF-8" description="构建子菜单"%>
<%@ attribute name="menu"
	type=" com.digitalplay.network.ireader.domain.sys.Menu" required="true"
	description="当前菜单"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="es" tagdir="/WEB-INF/tags"%>
<c:choose>
	<c:when test="${!menu.hasChildren}">
		<li><a href="<%=menuUrl(request, menu.getUrl())%>"><i	class="fa fa-circle-o"></i> ${menu.name}	</a>	</li>
	</c:when>
	<c:otherwise>
		<li class="treeview"><a href="<%=menuUrl(request, menu.getUrl())%>"> <i  class="fa fa-bar-chart-o"></i> <span>${menu.name}</span>	 <span	class="pull-right-container">	<i class="fa fa-angle-left pull-right"></i>	</span></a>
			<ul>
				<c:forEach items="${menu.children}" var="menu2">
					<es:submenu menu="${menu2}" />
				</c:forEach>
			</ul>
		</li>
	</c:otherwise>
</c:choose>

<%!private static String menuUrl(HttpServletRequest request, String url) {
		if (url.startsWith("http")) {
			return url;
		}
		String ctx = request.getContextPath();

		if (url.startsWith(ctx) || url.startsWith("/" + ctx)) {
			return url;
		}

		if (!url.startsWith("/")) {
			url = url + "/";
		}
		return ctx + url;

	}%>

