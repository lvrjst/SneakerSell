package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.ItemPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class SneakerSellDAO {
	private List<ItemPageDTO> sneakerSellDTOList = new ArrayList<ItemPageDTO>();

	private DBConnector dbConnector = new DBConnector();
	private Connection con = dbConnector.getConnection();

	public List<ItemPageDTO> getItemInfo(){
		String sql ="select * From item_info_transaction ";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				ItemPageDTO sneakerSellDTO = new ItemPageDTO();

				sneakerSellDTO.setItemId(rs.getString("item_id"));
				sneakerSellDTO.setItemTitle(rs.getString("item_title"));
				sneakerSellDTO.setItemName(rs.getString("item_name"));
				sneakerSellDTO.setPicUrl0(rs.getString("pic_url0"));
				sneakerSellDTO.setItemText(rs.getString("item_text"));
				sneakerSellDTO.setPostTime(rs.getString("post_time"));

				sneakerSellDTOList.add(sneakerSellDTO);
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			try{
				con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return sneakerSellDTOList;
	}

}
