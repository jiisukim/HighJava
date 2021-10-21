package board.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import board.dao.BoardDaoImpl;
import board.dao.IBoardDao;
import board.util.SqlMapClientFactory;
import board.vo.BoardVO;

public class BoardServiceImpl implements IBoardService{
	private IBoardDao boardDao;
	
	private static IBoardService boardService;
	
	private SqlMapClient smc;
	
	private BoardServiceImpl() {
		boardDao = BoardDaoImpl.getInstance();
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IBoardService getInstance() {
		
		if(boardService == null) {
			boardService = new BoardServiceImpl();
		}
		
		return boardService;
	}

	@Override
	public int insertBoard(BoardVO bv) {
		int cnt = 0;
		
		try {
			cnt = boardDao.insertBoard(smc, bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO bv) {
		int cnt = 0;
		
		try {
			cnt = boardDao.updateBoard(smc, bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int deleteBoard(String board_no) {
		int cnt = 0;
		
		try {
			cnt = boardDao.deleteBoard(smc, board_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public BoardVO getBoard(String board_no) {
		BoardVO bv = null;
		try {
			bv = boardDao.getBoard(smc, board_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bv;
	}

	@Override
	public List<BoardVO> boardAll() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		try {
			boardList = boardDao.boardAll(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return boardList;
	}
	
	

}
