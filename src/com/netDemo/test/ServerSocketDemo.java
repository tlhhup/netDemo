package com.netDemo.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {

	public static void main(String[] args) {
		new ServerThread().start();
		new ClientThread().start();
	}

	private static class ServerThread extends Thread {
		@Override
		public void run() {
			ServerSocket serverSocket = null;
			BufferedReader reader = null;
			BufferedWriter writer = null;
			try {
				serverSocket = new ServerSocket(10032);
				// 使用死循环获取链接的客户端的Socket对象
				while (true) {
					// 等待连接，该方法会导致线程阻塞一直等到获取到连接的客户端Socket对象
					Socket socket = serverSocket.accept();

					// 获取输入输出流对象
					if (reader == null) {
						reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					}
					if (writer == null) {
						writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
					}
					
					String str = reader.readLine();
					if(str!=null&&!"".equals(str)){
						System.out.println("客户端发送的数据是："+str);
						writer.write("你好啊！");
						writer.flush();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (writer != null) {
						writer.close();
					}
					if (reader != null) {
						reader.close();
					}
					if (serverSocket != null) {
						serverSocket.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
	}

	private static class ClientThread extends Thread {

		@Override
		public void run() {
			Socket socket = null;
			BufferedReader reader = null;
			BufferedWriter writer = null;
			try {
				socket = new Socket("", 10032);
				// 获取输入输出流对象
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				writer.write("你大爷的");
				writer.flush();
				
				String str = reader.readLine();
				System.out.println("服务端的数据为："+str);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (reader != null) {
						reader.close();
					}
					if (writer != null) {
						writer.close();
					}
					if (socket != null) {
						socket.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

	}

}
