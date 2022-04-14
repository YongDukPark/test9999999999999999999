<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<style type="text/css">
 		body {
 			text-align: center;
 		}
 		table{
			margin : auto; /* 사방으로 가운데 하고싶을때 사용 */ 			
 		}
</style>


<b>글쓰기</b>

<link rel="stylesheet" href="style.css">


<%@ include file="color.jsp" %>

<body bgcolor="<%=bodyback_c%>">

<form:form commandName="boardBean" method="post" action="write.bd?pagetNumber=${pageNumber }">
<table border = "1">
  	<tr>
  		<th align="right" colspan="2"><a href="List.bd?pageNumber=${pageNumber }">글목록</a></th>	
  	</tr>
  	
  	<tr>
  		<td width="100" bgcolor="<%=value_c%>" align="center">이 름</td>
  		<td>
  			<input type="text" name="writer" value="홍길동">
  			<form:errors cssClass="err" path="writer" />
  		</td> 
  	</tr>
  	
  	<tr>
  		<td width="100" bgcolor="<%=value_c%>">제 목</td>
  		<td>
  			<input type="text" name="subject" value="제목">
  			<form:errors cssClass="err" path="subject" />
  		</td> 
  	</tr>
  	
  	<tr>
  		<td width="100" bgcolor="<%=value_c%>">Email</td>
  		<td>
  			<input type="text" name="email" value="@">
  			<form:errors cssClass="err" path="email" />
  		</td> 
  	</tr>
  	
  	<tr>
  		<td width="100" bgcolor="<%=value_c%>">내용</td>
  		<td>
  			<textarea name="content" rows="15" cols="50">호호호</textarea>
  			<form:errors cssClass="err" path="content" />
  		</td> 
  	</tr>
  	
  	<tr>
  		<td width="100" bgcolor="<%=value_c%>">비밀번호</td>
  		<td>
  			<input type="password" name="passwd" value="1234">
  			<form:errors cssClass="err" path="passwd" />
  		</td> 
  	</tr>
  	
  	<tr>
  		<td colspan="2" align="center">
  			<input type="submit" value="글쓰기">
  			<input type="reset" value="다시작성">
  			<input type="button" value="목록보기" onClick="location.href='List.bd?pageNum=${pageNumber}'">
  		</td>	
  	</tr>
  	
</table>
</form:form>
</body>


