package com.taotao.parse;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.taotao.model.JDModel;

public class JdParse {
	public static List<JDModel> getData (String html) throws Exception{ 
		//获取的数据，存放在集合中 
		List<JDModel> data = new ArrayList<JDModel>(); 
		//采用Jsoup解析 
		Document doc = Jsoup.parse(html); 
		//获取html标签中的内容
		Elements elements=doc.select("ul[class=gl-warp clearfix]").select("li[class=gl-item]"); 
		for (Element ele:elements) { 
			String bookID=ele.attr("data-sku"); 
			String bookPrice=ele.select("div[class=p-price]").select("strong").select("i").text(); 
			String bookName=ele.select("div[class=p-name]").select("em").text(); 
			//创建一个对象，这里可以看出，使用Model的优势，直接进行封装 
			JDModel jdModel=new JDModel(); 
			//对象的值 
			jdModel.setBookID(bookID); 
			jdModel.setBookName(bookName); 
			jdModel.setBookPrice(bookPrice); 
			//将每一个对象的值，保存到List集合中 
			data.add(jdModel); 
		} 
		//返回数据 
		return data; 
	}
}
