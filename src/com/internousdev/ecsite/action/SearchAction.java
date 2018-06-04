package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.SearchDAO;
import com.internousdev.ecsite.dto.ItemPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport implements SessionAware {
	private String result = SUCCESS;
	private String maker;

	private List<ItemPageDTO> sneakerSellDTOList = new ArrayList<ItemPageDTO>();
	private SearchDAO searchDAO = new SearchDAO();
	private Map<String, Object> session;


	public String execute() throws SQLException{
		System.out.println(maker);
		sneakerSellDTOList = searchDAO.searchMaker(maker);
		System.out.println(sneakerSellDTOList);

		return result;
	}
	public String getMaker(){
	return maker;
	}
	public void setMaker(String maker){
	this.maker = maker;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public List<ItemPageDTO> getSneakerSellDTOList() {
		return sneakerSellDTOList;
	}


	public void setSneakerSellDTOList(List<ItemPageDTO> sneakerSellDTOList) {
		this.sneakerSellDTOList = sneakerSellDTOList;
	}

}
