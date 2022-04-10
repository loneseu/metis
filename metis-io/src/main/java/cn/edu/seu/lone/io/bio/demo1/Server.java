package cn.edu.seu.lone.io.bio.demo1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标：客户发消息，服务端接收消息
 */
public class Server {
    public static void main(String[] args) {
        try {
            // 1. 定义一个ServerSocket对象进行服务端口注册
            ServerSocket serverSocket = new ServerSocket(9999);
            // 2. 监听客户端Socket连接请求
            Socket socket = serverSocket.accept();
            // 3. 从socket管道中获得字节输入流对象
            InputStream inputStream = socket.getInputStream();
            // 4. 把字节输入流包装成缓冲字节输入流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String message;

            while ((message = bufferedReader.readLine()) != null) {
                System.out.println("服务端收到：" + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
