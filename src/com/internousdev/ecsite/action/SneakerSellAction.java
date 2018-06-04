package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dao.SneakerSellDAO;
import com.internousdev.ecsite.dto.ItemPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SneakerSellAction extends ActionSupport{
	private List<ItemPageDTO> sneakerSellDTOList = new ArrayList<ItemPageDTO>();


	public String execute(){
		String ret = ERROR;
		SneakerSellDAO sneakerSellDAO = new SneakerSellDAO();
		sneakerSellDTOList = sneakerSellDAO.getItemInfo();
			if(sneakerSellDTOList.size() > 0){
				ret=SUCCESS;
			}
		return ret;
	}
	public List<ItemPageDTO> getSneakerSellDTOList(){
	return sneakerSellDTOList;
	}
	public void setSneakerSellDTOList(List<ItemPageDTO> sneakerSellDTOList){
	this.sneakerSellDTOList = sneakerSellDTOList;
	}
}
