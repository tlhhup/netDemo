# netDemo
###netDemo
1. 计算机网络的分类
	1. 按照规模大小和延伸范围分为
		1. 局域网(LAN)：指在一个较小地理范围内的各种计算机网络设备互连在一起的通信网络，可以包含一个或多个子网，通常局限在几千米范围之内
		2. 城域网(MAN)：主要是由成域范围内的各种局域网之间互联而构成的
		3. 广域网(WAN)：是由相距较远的局域网或城域网互联而成，通常是除了计算机设备以外，还要涉及一些电信通信方式
	4. 按照网络的拓扑结构分为
		1. 星型网络
		2. 总线网络
		3. 环形网络
		4. 星型环形网络
		5. 树型网络
	6. 网络的传输介质
		1. 双绞线网
		2. 同轴电缆网
		3. 光纤网
		4. 卫星网
5. 开放系统互联模型
	1. 应用层
	2. 表示层
	3. 会话层
	4. 传输层
	5. 网络层
	6. 数据链路层
	7. 物理层
8. TCP/IP
	1. 模型分层
		1. 应用层
		2. 传输层
		3. 网络层
		4. 物理+数据链路层
	5. ip和端口号
		1. ip地址有32bit的数据组成  
		1. 端口号由16bit的数据组成
			1. 公认端口：0~1023，紧密绑定一些服务
			2. 注册端口：1024~49151,松散的绑定一些服务
			3. 动态或/和私有端口：49152~65535，应用程序使用的动态端口，应用程序一般不会主动使用这些端口
4. 网络访问
	1. 通过URLConnection获取数据
		1. URL：同一资源定位符--->它是指向互联网“资源”的
		2. URLConnection:代表应用程序和 URL 之间的通信链接。

				//创建url对象
				URL url=new URL("http://localhost:8080/tomcat.css");
				URLConnection connection = url.openConnection();
				
				//设置为可以发送数据-->再使用post请求的时候需要手动设置为true
				connection.setDoOutput(true);
				//获取输出流对象，发送数据
				OutputStream outputStream = connection.getOutputStream();
				outputStream.write(data);
				
				//获取输入流对象用于接收数据
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String str=null;
				while((str=reader.readLine())!=null){
					System.out.println(str);
				}
	2. TCP/IP获取数据-->使用流进行通信(Socket)
		1. ServerSocket:实现服务器套接字
		2. Socket:实现客户端套接字（也可以就叫“套接字”）
		