<%@page import="org.springframework.web.context.request.RequestScope"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../common/common.jsp" %>    

List.jsp<br>


<center>
<form action="list.bd">
	
	글목록(전체 글 : ${totalCount }) <br>
<table width="1000" border = "1">
  	<tr>
  		<td align="right"><a href="write.bd?pageNumber=${pageInfo.pageNumber }">글쓰기</a></td>	
  	</tr>
</table>


<table width = "1000" border = "1">
	<tr>
		<td align="center">번호</td>
		<td align="center">제목</td>
		<td align="center">작성자</td>
		<td align="center">작성일</td>
		<td align="center">조회</td>
		<td align="center">ip</td>
	</tr>
	
	
	<c:forEach var = "list" items="${list }">
		<tr>
			<td>${num = num-1 }</td>
			<td>
				
				<c:if test="${list.relevel>0 }">
					<c:set var="wid" value="${list.relevel*20}"/>
						<img src="${pageContext.request.contextPath}/resources/images/level.gif" width="${wid }" height="15"/>
						<img src="${pageContext.request.contextPath}/resources/images/re.gif"/>
				</c:if>
			
				${list.subject }
				<c:if test="${list.readcount>=10 }"><img src="${pageContext.request.contextPath}/resources/images/hot.gif"/></c:if>
			</td>
			<td>
				<a href="detailContent.bd?num=${list.num }&pageNumber=${pageInfo.pageNumber}">${list.writer }</a>
			</td>
			<td>
				<%-- <fmt:formatDate value="${list.regdate }" type="both" pattern="yyyy-mm-dd HH:mm:ss"/> --%>
				${list.regdate }
			</td>
			<td>
				${list.readcount }
			</td>
			<td>
				${list.ip }
			</td>
		</tr>
	</c:forEach>
	
</table>
	${pageInfo.pagingHtml}
</form>
</center>
