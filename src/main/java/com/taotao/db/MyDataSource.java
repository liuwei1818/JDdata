package com.taotao.db;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class MyDataSource {
	public static DataSource getDataSource(String connectURI){ 
		BasicDataSource ds = new BasicDataSource(); 
		//MySQL��jdbc���� 
		ds.setDriverClassName("com.mysql.jdbc.Driver"); 
		//��Ҫ���ӵ����ݿ��� 
		ds.setUsername("root"); 
		//MySQL�ĵ�½����
		ds.setPassword("13456"); 		 
		ds.setUrl(connectURI); 
		return ds;
	}
	
}
