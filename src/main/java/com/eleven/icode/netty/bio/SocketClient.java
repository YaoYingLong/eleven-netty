package com.eleven.icode.netty.bio;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author by YingLong on 2021/12/9
 */
public class SocketClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9000);
        // 接收服务端回传数据
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            // 向服务端发送数据
            String msg = scanner.nextLine();
            socket.getOutputStream().write(msg.getBytes());
            socket.getOutputStream().flush();
            System.out.println("向服务端发送数据结束");
//            byte[] bytes = new byte[1024];
//            socket.getInputStream().read(bytes);
//            System.out.println("接收到服务端数据：" + new String(bytes));
        }
    }

}
