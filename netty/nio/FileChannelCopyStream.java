package netty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelCopyStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/wenzhenma/Desktop/《凤凰架构》-copy-0403.pdf");
        FileChannel fileInputStreamChannel  = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("/Users/wenzhenma/Desktop/《凤凰架构》-copy-04031116.pdf");
        FileChannel fileOutputStreamChannel  = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        while (true){
            byteBuffer.clear();
            int read = fileInputStreamChannel.read(byteBuffer);
            System.out.println("read = " + read);
            if (read == -1){
                break;
            }
            byteBuffer.flip();

            fileOutputStreamChannel.write(byteBuffer);

        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
