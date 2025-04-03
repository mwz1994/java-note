package netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

public class ScatteringAndGatheringTest {
    public static void main(String[] args) throws IOException {
        // 使用 ServerSocketChannel 和 SocketChannel 网络
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        SocketAddress socketAddress = new InetSocketAddress(7000);

        // 端口绑定 socket
        serverSocketChannel.socket().bind(socketAddress);

        ByteBuffer[] byteBuffers = new ByteBuffer[3];

        byteBuffers[0] = ByteBuffer.allocate(2);
        byteBuffers[1] = ByteBuffer.allocate(3);
        byteBuffers[2] = ByteBuffer.allocate(5);

        // 等待客户端连接
        SocketChannel socketChannel = serverSocketChannel.accept();


        int messageLength = 10;

        while (true){
            int byteRead = 0;

            while (byteRead< messageLength){
                long l = socketChannel.read(byteBuffers);
                byteRead +=l;

                System.out.println("byteRead = "+ byteRead);

                for (int i = 0; i < 3; i++) {
                    var buffer = byteBuffers[i];
                    System.out.println("buffer["+i+"]" + " position = "+ buffer.position() + " , limit = "+ buffer.limit());
                }
            }

            Arrays.asList(byteBuffers).stream().forEach(byteBuffer -> byteBuffer.flip());

            long byteWrite = 0;

            while (byteWrite< messageLength){
                long l = socketChannel.write(byteBuffers);
                byteWrite += l;
            }

            for (int i = 0; i < 3; i++) {
                var buffer = byteBuffers[i];
                buffer.clear();
                System.out.println("buffer["+i+"] clear");
            }

            System.out.println("byteRead = "+ byteRead + " ,byteWrite = "+ byteWrite + " , messageLength = "+ messageLength);
        }


    }
}
