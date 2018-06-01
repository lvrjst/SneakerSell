package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.ItemPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemPageDAO {
	public ItemPageDTO getItemPageInfo(String itemId) throws SQLException{
		DBConnector dbconnector = new DBConnector();
		Connection con = dbconnector.getConnection();
		ItemPageDTO itemPageDTO = new ItemPageDTO();
		String sql = "SELECT * FROM item_info_transaction where item_id = ?";
		try{
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setString(1, itemId);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){

				itemPageDTO.setItemId(rs.getString("item_id"));
				itemPageDTO.setItemName(rs.getString("item_name"));
				itemPageDTO.setItemTitle(rs.getString("item_title"));
				itemPageDTO.setTopPicUrl(rs.getString("pic_url0"));
				itemPageDTO.setAnotherPicUrl1(rs.getString("pic_url1"));
				itemPageDTO.setAnotherPicUrl2(rs.getString("pic_url2"));
				itemPageDTO.setAnotherPicUrl3(rs.getString("pic_url3"));
				itemPageDTO.setAnotherPicUrl4(rs.getString("pic_url4"));
				itemPageDTO.setAnotherPicUrl5(rs.getString("pic_url5"));
				itemPageDTO.setAnotherPicUrl6(rs.getString("pic_url6"));
				itemPageDTO.setAnotherPicUrl7(rs.getString("pic_url7"));
				itemPageDTO.setAnotherPicUrl8(rs.getString("pic_url8"));
				itemPageDTO.setItemPrice(rs.getInt("item_price"));
				itemPageDTO.setItemText(rs.getString("item_text"));
				itemPageDTO.setItemStock(rs.getInt("item_stock"));
				itemPageDTO.setPostTime(rs.getString("post_time"));
				itemPageDTO.setMaker(rs.getString("maker"));
				itemPageDTO.setColor1(rs.getString("color1"));
				itemPageDTO.setColor2(rs.getString("color2"));
			}else{
				return null;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return itemPageDTO;
	}
}
