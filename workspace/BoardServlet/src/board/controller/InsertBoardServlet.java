package board.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;



public class InsertBoardServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/board/insertForm.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		// 1.요청 파라미터정보 가져오기
		String board_title = req.getParameter("board_title");
		String board_writer = req.getParameter("board_writer");
		String board_date = req.getParameter("board_date");
		String board_content = req.getParameter("board_content");
		
		BoardVO bv = new BoardVO();
		bv.setBoard_title(board_title);
		bv.setBoard_writer(board_writer);
		bv.setBoard_date(board_date);
		bv.setBoard_content(board_content);
		
		// 2. 서비스 객체 생성하기
		IBoardService boardService = 
				BoardServiceImpl.getInstance();
		
		// 3. 회원등록
		int cnt = boardService.insertBoard(bv);
		
		String msg = "";
		if(cnt > 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
		// 4. 목록 조회화면으로 이동
		//req.getRequestDispatcher("/member/list")
		//			.forward(req, resp);
		
		resp.sendRedirect(req.getContextPath() 
				+ "/board/boardList?msg=" + URLEncoder.encode(msg, "utf-8"));
		
	}
	
	
}
