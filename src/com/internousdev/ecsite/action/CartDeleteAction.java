package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartDAO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartDeleteAction extends ActionSupport implements SessionAware {

	private String userId;
	private String itemId ;
	private int sqlBranch;

	private Map<String,Object>session;
	private String result = SUCCESS;

	private LoginDTO loginDTO = new LoginDTO();
	private CartDAO cartDAO = new CartDAO();

	public String execute(){
		try{
			if(session.containsKey("LoginDTO")){
				loginDTO = (LoginDTO)session.get("LoginDTO");
				userId = loginDTO.getLoginId();
				sqlBranch = 0;
			}
			else{
				userId = session.get("tempUserId").toString();
				sqlBranch = 1;
			}
			cartDAO.cartDeleteInfo(userId,itemId,sqlBranch);
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
