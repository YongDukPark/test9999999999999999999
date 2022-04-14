<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
Update.jsp<br>

<form:form commandName="bean" method="post" action="update.bd?pageNumber=${pageNumber }">	
	<input type="hidden" name="num" value = "${num }">							
									
<table border = "1">
  	<tr>
  		<th align="right" colspan="2">
  			<a href="List.bd?pageNum=${pageNumber}">글목록</a>
  		</th>	
  	</tr>
  	
  	
  	<tr>
  		<td width="100">이 름</td>
  		<td>
  			<input type="text" name="writer" value="${bean.writer }">
  			<form:errors cssClass="err" path="writer" />
  		</td> 
  	</tr>
  	
  	<tr>
  		<td width="100">제 목</td>
  		<td>
  			<input type="text" name="subject" value="${bean.subject }">
  			<form:errors cssClass="err" path="subject" />
  		</td> 
  	</tr>
  	
  	<tr>
  		<td width="100">Email</td>
  		<td>
  			<input type="text" name="email" value="${bean.email }">
  			<form:errors cssClass="err" path="email" />
  		</td> 
  	</tr>
  	
  	<tr>
  		<td width="100">내용</td>
  		<td>
  			<textarea name="content" rows="15" cols="50">${bean.content }</textarea>
  			<form:errors cssClass="err" path="content" />
  		</td> 
  	</tr>
  	
  	<tr>
  		<td width="100">비밀번호</td>
  		<td>
  			<input type="password" name="passwd">
  			<form:errors cssClass="err" path="passwd" />
  		</td> 
  	</tr>
  	
  	<tr>
  		<td colspan="2" align="center">
  			<input type="submit" value="수정">
  			<input type="reset" value="다시작성">
  			<input type="button" value="목록보기" onClick="location.href='List.bd?pageNum=${pageNumber}'">
  		</td>	
  	</tr>
</table>
</form:form>









