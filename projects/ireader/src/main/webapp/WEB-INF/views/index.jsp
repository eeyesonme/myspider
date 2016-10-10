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
					<c:forEach items="${categories}" var="category">
							<dd>
							<a href="http://127.0.0.1:8080/ireader/category/${category.id}" target="_blank">
								<cite><em class="iconfont">&#xe614</em>	<span class=info><i>${category.name}</i> <b>${category.bookCount }</b></span></cite>
							</a>
							</dd>
					</c:forEach>
				</dl>
			</div>
			<div class="focus-box fl" data-l1="6">
		<div class="focus-slider">
			<div class="lbf-slides switchable-slides" id="switchable-slides">
				<ul>
					<li id="item1" data-rankid="1" style="transition: transform 300ms linear; backface-visibility: hidden; transform: translateX(0%);"><a href="#" target="_blank" data-aid="qd_A85"><img src="//qidian.qpic.cn/qidian_common/349573/ed49f2f0c0f1505a651ce24253ab13c4/0" width="100%"></a></li>
					<li id="item2" data-rankid="2" style="display: list-item; transition: transform 300ms linear; transform: translateX(-100%); backface-visibility: hidden;"><a href="#" target="_blank" data-aid="qd_A86"><img class="load" data-src=" http://qidian.qpic.cn/qidian_common/349573/7629298c7369f4868d935587b0426cb9/0" width="100%" src=" http://qidian.qpic.cn/qidian_common/349573/7629298c7369f4868d935587b0426cb9/0"></a></li>
					<li id="item3" data-rankid="3" style="display: list-item; transition: transform 300ms linear; transform: translateX(-100%); backface-visibility: hidden;"><a href="#" target="_blank" data-aid="qd_A87"><img class="load" data-src=" http://qidian.qpic.cn/qidian_common/349573/6c70a314037e3d1e0846f3d2b156501a/0" width="100%" src=" http://qidian.qpic.cn/qidian_common/349573/6c70a314037e3d1e0846f3d2b156501a/0"></a></li>
					<li id="item4" data-rankid="4" style="display: list-item; transition: transform 300ms linear; transform: translateX(-100%); backface-visibility: hidden;"><a href="#" target="_blank" data-aid="qd_A88"><img class="load" data-src=" http://qidian.qpic.cn/qidian_common/349573/59c4bcee809c0ddbae44e9de43fc30e1/0" width="100%" src=" http://qidian.qpic.cn/qidian_common/349573/59c4bcee809c0ddbae44e9de43fc30e1/0"></a></li>
					<li id="item5" data-rankid="5" style="display: list-item; transition: transform 300ms linear; transform: translateX(-100%); backface-visibility: hidden;"><a href="#" target="_blank" data-aid="qd_A89"><img class="load" data-src=" //qidian.qpic.cn/qidian_common/349573/2bcccc15e3d34428feda08e8a98aa87c/0" width="100%" src=" //qidian.qpic.cn/qidian_common/349573/2bcccc15e3d34428feda08e8a98aa87c/0"></a></li>
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
				<li><a href="#" target="_blank" data-aid="qd_A90"><img src="//qidian.qpic.cn/qidian_common/349573/b1fd8262af344eacae63759890ace9b3/0"></a></li>
				<li class="middle"><a href="#" target="_blank" data-aid="qd_A91"><img src="//qidian.qpic.cn/qidian_common/349573/7e674dc16f4cad06ba4699ec76d286e7/0"></a></li>
				<li><a href="#" target="_blank" data-aid="qd_A92"><img src="//qidian.qpic.cn/qidian_common/349573/01965f6f44ef3d37dc524ebc25551772/0"></a></li>
			</ul>
	</div>
	</div>
	</div>
	
	<div class="index-two-wrap box-center mb40 cf">
		<div class="book-list-wrap mr30 fl" data-l1="8">
			<h3 class="wrap-title lang">本周强推<a class="more" href="#" data-aid="qd_A105" target="_blank">更多<em class="iconfont"></em></a></h3>
			<div class="book-list">
				<ul>
					<c:forEach items="${books.content}" var="book">
						<li class="">
							<a class="channel" href="http://xuanhuan.qidian.com" target="_blank" ><em>「</em>${book.category.name}<em>」</em></a>				
							<strong><a class="name" href="#" target="_blank" title="${book.name}">${book.name}</a></strong>
							<a class="author" href="#" data-aid="" target="_blank">${book.author.name}</a>
						</li>						
					</c:forEach>
				</ul>
			</div>
		</div>
		
		<div class="edit-rec-wrap fl" data-l1="9">
		<h3 class="wrap-title lang">编辑推荐</h3>
		
		<div class="focus-today cf" data-l2="1">
			<div class="slider-wrap fl">
				<div id="carousel" class="carousel">
					<div class="slides" style="display: block; width: 93px; height: 124px;">
						<c:forEach items="${books.content}" var="book" varStatus="rankid">
							<c:if test="${rankid.count <4}">
								<div class="slideItem" data-rankid="${rankid.count}"	style="width: ${93-rankid.count*15}px; height: ${105-rankid.count*15}px; top: ${10*count }px; right: ${0-rankdi.count*40 }px; opacity: 1; z-index: ${rankid.count -1}; display: block;">
									<a href="#"	target="_blank"><img	src="//qidian.qpic.cn/qdbimg/349573/3681640/180" title="${book.name}"	alt="${book.name}" 	style="width: ${93-rankid.count*15}px; height: ${105-rankid.count*15-10}px; display: inline-block;"></a>
									<div class="shadow"style="width: 93px; z-index: -1; position: absolute; margin: 0px; padding: 0px; border: none; overflow: hidden; left: 0px; bottom: 0px;">
										<div class="shadowLeft" style="position: relative; float: left;"></div>
										<div class="shadowMiddle" style="position: relative; float: left; width: 74.4px;"></div>
										<div class="shadowRight" style="position: relative; float: left;"></div>
									</div>
								</div>
								</c:if>
							</c:forEach>					
						<div class="spinner"  style="display: none; width: 93px; height: 124px; top: 0px; right: 0px; opacity: 1; z-index: 10; position: absolute; cursor: pointer; overflow: hidden; padding: 0px; margin: 0px; border: none;"></div>
						<div class="videoOverlay" 	style="display: none; width: 93px; height: 124px; top: 0px; right: 0px; opacity: 1; z-index: 9; position: absolute; cursor: pointer; overflow: hidden; padding: 0px; margin: 0px; border: none;"></div>
					</div>
					<div class="prevButton iconfont" data-aid="qd_A180"></div>
					<div class="nextButton iconfont" data-aid="qd_A170"></div>
					<div class="description">
						<c:forEach items="${books.content}" var="book" varStatus="rankid">
							<div class="desc-wrap" data-rankid="${rankid.count}" 	style="position: absolute; top: 0px; left: 0px; display: none;">
								<h3><a href="#" target="_blank">${book.name }</a>	</h3>
								<p>${book.description }</p>
								<a class="read-btn" href=""   target="_blank">书籍详情</a>
							</div>	
						 </c:forEach>				
					</div>
					<div class="nextButton"></div>
					<div class="prevButton"></div>
					<div class="buttonNav" style="width: 133px; height: 10px;">
						<div class="bullet" style="text-align: center;"></div>
						<div class="bullet" style="text-align: center;"></div>
						<div class="bullet" style="text-align: center;"></div>
						<div class="bullet" style="text-align: center;"></div>
						<div class="bullet" style="text-align: center;"></div>
						<div class="bullet" style="text-align: center;"></div>
						<div class="bullet bulletActive" style="text-align: center;"></div>
					</div>
				</div>
			</div>
		</div> <!-- end focus-today-->
		
		<div class="edit-rec" data-l2="2">
			<ul class="edit-rec-list bd  cf">
				<c:forEach items="${books.content}" var="book" varStatus="rankid">
					<c:if test="${ rankid.count <=3 }">
							<li data-rankid="rankid.count"><h3>	<a href="#"	 target="_blank">${book.name }</a>	</h3>	<em class="total"><cite>41,595</cite><i>人在追</i></em>
							<p>${book.description}</p></li>
					</c:if>
				</c:forEach>
			</ul>
			<div class="rel">	<p class="line"></p></div>
			<ul class="edit-rec-list  cf">
				<c:forEach items="${books.content}" var="book" varStatus="rankid">
					<c:if test="${ rankid.count >3 && rankid.count<=6 }">
							<li data-rankid="rankid.count"><h3>	<a href="#"	 target="_blank">${book.name }</a>	</h3>	<em class="total"><cite>41,595</cite><i>人在追</i></em>
							<p>${book.description}</p></li>
					</c:if>
				</c:forEach>
			</ul>
		</div><!--end edit-rec  -->
		
		</div> <!-- end edit-rec-wrap -->
	</div><!-- end index-two-wrap -->
	
	<!-- start of the rank block -->
	<div class="rank-wrap box-center mb20" data-l1="11">
		<div id="numero3">
			<div id="rank-list-row" class="rank-list-row cf mb20">
				<div class="rank-list" data-l2="1">
					<h3 class="wrap-title lang">原创风云榜<i>·</i>新书<a class="more" href="#" 	data-aid="qd_A118" target="_blank">更多<em class="iconfont"></em></a></h3>
					<div class="book-list">
						<ul>
							<c:forEach items="${books.content}" var="book" varStatus="status">
								<c:if test="${status.count==1}">
									<li class="unfold" data-rankid="${status.count }"><div class="book-wrap cf">
										<div class="book-info fl">
											<h3>NO.1</h3>
											<h4><a href="#"		target="_blank" data-aid="qd_A117" data-bid="1003307568">${book.name }</a>	</h4>
											<p class="digital">	<em>${book.id }</em>月票	</p>
											<p class="author">	<a class="type" href="#"	target="_blank">${book.category.name }</a><i>·</i><a class="writer"	href="#"target="_blank">${book.author.name}</a></p>
										</div>
										<div class="book-cover">
											<a class="link"	href="#"><img src="//qidian.qpic.cn/qdbimg/349573/1003307568/180" alt="${book.name}"></a><span></span>
										</div>
									</div>
									</li>
								</c:if>
								<c:if test="${status.count>1}">
									<li data-rankid="${status.count }">
										<div class="num-box">
										<span class="num2">${status.count }</span>
									</div>
									<div class="name-box">
										<a class="name"	href="#"	target="_blank" >${book.name }</a><i class="total">${book.id }</i>
									</div>
									</li>
								</c:if>
							 </c:forEach>						
						</ul>
					</div>
				</div>
				
				<div class="rank-list" data-l2="2">
					<h3 class="wrap-title lang">	周点击榜<a class="more" href="#" target="_blank"		data-aid="qd_A118">更多<em class="iconfont"></em></a></h3>
					<div class="book-list">
						<ul>
							<c:forEach items="${books.content}" var="book" varStatus="status">
								<c:if test="${status.count==1}">
									<li class="unfold" data-rankid="1"><div class="book-wrap cf">
										<div class="book-info fl">
											<h3>NO.1</h3>
											<h4>
												<a href="#" target="_blank" >${book.name }</a>
											</h4>
										<p class="digital">	<em>28570</em>点击	</p>
											<p class="author">	<a class="type" href="#"	target="_blank">${book.category.name }</a><i>·</i><a class="writer"	href="#"target="_blank">${book.author.name}</a></p>
										</div>
										<div class="book-cover">
											<a class="link"	href="#"><img src="//qidian.qpic.cn/qdbimg/349573/1003307568/180" alt="${book.name}"></a><span></span>
										</div>
									</div></li>
								</c:if>
								<c:if test="${status.count>1}">
									<li data-rankid="${status.count }">
											<div class="num-box">
											<span class="num2">${status.count }</span>
										</div>
										<div class="name-box">
											<a class="name"	href="#"	target="_blank" >${book.name }</a><i class="total">${book.id }</i>
										</div>
										</li>
								</c:if>
							</c:forEach>
						</ul>
					</div>
				</div>
				
				<div class="rank-list" data-l2="2">
					<h3 class="wrap-title lang">	周推荐榜<a class="more" href="#" target="_blank"		data-aid="qd_A118">更多<em class="iconfont"></em></a></h3>
					<div class="book-list">
						<ul>
							<c:forEach items="${books.content}" var="book" varStatus="status">
								<c:if test="${status.count==1}">
									<li class="unfold" data-rankid="1"><div class="book-wrap cf">
										<div class="book-info fl">
											<h3>NO.1</h3>
											<h4>
												<a href="#" target="_blank" >${book.name }</a>
											</h4>
										<p class="digital">	<em>28570</em>推荐票</p>
											<p class="author">	<a class="type" href="#"	target="_blank">${book.category.name }</a><i>·</i><a class="writer"	href="#"target="_blank">${book.author.name}</a></p>
										</div>
										<div class="book-cover">
											<a class="link"	href="#"><img src="//qidian.qpic.cn/qdbimg/349573/1003307568/180" alt="${book.name}"></a><span></span>
										</div>
									</div></li>
								</c:if>
								<c:if test="${status.count>1}">
									<li data-rankid="${status.count }">
											<div class="num-box">
											<span class="num2">${status.count }</span>
										</div>
										<div class="name-box">
											<a class="name"	href="#"	target="_blank" >${book.name }</a><i class="total">${book.id }</i>
										</div>
										</li>
								</c:if>
							</c:forEach>
						</ul>
					</div>
				</div>
				
				<div class="rank-list" data-l2="4">
					<h3 class="wrap-title lang">	24小时热销榜<a class="more" href="#"	data-aid="qd_A118" target="_blank">更多<em class="iconfont"></em></a>	</h3>
					<div class="book-list">
						<ul>
							<c:forEach items="${books.content}" var="book" varStatus="status">
								<c:if test="${status.count==1}">
									<li class="unfold" data-rankid="1"><div class="book-wrap cf">
										<div class="book-info fl">
											<h3>NO.1</h3>
											<h4>
												<a href="#" target="_blank" >${book.name }</a>
											</h4>
										<p class="digital f16">销量冠军</p>
										<p class="author">	<a class="type" href="#"	target="_blank">${book.category.name }</a><i>·</i><a class="writer"	href="#"target="_blank">${book.author.name}</a></p>
										</div>
										<div class="book-cover">
											<a class="link"	href="#"><img src="//qidian.qpic.cn/qdbimg/349573/1003307568/180" alt="${book.name}"></a><span></span>
										</div>
									</div></li>
								</c:if>
								<c:if test="${status.count>1}">
									<li data-rankid="${status.count }">
											<div class="num-box">
											<span class="num2">${status.count }</span>
										</div>
										<div class="name-box">
											<a class="name"	href="#"	target="_blank" >${book.name }</a><i class="total">${book.id }</i>
										</div>
										</li>
								</c:if>
							</c:forEach>
						</ul>
					</div>
					</div>
				</div>
			</div>
		</div>
	<!-- end of the rank block -->
	
	<!-- start of the update block -->
	<div class="update-wrap box-center mb40 cf" data-l1="19">
		<div class="update-rec-wrap fl" data-l2="1">
			<h3 class="wrap-title lang">最近更新<span>24小时内更新12450本</span></h3>
			<div class="update-rec-list">
					<ul>
							<c:forEach items="${books.content}" var="book" varStatus="rankid">
								<c:if test="${ rankid.count <=3 }">
									<li data-rankid="${rankid.count}">
										<div class="book-wrap cf">
												<h4> <a href="#"	target="_blank" data-aid="qd_A150" data-bid="3666748">${book.name }</a></h4>
												<p class="digital">	<span>日更1千+</span><i>·</i><span>9.3分</span></p>
												<p class="author">	<a class="writer" 	href="#" data-aid="" target="_blank">${book.author.name }</a></p>
										</div>
								</c:if>
							</c:forEach>
						</ul>
				</div>
			</div>
			
		<div class="update-list-wrap fl" data-l2="2">
				<div class="update-tab cf">
					<a class="blue" href="//a.qidian.com" target="_blank" data-aid="qd_A155">更多<em class="iconfont"></em></a><span class="blue">|</span>
				</div>
				<div id="update-list" class="update-list">
					<div class="update-table all">
						<table width="100%">
							<colgroup>	<col width="60px">	<col width="170px">	<col width="270px">	<col width="100px">	<col width="70px">	</colgroup>
							<tbody>
							<c:forEach items="${books.content}" var="book" varStatus="rankid">
									<tr data-rankid="${rankid.count}">	<td><a class="classify" href=""	data-aid="qd_A156" target="_blank"><em>「</em>${book.category.name}<em>」</em></a></td>
										<td><a class="name" href="#" target="_blank" data-aid="qd_A157" data-bid="1003720618">${book.name }</a></td>
										<td><a class="section"	href="#"	 target="_blank">正文卷 第十六章 训练开始</a></td>
										<td class="respon"><a class="author" href="#" data-aid="" target="_blank">${book.author.name }</a></td>
										<td class="respon"><i>08-16 15:11</i></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
			  </div>
		</div>
		
		<div class="god-wrap fr" data-l2="3">
			<h3 class="wrap-title lang">大神动态</h3>
			<div class="god-list">
				<ul>
				<c:forEach items="${gods}" var="god" varStatus="rankid">
				 <li data-rankid="${rankid.count }">
				 <div class="god-info">
						<div class="photo">
							<a href="#"	target="_blank" data-aid="qd_A161"><img class="lazy"	src="http://wfqqreader.3g.qq.com/cover/topic/newad_0_150812164854.jpg"	data-original="http://wfqqreader.3g.qq.com/cover/topic/newad_0_150812164854.jpg" style="display: inline;"></a>
						</div>
						<h3>
							<a href="#"	target="_blank" data-aid="qd_A160">${god.name }</a>
						</h3>
						<p class="type">仙侠小说领军人物</p>
						<h4>代表作</h4>
						<p class="works cf">
							<a href="#" target="_blank"	data-aid="qd_A162" data-bid="1264634">仙逆</a><span>|</span>
						</p>
						<h4>简介</h4>
						<p class="intro">喜爱中国古典神话故事，并以此为基础，进行网络小说的创作。主要代表作《仙逆》，受到无数读者的喜爱</p>
					</div>
				</li>
				</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<!-- end of the update block -->
</body>
</html>

	

