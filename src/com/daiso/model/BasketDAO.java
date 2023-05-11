package com.daiso.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.daiso.dto.Basket;
import com.daiso.vo.BasketVO;

public class BasketDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//관리자 장바구니 보기
	public ArrayList<BasketVO> getBasketList(){
		ArrayList<BasketVO> basList = new ArrayList<BasketVO>();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.BASKET_SELECT_ALL2);
			rs = pstmt.executeQuery();
			while(rs.next()){
				BasketVO bas = new BasketVO();
				bas.setBnum(rs.getString("bnum"));
				bas.setId(rs.getString("id"));
				bas.setUname(rs.getString("name"));
				bas.setPcode(rs.getString("pcode"));
				bas.setPname(rs.getString("pname"));
				bas.setAmount(rs.getInt("amount"));
				bas.setPrice(rs.getInt("price"));
				basList.add(bas);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		return basList;
	}
	
	//해당 사용자 장바구니 보기
	public ArrayList<BasketVO> getByIdBasketList(String id){
		ArrayList<BasketVO> basList = new ArrayList<BasketVO>();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.BASKET_SELECT_BYID2);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				BasketVO bas = new BasketVO();
				bas.setBnum(rs.getString("bnum"));
				bas.setId(rs.getString("id"));
				bas.setUname(rs.getString("name"));
				bas.setPcode(rs.getString("pcode"));
				bas.setPname(rs.getString("pname"));
				bas.setAmount(rs.getInt("amount"));
				bas.setPrice(rs.getInt("price"));
				basList.add(bas);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		return basList;
	}
	
	//해당 상품별 장바구니 정보 조회
	public ArrayList<Basket> getByProductBasketList(String pcode){
		ArrayList<Basket> basList = new ArrayList<Basket>();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.BASKET_SELECT_BYPRODUCT);
			pstmt.setString(1, pcode);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Basket bas = new Basket();
				bas.setBnum(rs.getString("bnum"));
				bas.setId(rs.getString("id"));
				bas.setPcode(rs.getString("pcode"));
				bas.setAmount(rs.getInt("amount"));
				basList.add(bas);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		return basList;
	}
	
	//장바구니 상세보기
	public Basket getBasketDetail(String bnum){
		Basket bas = new Basket();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.BASKET_SELECT_BYBNUM);
			pstmt.setString(1, bnum);
			rs = pstmt.executeQuery();
			if(rs.next()){
				bas.setBnum(rs.getString("bnum"));
				bas.setId(rs.getString("id"));
				bas.setPcode(rs.getString("pcode"));
				bas.setAmount(rs.getInt("amount"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		return bas;
	}
	
	//장바구니 담기
	public int insertBasket(Basket bas){
		int cnt = 0;
		String bnum = createBnum();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.BASKET_INSERT);
			pstmt.setString(1, bnum);
			pstmt.setString(2, bas.getId());
			pstmt.setString(3, bas.getPcode());
			pstmt.setInt(4, bas.getAmount());
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
	
	public String createBnum(){
		String bnum = "";
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.BASKET_BNUM_GENERATOR);
			rs = pstmt.executeQuery();
			if(rs.next()){
				bnum = rs.getString("bnum");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		
		int tmp = Integer.parseInt(bnum) + 1;
		bnum = tmp + "";
		return bnum; 
	}
	
	//장바구니 삭제 
	public int deleteBasket(String bnum){
		int cnt = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.BASKET_DELETE);
			pstmt.setString(1, bnum);
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
