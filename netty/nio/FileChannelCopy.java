package netty.nio;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;

public class FileChannelCopy {
    public static void main(String[] args) throws IOException {
        File png = new File("/Users/wenzhenma/Desktop/week_log.png");

        FileChannel source = FileChannel.open(png.toPath(), StandardOpenOption.READ);

        ByteBuffer byteBuffer = ByteBuffer.allocate((int) png.length());

        source.read(byteBuffer);

        byteBuffer.flip();

        FileChannel target = FileChannel.open(new File("/Users/wenzhenma/Desktop/week_log_copy_04031053.png").toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        target.write(byteBuffer);

        source.close();
        target.close();

        System.out.println("copy over");
    }
}
