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

	public List<ItemPageDTO> searchMaker(String maker)throws SQLException{

		DBConnector dbConnector = new DBConnector();
		Connection con = (Connection)dbConnector.getConnection();
		String sql = "SELECT * FROM  item_info_transaction WHERE maker = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, maker);
			ResultSet rs = ps.executeQuery();

				while(rs.next()){
					ItemPageDTO sneakerSellDTO = new ItemPageDTO();

					sneakerSellDTO.setItemId(rs.getString("item_id"));
					sneakerSellDTO.setItemName(rs.getString("item_name"));
					sneakerSellDTO.setItemText(rs.getString("item_text"));
					sneakerSellDTO.setMaker(rs.getString("maker"));
					sneakerSellDTO.setItemPrice(rs.getInt("item_price"));
					sneakerSellDTO.setPicUrl0(rs.getString("pic_url0"));
					sneakerSellDTO.setPostTime(rs.getString("post_time"));
					sneakerSellDTO.setColor1(rs.getString("color1"));
					sneakerSellDTO.setColor2(rs.getString("color2"));
					sneakerSellDTO.setItemStock(rs.getInt("item_stock"));

					sneakerSellDTOList.add(sneakerSellDTO);
				}

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return sneakerSellDTOList;
	}

}
