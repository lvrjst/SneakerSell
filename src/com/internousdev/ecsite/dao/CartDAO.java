package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.internousdev.ecsite.dto.CartDTO;
import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class CartDAO {
	public Map<String,Object>session;

	public ArrayList<CartDTO> getCartInfo(String userId)throws SQLException{
		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();
		ArrayList<CartDTO> cartDTOList = new ArrayList<CartDTO>();

		String sql = "select * from cart_info left outer join item_info_transaction ON cart_info.item_id= item_info_transaction.item_id where user_id = ?";

				//"select * from cart_info left outer join product_info ON cart_info.product_id= product_info.product_id where user_id = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				CartDTO cartDTO = new CartDTO();
				cartDTO.setItemId(rs.getString("item_id"));
				cartDTO.setItemName(rs.getString("item_name"));
				//cartDTO.setProductName(rs.getString("productName"));
				//cartDTO.setProductNameKana(rs.getString("productNameKana"));
				cartDTO.setItemPrice(rs.getInt("item_price"));
				cartDTO.setItemCount(rs.getInt("item_count"));
				cartDTO.setItemTotalPrice(rs.getInt("item_total_price"));
				//下のやつの代わりcartDTO.setImageFilePath(rs.getString("imageFilePath"));
				cartDTO.setTopPicUrl(rs.getString("pic_url0"));
				//cartDTO.setReleaseConpany(rs.getString("releaseConpany"));
				//cartDTO.setReleaseDate(rs.getString("releaseDate"));
				//cartDTO.setItemStock(rs.getInt("item_stock"));
				cartDTOList.add(cartDTO);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return cartDTOList;
	}

		public void getCartInsertInfo(String userId,String itemId,int itemCount,int itemTotalPrice) throws SQLException{
			DBConnector dbConnector = new DBConnector();
			Connection con = dbConnector.getConnection();
			DateUtil dateUtil = new DateUtil();
			String sql = "INSERT INTO cart_info(user_id,temp_user_id,item_id,item_count,item_total_price,insert_date) VALUES(?,?,?,?,?,?)";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, userId);
			ps.setString(3, itemId);
			ps.setInt(4, itemCount);
			ps.setInt(5, itemTotalPrice);
			ps.setString(6, dateUtil.getDate());

			ps.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}


	public int getItemCount(String userId,String itemId)throws SQLException{
		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();
		int itemCount = 0;

		String sql = "select item_count from cart_info where user_id = ? and item_id = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, itemId);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				itemCount += rs.getInt("item_count");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return itemCount;
	}


	public void cartDeleteInfo(String userId, String itemId) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();

		String sql = "DELETE from cart_info where user_id = ? and item_id = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, itemId);
			ps.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}
	//ログイン時に変更
	public void changeTempUserId(String userId,String tempUserId) throws SQLException{
		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();
		String sql = "UPDATE cart_info SET user_id = ? from where temp_user_id = ? ";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, tempUserId);
			ps.executeQuery();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			con.close();
		}
	}

	public boolean duplicates(String userId, String itemId) throws SQLException{
		boolean result = false;
		String duplicate = null;
		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();
		String sql = "select user_id from cart_info where user_id = ? AND item_id = ? ";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, itemId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				duplicate = rs.getString("user_id");
			}
			if(duplicate != null){
				result = true;
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally {
			con.close();
		}
		return result;

	}
}
