package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.ClothesVO;

public class ClothesDAO_Oracle {
	
	public List<ClothesVO> allClothesList() {
		
		String sql = 

			"select distinct image from clothes ";
		
		List<ClothesVO> list = new ArrayList<ClothesVO>();
			
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);	
			rs = ps.executeQuery();
			
			while (rs.next()) {		
				ClothesVO vo = new ClothesVO();			

				vo.setImage(rs.getString("image"));
				list.add(vo);
			}
			System.out.println(list.toString());
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}	
		return list;
	}
	
	
	public List<ClothesVO> filterclothes(String type, String color) {
		
		String sql =
				
			"select * from clothes where cloth_type = ? and cloth_color = ? ";

		List<ClothesVO> list = new ArrayList<ClothesVO>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, type);
			ps.setString(2, color);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				ClothesVO vo = new ClothesVO();
				vo.setImage(rs.getString("image"));
				list.add(vo);
			}					
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return list;
	}
	
	public List<ClothesVO> filteralltypeclothes(String color) {
		
		String sql =
				
				"select distinct image " + 
				"from (select * from clothes where cloth_color = ? ) ";
		
		List<ClothesVO> list = new ArrayList<ClothesVO>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, color);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				ClothesVO vo = new ClothesVO();
				vo.setImage(rs.getString("image"));
				list.add(vo);
			}					
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return list;
	}
	
	public List<ClothesVO> filterallcolorclothes(String type) {
		
		String sql =
				
				"select * from clothes where cloth_type = ? ";
		
		List<ClothesVO> list = new ArrayList<ClothesVO>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, type);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				ClothesVO vo = new ClothesVO();
				vo.setImage(rs.getString("image"));
				list.add(vo);
			}					
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return list;
	}
}