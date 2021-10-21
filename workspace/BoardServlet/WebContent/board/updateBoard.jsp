<%@page import="java.net.URLEncoder"%>
<%@page import="board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	BoardVO boVo = (BoardVO)request.getAttribute("boVo");
// 	String board_no = boVo.getBoard_no()==null?"":boVo.getBoard_no();
// 	String board_title= boVo.getBoard_title()==null?"":boVo.getBoard_title();
// 	String board_writer = boVo.getBoard_writer()==null?"":boVo.getBoard_writer();
// 	String board_content = boVo.getBoard_content()==null?"":boVo.getBoard_content();
	
// 	String encode_no = URLEncoder.encode(board_no,"UTF-8");
// 	String encode_title= URLEncoder.encode(board_title,"UTF-8");
// 	String encode_writer = URLEncoder.encode(board_writer,"UTF-8");
// 	String encode_content = URLEncoder.encode(board_content,"UTF-8");
%>    	    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<form method="post" action="<%=request.getContextPath() %>/board/update">
		<input type="hidden" name="board_no" value="<%=boVo.getBoard_no() %>">
		<table>
			<tr>
				<td>제목:</td>
				<td><input type="text" name="board_title" value="<%=boVo.getBoard_title()%>"></td>
				
			</tr>		
			<tr>
				<td>작성자:</td>
				<td><input type="text" name="board_writer" value="<%=boVo.getBoard_writer()%>"></td>
			</tr>			
			<tr>
				<td>내용:</td>
				<td><textarea name="board_content"><%=boVo.getBoard_content()%></textarea></td>
			</tr>		
		</table>
		<input type="submit" value="게시글 수정">
	</form>
</body>
</html>