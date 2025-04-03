package netty.nio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class MapperByteBufferDemo {
    public static void main(String[] args) throws IOException {
        String path = "/Users/wenzhenma/Desktop/file-output.txt";

        try(FileChannel fileChannel = FileChannel.open(Path.of(path), StandardOpenOption.READ, StandardOpenOption.WRITE);){
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE,0,fileChannel.size());

            mappedByteBuffer.put(10,(byte) '$');
            mappedByteBuffer.put(11,(byte) '$');

            mappedByteBuffer.force();
        }
    }
}
