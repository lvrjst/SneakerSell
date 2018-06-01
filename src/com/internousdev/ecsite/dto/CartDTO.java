package com.internousdev.ecsite.dto;

public class CartDTO {
	private int itemCount ;
	private int itemTotalPrice ;

	private String itemId ;
	private String itemName ;
	private String itemTitle ;
	private String topPicUrl ;
	private int itemPrice ;
	private int itemStock ;


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

	public String getItemId(){
	return itemId;
	}
	public void setItemId(String itemId){
	this.itemId = itemId;
	}
	public String getItemName(){
	return itemName;
	}
	public void setItemName(String itemName){
	this.itemName = itemName;
	}
	public String getItemTitle(){
	return itemTitle;
	}
	public void setItemTitle(String itemTitle){
	this.itemTitle = itemTitle;
	}
	public String getTopPicUrl(){
	return topPicUrl;
	}
	public void setTopPicUrl(String topPicUrl){
	this.topPicUrl = topPicUrl;
	}
	public int getItemPrice(){
	return itemPrice;
	}
	public void setItemPrice(int itemPrice){
	this.itemPrice = itemPrice;
	}
	public int getItemStock(){
	return itemStock;
	}
	public void setItemStock(int itemStock){
	this.itemStock = itemStock;
	}


}
