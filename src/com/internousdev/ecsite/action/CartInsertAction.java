package com.internousdev.ecsite.action;


import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartDAO;
import com.internousdev.ecsite.dto.ItemPageDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartInsertAction extends ActionSupport implements SessionAware {
	private Map<String,Object>session;
	private String SUCCESS;
	private String userId ;
	private String itemId;
	private int itemCount;
	private int itemTotalPrice;
	private int itemPrice;
	private int sqlBranch;

	public String execute() throws SQLException{
		String result = SUCCESS;

		CartDAO cartDAO = new CartDAO();
		LoginDTO loginDTO = new LoginDTO();
		ItemPageDTO itemPageDTO = new ItemPageDTO();

		try{
			if(session.containsKey("LoginDTO")){
				loginDTO = (LoginDTO)session.get("LoginDTO");
				userId = loginDTO.getLoginId();
				sqlBranch = 0;
			}else{
				userId = session.get("tempUserId").toString();
				sqlBranch = 1;
			}

			//合計金額を出すために以下を使用

			itemPageDTO = (ItemPageDTO)session.get("ItemPageDTO");


			itemId = itemPageDTO.getItemId();

			if(cartDAO.duplicates(userId,itemId)){
			itemCount = itemCount + cartDAO.getItemCount(userId,itemId,sqlBranch);
			session.put("ItemCount", itemCount);
			cartDAO.cartDeleteInfo(userId,itemId,sqlBranch);
			}else{
			session.put("ItemCount", itemCount);
			}
			int intCount = Integer.parseInt(session.get("ItemCount").toString());

			itemPrice = itemPageDTO.getItemPrice();
			session.put("itemPrice", itemPrice);

			session.put("ItemTotalPrice", intCount * itemPrice);

			itemTotalPrice = (int)session.get("ItemTotalPrice");

			cartDAO.getCartInsertInfo(userId,itemId,itemCount,itemTotalPrice,sqlBranch);


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
	public int getItemCount(){
	return itemCount;
	}
	public void setItemCount(int itemCount){
	this.itemCount = itemCount;
	}
	public int getItemTotalPrice(){
	return itemTotalPrice;
	}
	public void setItemTotalPrice(int itemTotalPrice){
	this.itemTotalPrice = itemTotalPrice;
	}

	@Override
	public void setSession(Map<String, Object>session){
		this.session =session;
	}

}