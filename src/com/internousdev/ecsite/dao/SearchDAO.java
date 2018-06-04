package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.ItemPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class SearchDAO {
	private List<ItemPageDTO> sneakerSellDTOList = new ArrayList<ItemPageDTO>();
	public List<ItemPageDTO> searchMaker(String maker){

		ItemPageDTO itemPageDTO = new ItemPageDTO();
		DBConnector dbConnector = new DBConnector();
		Connection con = (Connection)dbConnector.getConnection();
		String sql = "SELECT * FROM  item_info_transaction WHERE maker = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, maker);
			ResultSet rs = ps.executeQuery();

				while(rs.next()){
					itemPageDTO.setItemId(rs.getString("Item_id"));
					itemPageDTO.setItemName(rs.getString("Item_name"));
					itemPageDTO.setItemText(rs.getString("Item_text"));
					itemPageDTO.setMaker(rs.getString("maker"));
					itemPageDTO.setItemPrice(rs.getInt("item_price"));
					itemPageDTO.setPicUrl0(rs.getString("pic_url0"));
					itemPageDTO.setPostTime(rs.getString("post_time"));
					itemPageDTO.setColor1(rs.getString("color1"));
					itemPageDTO.setColor2(rs.getString("color2"));
					itemPageDTO.setItemStock(rs.getInt("item_stock"));

					sneakerSellDTOList.add(itemPageDTO);
				}

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return sneakerSellDTOList;
	}

}
