<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
Reply.jsp<br>

<form:form commandName="bean" method="post" action="reply.bd">
<input type="hidden" name="ref" value="${ref }">
<input type="hidden" name="restep" value="${restep }">
<input type="hidden" name="relevel" value="${relevel }">

<table border = "1">
  	<tr>
  		<th align="right" colspan="2"><a href="List.bd?pageNum=${pageNumber}">글목록</a></th>	
  	</tr>
  	
  	<tr>
  		<td width="100">이 름</td>
  		<td>
  			<input type="text" name="writer" value="홍길동">
  			<form:errors cssClass="err" path="writer" />
  		</td> 
  	</tr>
  	
  	<tr>
  		<td width="100">제 목</td>
  		<td>
  			<input type="text" name="subject" value="[답글]">
  			<form:errors cssClass="err" path="subject" />
  		</td> 
  	</tr>
  	
  	<tr>
  		<td width="100">Email</td>
  		<td>
  			<input type="text" name="email" value="@">
  			<form:errors cssClass="err" path="email" />
  		</td> 
  	</tr>
  	
  	<tr>
  		<td width="100">내용</td>
  		<td>
  			<textarea name="content" rows="15" cols="50">호호호</textarea>
  			<form:errors cssClass="err" path="content" />
  		</td> 
  	</tr>
  	
  	<tr>
  		<td width="100">비밀번호</td>
  		<td>
  			<input type="password" name="passwd" value="1234">
  			<form:errors cssClass="err" path="passwd" />
  		</td> 
  	</tr>
  	
  	<tr>
  		<td colspan="2" align="center">
  			<input type="submit" value="답글쓰기">
  			<input type="reset" value="다시작성">
  			<input type="button" value="목록보기" onClick="location.href='List.bd?pageNum=${pageNumber}'">
  		</td>	
  	</tr>
  	
</table>
</form:form>
    
    
    