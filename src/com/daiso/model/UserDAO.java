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

public class UserDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	String key = "%03x";
	String qpw;
	
	public ArrayList<User1> getUserList() throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException{
		ArrayList<User1> userList = new ArrayList<User1>();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.USER_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()){
				User1 user = new User1();
				user.setId(rs.getString("id"));
				qpw = AES256.decryptAES256(rs.getString("pw"), key);
				int k = qpw.length();	//암호 글자수 세기
				String vpw = qpw.substring(0, 3);	//3글자만 암호를 보여주기
				String hpw = "";
				for(int i=0;i<k-3;i++){	//나머지는 *로 넣기
					hpw+="*";
				}
				user.setPw(vpw+hpw);
				user.setHpw(qpw);
				user.setUname(rs.getString("uname"));
				user.setUtel(rs.getString("utel"));
				user.setUemail(rs.getString("uemail"));
				user.setRegdate(rs.getString("regdate"));
				user.setUaddr(rs.getString("uaddr"));
				user.setPoint(rs.getInt("point"));
				user.setVisited(rs.getInt("visited"));
				userList.add(user);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		return userList; 
	}
	
	public int loginCheck(String id, String pw) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException{
		int cnt = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.USER_LOGIN);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				qpw = AES256.decryptAES256(rs.getString("pw"), key);
				if(pw.equals(qpw)){
					cnt = 1;
				} else {
					cnt = 0;
				} 
			} else {
				cnt = 9;
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
	public int loginPass(String id, String pw) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidParameterSpecException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException{
		int cnt = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.USER_LOGIN);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				qpw = AES256.decryptAES256(rs.getString("pw"), key);
				System.out.println(qpw);
				if(pw.equals(qpw)){
					cnt = 1;
				} else {
					cnt = 0;
				} 
			} else {
				cnt = 9;
			}
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
			if(rs.next()){
				user.setId(rs.getString("id"));
				qpw = AES256.decryptAES256(rs.getString("pw"), key);
				int k = qpw.length();	//암호 글자수 세기
				String vpw = qpw.substring(0, 3);	//3글자만 암호를 보여주기
				String hpw = "";
				for(int i=0;i<k-3;i++){	//나머지는 *로 넣기
					hpw+="*";
				}
				user.setPw(vpw+hpw);
				user.setUname(rs.getString("uname"));
				user.setUtel(rs.getString("utel"));
				user.setUemail(rs.getString("uemail"));
				user.setRegdate(rs.getString("regdate"));
				user.setUaddr(rs.getString("uaddr"));
				user.setPoint(rs.getInt("point"));
				user.setVisited(rs.getInt("visited"));
			}
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
			while(rs.next()){
				User1 user = new User1();
				user.setId(rs.getString("id"));
				qpw = AES256.decryptAES256(rs.getString("pw"), key);
				int k = qpw.length();	//암호 글자수 세기
				String vpw = qpw.substring(0, 3);	//3글자만 암호를 보여주기
				String hpw = "";
				for(int i=0;i<k-3;i++){	//나머지는 *로 넣기
					hpw+="*";
				}
				user.setPw(vpw+hpw);
				user.setUname(rs.getString("uname"));
				user.setUtel(rs.getString("utel"));
				user.setUemail(rs.getString("uemail"));
				user.setRegdate(rs.getString("regdate"));
				user.setUaddr(rs.getString("uaddr"));
				user.setPoint(rs.getInt("point"));
				user.setVisited(rs.getInt("visited"));
				uList.add(user);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		return uList;
	}
	
	public int resetPassword(String id, String passwd) {
		int cnt = 0;
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.USER_UPDATE_PW_RESET_TEL);
			pstmt.setString(1, passwd);
			pstmt.setString(2, id);
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
	
	public User1 getTel(String id) {
		User1 user = new User1();
		try {
			conn = Oracle11.getConnection();
			pstmt = conn.prepareStatement(Oracle11.USER_LOGIN);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				user.setId(rs.getString("id"));
				user.setUname(rs.getString("uname"));
				user.setUtel(rs.getString("utel"));
				user.setUemail(rs.getString("uemail"));
				user.setRegdate(rs.getString("regdate"));
				user.setUaddr(rs.getString("uaddr"));
				user.setPoint(rs.getInt("point"));
				user.setVisited(rs.getInt("visited"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Oracle11.close(rs, pstmt, conn);
		}
		return user;
	}
}