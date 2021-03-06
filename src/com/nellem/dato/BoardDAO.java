package com.nellem.dato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	private DataSource ds;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
//생성자에서 jdbc/mvc 객체를 찾아 DataSource 로 받는다.
	public BoardDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/JSP");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//Connection 해제를 위한 메소드
	public void close() {
		try {
			if(con !=null) {
				con.close();
				con=null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
// 전체 멤버 목록보기	
	public ArrayList<BoardDTO> list(){
		String sql = "SELECT * FROM BOARD";
		
		ArrayList<BoardDTO> dtos = new ArrayList<BoardDTO>();	//DB처리 결과를 MemberDTO에 담아 ArrayList로 만들기 위해
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {		//DB결과를 ResultSet에서 한행씩 추출하여 MemberDTO로 만든다.
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt("NO"));
				dto.setTitle(rs.getString("TITLE"));
				dto.setWriter(rs.getString("WRITER"));
				dto.setContent(rs.getString("CONTENT"));
				dto.setDate(rs.getDate("REGDATE"));
				dtos.add(dto);		//MemberDTO객체를 ArrayList에 추가한다.
			}
			rs.close(); pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dtos;
	}

//게시글 상세 보기	
	public BoardDTO view(int no) {
		String sql ="select title,writer,content,regdate from board where no=?";
		BoardDTO dto = new BoardDTO();
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {		//상세보기를 위한 한 레코드셋을 DTO에 저장
				dto.setNo(no);
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setContent(rs.getString("content"));
				dto.setDate(rs.getDate("regdate"));
			}
			
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;	//DTO객체에 데이터를 담아서 반환
	}
	
// 게시글 추가하기
	public boolean insert(BoardDTO dto) {	//DB에 저장이 잘되면 true, 잘안되었으면  false를 반환
		String sql = "insert into board(no, title, writer, content, date) values(seq_board_no.nextval, ?,?,?, SYSDATE)"; 
		boolean check = false;
		try {  
			con = ds.getConnection();  //Connection객체 CP에서 얻어오기
			pstmt =con.prepareStatement(sql);  	//Connection객체를 통해 SQL문 준비
			pstmt.setString(1, dto.getTitle());	//SQL문과 데이터 바인팅
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getContent());
			
			int x = pstmt.executeUpdate();	//SQL을 수행하고 결과 반환 : 결과는 입력이 된 행 갯수

			if(x<1) {	//1보다 적으면
				System.out.println("정상적으로 저장되지 않았습니다.");
			}else {		//1이상인 경우는 저장이 된 경우
				check=true;
			}
			pstmt.close();
		}catch(SQLException ex) {
			System.out.println("SQL insert 오류 : " + ex.getLocalizedMessage());
			check = false;
		}
		return check;
	}
// 게시판 정보 수정하기	
	public boolean update(BoardDTO dto) {
		String sql = "update board set title=?, content=? where no=?";
		boolean check = false;
		try {
			con = ds.getConnection();
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getNo());
			
			int x = pstmt.executeUpdate();	

			if(x<1) {
				System.out.println("정상적으로 저장되지 않았습니다.");
			}else {
				check=true;
			}
			pstmt.close();
		}catch(SQLException ex) {
			System.out.println("SQL insert 오류 : " + ex.getLocalizedMessage());
			check = false;
		}
		return check;
	}
// 게시판 삭제 하기		
	public boolean delete(int no) {
		String sql = "delete from board where no=?";
		boolean check = false;
		try {
			con = ds.getConnection();
			pstmt =con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			int x = pstmt.executeUpdate();	

			if(x<1) {
				System.out.println("정상적으로 삭제되지 않았습니다.");
			}else {
				check=true;
			}
			pstmt.close();
		}catch(SQLException ex) {
			System.out.println("SQL insert 오류 : " + ex.getLocalizedMessage());
			check = false;
		}
		return check;
	}
}	
