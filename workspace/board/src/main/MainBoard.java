package main;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import util.JDBCUtil;


public class MainBoard {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Scanner scan = new Scanner(System.in);

	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 자료 입력");
		System.out.println("  2. 자료 삭제");
		System.out.println("  3. 자료 수정");
		System.out.println("  4. 전체 자료 출력");
		System.out.println("  5. 자료 검색");
		System.out.println("  6. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}

	/**
	 * 프로그램 시작메서드
	 */
	public void start() {
		int choice;
		do {
			displayMenu(); // 메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch (choice) {
			case 1: // 자료 입력
				insertPost();
				break;
			case 2: // 자료 삭제
				deletePost();
				break;
			case 3: // 자료 수정
				updatePost();
				break;
			case 4: // 전체 자료 출력
				displayPostAll();
				break;
			case 5: // 자료검색
				searchPost();
				break;
			case 6: // 작업 끝
				System.out.println("작업을 마칩니다.");
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		} while (choice != 6);
	}
	
	private void searchPost() {
		
		System.out.println("검색할 게시글 번호를 입력하세요");
		System.out.print("번호 >> ");
		
		String board_no1 = scan.next();
		
	
		 System.out.println("---------------------------------------------------------------");
		
		try {
			conn = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM jdbc_board WHERE board_no = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board_no1);
			
			rs = pstmt.executeQuery();
			 
			 while(rs.next()) {
				 String board_no = rs.getString("board_no");
				 String board_writer = rs.getString("board_writer");
				 String board_title = rs.getString("board_title");
				 String board_content = rs.getString("board_content");
				 String board_date = rs.getString("board_date");
				 
				 System.out.println("번호 : " + board_no + "\n" + "작성자 : " + board_writer + "\n" + "제목 : "+ board_title + "\n" +"내용 : "+ board_content + "\n" + "날짜 : " +board_date);
				 
			 }
			 System.out.println("---------------------------------------------------------------");
			 System.out.println("출력 끝.");
			
			
		}catch (SQLException e) {
			System.out.println("게시글 가져오기 실패!");
			System.out.println();
		}finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		
		
	}

	//삭제
	private void deletePost() {
		
		System.out.println();
		System.out.println("삭제할 게시글 번호를 입력하세요");
		System.out.print("board_no >> ");
		
		String board_no = scan.next();
		
		try {
			conn = JDBCUtil.getConnection();
			
			String sql = "delete from jdbc_board where board_no = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board_no);
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("삭제되었습니다.");
			}else {
				System.out.println("실패");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		
	}

	//수정
	private void updatePost() {

		boolean chk = false;
		String board_no = "";

		do {
			System.out.println();
			System.out.println("수정할 board_no를 입력하세요.");
			System.out.print("board_no >> ");
			board_no = scan.next();
			chk = checkPost(board_no);
			
			if (chk == false) {
				System.out.println("board_no가" + board_no + "존재하지 않습니다.");
				System.out.println("다시 입력하세요");
			}

		} while (chk == false);
		
		System.out.print("board_writer >>");
		String board_writer = scan.next();
		
		System.out.print("board_title >>");
		String board_title = scan.next();
		
		scan.nextLine(); // 입력버퍼 키우기
		
		System.out.print("board_content >>");
		String board_content = scan.nextLine();
		
		try {
			
			conn = JDBCUtil.getConnection();
			
			String sql = "UPDATE jdbc_board " + 
					" SET board_writer = ?, board_title= ?, board_content= ? " + 
					" WHERE board_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board_writer);
			pstmt.setString(2, board_title);
			pstmt.setString(3, board_content);
			pstmt.setString(4, board_no);
			
			int cnt = pstmt.executeUpdate();
			
			System.out.println("테스트");
			
			if(cnt > 0) {
				System.out.println(board_no + "게시글 정보를 수정했습니다.");
			}else {
				System.out.println(board_no + "게시글 정보 수정 실패");
			}
			
			
		}catch (SQLException e) {
			System.out.println("캐치테스트");
			// TODO: handle exception
		}finally{
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		
	}

	
	
	//조회
	private void displayPostAll() {
		System.out.println();
		System.out.println("---------------------------------------------------------------");
		System.out.println(" 번호\t작성자\t제목\t내용\t시간");
		System.out.println("---------------------------------------------------------------");
		
		
		try {
			conn = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM jdbc_board";
			
			stmt = conn.createStatement();
			
			 rs = stmt.executeQuery(sql);
			 
			 while(rs.next()) {
				 String board_no = rs.getString("board_no");
				 String board_writer = rs.getString("board_writer");
				 String board_title = rs.getString("board_title");
				 String board_content = rs.getString("board_content");
				 String board_date = rs.getString("board_date");
				 
				 System.out.println(board_no + "\t" + board_writer + "\t" + board_title + "\t" + board_content + "\t" + board_date);
				 
			 }
			 System.out.println("---------------------------------------------------------------");
			 System.out.println("출력 끝.");
			
			
		}catch (SQLException e) {
			System.out.println("게시글 가져오기 실패!");
			System.out.println();
		}finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		
		
	}
	
	//입력
	private void insertPost() {

		boolean chk = false;
		String board_no = "";

		do {
			System.out.println();
//			System.out.println("추가할 게시글 번호를 입력하세요.");
//			System.out.print("게시글 번호 >> ");
			try {
				conn = JDBCUtil.getConnection();
				String sql = "select board_seq.nextVal from dual";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					board_no = rs.getString("nextVal");
				}
				
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
			
			chk = checkPost(board_no);
			if (chk == true) {
				System.out.println("게시글 번호가" + board_no + "인 게시글은 이미 존재합니다.");
				System.out.println("다시 입력하세요");
			}

		} while (chk == true);
		
		System.out.print("작성자 이름 >>");
		String board_writer = scan.next();
		
		System.out.print("제목 >>");
		String board_title = scan.next();
		
		scan.nextLine(); // 입력버퍼 키우기
		
		System.out.print("내용 >>");
		String board_content = scan.nextLine();
		
		
		try {
			
			conn = JDBCUtil.getConnection();
			
			String sql = " insert into jdbc_board (board_no,board_writer,board_title,board_content,board_date) values (?, ?, ?, ?, SYSDATE) ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board_no);
			pstmt.setString(2, board_writer);
			pstmt.setString(3, board_title);
			pstmt.setString(4, board_content);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println(board_no + "board_no 게시글 업로드 성공");
			}else {
				System.out.println(board_no + "게시글 업로드 실패");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		
	}

	// 회원 ID를 이용하여 회원이 있는지 알려주는 메서드/ board_no 체크할 회원 ID 존재하면 true, 아니면 false
	private boolean checkPost(String board_no) {

		boolean check = false;

		try {
			conn = JDBCUtil.getConnection();

			String sql = "select count(*) cnt from jdbc_board " + "where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board_no);

			rs = pstmt.executeQuery();

			int count = 0;

			if (rs.next()) {
				count = rs.getInt("cnt");
			}
			if (count > 0) {
				check = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			check = false;
		}finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}

		return check;
	}

	public static void main(String[] args) {
		MainBoard memObj = new MainBoard();
		memObj.start();
	}

}
