package netty.copy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NewIOServer {
    public static void main(String[] args) throws IOException {
        InetSocketAddress address = new InetSocketAddress(7001);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

//        serverSocketChannel.bind(address);

        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(address);

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        while (true){
            SocketChannel socketChannel = serverSocketChannel.accept();
            int readCount = 0;

            while (-1 != readCount){
                try {
                    readCount = socketChannel.read(byteBuffer);
                    String str = new String(byteBuffer.array());
                    System.out.println("receive string is --> ["+ str +"]");
                }catch (Exception e){
                    break;
                }
                //
                byteBuffer.rewind();
            }
        }
    }
}
