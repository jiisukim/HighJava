package service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ibatis.sqlmap.client.SqlMapClient;

import board.vo.BoardVO;
import dao.Dao;
import util.SqlMapClientFactory;


public class Service {
	
	private Dao dao = Dao.getInstance();
	private SqlMapClient smc = SqlMapClientFactory.getInstance();
	private static Service service;
	private Service() {}
	public static Service getInstance() {
		if(service == null) {
			service = new Service();
		}
		return service;
	}
	
	public int insertPost(BoardVO post) {
		
		
		int cnt = 0;
		
		try {
			cnt = dao.insertPost(smc, post);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	public int deletePost(String board_no) {
		
		int cnt = 0;
		try {
			cnt = dao.deletePost(smc, board_no);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return cnt;
	}
	
	public int updatePost(BoardVO post) {
		
		int cnt = 0;
		try {
			cnt = dao.updatePost(smc, post);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return cnt;
	}
	public List<BoardVO> searchPost(BoardVO post){
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			list = dao.searchPost(smc, post);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return list;
	}
	
	
	public List<BoardVO> displayPostAll(){
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			list = dao.displayPostAll(smc);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return list;
	}
	public String nextPost() {
		
		String next = "";
		try {
			next = dao.nextPost(smc);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return next;
	}
	
	public boolean checkPost(String board_no) {
		
		boolean chk = false;
		try {
			chk = dao.checkPost(smc, board_no);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return chk;
	}
	
}
