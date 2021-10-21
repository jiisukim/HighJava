package dao;
import java.sql.SQLException;
import java.util.List;
import com.ibatis.sqlmap.client.SqlMapClient;

import board.vo.BoardVO;

public class Dao {	
	
	private static Dao dao;
	private Dao() {}
	public static Dao getInstance() {
		if(dao==null) {
			dao = new Dao();
		}
		return dao;
	}

	public int insertPost(SqlMapClient smc, BoardVO post) throws SQLException {
		
		int cnt = 0;
		
		Object obj = smc.insert("post.insertPost",post);
		if(obj == null) {
			cnt = 1;
		}
		
		return cnt;

	}
	public int deletePost(SqlMapClient smc, String board_no) throws SQLException {
		int cnt = 0;
		
		cnt = (int)smc.delete("post.deletePost", board_no);
		
		
		return cnt;
	}
	
	public int updatePost(SqlMapClient smc, BoardVO post) throws SQLException {
		
		int cnt = 0;
		
		cnt = (int)smc.update("post.updatePost", post);
		
		return cnt;
	}
	
	public List<BoardVO> displayPostAll(SqlMapClient smc) throws SQLException {
		List<BoardVO> list = smc.queryForList("post.displayPostAll");
		return list;
	}
	
	public List<BoardVO> searchPost(SqlMapClient smc, BoardVO post) throws SQLException {
		
		List<BoardVO> list = smc.queryForList("post.searchPost", post);
		return list;
	}
	
	public boolean checkPost(SqlMapClient smc, String board_no) throws SQLException {
		boolean check = false;
		
		int count = (int) smc.queryForObject("post.checkPost", board_no);
	
		if (count > 0) {
			check = true;
		}
		
		return check;
	}
	
	public String nextPost(SqlMapClient smc) throws SQLException {
		String board_no = "";
		board_no = (String) smc.queryForObject("post.nextPost");
		return board_no;
	}
	
}
