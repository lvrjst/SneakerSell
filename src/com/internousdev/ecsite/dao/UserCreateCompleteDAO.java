package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;



public class UserCreateCompleteDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection con = dbConnector.getConnection();
	private DateUtil dateUtil = new DateUtil();

	private String sql = "INSERT INTO login_user_transaction(login_id, login_pass, user_name,name,furigana,zip,address,telephone ,mail_address,birthday_year,birthday_month ,birthday_day,direct_mail,insert_date) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		public void createUser(String loginId, String loginPass,String userName,String name, String furigana, String zip, String address, String telephone, String mailAddress, String birthdayYear, String birthdayMonth, String birthdayDay, String directMail)throws SQLException{

		try{
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1,loginId);
			ps.setString(2,loginPass);
			ps.setString(3,userName);
			ps.setString(4,name);
			ps.setString(5,furigana);
			ps.setString(6,zip);
			ps.setString(7,address);
			ps.setString(8,telephone);
			ps.setString(9,mailAddress);
			ps.setString(10,birthdayYear);
			ps.setString(11,birthdayMonth);
			ps.setString(12,birthdayDay);
			ps.setString(13,directMail);
			ps.setString(14,dateUtil.getDate());

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}
}
