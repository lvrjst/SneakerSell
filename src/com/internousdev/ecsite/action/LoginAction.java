package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport implements SessionAware{

	private String loginId;
	private String loginPass;
	private String userName;
	public Map<String, Object> session;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private BuyItemDAO buyItemDAO = new BuyItemDAO();

	public String execute() throws SQLException{
		String result = ERROR;
		loginDTO = loginDAO.getLoginUserInfo(loginId, loginPass);
		session.put("LoginDTO", loginDTO);

		try{
			if(((LoginDTO)session.get("LoginDTO")).getLoginFlg()){
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

	public String getLoginId(){
		return loginId;
	}
	public void setLoginId(String loginId){
		this.loginId = loginId;
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
