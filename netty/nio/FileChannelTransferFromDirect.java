package netty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileChannelTransferFromDirect {
    public static void main(String[] args) throws IOException {
        String src = "/Users/wenzhenma/Desktop/1719907396609_54.png";
        String tgt = "/Users/wenzhenma/Desktop/1719907396609_54_43_1145.png";

        FileChannel inputChannel = FileChannel.open(Path.of(src), StandardOpenOption.READ);

        FileChannel outputChannel = FileChannel.open(Path.of(tgt), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        outputChannel.transferFrom(inputChannel, 0, inputChannel.size());

        inputChannel.close();
        outputChannel.close();

        System.out.println("拷贝完成");

    }
}
