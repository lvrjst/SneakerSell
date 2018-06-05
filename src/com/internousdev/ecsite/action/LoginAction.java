package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.CartDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport implements SessionAware{

	private String userId;
	private String loginPass;
	private String userName;
	public Map<String, Object> session;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO LoginDTO = new LoginDTO();
	private BuyItemDAO buyItemDAO = new BuyItemDAO();

	public String execute() throws SQLException{
		String result = ERROR;
		LoginDTO = loginDAO.getLoginUserInfo(userId, loginPass);
		session.put("LoginDTO", LoginDTO);

		try{
			result = SUCCESS;

			if(!session.containsKey("LoginDTO")){
				//ログイン成功時に以下を使用
				CartDAO cartDAO = new CartDAO();
				String tempUserId = session.get("tempUserId").toString();
				cartDAO.changeTempUserId(userId,tempUserId);
				//dtoをセッションに格納
				session.put("LoginDTO",LoginDTO);
			}


			if(session.containsKey("LoginDTO")){
				result = SUCCESS;
				BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();

				session.put("loginFlg", true);
				session.put("id",buyItemDTO.getId());
				session.put("buyItemName",buyItemDTO.getItemName());
				session.put("buyItemPrice",buyItemDTO.getItemPrice());

				return result;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	public String getuserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId = userId;
	}
	public String getLoginPass(){
		return loginPass;
	}
	public void setLoginPass(String loginPass){
		this.loginPass = loginPass;
	}
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
	@Override
	public void setSession(Map<String, Object>session){
		this.session =session;
	}
}
