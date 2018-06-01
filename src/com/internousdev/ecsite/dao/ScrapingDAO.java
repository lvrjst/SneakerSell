package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jsoup.select.Elements;

import com.internousdev.ecsite.util.DBConnector;

public class ScrapingDAO {
	public void getScrapingInfo(String itemId,String itemName,String itemTitle, Elements elemPics,int itemPrice,String itemText,String postTime,String maker,String color1,String color2) throws SQLException{
		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();
		String sql = "INSERT INTO item_info_transaction( item_id, item_name, item_title,item_price, item_text, post_time, maker, color1, color2";

		for(int i =0; i < elemPics.size(); i++){

			if(i == elemPics.size() - 1){
				sql += "," + "pic_url" + i + ") VALUES (?,?,?,?,?,?,?,?,?";
			}else{
				sql += "," + "pic_url" + i ;
			}
		}

		for(int i =0; i < elemPics.size(); i++){
			if(i == elemPics.size() - 1){
				sql += "," + "?" + ")";
			}else{
				sql += "," + "?" ;
			}
		}
	try{
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,itemId);
		ps.setString(2,itemName);
		ps.setString(3,itemTitle);
		ps.setInt(4,itemPrice);
		ps.setString(5,itemText);
		ps.setString(6,postTime);
		ps.setString(7,maker);
		ps.setString(8,color1);
		ps.setString(9,color2);
		for(int i =0; i < elemPics.size(); i++){
			ps.setString(10+i, elemPics.get(i).attr("href"));
		}

		ps.executeUpdate();

	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		con.close();
	}
}


}
