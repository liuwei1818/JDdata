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
		//��ȡ�����ݣ�����ڼ����� 
		List<JDModel> data = new ArrayList<JDModel>(); 
		//����Jsoup���� 
		Document doc = Jsoup.parse(html); 
		//��ȡhtml��ǩ�е�����
		Elements elements=doc.select("ul[class=gl-warp clearfix]").select("li[class=gl-item]"); 
		for (Element ele:elements) { 
			String bookID=ele.attr("data-sku"); 
			String bookPrice=ele.select("div[class=p-price]").select("strong").select("i").text(); 
			String bookName=ele.select("div[class=p-name]").select("em").text(); 
			//����һ������������Կ�����ʹ��Model�����ƣ�ֱ�ӽ��з�װ 
			JDModel jdModel=new JDModel(); 
			//�����ֵ 
			jdModel.setBookID(bookID); 
			jdModel.setBookName(bookName); 
			jdModel.setBookPrice(bookPrice); 
			//��ÿһ�������ֵ�����浽List������ 
			data.add(jdModel); 
		} 
		//�������� 
		return data; 
	}
}
