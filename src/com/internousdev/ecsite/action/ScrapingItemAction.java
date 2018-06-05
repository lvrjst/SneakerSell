package com.internousdev.ecsite.action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.internousdev.ecsite.dao.ScrapingDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ScrapingItemAction extends ActionSupport{
		private ScrapingDAO scrapingDAO = new ScrapingDAO();

		private String itemId;
		private String itemName ;
		private String itemTitle ;
		private int itemPrice ;
		private String itemText ;
		private String postTime ;
		private String maker ;
		private String color1 ;
		private String color2 ;

		private long interval;
		private String scrapingItemUrl;


	public String execute() throws IOException, SQLException, InterruptedException {
		String result =SUCCESS;
		/*String url = "http://sneakerwars.jp/items/page/";
		 for(int i=2;i<10;i++){
			url += i+url;*///開始時間

			long startTime = System.currentTimeMillis();

			//System.out.println(url2);
			long endTime = System.currentTimeMillis();
			long time = interval - (endTime - startTime);
			if (time > 0) {
				Thread.sleep(time);
			}
			Random random = new Random();
			interval += random.nextInt(300);

			Document doc2 = Jsoup.connect(scrapingItemUrl).get();

			itemId = scrapingItemUrl.substring(20, 35);

			System.out.println(itemId);
			if(doc2.select("#logogroup > h2").isEmpty()){
				itemTitle = null;
			}else{
				itemTitle = doc2.select("#logogroup > h2").get(0).text();//タイトル
			}
			System.out.println(itemTitle);
			if(doc2.select("#view_col2 > div:nth-child(2) > h2").isEmpty()){
				itemName = null;
			}else{
				itemName = doc2.select("#view_col2 > div:nth-child(2) > h2").get(0).text();
			}
			System.out.println(itemName);
			if(doc2.select("#logogroup > h2").isEmpty()){
				itemTitle = null;
			}else{
				itemTitle = doc2.select("#logogroup > h2").get(0).text();
			}
			System.out.println(itemTitle);

			if(doc2.select("#view_col2 > div:nth-child(2) > dl > dd:nth-child(10)").isEmpty()){
				itemPrice = -1;
			}else{
				String stringPrice = doc2.select("#view_col2 > div:nth-child(2) > dl > dd:nth-child(10)").get(0).text().trim();
				if(stringPrice.contains("$")){
					stringPrice = stringPrice.replace("$", "");
				}else if(stringPrice.contains("円")){
					stringPrice = stringPrice.replace("円", "");
				}else{
				}
				if(stringPrice.contains(",")){
					stringPrice = stringPrice.replace(",", "");
				}
				itemPrice = Integer.parseInt(stringPrice.replaceAll("^[^0-9]$", ""));
			}

			System.out.println(itemPrice);

			if(doc2.select("#view_col2 > div:nth-child(2) > p.item_text.prevent-copy").isEmpty()){
				itemText = null;
			}else{
				itemText = doc2.select("#view_col2 > div:nth-child(2) > p.item_text.prevent-copy").get(0).text();
			}
			System.out.println(itemText);
			if(doc2.select("#view_col2 > div:nth-child(2) > p.view_time > time").isEmpty()){
				postTime = null;
			}else{
				postTime = doc2.select("#view_col2 > div:nth-child(2) > p.view_time > time").get(0).text();
			}
			System.out.println(postTime);
			if(doc2.select("#view_col2 > div:nth-child(2) > dl > dd:nth-child(2) > a:nth-child(1)").isEmpty()){
				maker = null;
			}else{
				maker = doc2.select("#view_col2 > div:nth-child(2) > dl > dd:nth-child(2) > a:nth-child(1)").get(0).text();
			}
			System.out.println(maker);
			if(doc2.select("#view_col2 > div:nth-child(2) > dl > dd:nth-child(4) > a:nth-child(1)").isEmpty()){
				color1 = null;
			}else{
				color1 = doc2.select("#view_col2 > div:nth-child(2) > dl > dd:nth-child(4) > a:nth-child(1)").get(0).text();
			}
			System.out.println(color1);
			if(doc2.select("#view_col2 > div:nth-child(2) > dl > dd:nth-child(4) > a:nth-child(2)").isEmpty()){
				color2 =  null;
			}else{
				color2 = doc2.select("#view_col2 > div:nth-child(2) > dl > dd:nth-child(4) > a:nth-child(2)").get(0).text();
			}
			System.out.println(color2);


			Elements elemPics = doc2.select("#view_col2 > div > ul > li > a");//商品の各画像

			scrapingDAO.getScrapingInfo(itemId, itemName, itemTitle, elemPics,itemPrice, itemText, postTime, maker, color1, color2);

			return result;

		}
		//}


	public String getScrapingItemUrl(String scrapingItemUrl){
		return scrapingItemUrl;
	}

	public void setScrapingItemUrl(String scrapingItemUrl) {
		this.scrapingItemUrl = scrapingItemUrl;
	}

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

}
