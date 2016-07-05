package com.netDemo.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionTest {

	public static void main(String[] args) {
		BufferedReader reader=null;
		try {
			//创建url对象
			URL url=new URL("http://localhost:8080/tomcat.css");
			URLConnection connection = url.openConnection();
			
			//设置为可以发送数据-->再使用post请求的时候需要手动设置为true
			connection.setDoOutput(true);
			//获取输出流对象，发送数据
			OutputStream outputStream = connection.getOutputStream();
			//outputStream.write(data);
			
			//获取输入流对象用于接收数据
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String str=null;
			while((str=reader.readLine())!=null){
				System.out.println(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(reader!=null){
					reader.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
