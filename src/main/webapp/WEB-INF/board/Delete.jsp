<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">

	function goList(){
		location.href="List.bd?pageNumber="+${pageNumber};
	}
	
</script>    

    
    
    
<form method="post" action="delete.bd?num=${num }&pageNumber=${pageNumber}">
	<table border="1" align="center">
		<tr>
			<td>비밀번호를 입력하세요</td>
		</tr>
		<tr>
			<td>비밀번호 : <input type="password" name="password"></td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="글삭제">
				<input type="button" value="글목록" onclick="goList()">
			</td>
		</tr>
	</table>
</form>    