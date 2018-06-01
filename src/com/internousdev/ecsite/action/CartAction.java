package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartDAO;
import com.internousdev.ecsite.dto.CartDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware {
	private Map<String,Object>session;
	private ArrayList<CartDTO> cartDTOList = new ArrayList<CartDTO>();
	private String ERROR;
	private  String userId;
	private int totalPrice;


	public String execute(){
		String result = ERROR;
		CartDAO cartDAO = new CartDAO();
		LoginDTO loginDTO = new LoginDTO();

		boolean loginFlg = (boolean) session.get("loginFlg");

		try{
			if(loginFlg){
				loginDTO = (LoginDTO)session.get("LoginDTO");
				userId = loginDTO.getLoginId();
			}
			else{
				userId = session.get("TempUserId").toString();
			}
				cartDTOList = cartDAO.getCartInfo(userId);

				totalPrice = totalPrice(cartDTOList);


				result = SUCCESS;
		}
		catch(Exception e){
			e.printStackTrace();
		}
			return result;
		}

	public int totalPrice(ArrayList<CartDTO> cartList){
		int totalPrice = 0;
		for(CartDTO cartDTO : cartList){
			totalPrice += cartDTO.getItemTotalPrice();
		}
		return totalPrice;
	}
	public String getUserId(){
	return userId;
	}
	public void setUserId(String userId){
	this.userId = userId;
	}
	public ArrayList<CartDTO> getCartDTOList(){
	return cartDTOList;
	}
	public void setCartDTOList(ArrayList<CartDTO> cartDTOList){
	this.cartDTOList = cartDTOList;
	}
	public int getTotalPrice(){
	return totalPrice;
	}
	public void setTotalPrice(int totalPrice){
	this.totalPrice = totalPrice;
	}
	public Map<String, Object> getSession() {
	return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
	this.session = session;
	}


}
