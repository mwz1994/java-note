package netty.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/wenzhenma/Desktop/error.txt");
        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        output("初始化", byteBuffer);
        channel.read(byteBuffer);
        output("调用 read ", byteBuffer);
        byteBuffer.flip();
        output("调用 flip ", byteBuffer);

        while (byteBuffer.hasRemaining()){
            byte b = byteBuffer.get();
            System.out.println("b --> " + (char)b);
        }

        output("调用 get ", byteBuffer);

        byteBuffer.clear();

        output("调用 clear ", byteBuffer);

        fileInputStream.close();
    }

    static void output(String step, Buffer buffer){
        System.out.println(step + " : ");
        System.out.print("capacity " + buffer.capacity()+ " , ");
        System.out.print("position " + buffer.position()+ " , ");
        System.out.print("limit " + buffer.limit()+ " , ");
        System.out.println();
    }
}
