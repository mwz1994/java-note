package netty.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class FileChannel003 {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/wenzhenma/Desktop/file-output.txt");

        FileInputStream fileInputStream = new FileInputStream(file);

        FileChannel fileChannel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());

        fileChannel.read(byteBuffer);

        String result = new String(byteBuffer.array());

        System.out.println("read result is --> "+ result);
    }
}
