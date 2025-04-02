package netty.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannel001 {
    public static void main(String[] args) throws IOException {
        String str = "hello FileChannel";

        FileOutputStream fileOutputStream = new FileOutputStream("/Users/wenzhenma/Desktop/file-output.txt");

        FileChannel fileChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(str.length());

        byteBuffer.put(str.getBytes());

        //对 byteBuffer 进行 flip
        byteBuffer.flip();

        fileChannel.write(byteBuffer);

        fileChannel.close();
    }
}
