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
	final static String USER_UPDATE_PW_RESET_TEL = "update user1 set pw=? where id=?";
	
	final static String PRODUCT_SELECT_ALL = "select * from product order by category asc";
	final static String PRODUCT_SELECT_CATE_ALL = "select * from product where category = ?";
	final static String PRODUCT_SELECT_ONE = "select * from product where pcode=?";
	final static String PRODUCT_INSERT = "insert into product values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	final static String PRODUCT_DELETE = "delete from product where pcode = ?";
	final static String PRODUCT_UPDATE1 = "update product set amount=amount+?, price=? where pcode=?";
	final static String PRODUCT_UPDATE2 = "update product set pname=?, pstd=?, price=?, pcom=?, amount=?, pic1=?, pic2=?, pic3=?, utburl=?, bookidx=?, cate=? where pcode=?";
	final static String PRODUCT_UPDATE_STOCK = "update product set price = ?, amount = amount + ? where pcode = ?";
	final static String PRODUCT_SELECT_SOLDOUT = "select * from product where amount<=0";
	
	final static String PRODUCT_CATE_SELECT1 = "select * from product where cate=?";
	final static String PRODUCT_CATE_SELECT2 = "select * from product where cate like ?||'%'";
	final static String PRODUCT_CATE_SELECT3 = "select * from product where cate like concat(?, '%')";
	final static String PRODUCT_SALES = "update product set amount=amount-? where pcode=?";
	
	final static String CATEGORY_SELECT_ALL = "select * from category where catecode = ?";
	final static String CATEGORY_SELECT_ONE = "select * from category where catecode = ?";
	final static String CATEGORY_SELECT_FIRST = "select distinct substr(catecode,1,2) as ct, categroup from category group by substr(catecode,1,2), categroup order by ct";
	final static String CATEGORY_SELECT_SECOND = "select catecode, catename from category where catecode like ?||'%' order by catecode";

	final static String BASKET_SELECT_ALL = "select * from basket order by bnum desc";
	final static String BASKET_SELECT_ALL2 = "select basket.bnum as bnum, basket.id as id, user1.uname as uname, basket.pcode as pcode, product.pname as pname, basket.amount as amount, product.price as price from basket, user1, product where basket.id=user1.id and basket.pcode=product.pcode";
	final static String BASKET_SELECT_BYID = "select * from basket where id=?";
	final static String BASKET_SELECT_BYID2 = "select basket.bnum as bnum, basket.id as id, user1.uname as uname, basket.pcode as pcode, product.pname as pname, basket.amount as amount, product.price as price from basket, user1, product where basket.id=user1.id and basket.pcode=product.pcode and basket.id=?";
	final static String BASKET_SELECT_BYID3 = "select basket.bnum as bnum, basket.id as id, user1.uname as uname, basket.pcode as pcode, product.pname as pname, basket.amount as amount, product.price as price from basket, user1, product where basket.id=user1.id and basket.pcode=product.pcode and basket.bnum=?";
	final static String BASKET_SELECT_BYPRODUCT = "select * from basket where pcode=?";
	final static String BASKET_SELECT_BYBNUM = "select * from basket where bnum=?";
	final static String BASKET_INSERT = "insert into basket values (?,?,?,?)";
	final static String BASKET_DELETE = "delete from basket where bnum=?";
	final static String BASKET_BNUM_GENERATOR = "select bnum from (select bnum from basket order by bnum desc) where rownum = 1";
	final static String BASKET_TRANS_BUY = "delete from basket where bnum=?";
	
	final static String ONUM_GENERATOR = "select onum from (select * from order1 order by onum desc) where rownum = 1";
	final static String PNUM_GENERATOR = "select pnum from (select * from payment order by pnum desc) where rownum = 1";
	final static String PAYMENT_ADD = "insert into payment values (?,?,?,?,?,?,default)";
	final static String PAYMENT_DELETE = "delete from payment where onum=?";
	
	final static String PAY_LIST = "select * from payment order by pnum desc";
	final static String PAY_BYONUM = "select * from payment where onum=? order by pnum desc";
	
	final static String ORDER_LIST_BYID = "select * from order1 where id=? order by onum desc";
	final static String ORDER_BYID = "select * from order1 where id=? and onum=?";
	
	final static String SALES_ADD = "insert into order1 values (?,?,?,?,?,default,?,?,?,?,?)";
	final static String SALES_LIST = "select order1.onum as onum, order1.id as id, order1.pcode as pcode, order1.amount as amount, order1.price as price, order1.odate as odate, order1.dstatus as dstatus, order1.dtel as dtel, order1.dname as dname, order1.daddr as daddr, order1.dcode as dcode, payment.pnum as pnum, payment.ptype as ptype, payment.ptnum as ptnum from order1, payment where payment.onum=order1.onum order by onum";
	final static String SALES_INFO = "select order1.onum as onum, order1.id as id, order1.pcode as pcode, order1.amount as amount, order1.price as price, order1.odate as odate, order1.dstatus as dstatus, order1.dtel as dtel, order1.dname as dname, order1.daddr as daddr, order1.dcode as dcode, payment.pnum as pnum, payment.ptype as ptype, payment.ptnum as ptnum from order1, payment where payment.onum=order1.onum and order1.onum=? order by onum";
	final static String SALES_LIST_BYID = "select order1.onum as onum, order1.id as id, order1.pcode as pcode, order1.amount as amount, order1.price as price, order1.odate as odate, order1.dstatus as dstatus, order1.dtel as dtel, order1.dname as dname, order1.daddr as daddr, order1.dcode as dcode, payment.pnum as pnum, payment.ptype as ptype, payment.ptnum as ptnum from order1, payment where payment.onum=order1.onum and order1.id=? order by onum";
	final static String SALES_PROGRESS_UPDATE = "update order1 set dname=?, dcode=?, dstatus=? where onum=?";
	final static String SALE_GET_BYID = "select order1.onum as onum, order1.id as id, order1.pcode as pcode, order1.amount as amount, order1.price as price, order1.odate as odate, order1.dstatus as dstatus, order1.dtel as dtel, order1.dname as dname, order1.daddr as daddr, order1.dcode as dcode, payment.pnum as pnum, payment.ptype as ptype, payment.ptnum as ptnum from order1, payment where payment.onum=order1.onum and order1.id=? and onum=?";
	final static String SALES_RETURN = "update order1 set dstatus='반품요청' where onum=?";
	final static String SALES_OK = "update order1 set dstatus='구매완료' where onum=?";
	
	final static String BUY_DELETE = "delete from order1 where onum=?";
	final static String PRODUCT_RETURN = "update product set amount=amount+? where pcode=?";
	
	
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