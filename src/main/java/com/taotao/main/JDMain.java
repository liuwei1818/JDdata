package com.taotao.main;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import com.taotao.db.MySQLControl;
import com.taotao.model.JDModel;
import com.taotao.util.URLFecter;

public class JDMain {
	//log4j
	static final Log logger = LogFactory.getLog(JDMain.class); 
	public static void main(String[] args) throws Exception { 
		//��ʼ��һ��httpclient 
		HttpClient client = new DefaultHttpClient(); 
		//����Ҫ��ȡ��һ����ַ��������Դ����ݿ��г�ȡ���ݣ�Ȼ������ѭ����������ȡһ��URL���� 
		String url="http://search.jd.com/Search?keyword=Python&enc=utf-8&book=y&wq=Python&pvid=33xo9lni.p4a1qb"; 
		//ץȡ������ 
		List<JDModel> bookdatas=URLFecter.URLParser(client, url); 
		//ѭ�����ץȡ������ 
		for (JDModel jd:bookdatas) { 
			logger.info("bookID:"+jd.getBookID()+"\t"+"bookPrice:"+jd.getBookPrice()+"\t"+"bookName:"+jd.getBookName()); 
		} 
		//��ץȡ�����ݲ������ݿ� 
		MySQLControl.executeInsert(bookdatas); 
	}
}
