package img.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;
import model.Img;

public class DaoImpl implements Dao {
	private DBConnect db;

	public DaoImpl() {
		db = DBConnect.getInstance();
	}

	public ArrayList<Img> selectAll() {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Img> data = new ArrayList<Img>();
		String sql = "select * from img order by num";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				data.add(new Img(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6)));
			}
			rs.close();
			pstmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return data;
	}

	public void insert(Img img) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "insert into img values(?, ?, ?, ?, ?, sysdate)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, img.getNum());
			pstmt.setString(2, img.getWriter());
			pstmt.setString(3, img.getPwd());
			pstmt.setString(4, img.getTitle());
			pstmt.setString(5, img.getPath());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public int makeNum() {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select seq_img.nextval from dual";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}
			rs.close();
			pstmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Img select(int num) {
 		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from img where num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return new Img(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6));
			}
			rs.close();
			pstmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	@Override
	public int delete(int num) {
		// TODO Auto-generated method stub
		
		return 0;
	}
}
