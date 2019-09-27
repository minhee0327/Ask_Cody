package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.CD_ClothVO;
import vo.SuggestionVO;

public class CD_ClothDAO {
	
	public int deleteCoordi(int coordi_id) {
		String sql = "delete from coordi_cloth where coordi_id = ? ";
		Connection con = null;
		PreparedStatement ps = null;
		
		int result = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			//? 세팅
			ps.setInt(1, coordi_id);
			
			//실행 및 결과값 핸들링
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}
	
	public int saveCoordi(CD_ClothVO vo) {
		System.out.println("사진 저장 시작");
		String sql = "insert into coordi_cloth values((select nvl(max(CDCLOTH_ID),0)+1 from coordi_cloth),?,?) ";
		
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);

			//? 세팅
			System.out.println("coordi_id: "+vo.getCoordi_id());
			ps.setInt(1, vo.getCoordi_id());
			ps.setString(2, vo.getImage());
			System.out.println("vo.getImage()  => "+vo.getImage());
		
			
			//실행 및 결과값 핸들링
			result = ps.executeUpdate();
			
			System.out.println("사진 저장 완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}
	
	public List<CD_ClothVO> loadCoordi(int coordi_id) {
		System.out.println("load 요청처리");
		String sql ="select * from coordi_cloth where coordi_id=? ";
		
		List <CD_ClothVO> list = new ArrayList<CD_ClothVO>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			//? 세팅
			ps.setInt(1, coordi_id);
			//실행 및 결과값 핸들링
			rs = ps.executeQuery();
			while(rs.next()) {
				CD_ClothVO vo = new CD_ClothVO();
				vo.setCdcloth_id(rs.getInt("cdcloth_id"));
				vo.setCoordi_id(rs.getInt("coordi_id"));
				vo.setImage(rs.getString("image"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return list;
		
	}
	
	public List<SuggestionVO> loadSuggestion() {
		System.out.println("loadSuggestion 처리");
		String sql ="select * from cloth_suggestion ";
		
		List <SuggestionVO> list = new ArrayList<SuggestionVO>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			//? 세팅
			//실행 및 결과값 핸들링
			rs = ps.executeQuery();
			while(rs.next()) {
				SuggestionVO vo = new SuggestionVO();
				vo.setCloth_id(rs.getInt("cloth_id"));
				vo.setSave_date(rs.getDate(2));
				vo.setImage(rs.getString("image"));

				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return list;
		
	}
}
