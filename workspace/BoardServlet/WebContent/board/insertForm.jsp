<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>신규 게시글 등록</title>
</head>
<body>
	<form method="post" action="<%=request.getContextPath() %>/board/insert">
		<table>
			<tr>
				<td>제목:</td>
				<td><input type="text" name="board_title"></td>
			</tr>		
			<tr>
				<td>작성자:</td>
				<td><input type="text" name="board_writer"></td>
			</tr>		
			<tr>
				<td>날짜:</td>
				<td><input type="date" name="board_date"></td>
			</tr>		
			<tr>
				<td>내용:</td>
				<td><input type="text" name="board_content"></td>
			</tr>		
					
		</table>
		<input type="submit" value="게시글 등록">
	</form>
</body>
</html>