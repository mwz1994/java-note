package netty.nio;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileChannel002 {
    public static void main(String[] args) throws IOException {
        String str  = "hello FileChannel";

        Path path = Path.of("/Users/wenzhenma/Desktop/file-output-002.txt");
        try(FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes());
            fileChannel.write(byteBuffer);
        }
    }
}
