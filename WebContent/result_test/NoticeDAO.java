package com.daiso.model;

import java.util.ArrayList;
import java.sql.*;
import com.daiso.dto.Notice;

public class NoticeDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public ArrayList<Notice> noticeListAll(){
		ArrayList<Notice> notiList = new ArrayList<Notice>();
		//notice 테이블에서 모든 레코드를 검색하여 반환된 ResultSet을 notiList에 add를 한다.
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.NOTICE_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Notice noti = new Notice();
				noti.setIdx(rs.getInt("idx"));
				noti.setTitle(rs.getString("title"));
				noti.setContent(rs.getString("content"));
				noti.setAuthor(rs.getString("author"));
				noti.setFile1(rs.getString("file1"));
				noti.setResdate(rs.getString("resdate"));
				noti.setReadcnt(rs.getInt("readcnt"));
				notiList.add(noti);
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		Oracle11.close(rs, pstmt, conn);
		return notiList;
	}
	
	public Notice getNotice(int idx){
		updateReadCount(idx);
		Notice noti = new Notice();
		//idx를 매개 변수로 던져 그에 해당하는 레코드 한 건만 반환받아 noti에 저장			

		try {
		conn = Oracle11.getConnection();
		pstmt = conn.prepareStatement(Oracle11.NOTICE_SELECT_ONE);
		pstmt.setInt(1, idx);
		rs = pstmt.executeQuery();
		
		if(rs.next()){
			noti.setIdx(rs.getInt("idx"));
			noti.setTitle(rs.getString("title"));
			noti.setContent(rs.getString("content"));
			noti.setAuthor(rs.getString("author"));
			noti.setFile1(rs.getString("file1"));
			noti.setResdate(rs.getString("resdate"));
			noti.setReadcnt(rs.getInt("readcnt"));
		}
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		Oracle11.close(rs, pstmt, conn);
		return noti;
	}
	public void updateReadCount(int idx){
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.NOTICE_UPDATE_READCNT);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		Oracle11.close(pstmt, conn);
	}
	
	public int insertNotice(Notice noti){
		int cnt = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.NOTICE_INSERT);
			pstmt.setString(1, noti.getTitle());
			pstmt.setString(2, noti.getContent());
			pstmt.setString(3, noti.getAuthor());
			pstmt.setString(4, "data/"+noti.getFile1());
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		Oracle11.close(pstmt, conn);
		return cnt;
	}
	
	public Notice updateNotice(int idx){
		Notice noti = new Notice();
		//idx를 매개변수로 던져서 그에 해당하는 레코드 한 건만 반환받아 noti에 저장
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.NOTICE_SELECT_ONE);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if(rs.next()){
				noti.setIdx(rs.getInt("idx"));
				noti.setTitle(rs.getString("title"));
				noti.setContent(rs.getString("content"));
				noti.setAuthor(rs.getString("author"));
				noti.setFile1(rs.getString("file1"));
				noti.setResdate(rs.getString("resdate"));
				noti.setReadcnt(rs.getInt("readcnt"));
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		Oracle11.close(rs, pstmt, conn);
		return noti;
	}

	public int updateNoticePro(Notice noti) {
		int cnt = 0;
		try {
			conn = Oracle11.getConnection();
			if(noti.getFile1()==null) {
				pstmt = conn.prepareStatement(Oracle11.NOTICE_UPDATE2);
				pstmt.setString(1, noti.getTitle());
				pstmt.setString(2, noti.getContent());
				pstmt.setInt(3, noti.getIdx());
			} else {
				pstmt = conn.prepareStatement(Oracle11.NOTICE_UPDATE1);
				pstmt.setString(1, noti.getTitle());
				pstmt.setString(2, noti.getContent());
				pstmt.setString(3, "data/"+noti.getFile1());
				pstmt.setInt(4, noti.getIdx());
			}
			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		Oracle11.close(pstmt, conn);
		return cnt;
	}

	public int deleteNotice(int idx) {
		int cnt = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.NOTICE_DELETE);
			pstmt.setInt(1, idx);

			cnt = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		Oracle11.close(pstmt, conn);
		return cnt;
	}
}