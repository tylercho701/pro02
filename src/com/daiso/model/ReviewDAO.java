package com.daiso.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.daiso.dto.Review;
import com.daiso.vo.ReviewVO;

public class ReviewDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public ArrayList<ReviewVO> getReviewList(String pcode){
		ArrayList<ReviewVO> reviewLst = new ArrayList<ReviewVO>();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.REVIEW_LIST);
			pstmt.setString(1, pcode);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				ReviewVO review = new ReviewVO();
				review.setRnum(rs.getString("rnum"));
				review.setId(rs.getString("id"));
				review.setOnum(rs.getString("onum"));
				review.setWrittendate(rs.getString("writtendate"));
				review.setRcom(rs.getString("rcom"));
				review.setPcode(rs.getString("pcode"));
				review.setRpoint(rs.getInt("rpoint"));
				reviewLst.add(review);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		return reviewLst;
	}
	
	public ArrayList<ReviewVO> getReviewListAll(){
		ArrayList<ReviewVO> reviewLst = new ArrayList<ReviewVO>();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.REVIEW_LIST_ALL);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				ReviewVO review = new ReviewVO();
				review.setRnum(rs.getString("rnum"));
				review.setId(rs.getString("id"));
				review.setOnum(rs.getString("onum"));
				review.setWrittendate(rs.getString("writtendate"));
				review.setRcom(rs.getString("rcom"));
				review.setRpoint(rs.getInt("rpoint"));
				review.setPcode(rs.getString("pcode"));
				review.setPname(rs.getString("pname"));
				reviewLst.add(review);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		return reviewLst;
	}
	
	public ReviewVO getReviewDtl (String rnum){
		ReviewVO review = new ReviewVO();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.REVIEW_DETAIL);
			pstmt.setString(1, rnum);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				review.setRnum(rs.getString("rnum"));
				review.setId(rs.getString("id"));
				review.setOnum(rs.getString("onum"));
				review.setWrittendate(rs.getString("writtendate"));
				review.setRcom(rs.getString("rcom"));
				review.setPcode(rs.getString("pcode"));
				review.setPname(rs.getString("pname"));
				review.setRpoint(Integer.parseInt(rs.getString("rpoint")));
				review.setOdate(rs.getString("odate"));
				review.setDstatus(rs.getString("dstatus"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		return review;
	}
	
	public ReviewVO getReviewer (String onum){
		ReviewVO review = new ReviewVO();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.REVIEW_FIND_REVIEWER);
			pstmt.setString(1, onum);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				review.setOnum(rs.getString("onum"));
				review.setId(rs.getString("id"));
				review.setPcode(rs.getString("pcode"));
				review.setPname(rs.getString("pname"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		return review;
	}
	
	public String getRnumGenerator(){
		String rnum = "";
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.RNUM_GENERATOR);
			rs = pstmt.executeQuery();
			if(rs.next()){
				rnum = rs.getString("rnum");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		
		int tmp = Integer.parseInt(rnum) + 1;
		rnum = tmp + "";
		return rnum;
	}
	
	public int insertReview(Review review){
		int cnt = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.REVIEW_INSERT);
			pstmt.setString(1, review.getRnum());
			pstmt.setString(2, review.getId());
			pstmt.setString(3, review.getOnum());
			pstmt.setString(4, review.getRcom());
			pstmt.setInt(5, review.getRpoint());
			cnt = pstmt.executeUpdate();			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(pstmt, conn);
		}
		
		return cnt;
	}
	
	public int updateReview(Review review){
		int cnt = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.REVIEW_UPDATE);
			pstmt.setString(1, review.getRcom());
			pstmt.setInt(2, review.getRpoint());
			pstmt.setString(3, review.getRnum());
			cnt = pstmt.executeUpdate();			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(pstmt, conn);
		}
		
		return cnt;
	}
	
	public int deleteReview(String rnum){
		int cnt = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.REVIEW_DELETE);
			pstmt.setString(1, rnum);
			cnt = pstmt.executeUpdate();			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(pstmt, conn);
		}
		
		return cnt;
	}
}