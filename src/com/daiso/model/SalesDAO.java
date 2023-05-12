package com.daiso.model;

import java.sql.*;

import com.daiso.dto.Order1;
import com.daiso.dto.Payment;

public class SalesDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public int addSales(Order1 order, Payment pay, String bnum){
		int cnt = 0;
		try {
			conn = Oracle11.getConnection();
			conn.setAutoCommit(false);	//트랜잭션 처리시 오토커밋을 비활성화
			pstmt = conn.prepareStatement(Oracle11.ADD_SALES);
			pstmt.setString(1, order.getOnum());
			pstmt.setString(2, order.getId());
			pstmt.setString(3, order.getPcode());
			pstmt.setInt(4, order.getAmount());
			pstmt.setInt(5, order.getPrice());
			pstmt.setString(6, order.getDstatus());
			pstmt.setString(7, order.getDtel());
			pstmt.setString(8, order.getDname());
			pstmt.setString(9, order.getDaddr());
			pstmt.setString(10, order.getDcode());
			cnt = pstmt.executeUpdate();

			pstmt = conn.prepareStatement(Oracle11.ADD_PAYMENT);
			pstmt.setString(1, pay.getPnum());
			pstmt.setString(2, pay.getId());
			pstmt.setString(3, pay.getOnum());
			pstmt.setString(4, pay.getPtype());
			pstmt.setString(5, pay.getPtnum());
			pstmt.setInt(6, pay.getPprice());
			cnt = cnt + pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(Oracle11.PRODUCT_SALES);
			pstmt.setInt(1, order.getAmount());
			pstmt.setString(2, order.getPcode());
			cnt = cnt + pstmt.executeUpdate();
			
			if(bnum!=null){
				pstmt = conn.prepareStatement(Oracle11.BASKET_DELETE);
				pstmt.setString(1, bnum);
				cnt = cnt + pstmt.executeUpdate();
			}
			
			conn.commit();	//수동 커밋
			conn.setAutoCommit(true);	//오토커밋 활성화
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(pstmt, conn);
		}
		return cnt;
	}
	
	public String getOcodeGenerator(){
		String onum = "";
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.ONUM_GENERATOR);
			rs = pstmt.executeQuery();
			if(rs.next()){
				onum = rs.getString("onum");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		
		int tmp = Integer.parseInt(onum) + 1;
		onum = tmp + "";
		return onum;
	}
	
	public String getPnumGenerator(){
		String pnum = "";
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.PNUM_GENERATOR);
			rs = pstmt.executeQuery();
			if(rs.next()){
				pnum = rs.getString("pnum");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		
		int tmp = Integer.parseInt(pnum) + 1;
		pnum = tmp + "";
		return pnum;
	}
}