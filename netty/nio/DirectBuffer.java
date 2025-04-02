package netty.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class DirectBuffer {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/wenzhenma/Desktop/error.txt");
        FileChannel inputStreamChannel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("/Users/wenzhenma/Desktop/error-output7.txt");
        FileChannel outputStreamChannel = fileOutputStream.getChannel();

//        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(10);
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        while (true){
            byteBuffer.clear();

            int read = inputStreamChannel.read(byteBuffer);

            System.out.println("read idx --> "+ read);
            if (read == -1){
                break;
            }

            byteBuffer.flip();

            outputStreamChannel.write(byteBuffer);
        }

    }
}
