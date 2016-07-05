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
				// ʹ����ѭ����ȡ���ӵĿͻ��˵�Socket����
				while (true) {
					// �ȴ����ӣ��÷����ᵼ���߳�����һֱ�ȵ���ȡ�����ӵĿͻ���Socket����
					Socket socket = serverSocket.accept();

					// ��ȡ�������������
					if (reader == null) {
						reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					}
					if (writer == null) {
						writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
					}
					
					String str = reader.readLine();
					if(str!=null&&!"".equals(str)){
						System.out.println("�ͻ��˷��͵������ǣ�"+str);
						writer.write("��ð���");
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
				// ��ȡ�������������
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				writer.write("���ү��");
				writer.flush();
				
				String str = reader.readLine();
				System.out.println("����˵�����Ϊ��"+str);
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
