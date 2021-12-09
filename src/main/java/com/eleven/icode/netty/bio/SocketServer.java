package com.eleven.icode.netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLOutput;

/**
 * @author by YingLong on 2021/12/9
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true) {
            System.out.println("等待连接....");
            // 阻塞方法
            final Socket clientSocket = serverSocket.accept();
            System.out.println("有客户端连接了....");
//            handler(clientSocket);
            new Thread(new Runnable() {
                public void run() {
                    try {
                        handler(clientSocket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    private static void handler(Socket socket) throws IOException {
        while (true) {
            byte[] bytes = new byte[1024];
            System.out.println("准备read....");
            // 接收客户端的数据，阻塞方法，没有数据可读时就阻塞
            int read = socket.getInputStream().read(bytes);
            System.out.println("read完毕....");
            if (read != -1) {
                System.out.println("接收到客户端数据：" + new String(bytes, 0, read));
            } else {
                System.out.println("关闭客户端");
                socket.close();
            }
        }
//        socket.getOutputStream().write("HelloClient".getBytes());
//        socket.getOutputStream().flush();
    }
}
