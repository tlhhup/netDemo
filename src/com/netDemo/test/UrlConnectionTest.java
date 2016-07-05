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
			//����url����
			URL url=new URL("http://localhost:8080/tomcat.css");
			URLConnection connection = url.openConnection();
			
			//����Ϊ���Է�������-->��ʹ��post�����ʱ����Ҫ�ֶ�����Ϊtrue
			connection.setDoOutput(true);
			//��ȡ��������󣬷�������
			OutputStream outputStream = connection.getOutputStream();
			//outputStream.write(data);
			
			//��ȡ�������������ڽ�������
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
