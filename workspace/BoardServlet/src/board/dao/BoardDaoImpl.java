package board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import board.vo.BoardVO;


public class BoardDaoImpl implements IBoardDao{
	private static IBoardDao boardDao;
	
	private BoardDaoImpl() {
		
	}
	
	public static IBoardDao getInstance() {
		if(boardDao == null) {
			boardDao = new BoardDaoImpl();
		}
		
		return boardDao;
	}
	
	@Override
	public int insertBoard(SqlMapClient smc, BoardVO bv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.insert("board.insertBoard", bv);
		
		if(obj == null) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public int updateBoard(SqlMapClient smc, BoardVO bv) throws SQLException {
		int cnt = smc.update("board.updateBoard", bv);
		
		return cnt;
	}

	@Override
	public int deleteBoard(SqlMapClient smc, String board_no) throws SQLException {
		int cnt = smc.delete("board.deleteBoard", board_no);
		
		return cnt;
	}

	@Override
	public BoardVO getBoard(SqlMapClient smc, String board_no) throws SQLException {
		BoardVO bv = 
		(BoardVO)smc.queryForObject("board.getBoard", board_no);
		
		return bv;
	}

	@Override
	public List<BoardVO> boardAll(SqlMapClient smc) throws SQLException {
		List<BoardVO> boardList = 
				smc.queryForList("board.boardAll");
		
		return boardList;
	}

}
