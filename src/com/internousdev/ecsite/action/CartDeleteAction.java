package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartDAO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartDeleteAction extends ActionSupport implements SessionAware {

	private String userId;
	private String itemId ;
	private Map<String,Object>session;
	private String result = SUCCESS;
	LoginDTO loginDTO = new LoginDTO();
	CartDAO cartDAO = new CartDAO();

	public String execute(){
		boolean loginFlg = (boolean) session.get("loginFlg");
		try{
			if(loginFlg){
				loginDTO = (LoginDTO)session.get("LoginDTO");
				userId = loginDTO.getLoginId();
			}
			else{
				userId = session.get("TempUserId").toString();
			}

			cartDAO.cartDeleteInfo(userId,itemId);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	public String getUserId(){
	return userId;
	}
	public void setUserId(String userId){
	this.userId = userId;
	}
	public String getItemId(){
	return itemId;
	}
	public void setItemId(String itemId){
	this.itemId = itemId;
	}
	public Map<String, Object> getSession() {
	return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
	this.session = session;
	}
}
