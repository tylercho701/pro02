package com.daiso.model;

import java.sql.*;

public class Oracle11 {
	static String driver = "oracle.jdbc.driver.OracleDriver";
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static String user = "system";
	static String pass = "1234";
	
	final static String NOTICE_SELECT_ALL = "select * from notice";
	final static String NOTICE_SELECT_ONE = "select * from notice where idx=?";
	final static String NOTICE_UPDATE_READCNT = "update notice set readcnt = readcnt + 1 where idx = ?";
	final static String NOTICE_INSERT = "insert into notice values (noti_seq.nextval, ?, ?, ?, ?, default, default)";
	final static String NOTICE_UPDATE1 = "update notice set title=?, content=?, file1=?, resdate=sysdate where idx=?";
	final static String NOTICE_UPDATE2 = "update notice set title=?, content=?, resdate=sysdate where idx=?";
	final static String NOTICE_DELETE = "delete from notice where idx=?";
	
	final static String USER_SELECT_ALL = "select * from user1 order by regdate desc";
	final static String USER_LOGIN = "select * from user1 where id = ?";
	final static String USER_VISIT_COUNT =  "update user1 set visited=visited+1 where id=?";
	final static String USER_INSERT = "insert into user1(id, pw, uname, utel, uaddr, uemail) values (?,?,?,?,?,?)";
	final static String USER_UPDATE1 = "update user1 set pw=?, uname=?, utel=?, uaddr=?, uemail=? where id=?";
	final static String USER_UPDATE2 = "update user1 set uname=?, utel=?, uaddr=?, uemail=? where id=?";
	final static String USER_DELETE = "delete from user1 where id=?";
	
	final static String PRODUCT_SELECT_ALL = "select * from product";
	final static String PRODUCT_SELECT_CATE_ALL = "select * from product where category = ?";
	final static String PRODUCT_SELECT_ONE = "select * from product where pcode=?";
	final static String PRODUCT3 = "";
	
	final static String CATEGORY_SELECT_ALL = "select * from category where catecode = ?";
	final static String CATEGORY_SELECT_ONE = "select * from category where catecode = ?";
	final static String CATEGORY3 = "";

	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pass);

		return conn;
	}
	
	public static void close(PreparedStatement pstmt, Connection conn){
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}