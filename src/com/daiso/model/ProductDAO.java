package com.daiso.model;

import java.sql.*;
import java.util.*;

import com.daiso.dto.Product;

public class ProductDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public Product getProduct(String pcode){
		Product pro = new Product();
		
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.PRODUCT_SELECT_ONE);
			pstmt.setString(1, pcode);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				pro.setPcode(rs.getString("pcode"));
				pro.setPname(rs.getString("pname"));
				pro.setPmeas(rs.getString("pmeas"));
				pro.setPrice(rs.getInt("price"));
				pro.setPcom(rs.getString("pcom"));
				pro.setAmount(rs.getInt("amount"));
				pro.setPic1(rs.getString("pic1"));
				pro.setPic2(rs.getString("pic2"));
				pro.setPic3(rs.getString("pic3"));
				pro.setCategory(rs.getString("category"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		return pro;
	}
	
	public ArrayList<Product> getProductList(){
		ArrayList<Product> proList = new ArrayList<Product>();
		Product pro = new Product();
		
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.PRODUCT_SELECT_ALL);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				pro.setPcode(rs.getString("pcode"));
				pro.setPname(rs.getString("pname"));
				pro.setPmeas(rs.getString("pmeas"));
				pro.setPrice(rs.getInt("price"));
				pro.setPcom(rs.getString("pcom"));
				pro.setAmount(rs.getInt("amount"));
				pro.setPic1(rs.getString("pic1"));
				pro.setPic2(rs.getString("pic2"));
				pro.setPic3(rs.getString("pic3"));
				pro.setCategory(rs.getString("category"));
				proList.add(pro);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		return proList;
	}
	
	public ArrayList<Product> getCateProductList(String cate){
		ArrayList<Product> proList = new ArrayList<Product>();
		
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.PRODUCT_SELECT_CATE_ALL);
			pstmt.setString(1, cate);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Product pro = new Product();
				pro.setPcode(rs.getString("pcode"));
				pro.setPname(rs.getString("pname"));
				pro.setPmeas(rs.getString("pmeas"));
				pro.setPrice(rs.getInt("price"));
				pro.setPcom(rs.getString("pcom"));
				pro.setAmount(rs.getInt("amount"));
				pro.setPic1(rs.getString("pic1"));
				pro.setPic2(rs.getString("pic2"));
				pro.setPic3(rs.getString("pic3"));
				pro.setCategory(rs.getString("category"));
				proList.add(pro);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		return proList;
	}
	
	public HashMap<String, String> getCategory(String cate){
		HashMap<String, String> cateMap = new HashMap<String, String>();
		
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.CATEGORY_SELECT_ALL);
			pstmt.setString(1, cate);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				cateMap.put("catecode", rs.getString("catecode"));
				cateMap.put("categroup", rs.getString("categroup"));
				cateMap.put("catename", rs.getString("catename"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		return cateMap;
	}
}