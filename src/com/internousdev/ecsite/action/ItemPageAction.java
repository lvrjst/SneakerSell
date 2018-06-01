package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemPageDAO;
import com.internousdev.ecsite.dto.ItemPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemPageAction extends ActionSupport implements SessionAware{
	private String itemId;
	private Map<String,Object>session;
	private ItemPageDTO itemPageDTO = new ItemPageDTO();

	public String execute() throws SQLException{
		String result = SUCCESS;
		ItemPageDAO itemPageDAO = new ItemPageDAO();

		try{
			itemPageDTO = itemPageDAO.getItemPageInfo(itemId);
			session.put("ItemPageDTO",itemPageDTO);

		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	public String getItemId(){
	return itemId;
	}
	public void setItemId(String itemId){
	this.itemId = itemId;
	}
	public ItemPageDTO getItemPageDTO(){
	return itemPageDTO;
	}
	public void setItemPageDTO(ItemPageDTO itemPageDTO){
	this.itemPageDTO = itemPageDTO;
	}
	@Override
	public void setSession(Map<String, Object>session){
		this.session =session;
	}

}
