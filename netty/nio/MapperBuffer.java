package netty.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MapperBuffer {
    static private final int start = 0;
    static private final int size = 10;

    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/wenzhenma/Desktop/error.txt","rw");

        FileChannel fileChannel = randomAccessFile.getChannel();

        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE,start,size);

        mappedByteBuffer.put(4, (byte) 'H');
        mappedByteBuffer.put(6, (byte) 'H');

        randomAccessFile.close();
    }
}
