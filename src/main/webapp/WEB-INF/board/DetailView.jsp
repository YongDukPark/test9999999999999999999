<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
list.jsp(제목클릭시 번호를 넘긴다.) => content.jsp

<%/*
	int num = Integer.parseInt(request.getParameter("num"));
	int pageNum = Integer.parseInt(request.getParameter("pageNum"));
	out.print("num : " + num + "<br>");
	out.print("pageNum : " + pageNum + "<br>");
	
	BoardDao dao = BoardDao.getInstance();
	BoardBean bean = dao.getArticle(num);
	out.print(bean.getRef()+"/"+bean.getRe_step()+"/"+bean.getRe_level() + "<br>");
	
	*/
%>

<script type="text/javascript">

	function updateNum() {
		location.href="update.bd?num="+${bean.num }+"&pageNumber="+${pageNumber };
	}
	function deleteNum(){
		//alert(1);
		location.href="delete.bd?num="+${bean.num }+"&pageNumber="+${pageNumber };
	}
	function replyForm(){
		location.href="reply.bd?ref="+${bean.ref }+"&restep="+${bean.restep }+"&relevel="+${bean.relevel };
	}			
	function List() {
		//alert(1);
		location.href="List.bd?pageNumber="+${pageNumber};
		//
	}
	
	
	
</script>


<form method="post" action="writeProc.jsp">
<table border = "1" width = "500" align="center">
	<tr>
		<td align="center">글번호</td>
		<td align="center">${bean.num }</td>
		<td align="center">조회수</td>
		<td align="center">${bean.readcount}</td>
	</tr>
	
	<tr>
		<td align="center">작성자 ${bean.passwd }</td>
		<td align="center">${bean.writer}</td>
		<td align="center">작성일</td>
		<td align="center">${bean.regdate}</td>
	</tr>
	
	<tr>
		<td align="center">글제목</td>
		<td colspan="3">${bean.subject}</td>
	</tr>
	
	<tr height = "50">
		<td align="center">글내용</td>
		<td colspan="3">${bean.content}</td>
	</tr>
	
	<tr align="center" height = "50">
		<td colspan="4">
			<input type="button" value="글수정" onclick="updateNum()">
			<input type="button" value="글삭제" onclick="deleteNum()">
			<input type="button" value="답글쓰기" onclick="replyForm()">
			<input type="button" value="글목록" onclick="List()">		
		</td>																
	</tr>
	
</table>
</form>
    
