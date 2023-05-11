package com.daiso.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.daiso.dto.Notice;
import com.daiso.dto.Product;
import com.daiso.vo.CategoryVO;

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
		
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.PRODUCT_SELECT_ALL);
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
	
	public int insertProduct(Product pro){
		int cnt = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.PRODUCT_INSERT);
			pstmt.setString(1, pro.getPcode());
			pstmt.setString(2, pro.getPname());
			pstmt.setString(3, pro.getPmeas());
			pstmt.setInt(4, pro.getPrice());
			pstmt.setString(5, pro.getPcom());
			pstmt.setInt(6, pro.getAmount());
			pstmt.setString(7, pro.getPic1());
			pstmt.setString(8, pro.getPic2());
			pstmt.setString(9, pro.getPic3());
			pstmt.setString(10, pro.getCategory());
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
	
	public ArrayList<CategoryVO> getFirstCategoryList(){
		ArrayList<CategoryVO> cateList = new ArrayList<CategoryVO>();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.CATEGORY_SELECT_FIRST);
			rs = pstmt.executeQuery();
			while(rs.next()){
				CategoryVO cate = new CategoryVO();
				cate.setCt(rs.getString("ct"));
				cate.setCategroup(rs.getString("categroup"));
				cateList.add(cate);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		return cateList;
	}
	
	//중분류 코드 반환
	public ArrayList<CategoryVO> getSecondCategoryList(String ct){
		ArrayList<CategoryVO> cateList = new ArrayList<CategoryVO>();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.CATEGORY_SELECT_SECOND);
			pstmt.setString(1, ct);
			rs = pstmt.executeQuery();
			while(rs.next()){
				CategoryVO cate = new CategoryVO();
				cate.setCate(rs.getString("catecode"));
				cate.setCatename(rs.getString("catename"));
				cateList.add(cate);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		return cateList;
	}
	
	public int deleteProduct(String pcode){
		int cnt = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.PRODUCT_DELETE);
			pstmt.setString(1, pcode);
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
	
	public int updateStockProduct(int price, int amount, String pcode){
		int cnt = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.PRODUCT_UPDATE_STOCK);
			pstmt.setInt(1, price);
			pstmt.setInt(2, amount);
			pstmt.setString(3, pcode);
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
	
	public Product updateProduct(String pcode){
		Product pro = new Product();
		//pcode를 매개변수로 던져서 그에 해당하는 레코드 한 건만 반환받아 pro에 저장
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.PRODUCT_SELECT_ONE);
			pstmt.setString(1, pcode);
			rs = pstmt.executeQuery();
			if(rs.next()){
				pro.setPcode(rs.getString("pcode"));
				pro.setPname(rs.getString("pname"));
				pro.setPmeas(rs.getString("pmeas"));
				pro.setPrice(rs.getInt("price"));
				pro.setPcom(rs.getString("pcom"));
				pro.setAmount(rs.getInt("amount"));
				pro.setPic1(rs.getString("pic1"));
				pro.setPic2(rs.getString("pic2"));
				pro.setPic3(rs.getString("pic3"));
				pro.setCategory(rs.getString("Category"));
			}
		} catch (ClassNotFoundException e) { //오라클 JDBC 클래스가 없거나 경로가 다른 경우 발생
			e.printStackTrace();
		} catch (SQLException e){	//sql 구문이 틀린 경우 발생
			e.printStackTrace();			
		} catch (Exception e){	//알 수 없는 예외인 경우 발생
			e.printStackTrace();
		}
		Oracle11.close(rs, pstmt, conn);
		return pro;
	}
}