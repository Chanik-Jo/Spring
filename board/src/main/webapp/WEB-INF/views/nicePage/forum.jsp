<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html style="font-size: 16px;" lang="ko-KR">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<meta name="keywords"
	content="Learn Everyday, Join online courses today, Train Your Brain Today!, Learn to enjoyevery minute of your life., Online Learning, Innovations in Online Learning, Education and Learning, 01, 02, 03, 04, Contact Us">
<meta name="description" content="">
<meta name="page_type" content="np-template-header-footer-from-plugin">
<title>forum</title>
<link rel="stylesheet" href="../../resources/css/nicepage.css"
	media="screen">
<!-- 나중에 nicepage에서 고친 새로운 css를 적용해야한다. 아직도 문제가 해결되지 않는다. -->
<link rel="stylesheet" href="../../resources/css/forum.css"
	media="screen">
<script class="u-script" type="text/javascript"
	src="../../resources/js/jquery.js" defer=""></script>
<script class="u-script" type="text/javascript"
	src="../../resources/js/nicepage.js" defer=""></script>
<meta name="generator" content="Nicepage 3.9.3, nicepage.com">

<script>

	document.getElementById("searchBtn").onclick = function () {
		  
		let searchType = document.getElementsByName("searchType")[0].value;
		let keyword =  document.getElementsByName("keyword")[0].value;
		
		location.href = "/forum/listPageSearch?num=1" + "&searchType=" + searchType + "&keyword=" + keyword;
	};
</script>

<script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": "Site1",
		"url": "index.html"
}</script>
<meta property="og:title" content="forum">
<meta property="og:type" content="website">
<meta name="theme-color" content="#478ac9">
<link rel="canonical" href="index.html">
<meta property="og:url" content="index.html">
</head>
<body class="u-body u-stick-footer">
	<%@ include file="./headAndFooter/header.jsp"%>


	<section class="u-clearfix u-image u-section-1" id="sec-177b"
		data-image-width="1980" data-image-height="1114">
		<div
			class="u-clearfix u-sheet u-valign-middle-lg u-valign-middle-md u-valign-middle-sm u-valign-middle-xs u-valign-top-xl u-sheet-1">
			<div
				class="u-clearfix u-expanded-width u-layout-wrap u-layout-wrap-1">
				<div class="u-gutter-0 u-layout">
					<div class="u-layout-col">
						<div
							class="u-align-center u-container-style u-layout-cell u-size-30 u-layout-cell-1">
							<div
								class="u-container-layout u-valign-middle-lg u-valign-middle-md u-valign-middle-xl u-container-layout-1">
								<a href="/forum/write" class="u-btn u-button-style u-btn-1">new</a>





							
								<div class="u-text u-text-1">
									<select name="searchType">
										<option value="title"
											<c:if test="${page.searchType eq 'title'}">selected</c:if>>제목</option>
										<option value="content"
											<c:if test="${page.searchType eq 'content'}">selected</c:if>>내용</option>
										<option value="title_content"
											<c:if test="${page.searchType eq 'title_content'}">selected</c:if>>제목+내용</option>
										<option value="writer"
											<c:if test="${page.searchType eq 'writer'}">selected</c:if>>작성자</option>
									</select> <input type="text" name="keyword" value="${page.keyword}" />

									<button class="u-btn u-button-style u-btn-2" type="button"
										id="searchBtn">검색</button>
								</div>

							</div>
						</div>
						<div
							class="u-container-style u-layout-cell u-size-30 u-layout-cell-2">
							<div
								class="u-container-layout u-valign-middle-lg u-valign-middle-xl u-container-layout-2">
								<p class="u-align-center u-text u-text-2">
									<c:if test="${page.prev}">

										<span>[<a href="/forum/listPageSearch?num=${page.startPageNum - 1}${page.searchTypeKeyword}">이전</a>	]
										</span>
									</c:if>

									<c:forEach begin="${page.startPageNum}"
										end="${page.endPageNum}" var="num">
										<span> <c:if test="${select != num}">
												<a href="/forum/listPageSearch?num=${num}${page.searchTypeKeyword}">${num}</a>
