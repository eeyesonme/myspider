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
	<div class="focus-wrap box-center mb40 cf">
	<div class="classify-list fl so-awesome" id="classify-list" data-l1="5">
		<dl>
		<dd><a href="//qihuan.qidian.com/" target="_blank" data-aid="qd_A72"><cite><em class="iconfont">&#xe614</em><span class="info"><i>玄幻</i><b>98539</b></span></cite></a></dd>
		<dd><a href="//qihuan.qidian.com/" target="_blank" data-aid="qd_A72"><cite><em class="iconfont">&#xe614</em><span class="info"><i>奇幻</i><b>98539</b></span></cite></a></dd>
		<dd class="even"><a href="//wuxia.qidian.com/" target="_blank" data-aid="qd_A73"><cite><em class="iconfont"></em><span class="info"><i>武侠</i><b>22949</b></span></cite></a></dd>
		<dd class="even"><a href="//xianxia.qidian.com/" target="_blank" data-aid="qd_A74"><cite><em class="iconfont"></em><span class="info"><i>仙侠</i><b>17281</b></span></cite></a></dd>
		<dd><a href="//dushi.qidian.com/" target="_blank" data-aid="qd_A75"><cite><em class="iconfont"></em><span class="info"><i>都市</i><b>2609</b></span></cite></a></dd>
		<dd><a href="//zhichang.qidian.com/" target="_blank" data-aid="qd_A76"><cite><em class="iconfont"></em><span class="info"><i>职场</i><b>17873</b></span></cite></a></dd>
		<dd class="even"><a href="//junshi.qidian.com/" target="_blank" data-aid="qd_A77"><cite><em class="iconfont"></em><span class="info"><i>军事</i><b>15822</b></span></cite></a></dd>
		<dd class="even"><a href="//lishi.qidian.com/" target="_blank" data-aid="qd_A78"><cite><em class="iconfont"></em><span class="info"><i>历史</i><b>5653</b></span></cite></a></dd>
		<dd><a href="//youxi.qidian.com/" target="_blank" data-aid="qd_A79"><cite><em class="iconfont"></em><span class="info"><i>游戏</i><b>7665</b></span></cite></a></dd>
		<dd><a href="//tiyu.qidian.com/" target="_blank" data-aid="qd_A80"><cite><em class="iconfont tiyu"></em><span class="info"><i>体育</i><b>7476</b></span></cite></a></dd>
		<dd class="even"><a href="//kehuan.qidian.com/" target="_blank" data-aid="qd_A81"><cite><em class="iconfont"></em><span class="info"><i>科幻<strong class="rec"></strong></i><b>9661</b></span></cite></a></dd>
		<dd class="even"><a href="//lingyi.qidian.com/" target="_blank" data-aid="qd_A82"><cite><em class="iconfont lingyi"></em><span class="info"><i>灵异</i><b>39141</b></span></cite></a></dd>
		<dd><a href="//www.qdmm.com/" target="_blank" data-aid="qd_A83"><cite><em class="iconfont"></em><span class="info"><i>女生网</i><b>49971</b></span></cite></a></dd>
		<dd><a href="//2cy.qidian.com/" target="_blank" data-aid="qd_A84"><cite><em class="iconfont erciyuan"></em><span class="info"><i>二次元</i><b>56663</b></span></cite></a></dd>
		</dl>
	</div>
	<div class="focus-box fl" data-l1="6">
		<div class="focus-slider">
			<div class="lbf-slides switchable-slides" id="switchable-slides">
				<ul>
					<li id="item1" data-rankid="1" style="transition: transform 300ms linear; backface-visibility: hidden; transform: translateX(0%);"><a href="http://www.qidian.com/Book/3686217.aspx" target="_blank" data-aid="qd_A85"><img src="//qidian.qpic.cn/qidian_common/349573/ed49f2f0c0f1505a651ce24253ab13c4/0" width="100%"></a></li>
					<li id="item2" data-rankid="2" style="display: list-item; transition: transform 300ms linear; transform: translateX(-100%); backface-visibility: hidden;"><a href="http://www.qidian.com/Book/3641743.aspx" target="_blank" data-aid="qd_A86"><img class="load" data-src=" http://qidian.qpic.cn/qidian_common/349573/7629298c7369f4868d935587b0426cb9/0" width="100%" src=" http://qidian.qpic.cn/qidian_common/349573/7629298c7369f4868d935587b0426cb9/0"></a></li>
					<li id="item3" data-rankid="3" style="display: list-item; transition: transform 300ms linear; transform: translateX(-100%); backface-visibility: hidden;"><a href="http://www.qidian.com/Book/3573039.aspx" target="_blank" data-aid="qd_A87"><img class="load" data-src=" http://qidian.qpic.cn/qidian_common/349573/6c70a314037e3d1e0846f3d2b156501a/0" width="100%" src=" http://qidian.qpic.cn/qidian_common/349573/6c70a314037e3d1e0846f3d2b156501a/0"></a></li>
					<li id="item4" data-rankid="4" style="display: list-item; transition: transform 300ms linear; transform: translateX(-100%); backface-visibility: hidden;"><a href="http://www.qidian.com/Book/3682326.aspx" target="_blank" data-aid="qd_A88"><img class="load" data-src=" http://qidian.qpic.cn/qidian_common/349573/59c4bcee809c0ddbae44e9de43fc30e1/0" width="100%" src=" http://qidian.qpic.cn/qidian_common/349573/59c4bcee809c0ddbae44e9de43fc30e1/0"></a></li>
					<li id="item5" data-rankid="5" style="display: list-item; transition: transform 300ms linear; transform: translateX(-100%); backface-visibility: hidden;"><a href="http://game.qidian.com/index.aspx" target="_blank" data-aid="qd_A89"><img class="load" data-src=" //qidian.qpic.cn/qidian_common/349573/2bcccc15e3d34428feda08e8a98aa87c/0" width="100%" src=" //qidian.qpic.cn/qidian_common/349573/2bcccc15e3d34428feda08e8a98aa87c/0"></a></li>
				</ul>
			<div class="thumb lbf-button-group nav">
				<a href="#item1" class="lbf-button active">剑娘</a>
				<a href="#item2" class="lbf-button">超品奇才</a>
				<a href="#item3" class="lbf-button">恶灵国度</a>
				<a href="#item4" class="lbf-button">异界大召唤系统</a>
				<a href="#item5" class="lbf-button game-link" target="_blank" data-aid="qd_A89"><em class="iconfont yxtd"></em>游戏天地</a>
			</div>
		</div>
	</div>
	<div class="focus-img cf">
			<ul>
				<li><a href="http://mp.weixin.qq.com/s?__biz=MTk1MjM1NjQyMQ==&amp;mid=2652585315&amp;idx=1&amp;sn=e55497557bd734ec9f6b0c54bb11a642#rd" target="_blank" data-aid="qd_A90"><img src="//qidian.qpic.cn/qidian_common/349573/b1fd8262af344eacae63759890ace9b3/0"></a></li>
				<li class="middle"><a href="http://game.qidian.com/game/LoginGame/Login2012.aspx?areaUrl=czEwLnR0eHkuZ2FtZS5xaWRpYW4uY29tfGdhbWVpZD0zNDd8Z2FtZW5hbWU9zajM7M730858Z2FtZWFyZWE9MTB8YXJlYW5hbWU9xvC14zEwx/h8YXJlYXNob3J0PXR0eHk%3d" target="_blank" data-aid="qd_A91"><img src="//qidian.qpic.cn/qidian_common/349573/7e674dc16f4cad06ba4699ec76d286e7/0"></a></li>
				<li><a href="http://activity.qidian.com/2016/newqidian" target="_blank" data-aid="qd_A92"><img src="//qidian.qpic.cn/qidian_common/349573/01965f6f44ef3d37dc524ebc25551772/0"></a></li>
			</ul>
	</div>
	</div>
	
	<div class="notice-wrap fr" data-l1="7">
		<div class="notice" id="notice">
			<a class="more" id="more-notice" href="javascript:" target="_blank" data-aid="qd_A99"><em class="dib-wrap point"><span></span><span></span><span></span></em><i style="top: -18px; right: -18px;"></i></a>
			<h3><a href="http://activity.qidian.com/2016/newqidian" target="_blank" data-aid="qd_A93">起点新版，福利天天送</a></h3><div class="notice-list"><ul><li class="color-type_0" data-rankid="1"><a href="http://acts.qidian.com/2016/5614479/" target="_blank" data-aid="qd_A94"><i>「</i>活动<i>」</i>星创奖：大玄幻时代</a></li><li class="color-type_0" data-rankid="2"><a href="http://www.qidian.com/News/ShowNews.aspx?newsiD=1074763" target="_blank" data-aid="qd_A95"><i>「</i>公告<i>」</i>阅文CCG夏日祭活动</a></li><li class="color-type_0" data-rankid="3"><a href="http://zt.qidian.com/2016/26887/index_1.html" target="_blank" data-aid="qd_A96"><i>「</i>公告<i>」</i>崛起：叶之凡的成神路</a></li>
			<li class="color-type_0" data-rankid="4"><a href="http://zt.qidian.com/2016/5613793/index.html" target="_blank" data-aid="qd_A97"><i>「</i>公告<i>」</i>欧洲杯狂欢节</a></li>
			<li class="color-type_0" data-rankid="5"><a class="red" href="http://game.qidian.com/game/tmld/20160527/index.html" target="_blank" data-aid="qd_A98"><em>页游</em>★☆毒医道之路★☆</a></li>
			<li class="color-type_0" data-rankid="6"><a class="red" href="http://game.qidian.com/game/nslm2/20160114/index.html" target="_blank" data-aid="qd_A99"><em>页游</em>★☆经典剧情再续★☆</a></li>
			</ul>
		</div>
		<div class="attention">
			<ul id="wordSlide" class="word_slide" data-rel="#wordSlide li"><em class="iconfont"></em>
			<li id="wordList1" style="display: list-item; transition: transform 250ms linear; backface-visibility: hidden; transform: translateY(-100%);" data-rel="wordList1" data-rankid="1"><a href="http://www.qidian.com/Book/3513193.aspx" target="_blank" data-aid="qd_A100">梦里迁回订阅了《雪鹰领主》</a></li>
			<li id="wordList2" data-rel="wordList2" data-rankid="1" style="display: list-item; transition: transform 250ms linear; transform: translateY(-100%); backface-visibility: hidden;"><a href="http://www.qidian.com/Book/2494758.aspx" target="_blank" data-aid="qd_A100">mndsgyt订阅了《武炼巅峰》</a></li>
			<li id="wordList3" data-rel="wordList3" data-rankid="2" style="display: list-item; transition: transform 250ms linear; transform: translateY(-100%); backface-visibility: hidden;"><a href="http://www.qidian.com/Book/1001818834.aspx" target="_blank" data-aid="qd_A100">逸年1若风订阅了《实业帝国》</a></li>
			<li id="wordList4" data-rel="wordList4" data-rankid="3" style="display: list-item; transition: transform 250ms linear; transform: translateY(-100%); backface-visibility: hidden;"><a href="http://www.qidian.com/Book/1003303774.aspx" target="_blank" data-aid="qd_A100">蜗牛老板订阅了《慕南枝》</a></li>
			<li id="wordList5" data-rel="wordList5" data-rankid="4" style="display: list-item; transition: transform 250ms linear; transform: translateY(-100%); backface-visibility: hidden;"><a href="http://www.qidian.com/Book/3660066.aspx" target="_blank" data-aid="qd_A100">书友160703144244357订阅了《我的妹妹是偶像》</a></li>
			<li id="wordList6" data-rel="wordList6" data-rankid="5" style="display: list-item; transition: transform 250ms linear; transform: translateY(-100%); backface-visibility: hidden;"><a href="http://www.qidian.com/Book/3623299.aspx" target="_blank" data-aid="qd_A100">fiona216订阅了《妻贵》</a></li>
			<li id="wordList7" data-rel="wordList7" data-rankid="6" style="display: list-item; transition: transform 250ms linear; transform: translateY(-100%); backface-visibility: hidden;"><a href="http://www.qidian.com/Book/1003349860.aspx" target="_blank" data-aid="qd_A100">阿金订阅了《混在澳洲当土豪》</a></li>
			<li id="wordList8" data-rel="wordList8" data-rankid="7" style="display: list-item; transition: transform 250ms linear; transform: translateY(-100%); backface-visibility: hidden;"><a href="http://www.qidian.com/Book/1002491846.aspx" target="_blank" data-aid="qd_A100">被抛弃的感觉订阅了《红色苏联》</a></li>
			<li id="wordList9" data-rel="wordList9" data-rankid="8" style="display: list-item; transition: transform 250ms linear; transform: translateY(-100%); backface-visibility: hidden;"><a href="http://www.qidian.com/Book/3513193.aspx" target="_blank" data-aid="qd_A100">lonelyc8订阅了《雪鹰领主》</a></li>
			<li id="wordList10" data-rel="wordList10" data-rankid="9" style="display: list-item; transition: transform 250ms linear; transform: translateY(-100%); backface-visibility: hidden;"><a href="http://www.qidian.com/Book/3645401.aspx" target="_blank" data-aid="qd_A100">Zerohop订阅了《我的庄园》</a></li>
			<li id="wordList11" data-rel="wordList11" data-rankid="10" style="display: list-item; transition: transform 250ms linear; transform: translateY(0%); backface-visibility: hidden;"><a href="http://www.qidian.com/Book/3198729.aspx" target="_blank" data-aid="qd_A100">书友150227214121564订阅了《农家仙田》</a></li>
			</ul>
		</div>
	</div>
	
	<div class="notice-banner" id="tr-banner" data-l1="30"><a href="javascript:" target="_blank" data-aid="qd_A101"><img src=""></a><a href="http://game.qidian.com/game/LoginGame/Login2012.aspx?areaUrl=czEwLnR0eHkuZ2FtZS5xaWRpYW4uY29tfGdhbWVpZD0zNDd8Z2FtZW5hbWU9zajM7M730858Z2FtZWFyZWE9MTB8YXJlYW5hbWU9xvC14zEwx/h8YXJlYXNob3J0PXR0eHk%3d" target="_blank" data-aid="qd_A101" style="display: inline;"></a><embed class="flash_banner fix" src="//qidian.qpic.cn/qidian_common/349573/879d0f78e3b42430645e3de31402b8f1/0" quality="high" wmode="transparent" type="application/x-shockwave-flash" autostart="1">
	</div>
	</div>
	</div>
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