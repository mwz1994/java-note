package netty.nio;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileChannel004 {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/wenzhenma/Desktop/file-output.txt");

        FileChannel fileChannel = FileChannel.open(file.toPath(), StandardOpenOption.READ);

        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());

        fileChannel.read(byteBuffer);

        fileChannel.close();

        String result = new String(byteBuffer.array());

        System.out.println("read result is --> "+ result);
    }
}
