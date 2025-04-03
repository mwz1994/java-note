package netty.nio;

import java.io.*;
import java.nio.ByteBuffer;

public class FileChannelStreamCopy {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/wenzhenma/Desktop/《凤凰架构》.pdf");
        FileInputStream fileInputStream = new FileInputStream(file.getPath());

        var inputStreamChannel = fileInputStream.getChannel();

        var byteBuffer = ByteBuffer.allocate((int) file.length());

        inputStreamChannel.read(byteBuffer);

        byteBuffer.flip();

        FileOutputStream fileOutputStream = new FileOutputStream("/Users/wenzhenma/Desktop/《凤凰架构》-copy-0403.pdf");
        var outputStreamChannel = fileOutputStream.getChannel();

        outputStreamChannel.write(byteBuffer);

        fileOutputStream.close();
        fileInputStream.close();

        inputStreamChannel.close();
        outputStreamChannel.close();

    }
}
