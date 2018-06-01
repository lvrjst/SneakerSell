package com.internousdev.ecsite.action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.internousdev.ecsite.dao.ScrapingDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ScrapingAction extends ActionSupport{
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


	public String execute() throws IOException, SQLException, InterruptedException {
		String result =SUCCESS;
		String url = "http://sneakerwars.jp/items/page/3";
		/*String url = "http://sneakerwars.jp/items/page/";
		 for(int i=2;i<10;i++){
			url += i+url;*///開始時間

			Document doc = Jsoup.connect(url).get();
			//Element element = doc.select("#pageid1 > div > article > div > a").get(0);//2ページ目にあるurl(1個目)

			Elements elements = doc.select("#pageid1 > div > article > div > a");//１ページにある各url(16個)
			for(Element element:elements){
				System.out.println(element);
				long startTime = System.currentTimeMillis();

				String url2 = "http://sneakerwars.jp" + element.attr("href");
				//System.out.println(url2);
				long endTime = System.currentTimeMillis();
				long time = interval - (endTime - startTime);
				if (time > 0) {
					Thread.sleep(time);
				}
				Random random = new Random();
				interval += random.nextInt(300);

				Document doc2 = Jsoup.connect(url2).get();

				//色々な変数記述するのがめんどいからMap型で格納するのが楽？
				if(element.attr("href").isEmpty()){
					itemId = null;
				}else{
					itemId = element.attr("href");//ID
				}
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
					/*String topPicUrl = elemPics.get(0).attr("href");
					String anotherPicUrl1=elemPics.get(1).attr("href");
					String anotherPicUrl2=elemPics.get(2).attr("href");
					String anotherPicUrl3=elemPics.get(3).attr("href");
					String anotherPicUrl4=elemPics.get(4).attr("href");
					String anotherPicUrl5=elemPics.get(5).attr("href");
					String anotherPicUrl6=elemPics.get(6).attr("href");
					String anotherPicUrl7=elemPics.get(7).attr("href");
					String anotherPicUrl8=elemPics.get(8).attr("href");*/



				scrapingDAO.getScrapingInfo(itemId, itemName, itemTitle, elemPics,itemPrice, itemText, postTime, maker, color1, color2);

			}
		//}
		return result;
	}

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

//	String url = "http://sneakerwars.jp/items/page/2";
//	Document doc = Jsoup.connect(url).get();
//	Elements elements = doc.select("#pageid1 > div > article > div > a");
//	for(Element element:elements){
//		System.out.println(element.attr("href"));
//	}
//

//	public static void main(String[] args) throws IOException {
//		String url = "https://twitter.com/search?lang=ja&src=typd";
//		Document doc = Jsoup.connect(url).timeout(8000).data("q", "クックパッド").get();
//		Elements elements = doc.select("p.TweetTextSize.js-tweet-text.tweet-text");
//			for(Element element:elements){
//				System.out.println(element.text());
//			}
//    }
}
