package netty.copy;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class LegacyIOServer {
    public static void main(String[] args) throws IOException {
        InetSocketAddress address = new InetSocketAddress(7002);
        ServerSocket socket = new ServerSocket();
        socket.bind(address);

        int readCount;
        int sumCount = 0;

        while (true){
            Socket inputSocket = socket.accept();
            var inputStream = inputSocket.getInputStream();
            byte[] bytes = new byte[512];
            while ((readCount = inputStream.read(bytes)) != -1) {
                String str = new String(bytes);
                System.out.println("read str ->> ["+str+"]");
                // 仅读取数据，不处理
                sumCount += readCount;
            }
            System.out.println("total read count is "+ sumCount);
        }

    }
}
