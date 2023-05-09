package com.daiso.model;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.crypto.util.AES256;
import com.daiso.dto.User1;

public class ProductDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public int loginCheck(String pcode) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException{
		int cnt = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.USER_LOGIN);
			pstmt.setString(1, pcode);
			rs = pstmt.executeQuery();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		return cnt;
	}
	public int loginPass(String id, String pw) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidParameterSpecException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException{
		int cnt = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.USER_LOGIN);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		userVisitedCount(id);
		return cnt;
	}
	
	public int idCheck(String id){
		int cnt = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.USER_LOGIN);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				cnt = 1;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		return cnt;
	}
	
	public void userVisitedCount(String id){
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.USER_VISIT_COUNT);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(pstmt, conn);
		}
	}
	
	public int insertUser(User1 user){
		int cnt = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.USER_INSERT);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			pstmt.setString(3, user.getUname());
			pstmt.setString(4, user.getUtel());
			pstmt.setString(5, user.getUaddr());
			pstmt.setString(6, user.getUemail());
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
	
	public User1 myInfo(String id) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException{
		User1 user = new User1();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.USER_LOGIN);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		return user;
	}
	
	public int updateUser1(User1 user){
		int cnt = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.USER_UPDATE1);
			pstmt.setString(1, user.getPw());
			pstmt.setString(2, user.getUname());
			pstmt.setString(3, user.getUtel());
			pstmt.setString(4, user.getUaddr());
			pstmt.setString(5, user.getUemail());
			pstmt.setString(6, user.getId());
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
	
	public int updateUser2(User1 user){
		int cnt = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.USER_UPDATE2);
			pstmt.setString(1, user.getUname());
			pstmt.setString(2, user.getUtel());
			pstmt.setString(3, user.getUaddr());
			pstmt.setString(4, user.getUemail());
			pstmt.setString(5, user.getId());
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
	
	
	public int deleteUser(String id){
		int cnt = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.USER_DELETE);
			pstmt.setString(1, id);
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
	
	public ArrayList<User1> userList() throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException{
		ArrayList<User1> uList = new ArrayList<User1>();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.USER_SELECT_ALL);
			rs = pstmt.executeQuery();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		return uList;
	}
}