package com.daiso.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.daiso.dto.Order1;
import com.daiso.dto.Payment;
import com.daiso.vo.SalesVO;

public class SalesDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public int addSales(Order1 order, Payment pay, String bnum){
		int cnt = 0;
		try {
			conn = Oracle11.getConnection();
			conn.setAutoCommit(false);	//트랜잭션 처리시 오토커밋을 비활성화
			pstmt = conn.prepareStatement(Oracle11.SALES_ADD);
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

			pstmt = conn.prepareStatement(Oracle11.PAYMENT_ADD);
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
	
	public ArrayList<SalesVO> getSalesList(){
		ArrayList<SalesVO> salesList = new ArrayList<SalesVO>();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.SALES_LIST);
			rs = pstmt.executeQuery();
			while(rs.next()){
				SalesVO sale = new SalesVO();
				sale.setOnum(rs.getString("onum"));
				sale.setId(rs.getString("id"));
				sale.setPcode(rs.getString("pcode"));
				sale.setAmount(rs.getInt("amount"));
				sale.setPrice(rs.getInt("price"));
				sale.setOdate(rs.getString("odate"));
				sale.setDstatus(rs.getString("dstatus"));
				sale.setDtel(rs.getString("dtel"));
				sale.setDname(rs.getString("dname"));
				sale.setDaddr(rs.getString("daddr"));
				sale.setDcode(rs.getString("dcode"));
				sale.setPnum(rs.getString("pnum"));
				sale.setPtype(rs.getString("ptype"));
				sale.setPtnum(rs.getString("ptnum"));
				salesList.add(sale);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		return salesList;
	}
	
	//관리자의 특정 판매 데이터 로딩 
	public SalesVO getSales(String onum){
		SalesVO sale = new SalesVO();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.SALES_INFO);
			pstmt.setString(1, onum);
			rs = pstmt.executeQuery();
			if(rs.next()){
				sale.setOnum(rs.getString("onum"));
				sale.setId(rs.getString("id"));
				sale.setPcode(rs.getString("pcode"));
				sale.setAmount(rs.getInt("amount"));
				sale.setPrice(rs.getInt("price"));
				sale.setOdate(rs.getString("odate"));
				sale.setDstatus(rs.getString("dstatus"));
				sale.setDtel(rs.getString("dtel"));
				sale.setDname(rs.getString("dname"));
				sale.setDaddr(rs.getString("daddr"));
				sale.setDcode(rs.getString("dcode"));
				sale.setPnum(rs.getString("pnum"));
				sale.setPtype(rs.getString("ptype"));
				sale.setPtnum(rs.getString("ptnum"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		return sale;
	}
	
	//특정 사용자의 구매 목록 로딩
	public ArrayList<SalesVO> getByIdSalesList(String id){
		ArrayList<SalesVO> salesList = new ArrayList<SalesVO>();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.SALES_LIST_BYID);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				SalesVO sale = new SalesVO();
				sale.setOnum(rs.getString("onum"));
				sale.setId(rs.getString("id"));
				sale.setPcode(rs.getString("pcode"));
				sale.setAmount(rs.getInt("amount"));
				sale.setPrice(rs.getInt("price"));
				sale.setOdate(rs.getString("odate"));
				sale.setDstatus(rs.getString("dstatus"));
				sale.setDtel(rs.getString("dtel"));
				sale.setDname(rs.getString("dname"));
				sale.setDaddr(rs.getString("daddr"));
				sale.setDcode(rs.getString("dcode"));
				sale.setPnum(rs.getString("pnum"));
				sale.setPtype(rs.getString("ptype"));
				sale.setPtnum(rs.getString("ptnum"));
				salesList.add(sale);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		return salesList;
	}
	
	//특정 사용자의 특정 판매 데이터 로딩
	public SalesVO getByIdSales(String id, String ocode){
		SalesVO sale = new SalesVO();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.SALES_LIST_BYID);
			pstmt.setString(1, id);
			pstmt.setString(2, ocode);
			rs = pstmt.executeQuery();
			while(rs.next()){
				sale.setOnum(rs.getString("onum"));
				sale.setId(rs.getString("id"));
				sale.setPcode(rs.getString("pcode"));
				sale.setAmount(rs.getInt("amount"));
				sale.setPrice(rs.getInt("price"));
				sale.setOdate(rs.getString("odate"));
				sale.setDstatus(rs.getString("dstatus"));
				sale.setDtel(rs.getString("dtel"));
				sale.setDname(rs.getString("dname"));
				sale.setDaddr(rs.getString("daddr"));
				sale.setDcode(rs.getString("dcode"));
				sale.setPnum(rs.getString("pnum"));
				sale.setPtype(rs.getString("ptype"));
				sale.setPtnum(rs.getString("ptnum"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		return sale;
	}
	
	//판매 정보 목록만 로딩
	public ArrayList<Order1> getByIdBuyList(String id){
		ArrayList<Order1> buyList = new ArrayList<Order1>();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.ORDER_LIST_BYID);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Order1 order = new Order1();
				order.setOnum(rs.getString("onum"));
				order.setId(rs.getString("id"));
				order.setPcode(rs.getString("pcode"));
				order.setAmount(rs.getInt("amount"));
				order.setPrice(rs.getInt("price"));
				order.setOdate(rs.getString("odate"));
				order.setDstatus(rs.getString("dstatus"));
				order.setDtel(rs.getString("dtel"));
				order.setDname(rs.getString("dname"));
				order.setDaddr(rs.getString("daddr"));
				order.setDcode(rs.getString("dcode"));
				buyList.add(order);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		return buyList;
	}
	
	//모든 결제 정보 목록만 로딩
	public ArrayList<Payment> getByPayList(){
		ArrayList<Payment> payList = new ArrayList<Payment>();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.PAY_LIST);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Payment pay = new Payment();
				pay.setPnum(rs.getString("pnum"));
				pay.setId(rs.getString("id"));
				pay.setOnum(rs.getString("onum"));
				pay.setPtype(rs.getString("ptype"));
				pay.setPtnum(rs.getString("ptnum"));
				pay.setPprice(rs.getInt("pprice"));
				pay.setPdate(rs.getString("pdate"));
				payList.add(pay);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		return payList;
	}
	
	
	//특정 사용자의 특정 결제 정보
	public Payment getByIdPay(String onum){
		Payment pay = new Payment();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.PAY_BYONUM);
			pstmt.setString(1, onum);
			rs = pstmt.executeQuery();
			if(rs.next()){
				pay.setPnum(rs.getString("pnum"));
				pay.setId(rs.getString("id"));
				pay.setOnum(rs.getString("onum"));
				pay.setPtype(rs.getString("ptype"));
				pay.setPtnum(rs.getString("ptnum"));
				pay.setPprice(rs.getInt("pprice"));
				pay.setPdate(rs.getString("pdate"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		return pay;
	}
	
	public int salesProgressUpdate(Order1 order){
		int cnt = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.SALES_PROGRESS_UPDATE);
			pstmt.setString(1, order.getDname());
			pstmt.setString(2, order.getDcode());
			pstmt.setString(3, order.getDstatus());
			pstmt.setString(4, order.getOnum());
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

	public int cancelSales(String onum, String pcode, int amount) {
		int cnt = 0;
		try {
			conn = Oracle11.getConnection();
			conn.setAutoCommit(false);	//트랜잭션 처리시 오토커밋을 비활성화
			
			pstmt = conn.prepareStatement(Oracle11.PAYMENT_DELETE);
			pstmt.setString(1, onum);
			cnt = pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(Oracle11.BUY_DELETE);
			pstmt.setString(1, onum);
			cnt = cnt + pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(Oracle11.PRODUCT_RETURN);
			pstmt.setInt(1, amount);
			pstmt.setString(2, pcode);
			cnt = cnt + pstmt.executeUpdate();
			
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

	public int returnSales(String onum) {
		int cnt = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.SALES_RETURN);
			pstmt.setString(1, onum);
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

	public int okSales(String onum) {
		int cnt = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.SALES_OK);
			pstmt.setString(1, onum);
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