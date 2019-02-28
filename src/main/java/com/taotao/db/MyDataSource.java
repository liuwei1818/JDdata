package com.taotao.db;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class MyDataSource {
	public static DataSource getDataSource(String connectURI){ 
		BasicDataSource ds = new BasicDataSource(); 
		//MySQL的jdbc驱动 
		ds.setDriverClassName("com.mysql.jdbc.Driver"); 
		//所要连接的数据库名 
		ds.setUsername("root"); 
		//MySQL的登陆密码
		ds.setPassword("13456"); 		 
		ds.setUrl(connectURI); 
		return ds;
	}
	
}
