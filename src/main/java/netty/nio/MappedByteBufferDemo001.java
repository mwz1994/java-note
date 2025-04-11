package netty.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class MappedByteBufferDemo001 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/wenzhenma/Desktop/file-output.txt","rw");
        var fileChannel = randomAccessFile.getChannel();

        var mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0,20);

        mappedByteBuffer.put(0, (byte) '*');
        mappedByteBuffer.put(2, (byte) '*');

        randomAccessFile.close();
    }
}
