package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class PostDAO {
	public Map<String,Object>session;
	private String sql;

/*	postの内容を全部みられるようのメソッド
 * 	public ArrayList<PostDTO> getPostInfo()throws SQLException{
		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();
		ArrayList<PostDTO> postDTOList = new ArrayList<PostDTO>();

		sql = "select * from post_info where user_id = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				PostDTO postDTO = new PostDTO();
				postDTO.setUserId(rs.getString("user_id"));
				postDTO.setTempUserId(rs.getString("temp_user_id"));
				postDTO.setName(rs.getString("name"));
				postDTO.setEmail(rs.getString("email"));
				postDTO.setPlayer(rs.getString("player"));
				postDTO.setMessage(rs.getString("message"));
				postDTOList.add(postDTO);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return postDTOList;
	}
*/
		public void Post(String userId,String name,String email,String player,String message,int sqlBranch) throws SQLException{
			DBConnector dbConnector = new DBConnector();
			Connection con = dbConnector.getConnection();
			DateUtil dateUtil = new DateUtil();
			if(sqlBranch == 0){
				sql = "INSERT INTO post_info(user_id,name,email,player,message,insert_date) VALUES(?,?,?,?,?)";
			}else{
				sql = "INSERT INTO post_info(temp_user_id ,name,email,player,message,insert_date) VALUES(?,?,?,?,?)";
			}
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, player);
			ps.setString(5, message);
			ps.setString(6, dateUtil.getDate());

			ps.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}



	//ログイン時に変更
	public void changeTempUserIdPost(String userId,String tempUserId) throws SQLException{
		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();
		String sql = "UPDATE post_info SET user_id = ? from where temp_user_id = ? ";
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
}
