<%@page import="board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
	BoardVO boVo = (BoardVO)request.getAttribute("boVo");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세글 조회</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>No.</td>
			<td><%=boVo.getBoard_no() %></td>
		</tr>
		<tr>
			<td>작성자:</td>
			<td><%=boVo.getBoard_writer() %></td>
		</tr>
		<tr>
			<td>제목:</td>
			<td><%=boVo.getBoard_title() %></td>
		</tr>
		<tr>
			<td>날짜:</td>
			<td><%=boVo.getBoard_date() %></td>
		</tr>
		<tr>
			<td>내용:</td>
			<td><%=boVo.getBoard_content() %></td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="boardList">[목록]</a>
				<a href="update?board_no=<%=boVo.getBoard_no() %>">[게시글 수정]</a>
				<a href="delete?board_no=<%=boVo.getBoard_no() %>">[게시글 삭제]</a>
			</td>
		</tr>
	</table>
</body>
</html>