<!-- 												searchTypeKeyword : "&searchType=" + searchType + "&keyword=" + keyword;	 -->
											</c:if> <c:if test="${select == num}">
												<b>${num}</b>
											</c:if>
										</span>
									</c:forEach>
									<c:if test="${page.next}">
										<span>[ <a href="/forum/listPageSearch?num=${page.endPageNum + 1}${page.searchTypeKeyword}">다음</a>]
										</span>
									</c:if>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section
		class="u-align-left u-clearfix u-image u-image-tiles u-section-2"
		id="sec-8581" data-image-width="1980" data-image-height="1114">
		<div
			class="u-clearfix u-sheet u-valign-top-lg u-valign-top-md u-valign-top-xl u-sheet-1">
			<div
				class="u-clearfix u-expanded-width u-gutter-0 u-layout-wrap u-layout-wrap-1">
				<div class="u-gutter-0 u-layout">
					<div class="u-layout-row">
						<div
							class="u-container-style u-layout-cell u-size-60 u-layout-cell-1">
							<div class="u-container-layout u-container-layout-1">
								<div
									class="u-align-left-lg u-align-left-xl u-expanded-width u-hidden-sm u-hidden-xs u-table u-table-responsive u-table-1">
									<table class="u-table-entity">
										<colgroup>
											<col width="5.3%">
											<col width="61.7%">
											<col width="19.4%">
											<col width="3.1%">
											<col width="10.5%">
										</colgroup>
										<thead
											class="u-palette-4-base u-table-header u-table-header-1">

											<tr style="height: 68px;">

												<th class="u-border-1 u-border-palette-4-base u-table-cell">번호<br>
												</th>
												<th class="u-border-1 u-border-palette-4-base u-table-cell">제목</th>
												<th class="u-border-1 u-border-palette-4-base u-table-cell">작성일</th>
												<th class="u-border-1 u-border-palette-4-base u-table-cell">작성자</th>
												<th class="u-border-1 u-border-palette-4-base u-table-cell">조회수</th>
											</tr>

										</thead>
										<tbody class="u-table-body">
											<c:forEach items="${list}" var="list">
												<tr style="height: 80px;">

													<td
														class="u-border-1 u-border-grey-30 u-first-column u-grey-5 u-table-cell u-table-cell-6">${list.bno}<br>
													</td>
													<td class="u-border-1 u-border-grey-30 u-table-cell"><a
														href="/forum/view?bno=${list.bno}">${list.title}</a></td>
													<td class="u-border-1 u-border-grey-30 u-table-cell"><fmt:formatDate
															value="${list.regDate}" pattern="yyyy-MM-dd" /></td>
													<td class="u-border-1 u-border-grey-30 u-table-cell">${list.writer}</td>
													<td class="u-border-1 u-border-grey-30 u-table-cell">${list.viewCnt}</td>

												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<div
									class="u-expanded-width u-hidden-lg u-hidden-md u-hidden-xl u-table u-table-responsive u-table-2">
									<table class="u-table-entity">
										<colgroup>
											<col width="94%">
											<col width="6%">
										</colgroup>
										<thead
											class="u-palette-4-base u-table-header u-table-header-2">
											<tr style="height: 57px;">
												<th class="u-border-1 u-border-palette-4-base u-table-cell">제목</th>
												<th class="u-border-1 u-border-palette-4-base u-table-cell">조회수</th>
											</tr>
										</thead>
										<tbody class="u-table-body">
											<c:forEach items="${list}" var="list">
												<tr style="height: 26px;">

													<td
														class="u-border-1 u-border-grey-30 u-table-cell u-white u-table-cell-13"><a
														href="/forum/view?bno=${list.bno}">${list.title}</a></td>
													<td class="u-border-1 u-border-grey-30 u-table-cell">${list.viewCnt}<br>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<%@ include file="./headAndFooter/footer.jsp"%>
	<script>

	document.getElementById("searchBtn").onclick = function () {
		  
		let searchType = document.getElementsByName("searchType")[0].value;
		let keyword =  document.getElementsByName("keyword")[0].value;
		
		location.href = "/board/listPageSearch?num=1" + "&searchType=" + searchType + "&keyword=" + keyword;
	};
</script>
</body>
</html>