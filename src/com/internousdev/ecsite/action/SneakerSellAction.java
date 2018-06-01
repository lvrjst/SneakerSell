package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dao.SneakerSellDAO;
import com.internousdev.ecsite.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SneakerSellAction extends ActionSupport{
	private List<ItemDTO> sneakerSellDTOList = new ArrayList<ItemDTO>();


	public String execute(){
		String ret = ERROR;
		SneakerSellDAO sneakerSellDAO = new SneakerSellDAO();
		sneakerSellDTOList = sneakerSellDAO.getItemInfo();
			if(sneakerSellDTOList.size() > 0){
				ret=SUCCESS;
			}else{
				ret=ERROR;
			}
		return ret;
	}
	public List<ItemDTO> getSneakerSellDTOList(){
	return sneakerSellDTOList;
	}
	public void setSneakerSellDTOList(List<ItemDTO> sneakerSellDTOList){
	this.sneakerSellDTOList = sneakerSellDTOList;
	}
}
